package co.empresa.test.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.Conexion;
public class EleccionDao {
     
	private Conexion conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO eleccion (nombre, fechainicio, fechafin, cargo) VALUES (?, ?, ?, ?)";
	private static final String DELATE_USUARIO_SQL = "DELETE FROM eleccion WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE eleccion SET nombre = ?, fechainicio= ?, fechafin= ?, cargo = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM eleccion WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM eleccion;";
	
	public EleccionDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	
	public void insert(Eleccion eleccion) throws SQLException {
        System.out.println("Guardando usuario");
		try {
			PreparedStatement preparedStatement = conexion.setPreaparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, eleccion.getNombre());
			preparedStatement.setDate(2, eleccion.getFechainicio());
			preparedStatement.setDate(3, eleccion.getFechafin());
			preparedStatement.setString(4, eleccion.getCargo());
			System.out.println("Guardando eleccion ....");
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void delete (int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(DELATE_USUARIO_SQL);
		    preparedStatement.setInt(1, id);
	
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	
	
	

	
	public void uptade(Usuario usuarioActual) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuarioActual.getDocumento());
			preparedStatement.setString(1, usuarioActual.getNombre());
			preparedStatement.setString(2, usuarioActual.getApellido());
			preparedStatement.setInt(3, 0);
			preparedStatement.setDate(2, usuarioActual.getFechainicio());
			preparedStatement.setDate(3, usuarioActual.getFechafin());
			preparedStatement.setString(4, usuarioActual.getCargo());
			System.out.println("Guardando eleccion ....");
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	
	
	public List<Eleccion> selectAll() {
		List <Eleccion> elecciones = new ArrayList<>();
		System.out.print("entro a selectall");
    try {
		System.out.print("entro al try de select All");

    	PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(SELECT_ALL_USUARIOS);
	    
    	ResultSet rs = conexion.query();
    	
    	while(rs.next()) {
    		System.out.print("entro al while de selectAll");

    		int id = rs.getInt("id");
    		String nombre = rs.getString("nombre");
    		Date fechainicio = rs.getDate("fechainicio");
    		Date fechafin = rs.getDate("fechafin");
    		String cargo = rs.getString("cargo");
    		elecciones.add(new Eleccion(id, nombre, fechainicio, fechafin, cargo));
    	}
    	
    } catch (SQLException e) {
		
	}
	
    return elecciones;
    
	}
	
	
	public Eleccion select(int id) {
		Eleccion eleccion = null;
		
		List <Eleccion> elecciones = new ArrayList<>();
		
    try {
	
    	PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(SELECT_USUARIO_BY_ID);
	    preparedStatement.setInt(1, id);
    	
	    ResultSet rs = conexion.query();
    	
	    
    	while(rs.next()) {
    		String nombre = rs.getString("nombre");
    		Date fechainicio = rs.getDate("email");
    		Date fechafin = rs.getDate("pais");
    		String cargo = rs.getString("cargo");
    		eleccion = new Eleccion(id, nombre, fechainicio, fechafin, cargo);
    	}
    	
    } catch (SQLException e) {
		
	}
	
    return eleccion;
    
	}
	
}

