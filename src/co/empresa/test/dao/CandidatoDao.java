package co.empresa.test.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Candidato;
import co.empresa.test.modelo.Eleccion;
import co.empresa.test.util.Conexion;

public class CandidatoDao {
	     
		private Conexion conexion;
		
		private static final String INSERT_USUARIO_SQL = "INSERT INTO candidato (documento, nombre, apellido, eleccion, numero) VALUES (?, ?, ?, ?, ?)";
		private static final String DELATE_USUARIO_SQL = "DELETE FROM candidato WHERE id = ?;";
		private static final String UPDATE_USUARIO_SQL = "UPDATE candidato SET documento = ?, nombre= ?, apellido= ?, eleccion = ?, numero = ? WHERE id = ?;";
		private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM candidato WHERE id = ?;";
		private static final String SELECT_ALL_USUARIOS = "SELECT * FROM candidato;";
		
		public CandidatoDao() {
			this.conexion = Conexion.getConexion();
		}
		
		
		
		public void insert(Candidato candidato) throws SQLException {
	        System.out.println("Guardando usuario");
			try {
				PreparedStatement preparedStatement = conexion.setPreaparedStatement(INSERT_USUARIO_SQL);
				preparedStatement.setString(1, candidato.getDocumento());
				preparedStatement.setString(2, candidato.getNombre());
				preparedStatement.setString(3, candidato.getApellido());
				preparedStatement.setInt(4, candidato.getEleccion());
				preparedStatement.setInt(5, candidato.getNumero());
				System.out.println("Guardando candidato ....");
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
		
		
		
		

		
		public void uptade(Candidato candidato) throws SQLException {
			try {
				PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(UPDATE_USUARIO_SQL);
				preparedStatement.setString(1, candidato.getDocumento());
				preparedStatement.setString(2, candidato.getNombre());
				preparedStatement.setString(3, candidato.getApellido());
				preparedStatement.setInt(4, candidato.getEleccion());
				preparedStatement.setInt(5, candidato.getNumero());
				System.out.println("Guardando candidato ....");
				conexion.execute();
			} catch (SQLException e) {
				
			}
		}
		
		
		
		public List<Candidato> selectAll() {
			List <Candidato> candidatos = new ArrayList<>();
			System.out.print("entro a selectall");
	    try {
			System.out.print("entro al try de select All");

	    	PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(SELECT_ALL_USUARIOS);
		    
	    	ResultSet rs = conexion.query();
	    	
	    	while(rs.next()) {
	    		System.out.print("entro al while de selectAll");

	    		int id = rs.getInt("id");
	    		String documento = rs.getString("documento");
	    		String nombre = rs.getString("nombre");
	    		String apellido = rs.getString("apellido");
	    		int eleccion= rs.getInt("eleccion");
	    		int numero = rs.getInt("numero");
	    		candidatos.add(new Candidato(id, documento, nombre, apellido, eleccion, numero));
	    	}
	    	
	    } catch (SQLException e) {
			
		}
		
	    return candidatos;
	    
		}
		
		
		public Candidato select(int id) {
			Candidato candidato = null;
			
			List <Candidato> candidatos = new ArrayList<>();
			
	    try {
		
	    	PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(SELECT_USUARIO_BY_ID);
		    preparedStatement.setInt(1, id);
	    	
		    ResultSet rs = conexion.query();
	    	
		    
	    	while(rs.next()) {
	    		String documento = rs.getString("documento");
	    		String nombre = rs.getString("nombre");
	    		String apellido = rs.getString("apellido");
	    		int eleccion= rs.getInt("eleccion");
	    		int numero = rs.getInt("numero");	
	    		
	    		candidato = new Candidato(id, documento,nombre, apellido, eleccion, numero);
	    	}
	    	
	    } catch (SQLException e) {
			
		}
		
	    return candidato;
	    
		}
		
	}


