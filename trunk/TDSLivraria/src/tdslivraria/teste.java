/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tdslivraria;
import Classes.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author marcelo-note
 */
public class teste {
    
    public static void main(String[] args) throws SQLException{
        DB instance = DB.getInstance();
        
        ResultSet res = instance.pesquisa("SELECT * FROM funcionarios");
        
        res.absolute(-1);
        System.out.println(res.getRow());
    }

}
