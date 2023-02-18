<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<JavaBeans> listaDeUsuarios = (ArrayList<JavaBeans>) request.getAttribute("listaDeUsuarios");
%>

<!DOCTYPE html>
<html lang="pt_br">
	
	<head>
		<meta charset="UTF-8">
		<title>Portal Aprendizes BB - Usuários</title>
		
		<link rel="icon" href="images/iconBB.png">
		<link rel="stylesheet" href="style.css">		
	</head>
	
	<body>
		
		<table id="tabela01">
			<thead>
				<tr>
					<th>Matrícula</th>
					<th>Nome Completo</th>
					<th>E-mail de contato</th>
					<th>Telefone de contato</th>
					<th>Gênero</th>
					<th>Categoria</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i = 0; i < listaDeUsuarios.size(); i++){ %>
					<tr>
						<td><%=listaDeUsuarios.get(i).getMatricula() %></td>
						<td><%=listaDeUsuarios.get(i).getNome() %></td>
						<td><%=listaDeUsuarios.get(i).getEmail() %></td>
						<td><%=listaDeUsuarios.get(i).getTelefone() %></td>
						<td><%=listaDeUsuarios.get(i).getGenero() %></td>
						<td><%=listaDeUsuarios.get(i).getCategoria() %></td>
						<td>
							<a href="selecionarUsuario?matricula=<%=listaDeUsuarios.get(i).getMatricula() %>" class="botao01">Editar</a>
							<%-- <a href="apagarUsuario?matricula=<%=listaDeUsuarios.get(i).getMatricula() %>" class="botao02" onclick="confirmarExclusaoDeRegistro()">Apagar</a> --%>
							<a href="javascript: confirmarExclusaoDeRegistro('<%=listaDeUsuarios.get(i).getMatricula() %>')" class="botao02">Apagar</a>
						</td>
						
					</tr>
				<%} %>
			</tbody>
		</table>
		
		<br>
		
		<a href="novoUsuario.html" class="botao01">Novo Usuário</a>
		<a href="gerarRelatorioDeUsuarios" class="botao01">Gerar relatório</a>
		
		<script src="scripts/confirmadorDeExclusao.js"></script>
		
	</body>
</html>