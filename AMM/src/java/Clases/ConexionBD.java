package Clases;
/**
 *
 * @author nyath
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/amm";
    private static final String USER = "root";
    private static final String PASSWORD = "1026571230";
    
    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
            return null;
        }
    }
    
}
