/**
 * Validador de dados de formulário
 * @author Thiago Barbosa Ribeiro
 */

 function validar(){
	 let matricula = frmNovoUsuario.matricula.value
	 let nome = frmNovoUsuario.nome.value
	 let email = frmNovoUsuario.email.value
	 let telefone = frmNovoUsuario.telefone.value
	 let genero = frmNovoUsuario.genero.value
	 let categoria = frmNovoUsuario.categoria.value
	 
	 if(matricula === "" ||
	    nome      === "" ||
	    email     === "" ||
	    telefone  === "" ||
	    genero    === "" ||
	    categoria === ""){
		alert('Todos os campos devem ser preenchidos.')
		frmNovoUsuario.matricula.focus()
		return false		
	 }  else{
		document.forms['frmNovoUsuario'].submit()
	 }
	 
 }