package co.empresa.test.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.empresa.test.dao.EleccionDao;
import co.empresa.test.modelo.Eleccion;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class EleccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EleccionDao eleccionDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleccionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.eleccionDao = new EleccionDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case"/insert":
			insertarUsuario(request, response);
			break;
		case "/delete":
			eliminarUsuario(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			actualizarUsuario(request, response);
			break;
			default: 
				listUsuarios(request, response);
				break;
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccion.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		String nombre= request.getParameter("nombre");
		Date email= request.getParameter("fechainicio");
		Date pais= request.getParameter("fechafin");
		String cargo= request.getParameter("cargo");
		
		Eleccion eleccion = new Eleccion (nombre, fechainicio, fechafin, cargo);
		
	    eleccionDao.insert(eleccion);
	    System.out.println(eleccion.toString());
		
		response.sendRedirect("list");
		}
	
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Eleccion usuarioActual = eleccionDao.select(id);
			
			request.setAttribute("usuario", usuarioActual);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		    dispatcher.forward(request, response);
	}
	
	

	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String nombre = request.getParameter("nombre");
		        Date fechainicio = request.getParameter("fechainicio");
		        Date fechafin = request.getParameter("fechafin");
		        String cargo = request.getParameter("cargo");

		        Eleccion usuarioActual = eleccionDao.select(id);
		        usuarioActual.setNombre(nombre);
		        usuarioActual.setFechainicio(fechainicio);
		        usuarioActual.setFechafin(fechafin);
		        usuarioActual.setCargo(cargo);
		        
		        System.out.println(usuarioActual.getFechainicio());
		        eleccionDao.uptade(usuarioActual);
		        response.sendRedirect("list");
		    }
	

	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
	    eleccionDao.delete(id);
		
		response.sendRedirect("list");
		}
	
	private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
		List <Eleccion> listUsuarios = eleccionDao.selectAll();
		request.setAttribute("listUsuarios", listUsuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuariolist.jsp");
	    dispatcher.forward(request, response);
		
}
	
}

