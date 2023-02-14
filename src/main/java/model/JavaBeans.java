package model;

public class JavaBeans {

	private String matriculaAprendiz;
	private String nomeAprendiz;
	private String emailAprendiz;
	private long telefoneAprendiz;
	private String generoAprendiz;
	
	public JavaBeans() {
		super();
		
	}

	public JavaBeans(String matriculaAprendiz, String nomeAprendiz, String emailAprendiz, long telefoneAprendiz, String generoAprendiz) {
		super();
		this.matriculaAprendiz = matriculaAprendiz;
		this.nomeAprendiz = nomeAprendiz;
		this.emailAprendiz = emailAprendiz;
		this.telefoneAprendiz = telefoneAprendiz;
		this.generoAprendiz = generoAprendiz;
	}

	public String getMatriculaAprendiz() {
		return matriculaAprendiz;
	}

	public void setMatriculaAprendiz(String matriculaAprendiz) {
		this.matriculaAprendiz = matriculaAprendiz;
	}

	public String getNomeAprendiz() {
		return nomeAprendiz;
	}

	public void setNomeAprendiz(String nomeAprendiz) {
		this.nomeAprendiz = nomeAprendiz;
	}

	public String getEmailAprendiz() {
		return emailAprendiz;
	}

	public void setEmailAprendiz(String emailAprendiz) {
		this.emailAprendiz = emailAprendiz;
	}

	public long getTelefoneAprendiz() {
		return telefoneAprendiz;
	}

	public void setTelefoneAprendiz(long telefoneAprendiz) {
		this.telefoneAprendiz = telefoneAprendiz;
	}

	public String getGeneroAprendiz() {
		return generoAprendiz;
	}

	public void setGeneroAprendiz(String generoAprendiz) {
		this.generoAprendiz = generoAprendiz;
	}
		
}
