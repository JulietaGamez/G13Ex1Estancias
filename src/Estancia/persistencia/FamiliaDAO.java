/*
Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10
años.
 */
package Estancia.persistencia;

import Estancia.entidades.Casa;
import Estancia.entidades.Familia;
import Estancia.servicios.CasaService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julietagamez
 */
public class FamiliaDAO extends DAO {

    ArrayList<Familia> listaConsulta = new ArrayList();
    CasaService cS = new CasaService();

    public void prueba() throws ClassNotFoundException, SQLException {
        super.conectarBase();
    }

    public ArrayList<Familia> primerConsulta() throws ClassNotFoundException, SQLException, Exception {
        try {
            super.conectarBase();
            super.consultarBase("SELECT * from familias where num_hijos >=3 and edad_maxima <10");
            Familia f = null;
            while (super.resultado.next()) {
                f = new Familia();
                f.setEdad_maxima(super.resultado.getInt("edad_maxima"));
                f.setEdad_minima(super.resultado.getInt("edad_minima"));
                f.setEmail(super.resultado.getString("email"));
                f.setCasa(cS.buscarCasaPorId(super.resultado.getInt("id_casa_familia")));
                f.setId_familia(super.resultado.getInt("id_familia"));
                f.setNombre(super.resultado.getString("nombre"));
                f.setNum_hijos(super.resultado.getInt("num_hijos"));
                listaConsulta.add(f);
            }
            super.desconectarBase();
        } catch (Exception e) {
            super.desconectarBase();
            throw e;
        }
        return listaConsulta;
    }
    
    public ArrayList<Familia> tercerConsulta() throws ClassNotFoundException, SQLException, Exception {
        try {
            super.conectarBase();
            super.consultarBase("SELECT * from familias where email like '%hotmail%'");
            Familia f = null;
            while (super.resultado.next()) {
                f = new Familia();
                f.setEdad_maxima(super.resultado.getInt("edad_maxima"));
                f.setEdad_minima(super.resultado.getInt("edad_minima"));
                f.setEmail(super.resultado.getString("email"));
                f.setCasa(cS.buscarCasaPorId(super.resultado.getInt("id_casa_familia")));
                f.setId_familia(super.resultado.getInt("id_familia"));
                f.setNombre(super.resultado.getString("nombre"));
                f.setNum_hijos(super.resultado.getInt("num_hijos"));
                listaConsulta.add(f);
            }

            super.desconectarBase();
        } catch (Exception e) {
            super.desconectarBase();
            throw e;
        }
        return listaConsulta;
    }
}
