
package Estancia.persistencia;

import Estancia.entidades.Casa;
import Estancia.entidades.Cliente;
import Estancia.entidades.Estancia;
import Estancia.servicios.CasaService;
import Estancia.servicios.ClienteService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EstanciaDAO extends DAO{
    ArrayList<Estancia> listaConsulta = new ArrayList();
    ClienteService cS= new ClienteService();
    CasaService caS=new CasaService ();
    Scanner leer = new Scanner(System.in);
    public Estancia buscarEstanciasPorId(int id_cliente, int id_casa) throws Exception{
         try {
            String sql = "SELECT * FROM Estancias where id_cliente = "
                    + id_cliente + "AND id_casa ="+ id_casa +";";
            consultarBase(sql);

              Estancia e = null;
              Cliente c= null;
              Casa ca= null;
            while (resultado.next()) {
                e = new Estancia();
                e.setId_estancia(super.resultado.getInt("id_estancia"));
                e.setFecha_desde(super.resultado.getDate("fecha_desde"));
                e.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                e.setNombre_huesped(super.resultado.getString("nombre_huesped"));
               
                e.setCliente(c=cS.buscarClientePorId(super.resultado.getInt("id_cliente")));
                
                e.setCasa(ca=caS.buscarCasaPorId(super.resultado.getInt("id_casa")));
                
            }
            desconectarBase();
            return e;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }
    public ArrayList<Estancia> quintaConsulta () throws ClassNotFoundException, SQLException, Exception{
        try{
            super.conectarBase();
            super.consultarBase("select distinct * from clientes c , casas ca , estancias e " +
"where c.id_cliente = e.id_cliente and e.id_casa = ca.id_casa and c.nombre = e.nombre_huesped;");
            Estancia e=null;
           
            while (super.resultado.next()) {
                e= new Estancia();
                e.setId_estancia(super.resultado.getInt("id_estancia"));
                e.setFecha_desde(super.resultado.getDate("fecha_desde"));
                e.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                e.setNombre_huesped(super.resultado.getString("nombre_huesped"));
                e.setCliente(cS.buscarClientePorId(super.resultado.getInt("id_cliente")));
                e.setCasa(caS.buscarCasaPorId(super.resultado.getInt("id_casa")));
           listaConsulta.add(e);
           }
            
           
            super.desconectarBase();
            }catch(Exception e){
                super.desconectarBase();
                throw e;
        }
        return listaConsulta;
    }
    public ArrayList<Estancia> sextaConsulta () throws ClassNotFoundException, SQLException, Exception{
        try{
            super.conectarBase();
            super.consultarBase("select e.id_estancia, e.id_cliente, cl.nombre, cl.pais, cl.ciudad, c.id_casa, c.calle, c.pais, c.tipo_vivienda \n" +
"from estancias e, clientes cl, casas c \n" +
"where cl.id_cliente = e.id_cliente and e.id_casa = c.id_casa and cl.nombre = e.nombre_huesped;");
            Estancia e=null;
            Cliente c= null;
            Casa ca= null;
            while (super.resultado.next()) {
                e= new Estancia();
                e.setId_estancia(super.resultado.getInt("id_estancia"));
                e.setCliente(c=cS.buscarClientePorId(super.resultado.getInt("id_cliente")));
                e.setCasa(ca=caS.buscarCasaPorId(super.resultado.getInt("id_casa")));
           listaConsulta.add(e);
           }
            
           
            super.desconectarBase();
            }catch(Exception e){
                super.desconectarBase();
                throw e;
        }
        return listaConsulta;
    }
//    update estancias set nombre_huesped ='Julieta' where (select id_casa where fecha_desde >= '2020-06-2' and adddate('2020-06-2', +5) <= fecha_hasta and id_casa = 3);

    public ArrayList<Estancia> decimaConsulta () throws ClassNotFoundException, SQLException, Exception {
            preDecimaConsulta();
        try {
             
            super.conectarBase();
            
            System.out.println("Seleccione el id de casa que desea que desea ocupar");
            int id_ca= leer.nextInt();
            System.out.println("Ingresar el nombre del huesped");
            String nombreH=leer.next();
            super.instarModificarEliminar("update estancias set nombre_huesped = '"+ nombreH + "'WHERE id_casa = "+ id_ca);
            
            super.desconectarBase();
            
        }catch (Exception e){
            super.desconectarBase();
            throw e;
        }
        mostrarConsulta10();
        return listaConsulta;
    }
    public ArrayList<Estancia> preDecimaConsulta () throws ClassNotFoundException, SQLException, Exception {
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
            super.consultarBase("select * from estancias where fecha_desde >= ' "
                    + anio + "-" + mes+ "-" + dia + "' AND adddate('"+anio 
                    + "-" + mes+ "-" + dia + "',"+cantdias+") <= fecha_hasta");
            Estancia e=null;
            while (super.resultado.next()) {
                e= new Estancia();
                e.setId_estancia(super.resultado.getInt("id_estancia"));
                e.setFecha_desde(super.resultado.getDate("fecha_desde"));
                e.setFecha_hasta(super.resultado.getDate("fecha_hasta"));
                e.setNombre_huesped(super.resultado.getString("nombre_huesped"));
                e.setCliente(cS.buscarClientePorId(super.resultado.getInt("id_cliente")));
                e.setCasa(caS.buscarCasaPorId(super.resultado.getInt("id_casa")));

                listaConsulta.add(e);           
            }
            super.desconectarBase();
            System.out.println("Casas disponibles:");
            for (Estancia estancia : listaConsulta) {
                System.out.println(estancia.getId_estancia());
            }
        }catch (Exception e){
            super.desconectarBase();
            throw e;
        }
        
        return listaConsulta;
    }
public ArrayList<Estancia> mostrarConsulta10 () throws ClassNotFoundException, SQLException, Exception{
        ArrayList<Estancia>listaConsulta10= new ArrayList();
    try{
            super.conectarBase();
            super.consultarBase("select * from estancias");
            Estancia e=null;
            
            while (super.resultado.next()) {
                e= new Estancia();
                e.setId_estancia(super.resultado.getInt("id_estancia"));
                e.setNombre_huesped(super.resultado.getString("nombre_huesped"));
                e.setCliente(cS.buscarClientePorId(super.resultado.getInt("id_cliente")));
                e.setCasa(caS.buscarCasaPorId(super.resultado.getInt("id_casa")));
           listaConsulta10.add(e);
           }
            super.desconectarBase();
            System.out.println("--Lista Casas--");
            
            for (Estancia estancia : listaConsulta10) {
                System.out.println( "Casa= "+ estancia.getCasa().getId_casa()+ " Nombre = "+ estancia.getNombre_huesped());
            }
            }catch(Exception e){
                super.desconectarBase();
                throw e;
        }
        return listaConsulta10;
    }
}
