<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<div>

<form method="post" action="usuarioControlador">
<div class="card" style="width: 18rem; margin:50px auto;">
<h1>Login</h1>
  <div class="card-body">
  <div class="mb-3">
    <label for="usuario" class="form-label">Usuario</label>
    <input type="text" class="form-control" name="usuario" placeholder="Ingresar usuario">
    
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Ingresar contraseña">
  </div>
  
  <button type="submit" class="btn btn-primary" name="accion" value="Ingresar">Ingresar</button>
</form>
  </div>
</div>
<div class="alert alert-primary" role="alert">
<%
if(request.getParameter("men")!=null){
	out.println(request.getParameter("men"));
}
%>
</div>


</div>
</body>

</body>
</html>