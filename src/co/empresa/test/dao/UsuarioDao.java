package co.empresa.test.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.Conexion;
public class UsuarioDao {
     
	private Conexion conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?)";
	private static final String DELATE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?, email= ?, pais= ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario;";
	
	public UsuarioDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	
	public void insert(Usuario usuario) throws SQLException {
        System.out.println("Guardando usuario");
		try {
			PreparedStatement preparedStatement = conexion.setPreaparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			System.out.println("Guardando usuario ....");
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
	
	
	
	

	
	public void uptade(Usuario usuario) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(UPDATE_USUARIO_SQL);
		    preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	
	
	public List<Usuario> selectAll() {
		List <Usuario> usuarios = new ArrayList<>();
		System.out.print("entro a selectall");
    try {
		System.out.print("entro al try de select All");

    	PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(SELECT_ALL_USUARIOS);
	    
    	ResultSet rs = conexion.query();
    	
    	while(rs.next()) {
    		System.out.print("entro al while de selectAll");

    		int id = rs.getInt("id");
    		String nombre = rs.getString("nombre");
    		String email = rs.getString("email");
    		String pais = rs.getString("pais");
    		usuarios.add(new Usuario(id, nombre, email, pais));
    	}
    	
    } catch (SQLException e) {
		
	}
	
    return usuarios;
    
	}
	
	
	public Usuario select(int id) {
		Usuario usuario = null;
		
		List <Usuario> usuarios = new ArrayList<>();
		
    try {
	
    	PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreaparedStatement(SELECT_USUARIO_BY_ID);
	    preparedStatement.setInt(1, id);
    	
	    ResultSet rs = conexion.query();
    	
	    
    	while(rs.next()) {
    		String nombre = rs.getString("nombre");
    		String email = rs.getString("email");
    		String pais = rs.getString("pais");
    		usuario = new Usuario(id, nombre, email, pais);
    	}
    	
    } catch (SQLException e) {
		
	}
	
    return usuario;
    
	}
	
}
