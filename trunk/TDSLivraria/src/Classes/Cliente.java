/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcio
 */
public class Cliente extends Pessoa{
    
    String email;
    String endereco;
    private int id;

    public Cliente(String email, String endereco, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.email = email;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public boolean cadastrar(DB instance) throws SQLException{
        String insert = "INSERT INTO clientes ";
        String values = "VALUES (default,";
        values += "'" + this.getNome() + "', ";
        values += "'" + this.getCpf() + "', ";
        values += "'" + this.getTelefone() + "', ";
        values += "'" + this.getEmail() + "', ";
        values += "'" + this.getEndereco() + "')";
        
        ResultSet af = instance.insereReturning(insert+values);
        if(af != null){
            af.next();
            this.id = af.getInt("id_cliente");
            return true;
        }else{
            return false;
        }
    }

}
