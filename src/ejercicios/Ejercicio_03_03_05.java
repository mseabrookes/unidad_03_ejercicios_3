package ejercicios;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Ejercicio_03_03_05 {

    public static void main(String[] args) {
    	
        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "birt";
        String contrasena = "birt";
        
        String informacion_callable_statement = "{call actu_pobla(?,?,?)}";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); CallableStatement acceso = conexion.prepareCall(informacion_callable_statement)) {
            
        	acceso.setString(1, "ALB");
        	acceso.setInt(2, 2);
        	acceso.registerOutParameter(3, java.sql.Types.INTEGER);

        	acceso.execute();

            int actualizaciones = acceso.getInt(3);
            //Por el bien de mi entendimiento, me he tomado la libertad de cambiar "filas" por "actualizaciones".
            System.out.println("Número de filas actualizadas: " + actualizaciones);

        } catch (Exception e) {
        	e.printStackTrace();
        }
        //Por el bien de mi entendimiento, me he tomado la libertad de cambiar "actu_pobla " por "acceso".
    }
}