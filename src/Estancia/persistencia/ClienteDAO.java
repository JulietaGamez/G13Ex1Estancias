
package Estancia.persistencia;

import Estancia.entidades.Cliente;


public final class ClienteDAO extends DAO{
    public Cliente buscarClientePorId(int id_cliente) throws Exception {

        try {
            String sql = "SELECT * FROM Clientes where id_cliente ="
                    + id_cliente + ";";
            consultarBase(sql);

            Cliente cliente = null;

            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setCalle(super.resultado.getNString(3));
                cliente.setId_cliente(super.resultado.getInt(1));
                cliente.setNombre(super.resultado.getString(2));
                cliente.setCodigo_postal(super.resultado.getString(5));
                cliente.setCiudad(super.resultado.getString(6));
                cliente.setNumero(super.resultado.getInt(4));
                cliente.setEmail(super.resultado.getString(8));
                cliente.setPais(super.resultado.getString(7));
                
                
            }
            desconectarBase();
            return cliente;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

        }

    
    

