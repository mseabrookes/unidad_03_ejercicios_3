package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ejercicio_03_03_02 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "birt";
        String contrasena = "birt";
        
        String informacion_prepared_statement = "select * from country where continent=?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); PreparedStatement acceso = conexion.prepareStatement(informacion_prepared_statement)) {
        	System.out.println("Por favor, introduzca el nombre del continente cuyos paises usted desea visualizar:");
        	System.out.println("ADVERTENCIA");
            System.out.println("Debido a como esta estructurada la base de datos, se requiere introducir el nombre del contiente en ingles para el correcto funcionamiento del programa.");
            String nombre_continente = Consola.readString();
            acceso.setString(1, nombre_continente);

            try (ResultSet resultado_acceso = acceso.executeQuery()) {
                while (resultado_acceso.next()) {
                    System.out.println(resultado_acceso.getString(2));
                }
            }
            catch (Exception e) {
            	e.printStackTrace();
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}