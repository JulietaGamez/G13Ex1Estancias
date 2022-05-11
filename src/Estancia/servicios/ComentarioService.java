
package Estancia.servicios;


import Estancia.entidades.Comentario;
import Estancia.persistencia.ComentarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComentarioService {
    ComentarioDAO cD= new ComentarioDAO();
public void Mostrar9() throws SQLException, Exception {
      cD.novenaConsulta();
        
    }
}
