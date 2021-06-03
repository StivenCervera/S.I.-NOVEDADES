<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="asset/Style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Listar</title>
</head>
<body>
<center>
<table  id="racetimes">
<tr>		<th id="firstrow"> Foto Perfil</th>
			<th>ID usuario</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Correo</th>
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>ID tipo documento</th>
			
			<th></th>

</tr>
<c:forEach var="usuario" items="${lista}">
<tr>
					<td><img src="controladorimg?id=${usuario.getIdUsuario()}" width="150"  height="150"></td>
						<td>${usuario.getIdUsuario()} </td>
						<td>${usuario.getNombreUsuario()} </td>
						<td>${usuario.getApellidoUsuario()} </td>
						<td>${usuario.getDireccionUsuario()} </td>
						<td>${usuario.getNomUsuario()} </td>
						<td>${usuario.getPassUsuario()} </td>
						<td>${usuario.getIdtipodocumentoFK()} </td>

						<td>
				   <div class="btn-group">
				   <a class="btn btn-info" href="usuarioControlador?accion=editar&id=${usuario.getIdUsuario()}">Editar</a>
						<a class="btn btn-primary" Style="background-color:red; border:red;"href="usuarioControlador?accion=eliminar&id=${usuario.getIdUsuario()}">Eliminar</a>
							</div>
						</td>
</tr>
</c:forEach>

</table>
</body>
</html>

<%@ include file="footer.jsp" %>