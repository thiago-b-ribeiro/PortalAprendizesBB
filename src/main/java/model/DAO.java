package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	private String driver   = "com.mysql.cj.jdbc.Driver";
	private String url      = "jdbc:mysql://127.0.0.1:3306/dbAprendizesBB?useTimezone=true&serverTimezone=UTC";
	private String user     = "root";
	private String password = "Recomeco137!";
	
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
	
	public void testeConectar() {
		try {
			Connection con = conectar();	
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirNovoUsuario(JavaBeans usuario) {
		String create = "INSERT INTO tbUsuarios (matricula, nome, email, telefone, genero, categoria) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
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
}
