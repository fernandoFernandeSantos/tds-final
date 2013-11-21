/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author marcio
 */
public class Cliente extends Pessoa{
    
    String email;
    String endereco;

    public Cliente(String email, String endereco, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.email = email;
        this.endereco = endereco;
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
    
    public void cadastrar(DB instance){
        
    }

}
