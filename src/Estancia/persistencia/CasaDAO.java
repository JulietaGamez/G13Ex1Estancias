/*
 Buscar y listar las casas disponibles para el periodo comprendido 
entre el 1 de
agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
 */
package Estancia.persistencia;

import Estancia.entidades.Casa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CasaDAO extends DAO {


    Scanner leer= new Scanner(System.in);
    ArrayList<Casa>listaConsulta= new ArrayList();
    public ArrayList<Casa> segundaConsulta () throws ClassNotFoundException, SQLException, Exception {
        try {
            super.conectarBase();
            super.consultarBase("select * from casas where fecha_desde = '2020-08-1' and fecha_hasta ='2020-08-31' and pais like 'Reino Unido'");
            Casa c=null;
            while (super.resultado.next()) {
                c= new Casa();
                c.setCalle(super.resultado.getNString("calle"));
                c.setCiudad(super.resultado.getNString("ciudad"));
                c.setCodigo_postal(super.resultado.getNString("codigo_postal"));
                c.setFecha_desde(super.resultado.getDate("fecha_desde"));
                c.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                c.setId_casa(super.resultado.getInt("id_casa"));
                c.setPais(super.resultado.getString("pais"));
                c.setTipo_vivienda(super.resultado.getString("tipo_vivienda"));
                c.setTiempo_maximo(super.resultado.getInt("tiempo_maximo"));
                c.setTiempo_minimo(super.resultado.getInt("tiempo_minimo"));
                c.setPrecio_habitacion(super.resultado.getFloat("precio_habitacion"));
                

                listaConsulta.add(c);           
            }
            super.desconectarBase();
            
        }catch (Exception e){
            super.desconectarBase();
            throw e;
        }
        return listaConsulta;
    }
    public ArrayList<Casa> cuartaConsulta () throws ClassNotFoundException, SQLException, Exception {
        try {
            super.conectarBase();
            System.out.println("Ingrese el dia ");
            int dia= leer.nextInt();
            System.out.println("Ingrese el mes ");
            int mes= leer.nextInt();
            System.out.println("Ingrese el año ");
            int anio=leer.nextInt();
            System.out.println("Ingrese la cantidad de dias que desea hospedares");
            int cantdias= leer.nextInt();
            
            super.consultarBase("SELECT * FROM casas WHERE fecha_desde >= ' "
                    + anio + "-" + mes+ "-" + dia + "' AND adddate('"+anio 
                    + "-" + mes+ "-" + dia + "',"+cantdias+") <= fecha_hasta;");
            Casa c=null;
            while (super.resultado.next()) {
                c= new Casa();
                c.setCalle(super.resultado.getNString("calle"));
                c.setCiudad(super.resultado.getNString("ciudad"));
                c.setCodigo_postal(super.resultado.getNString("codigo_postal"));
                c.setFecha_desde(super.resultado.getDate("fecha_desde"));
                c.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                c.setId_casa(super.resultado.getInt("id_casa"));
                c.setPais(super.resultado.getString("pais"));
                c.setTipo_vivienda(super.resultado.getString("tipo_vivienda"));
                c.setTiempo_maximo(super.resultado.getInt("tiempo_maximo"));
                c.setTiempo_minimo(super.resultado.getInt("tiempo_minimo"));
                c.setPrecio_habitacion(super.resultado.getFloat("precio_habitacion"));
                c.setNumero(super.resultado.getInt("numero"));
                //c.setComentario(cSe.buscarComentarioPorId(super.resultado.getInt("id_casa")));

                listaConsulta.add(c);           
            }
            super.desconectarBase();
            
        }catch (Exception e){
            super.desconectarBase();
            throw e;
        }
        return listaConsulta;
    }
    public  Casa buscarCasaPorId(int id_casa) throws Exception {
       try {
            String sql = "SELECT * FROM Casas WHERE id_casa="
                    + id_casa + ";";
            super.consultarBase(sql);
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();
                c.setCalle(super.resultado.getNString("calle"));
                c.setCiudad(super.resultado.getNString("ciudad"));
                c.setCodigo_postal(super.resultado.getNString("codigo_postal"));
                c.setFecha_desde(super.resultado.getDate("fecha_desde"));
                c.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                c.setId_casa(super.resultado.getInt("id_casa"));
                c.setPais(super.resultado.getString("pais"));
                c.setTipo_vivienda(super.resultado.getString("tipo_vivienda"));
                c.setTiempo_maximo(super.resultado.getInt("tiempo_maximo"));
                c.setTiempo_minimo(super.resultado.getInt("tiempo_minimo"));
                c.setPrecio_habitacion(super.resultado.getFloat("precio_habitacion"));
                //c.setComentario(cSe.buscarComentarioPorId(super.resultado.getInt("id_casa")));

            }
            desconectarBase();
            return c;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }
    public ArrayList<Casa> septimaConsulta () throws ClassNotFoundException, SQLException, Exception {
        try {
            super.conectarBase();
            
            super.instarModificarEliminar("update  casas set  precio_habitacion = precio_habitacion + (precio_habitacion * 0.05)\n" +
"where pais like 'Reino unido';");
           
        } catch (Exception e) {
            throw e;
        } finally {
            super.desconectarBase();
        }
        
        return listaConsulta;
    }
     public  ArrayList<Casa> consultaCasa7() throws Exception {
       try {
            String sql = "SELECT * FROM Casas ";
            super.consultarBase(sql);
            consultarBase(sql);

            Casa c = null;

            while (resultado.next()) {
                c = new Casa();
                c.setCalle(super.resultado.getNString("calle"));
                c.setCiudad(super.resultado.getNString("ciudad"));
                c.setCodigo_postal(super.resultado.getNString("codigo_postal"));
                c.setFecha_desde(super.resultado.getDate("fecha_desde"));
                c.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                c.setId_casa(super.resultado.getInt("id_casa"));
                c.setPais(super.resultado.getString("pais"));
                c.setTipo_vivienda(super.resultado.getString("tipo_vivienda"));
                c.setTiempo_maximo(super.resultado.getInt("tiempo_maximo"));
                c.setTiempo_minimo(super.resultado.getInt("tiempo_minimo"));
                c.setPrecio_habitacion(super.resultado.getFloat("precio_habitacion"));
                //c.setComentario(cSe.buscarComentarioPorId(super.resultado.getInt("id_casa")));

                listaConsulta.add(c);
            }
            desconectarBase();
            return listaConsulta;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }
     public ArrayList<Casa> octavaConsulta () throws ClassNotFoundException, SQLException, Exception {
        try {
            String sql = "select count(id_casa),pais  from casas group by pais ";
            super.consultarBase(sql);
            Casa c = null;
            while (resultado.next()) {
                c = new Casa();
             
                c.setId_casa(super.resultado.getInt("count(id_casa)"));
                c.setPais(super.resultado.getString("pais"));
                
                listaConsulta.add(c);
            }
            desconectarBase();
            for (Casa casa : listaConsulta) {
                System.out.println("(Count)id_casa= "+casa.getId_casa()+" pais= "+ casa.getPais());
            }
            return listaConsulta;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
         
     }

   
}

