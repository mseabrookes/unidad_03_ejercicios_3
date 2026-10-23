package ejercicios;

import java.sql.*;

public class Ejercicio_03_03_06 {

    public static void main(String[] args) {
    	
    	String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "birt";
        String contrasena = "birt";
    	
        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); Statement acceso = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet resultado_acceso = acceso.executeQuery("select * from world.city where CountryCode ='ESP' order by population")) {
        	resultado_acceso.last();
        	resultado_acceso.updateInt("Population", 3223335);
        	resultado_acceso.updateRow();
        	
        	System.out.println("La población de la ciudad " + resultado_acceso.getString("Name") + " ha sido actualizada.");
        	System.out.println("Nuevo número de población: " + resultado_acceso.getInt("Population"));
            
            resultado_acceso.previous();
            resultado_acceso.updateInt("Population", 1620344);
            resultado_acceso.updateRow();
            
            System.out.println("La población de la ciudad " + resultado_acceso.getString("Name") + " ha sido actualizada.");
        	System.out.println("Nuevo número de población: " + resultado_acceso.getInt("Population"));

        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
//Nota: Me llama mucho la atención la solución provista al alumnado de este ejercicio. Siendo más especifico, me refiero a la creción de metodos para la url, usuario, contraena y consulta en lugar de hacerlo en el
//main como he acostumbrado hacer hasta ahora(y tambien he visto en previas soluciones).