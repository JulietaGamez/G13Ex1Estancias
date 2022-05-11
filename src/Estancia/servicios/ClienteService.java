/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estancia.servicios;

import Estancia.entidades.Cliente;
import Estancia.persistencia.ClienteDAO;

/**
 *
 * @author julietagamez
 */
public class ClienteService {
    ClienteDAO cD= new ClienteDAO();
    public Cliente buscarClientePorId(int id_cliente) throws Exception {

        try {

            //Validacion
            if (id_cliente < 0) {
                throw new Exception("Debe indicar un codigo de cliente");

            }
            Cliente cliente = cD.buscarClientePorId(id_cliente);

            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }
}

