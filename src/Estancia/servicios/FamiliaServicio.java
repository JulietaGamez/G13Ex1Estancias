/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estancia.servicios;

import Estancia.entidades.Familia;
import Estancia.persistencia.FamiliaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julietagamez
 */
public class FamiliaServicio {
     FamiliaDAO fD= new FamiliaDAO();
    public void Mostrar1 () throws SQLException, Exception{
        ArrayList<Familia>lista=fD.primerConsulta();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }
    
    public void Mostrar3 () throws SQLException, Exception{
        ArrayList<Familia>lista=fD.tercerConsulta();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }
}
