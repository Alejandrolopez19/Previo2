package co.empresa.test.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.dao.UsuarioDao;

public class test {

	
	
	public static void main(String[] args) throws SQLException {
		
		
	//	Usuario u1 = new Usuario("alejandro","email@com", "colombianito");
		
		UsuarioDao u2 = new UsuarioDao();
		
		//u2.insert(u1);
		
		List <Usuario> usuarios = new ArrayList<>();
		usuarios=u2.selectAll();
		System.out.println(usuarios);
		System.out.println("ENtra");
	}
	
}


