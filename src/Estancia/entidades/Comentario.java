/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estancia.entidades;

public class Comentario {
    private int id_comentario;
    private Casa casa;
    private String comentario;

    public Comentario() {
    }

    public Comentario(int id_comentario, Casa casa, String comentario) {
        this.id_comentario = id_comentario;
        this.casa = casa;
        this.comentario = comentario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }



    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id_comentario=" + id_comentario + ", id_casa=" + casa+ ", comentario=" + comentario + '}';
    }
    
}
