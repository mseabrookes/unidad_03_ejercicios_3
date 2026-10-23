package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejercicio_03_03_01 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "birt";
        String contrasena = "birt";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); Statement acceso = conexion.createStatement(); ResultSet resultado_acceso = acceso.executeQuery("Select * from country")) {
            while (resultado_acceso.next()) {
                System.out.println(resultado_acceso.getString(2));
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}