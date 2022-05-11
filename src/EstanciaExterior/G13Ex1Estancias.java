package EstanciaExterior;


import Estancia.servicios.CasaService;
import Estancia.servicios.ComentarioService;

import Estancia.servicios.EstanciaService;
import Estancia.servicios.FamiliaServicio;
import java.sql.SQLException;

public class G13Ex1Estancias {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
     
        FamiliaServicio fS = new FamiliaServicio();
        CasaService cS = new CasaService();
        EstanciaService eS = new EstanciaService();
        ComentarioService coS=new ComentarioService();
        //fS.Mostrar1();
        //cS.Mostrar2();
        //fS.Mostrar3();
        //cS.Mostrar4();
        //eS.Mostrar5();
        eS.Mostrar6();
        //cS.Mostrar7();
        //cS.Mostrar8();
        //coS.Mostrar9();
        //eS.Mostrar10();
     
    }

}
