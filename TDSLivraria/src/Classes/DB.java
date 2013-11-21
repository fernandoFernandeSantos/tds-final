package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public final class DB {
       Connection con;
       int x;
       
       static private DB INSTANCE;
    
    private DB(){
         this.start();
    }
    public static DB getInstance(){
        if(INSTANCE   == null){
            INSTANCE = new DB();
        }
        return INSTANCE;
        
    }
    
    public void start(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String usuario = "postgres";
            String senha = "admin";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao se conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public ResultSet pesquisa(String Query){
        
        Statement stm = null;
        ResultSet rs = null;
        try {
//            stm = con.createStatement();
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //stm.executeUpdate("INSERT INTO funcionarios VALUES (default,'Admin', 'admin')");
            rs = stm.executeQuery(Query);
        //    con.close();
            return rs;
        } catch (SQLException ex) {
            return rs;
        }
        
    }
    
    public int insere(String Query){
        
        Statement stm = null;
        //ResultSet rs = null;
        int affectedRows = 0;
        try {
//            stm = con.createStatement();
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            affectedRows = stm.executeUpdate(Query);
            //rs = stm.executeQuery(Query);
          //  con.close();
            return affectedRows;
        } catch (SQLException ex) {
            return affectedRows;
        }
        
    }
    
    
    
    
}
