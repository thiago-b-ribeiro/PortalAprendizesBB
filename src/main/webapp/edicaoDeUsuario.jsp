<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt_br">
	
	<head>
		<meta charset="UTF-8">
		<title>Portal Aprendizes BB - Editar Usuários</title>
		
		<link rel="icon" href="images/iconBB.png">
		<link rel="stylesheet" href="style.css">		
	</head>
	
	<body>
	
		<h1>Edição de Dados do Usuário</h1>
		<form name="frmNovoUsuario" action="alterarDadosUsuario">
		
			<table>
			
				<tr>
					<td><input type="text" name="matricula" class="caixaDeTexto01" readonly value="<%out.println(request.getAttribute("matricula")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="nome" class="caixaDeTexto01" value="<%out.println(request.getAttribute("nome")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="email" class="caixaDeTexto01" value="<%out.println(request.getAttribute("email")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="telefone" class="caixaDeTexto02" value="<%out.println(request.getAttribute("telefone")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="genero" class="caixaDeTexto01" value="<%out.println(request.getAttribute("genero")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="categoria" class="caixaDeTexto01" value="<%out.println(request.getAttribute("categoria")); %>"></td>
				</tr>
				
			</table>
			
			<input type="button" value="Salvar" class="botao01" onclick="validarCamposPreenchidos()">
			
		</form>
		
		<script src="scripts/validadorDeCampos.js"></script>
		
	</body>
	
</html>