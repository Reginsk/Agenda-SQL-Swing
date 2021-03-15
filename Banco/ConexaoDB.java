package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String DRIVER  = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
    
    public static Connection conectar(){
        Connection conn = null;
        
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Foi");
        }catch(ClassNotFoundException ex){
            System.out.println("Erro no Driver");
        }catch(SQLException sqlex){
            System.out.println("Erro no servidor");
        }
     return conn;           
           
    }
}
