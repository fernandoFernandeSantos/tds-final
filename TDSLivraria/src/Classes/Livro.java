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
public class Livro {
    /*
     Cadastro/Busca de livros (título, autor(es), editora, ISBN, edição, número de páginas e categoria 
     (técnico, romance, infantil, adulto, religioso, literatura brasileira e literatura estrangeira); 

     */

    private String titulo;
    private String autores;
    private String editora;
    private String isbn;
    private int edicao;
    private int numeroPaginas;
    private String categoria;
    private int id;
    private float preco;

    public Livro() {
    }

    public Livro(String titulo, String autores, String editora, String isbn, int edicao, int numeroPaginas, String categoria, float preco) {
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.isbn = isbn;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
        this.categoria = categoria;
        this.preco = preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean cadastra() {
        ResultSet rs;

        try {
            DB.getInstance().insere("INSERT INTO livros VALUES (default, '" + this.titulo + "', '" + this.autores + "', '" + this.editora + "', '" + this.isbn + "', " + this.edicao + ", " + this.numeroPaginas + ", " + this.preco + ");");
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public ArrayList getLivros(String titulo) throws SQLException {
        ArrayList<Livro> retorno = new ArrayList<>();
        String sql = "SELECT * FROM livros WHERE titulo LIKE '%" + titulo + "%'";
        ResultSet rs = DB.getInstance().pesquisa(sql);

        while(rs.next()){
            String tituloO = rs.getString("titulo");
            String autores = rs.getString("autores");
            String editora = rs.getString("editora");
            String ISBN = rs.getString("ISBN");
            int num_paginas = rs.getInt("numero_paginas");
            float preco = rs.getFloat("preco");
            int edicao = rs.getInt("edicao");
            int id = rs.getInt("id_livro");
            
            retorno.add(new Livro(titulo, autores, editora, isbn, edicao, numeroPaginas, categoria, preco));
            
        }
        return retorno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }
    
    
    
}
