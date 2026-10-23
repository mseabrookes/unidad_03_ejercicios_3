package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejercicio_03_03_04 {

    public static void main(String[] args) {
    	
        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "birt";
        String contrasena = "birt";

        String informacion_prepared_statement = "insert into city (name, countrycode, district, population) values (?,?,?,?)";
        
        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); PreparedStatement acceso = conexion.prepareStatement(informacion_prepared_statement, Statement.RETURN_GENERATED_KEYS)) {
            
            acceso.setString(1, "Lucca");
            acceso.setString(2, "ITA");
            acceso.setString(3, "Toscana");
            acceso.setInt(4, 88397);
            
            acceso.executeUpdate();

            try (ResultSet resultado_acceso = acceso.getGeneratedKeys()) {
            	while (resultado_acceso.next()) {
            		System.out.println("Se ha añadido una nueva ciudad a la base de datos.");
                    System.out.println("ID de la nueva ciudad: " + resultado_acceso.getInt(1));
                }
            } 
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}