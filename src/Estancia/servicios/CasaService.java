package Estancia.servicios;

import Estancia.entidades.Casa;
import Estancia.persistencia.CasaDAO;
import Estancia.persistencia.DAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class CasaService {

    CasaDAO cD = new CasaDAO();

    public void Mostrar2() throws SQLException, Exception {
        ArrayList<Casa> lista = cD.segundaConsulta();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }

    public void Mostrar4() throws SQLException, Exception {
        ArrayList<Casa> lista = cD.cuartaConsulta();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }

    public void Mostrar6() throws SQLException, Exception {
        ArrayList<Casa> lista = cD.consultaCasa7();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }

    public void Mostrar7() throws SQLException, Exception {
        cD.septimaConsulta();
        ArrayList<Casa> lista = cD.consultaCasa7();
        for (Object object : lista) {
            System.out.println(object.toString());
        }
    }
    public void Mostrar8() throws SQLException, Exception{
      cD.octavaConsulta();
    }

    public Casa buscarCasaPorId(int codigo) throws Exception {

        try {

            //Validacion
            if (codigo < 0) {
                throw new Exception("Debe indicar un codigo de casa");

            }
            Casa casa = cD.buscarCasaPorId(codigo);

            return casa;
        } catch (Exception e) {
            throw e;
        }
    }
}
