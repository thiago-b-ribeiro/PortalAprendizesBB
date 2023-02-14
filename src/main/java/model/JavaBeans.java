package model;

public class JavaBeans {

	private String matricula;
	private String nome;
	private String email;
	private long telefone;
	private String genero;
	private byte categoria;
	
	public JavaBeans() {
		super();
		
	}

	public JavaBeans(String matricula, String nome, String email, long telefone, String genero, byte categoria) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.genero = genero;
		this.categoria = categoria;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public byte getCategoria() {
		return categoria;
	}

	public void setCategoria(byte categoria) {
		this.categoria = categoria;
	}
	
}
