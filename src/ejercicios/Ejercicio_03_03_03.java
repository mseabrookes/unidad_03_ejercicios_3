package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ejercicio_03_03_03 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "birt";
        String contrasena = "birt";
        
        String informacion_prepared_statement = "Update country set population = ? where code = ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); PreparedStatement acceso = conexion.prepareStatement(informacion_prepared_statement)) {
        		System.out.println("Por favor, introduzca el código del país cuya población usted desea actualizar:");
                String codigo_pais = Consola.readString();
                acceso.setString(2, codigo_pais);
                
                System.out.println("Por favor, introduzca el nuevo número de población:");
                int poblacion_pais_actualizada = Consola.readInt();

                acceso.setInt(1, poblacion_pais_actualizada);
                int resultado = acceso.executeUpdate();

                if (resultado == 1) {
                    System.out.println("La población del país cuyo código es " + codigo_pais + " ha sido actualizada.");
                    System.out.println("Nuevo número de población: " + poblacion_pais_actualizada);
                }
                //resultado será 1 al efectuar correctamente la actualización de la base de datos. Debido a como esta estructurado el programa, únicamente se puede seleccionar un codigo de país por ejecucción.
                else {
                    System.out.println("La base de datos no se ha actualizado.");
                }
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}