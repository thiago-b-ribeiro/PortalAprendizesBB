package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", 
						   "/main", 
						   "/inserirNovoUsuario", 
						   "/selecionarUsuario", 
						   "/alterarDadosUsuario", 
						   "/apagarUsuario", 
						   "/gerarRelatorioDeUsuarios"})
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
		}  else if(action.equals("/gerarRelatorioDeUsuarios")) {
			gerarRelatorioDeUsuarios(request, response);
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
	
	protected void gerarRelatorioDeUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document document = new Document();
		
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "Relatório De Usuários.pdf");
			
			PdfWriter.getInstance(document, response.getOutputStream());
			
			document.open();			
			document.add(new Paragraph("Lista de usuários:"));			
			document.add(new Paragraph(" "));
			
			PdfPTable table = new PdfPTable(6);
			PdfPCell col01 = new PdfPCell(new Paragraph("Matrícula"));
			PdfPCell col02 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col03 = new PdfPCell(new Paragraph("E-mail"));
			PdfPCell col04 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col05 = new PdfPCell(new Paragraph("Gênero"));
			PdfPCell col06 = new PdfPCell(new Paragraph("Categoria"));
			table.addCell(col01);
			table.addCell(col02);
			table.addCell(col03);
			table.addCell(col04);
			table.addCell(col05);
			table.addCell(col06);
			
			ArrayList<JavaBeans> listaDeUsuarios = dao.listarUsuarios();
			for(int i = 0; i < listaDeUsuarios.size(); i++){
				table.addCell(listaDeUsuarios.get(i).getMatricula());
				table.addCell(listaDeUsuarios.get(i).getNome());
				table.addCell(listaDeUsuarios.get(i).getEmail());
				table.addCell(Long.toString(listaDeUsuarios.get(i).getTelefone()));
				table.addCell(listaDeUsuarios.get(i).getGenero());
				table.addCell(Byte.toString(listaDeUsuarios.get(i).getCategoria()));
			}
			
			document.add(table);
			
			document.close();
			
		} catch (Exception e) {
			System.out.println(e);
			document.close();
		}
	}
}
