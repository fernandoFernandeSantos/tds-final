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
public class Livro {
    /*
    Cadastro/Busca de livros (título, autor(es), editora, ISBN, edição, número de páginas e categoria 
(técnico, romance, infantil, adulto, religioso, literatura brasileira e literatura estrangeira); 

    */
    private String titulo;
    private String autores;
    private String editora;
    private String isbn;
    private String edicao;
    private int numeroPaginas;
    private String categoria;
    private int id;

    public Livro() {
    }

    public Livro(String titulo, String autores, String editora, String isbn, String edicao, int numeroPaginas, String categoria) {
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.isbn = isbn;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
        this.categoria = categoria;
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

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
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
  
    
    
}
