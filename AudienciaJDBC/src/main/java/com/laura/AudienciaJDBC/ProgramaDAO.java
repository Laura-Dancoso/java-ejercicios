package com.laura.AudienciaJDBC;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProgramaDAO {

    public static void insertarPrograma(Programa programa){
        try {
            Connection cn = ConnectionManager.getConnection();
            String sqlInsert = "INSERT INTO programa (nombre,horaEmision,tipoPrograma,radioEmisora,audiencia) VALUES ('" + programa.getNombre() + "', '" + programa.getHoraEmision() + "', " + programa.getTipoPrograma() + ", " + programa.getRadioEmisora() + ", " + programa.getAudiencia() + ")";
            Statement st = cn.createStatement();
            st.execute(sqlInsert);
            st.close();
            cn.close();
            System.out.println("Programa agregado");
        }catch (Exception e){
            System.out.println("No se pudo agregar el programa");
        }
    }
    public static List<Programa> getProgramas(String sqlSelect) throws Exception{
        List<Programa> programas = new ArrayList<>();
        Connection cn = ConnectionManager.getConnection();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sqlSelect);
        while(rs.next()){
        Programa p = new Programa();
        p.setNombre(rs.getString("nombre"));
        p.setHoraEmision(LocalTime.parse(rs.getString("horaEmision")));
        p.setTipoPrograma(rs.getInt("tipoPrograma"));
        p.setRadioEmisora(rs.getInt("radioEmisora"));
        p.setAudiencia(rs.getInt("audiencia"));
        programas.add(p);
        }
        st.close();
        cn.close();
        return programas;
    }
    public static List<Programa> getAllProgramas()throws Exception{
        return getProgramas("SELECT * FROM programa");
    }
    public static List<Programa> mostrarProgramasMayorAudiencia(int m) throws Exception{
        List<Programa> programas = getAllProgramas();
        //ordena la lista según la audiencia
        Collections.sort(programas, (d1, d2) -> {
            return d2.getAudiencia() - d1.getAudiencia();
        });
        //retorna la cantidad pasada por parametro
        return programas.subList(0,m);
    }
    public static List<Programa> mostrarExistePrograma(String nombrePrograma)throws Exception{
        return getProgramas("SELECT * FROM Programa WHERE nombre='" + nombrePrograma +"'");
    }
    public static int[] mostrarCantidadDeProgramasSegunTipo(int emisora)throws Exception{
        List<Programa> filterList = getProgramas("SELECT * FROM Programa WHERE radioEmisora="+emisora);
        int [] cant= new int[4];
        for(Programa programa:filterList){
            if (programa.getTipoPrograma()>= 0 && programa.getTipoPrograma()<=3)
                cant[programa.getTipoPrograma()]++;
        }
        return cant;
    }
    //Map<numeroemisora,cantidadseguntipo>
    public static Map<Integer,int[]> mostrarCantidadProgramasSegunTipoYEmisora() throws Exception{
        int emisoras=10;
        Map <Integer,int[]> cant = new HashMap<>();
        for (Programa programa: ProgramaDAO.getAllProgramas()){
            if (cant.containsKey(programa.getRadioEmisora())){
                cant.replace(programa.getRadioEmisora(), mostrarCantidadDeProgramasSegunTipo(programa.getRadioEmisora()));
            }else{
                cant.put(programa.getRadioEmisora(), mostrarCantidadDeProgramasSegunTipo(programa.getRadioEmisora()));
            }
        }
        return cant;
    }
    public static int mostrarCuantosProgramasTienenAudienciaMenorA(int r)throws Exception{
        List<Programa> filterList = getProgramas("SELECT * FROM Programa WHERE hour(horaEmision)>=15 && audiencia<" + r);
        return filterList.size();
    }
}
