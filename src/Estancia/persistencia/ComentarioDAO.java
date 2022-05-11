package Estancia.persistencia;

import Estancia.entidades.Comentario;
import Estancia.servicios.CasaService;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ComentarioDAO extends DAO {

    CasaService cS = new CasaService();
    ArrayList<Comentario> listaConsulta = new ArrayList();

    public ArrayList<Comentario> novenaConsulta() throws ClassNotFoundException, SQLException, Exception {
        try {
            String sql = "select ca.id_casa,ca.tipo_vivienda, co.comentario from casas ca, comentarios co where ca.id_casa= co.id_casa and co.comentario like '%limpia%' and pais like 'Reino unido';";
            super.consultarBase(sql);
            Comentario c = null;
            while (super.resultado.next()) {
                c = new Comentario();
                c.setCasa(cS.buscarCasaPorId(super.resultado.getInt("id_casa")));
                c.setComentario(super.resultado.getString("comentario"));
              
                listaConsulta.add(c);
            }
            desconectarBase();
            for (Comentario comentario : listaConsulta) {
                System.out.println( "Id casa= "+ c.getCasa().getId_casa() + " Comentario= "+c.getComentario());
            }
            return listaConsulta;
        } catch (Exception e) {
    
            desconectarBase();
            throw e;
        }

    }
}

//    public  Comentario buscarComentarioPorId(int id_casa) throws Exception {
//       try {
//            String sql = "SELECT * FROM Comentarios WHERE id_casa="
//                    + id_casa + ";";
//            super.consultarBase(sql);
//            Comentario co = null;
//            while (resultado.next()) {
//                co = new Comentario();
//                co.setComentario(super.resultado.getString("comentario"));
//                co.setId_comentario(super.resultado.getInt("id_comentario"));
//                co.setCasa(cS.buscarCasaPorId(id_casa));
//            }
//            desconectarBase();
//            return co;
//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
//        }
//}

