/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcio
 */
public class Cliente extends Pessoa {

    String email;
    String endereco;
    private int id;

    public Cliente(String email, String endereco, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente(String email, String endereco, String nome, String cpf, String telefone, int id) {
        super(nome, cpf, telefone);
        this.email = email;
        this.id = id;
        this.endereco = endereco;
    }

    public Cliente() {
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

    public boolean cadastrar(DB instance) throws SQLException {
        String insert = "INSERT INTO clientes ";
        String values = "VALUES (default,";
        values += "'" + this.getNome() + "', ";
        values += "'" + this.getCpf() + "', ";
        values += "'" + this.getTelefone() + "', ";
        values += "'" + this.getEmail() + "', ";
        values += "'" + this.getEndereco() + "')";

        ResultSet af = instance.insereReturning(insert + values);
        if (af != null) {
            af.next();
            this.id = af.getInt("id_cliente");
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getClients(String nome) throws SQLException {
        ArrayList<Cliente> retorno = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nome LIKE '%" + nome + "%'";
        ResultSet rs = DB.getInstance().pesquisa(sql);

        while (rs.next()) {
            int id = rs.getInt("id_cliente");
            nome = rs.getString("nome");
            String cpf = rs.getString("CPF");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            String endereco = rs.getString("endereco");
            retorno.add(new Cliente(email, endereco, nome, cpf, telefone, id));

        }
        return retorno;
    }

    public static void venda(Cliente cl, ArrayList<Livro> produtos, int tipo, int parcelas, Funcionario fn, String formaPag) throws SQLException {
        ResultSet rs;
        for (Livro livro : produtos) {
            DB.getInstance().insere("INSERT INTO vendas VALUES (default, " + fn.getId() + ", " + livro.getId() + ", "
                    + tipo + ", '" + formaPag + "', " + livro.getPreco() + ");");
           
              if (formaPag.equals("a_prazo")) {
                  rs = DB.getInstance().pesquisa("SELECT MAX (id_venda) as id_venda FROM vendas");
                int idVenda;
                rs.next();
                idVenda = rs.getInt("id_venda");
                DB.getInstance().insere("INSERT INTO a_prazo VALUES (" + idVenda + ", "+ parcelas + ", "+
                                        cl.getId()+ ");");

            }
        }

    }

}
