package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/main", "/inserirNovoUsuario", "/selecionarUsuario", "/alterarDadosUsuario", "/apagarUsuario"})
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
		} else if(action.equals("/selecionarUsuario")) {
			selecionarUsuario(request, response);
		}  else if(action.equals("/alterarDadosUsuario")) {
			alterarDadosUsuario(request, response);
		}  else if(action.equals("/apagarUsuario")) {
			apagarUsuario(request, response);
		}  else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> listaDeUsuarios = dao.listarUsuarios();
		request.setAttribute("listaDeUsuarios", listaDeUsuarios);
		RequestDispatcher rd = request.getRequestDispatcher("listaDeUsuarios.jsp");
		rd.forward(request, response);
	}
	
	protected void inserirNovoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario.setMatricula(request.getParameter("matricula"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(Long.parseLong(request.getParameter("telefone")));
		usuario.setGenero(request.getParameter("genero"));
		usuario.setCategoria(Byte.parseByte(request.getParameter("categoria")));
		
		dao.inserirNovoUsuario(usuario);
		
		response.sendRedirect("main");
	}

	protected void selecionarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String matricula = request.getParameter("matricula");

		usuario.setMatricula(matricula);
		
		dao.selecionarUsuario(usuario);
		
		request.setAttribute("matricula", usuario.getMatricula());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("telefone", usuario.getTelefone());
		request.setAttribute("genero", usuario.getGenero());
		request.setAttribute("categoria", usuario.getCategoria());
		
		RequestDispatcher rd = request.getRequestDispatcher("edicaoDeUsuario.jsp");
		rd.forward(request, response);
	}

	protected void alterarDadosUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario.setMatricula(request.getParameter("matricula"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(Long.parseLong(request.getParameter("telefone")));
		usuario.setGenero(request.getParameter("genero"));
		usuario.setCategoria(Byte.parseByte(request.getParameter("categoria")));
		
		dao.editarUsuario(usuario);
		
		response.sendRedirect("main");
	}

	protected void apagarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("matricula"));
		usuario.setMatricula(request.getParameter("matricula"));
		
		dao.apagarUsuario(usuario);
		
		response.sendRedirect("main");
	}
}
