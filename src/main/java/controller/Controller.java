package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/main", "/inserirNovoUsuario"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	
	JavaBeans usuario = new JavaBeans();
	
    public Controller() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		if (action.equals("/main")){
			listarUsuarios(request, response);
		} else if(action.equals("/inserirNovoUsuario")) {
			inserirNovoUsuario(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("usuarios.jsp");
	}
	
	protected void inserirNovoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricula = request.getParameter("matricula");
		System.out.println(matricula);
		
		usuario.setMatricula(request.getParameter("matricula"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(Long.parseLong(request.getParameter("telefone")));
		usuario.setGenero(request.getParameter("genero"));
		usuario.setCategoria(Byte.parseByte(request.getParameter("categoria")));
		
		dao.inserirNovoUsuario(usuario);
		
		response.sendRedirect("main");
	}

}
