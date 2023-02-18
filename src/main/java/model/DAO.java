package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver   = "com.mysql.cj.jdbc.Driver";
	private String url      = "jdbc:mysql://127.0.0.1:3306/dbAprendizesBB?useTimezone=true&serverTimezone=UTC";
	private String user     = "root";
	private String password = "Recomeco137!";
	
	/**
	 * 	public void testeConectar() {
	 *		try {
	 *			Connection con = conectar();	
	 *			System.out.println(con);
	 *			con.close();
	 *		} catch (Exception e) {
	 *			System.out.println(e);
	 *		}
	 *	}
	 **/
			
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void inserirNovoUsuario(JavaBeans usuario) {
		String sqlInserirNovoUsuario = "INSERT INTO tbUsuarios (matricula, nome, email, telefone, genero, categoria) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sqlInserirNovoUsuario);
			
			pst.setString(1, usuario.getMatricula());
			pst.setString(2, usuario.getNome());
			pst.setString(3, usuario.getEmail());
			pst.setLong(4, usuario.getTelefone());
			pst.setString(5, usuario.getGenero());
			pst.setByte(6, usuario.getCategoria());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<JavaBeans> listarUsuarios(){		
		ArrayList<JavaBeans> listaDeUsuarios = new ArrayList<>();
		
		String sqlListarUsuarios = "SELECT * FROM tbUsuarios";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sqlListarUsuarios);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				listaDeUsuarios.add(new JavaBeans(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getByte(6)));
			}
			
			con.close();
			
			return listaDeUsuarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarUsuario(JavaBeans usuario) {		
		String sqlSelecionarUsuario = "SELECT * FROM tbUsuarios WHERE matricula = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sqlSelecionarUsuario);
			pst.setString(1, usuario.getMatricula());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario.setMatricula(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				usuario.setTelefone(rs.getLong(4));
				usuario.setGenero(rs.getString(5));
				usuario.setCategoria(rs.getByte(6));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editarUsuario(JavaBeans usuario) {
		String sqlEditarUsuario = "UPDATE tbUsuarios SET matricula = ?, nome = ?, email = ?, telefone = ?, genero = ?, categoria = ? WHERE matricula = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sqlEditarUsuario);
						
			pst.setString(1, usuario.getMatricula());
			pst.setString(2, usuario.getNome());
			pst.setString(3, usuario.getEmail());
			pst.setLong(4, usuario.getTelefone());
			pst.setString(5, usuario.getGenero());
			pst.setByte(6, usuario.getCategoria());
			pst.setString(7, usuario.getMatricula());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void apagarUsuario(JavaBeans usuario) {
		String sqlApagarUsuario = "DELETE FROM tbUsuarios WHERE matricula = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sqlApagarUsuario);
						
			pst.setString(1, usuario.getMatricula());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
