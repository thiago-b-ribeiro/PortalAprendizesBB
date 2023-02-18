/**
 * Confirmador de exclusão de registros
 * @author Thiago Barbosa Ribeiro
 */

 function confirmarExclusaoDeRegistro(chavePrimaria){
	 let resposta = confirm("Confirma a exclusão do registro?")
	 
	 if (resposta === true){
		 window.location.href = "apagarUsuario?matricula=" + chavePrimaria
		 
	 }
 }