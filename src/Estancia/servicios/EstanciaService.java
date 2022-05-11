package Estancia.servicios;

import Estancia.entidades.Estancia;
import Estancia.persistencia.EstanciaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstanciaService {

    EstanciaDAO eD = new EstanciaDAO();

    public void Mostrar6() throws SQLException, Exception {
        ArrayList<Estancia> lista = eD.sextaConsulta();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }

    public void Mostrar5() throws SQLException, Exception {
        ArrayList<Estancia> lista = eD.quintaConsulta();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }

    public void Mostrar10() throws SQLException, Exception {
       eD.decimaConsulta();
       
       
    }
    
}
