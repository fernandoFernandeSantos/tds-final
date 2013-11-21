/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcio
 */
public class Funcionario extends Pessoa {
    
    private String login;
    private String senha;
    private String funcao;
    private int id;

    public Funcionario(String login, String senha, String funcao, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.login = login;
        this.senha = senha;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public boolean cadastrar(DB instance){
        String insert = "INSERT INTO funcionarios ";
        String values = "VALUES (default,";
        values += "'" + this.getLogin() + "', ";
        values += "'" + this.getSenha() + "', ";
        values += "'" + this.getNome() + "', ";
        values += "'" + this.getCpf() + "', ";
        values += "'" + this.getTelefone() + "', ";
        values += "'" + this.getFuncao() + "')";
        
        System.out.println(insert+values);
        int af = instance.insere(insert+values);
        if(af > 0){
            return true;
        }
        return false;
    }
    
    public static Funcionario logar(String login, String senha, DB instance) {
        String select = "SELECT * ";
        String from = "FROM funcionarios ";
        String where = "WHERE senha = '" + senha + "' AND UPPER(login) = UPPER('" + login +"')";
        Funcionario f = null;
        ResultSet res = DB.getInstance().pesquisa(select + from + where);
        try {
            if(res.next()){
                f = new Funcionario(res.getString("login"),
                        res.getString("senha"),
                        res.getString("funcao"),
                        res.getString("nome"),
                        res.getString("cpf"),
                        res.getString("telefone"));
                f.setId(res.getInt("id_funcionario"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
        return f;
    }
    
}
