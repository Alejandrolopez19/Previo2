package co.empresa.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion3 {
	static final String URL = "postgres://mnjgxshj:Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV@queenie.db.elephantsql.com";
	static final String USER = "mnjgxshj";
	static final String PASS = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	 
	public static Connection crearConexion() throws ClassNotFoundException, SQLException{
	Class.forName("org.postgresql.Driver");
	Connection conexion = DriverManager.getConnection(URL, USER, PASS);
	if (conexion != null){
	System.out.print("Conexion establecida...");
	return conexion;
	}
	return null;
	}
}
