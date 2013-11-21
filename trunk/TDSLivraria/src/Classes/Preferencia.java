/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;

/**
 *
 * @author Marcelo
 */
public class Preferencia {
    
    private int id_cliente;
    private String preferencia;

    public Preferencia(int id_cliente, String preferencia) {
        this.id_cliente = id_cliente;
        this.preferencia = preferencia;
    }

    public Preferencia() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
    
    public boolean cadastrar(DB instance){
        
        String insert = "INSERT INTO preferencias ";
        String values = "VALUES (";
        values += this.getId_cliente() + ", ";
        values += "'" + this.getPreferencia() +"')";
        
        int af = instance.insere(insert+values);
        if(af > 0){
            return true;
        }
        return false;
        
    }
    
}
