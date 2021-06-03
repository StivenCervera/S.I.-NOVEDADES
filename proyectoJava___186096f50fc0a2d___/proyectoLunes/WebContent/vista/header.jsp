<%@page session="true"%>
<% 
if(session.getAttribute("usuarios")!=null)
{
	if(request.getParameter("men")!=null){
		%>
		<script>
		alert("<%=request.getParameter("men")%>");
		</script>
		
	<%	
	}

%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<link href="assets/estilos.css" rel="stylesheet"> 
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color:gray">
  
  <div class="container-fluid">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarScroll">
      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="UsuarioController?accion=Principal">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="usuarioControlador?accion=registrar">Registrar</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="usuarioControlador?accion=consultar">Consultar</a>
        </li>
        
    <div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    ${usuarios.getNomUsuario()}
  </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="#">${usuarios.getNombreUsuario()} ${usuarios.getApellidoUsuario()} </a></li>
    <li><a class="dropdown-item" href="usuarioControlador?accion=salir">Cerrar sesion</a></li>
      </ul>
      
   </ul>
</div>
      
</div>
      
    </div>
  </div>
</nav>
<%
}
else{
	request.getRequestDispatcher("../usuarioControlador?accion=login&men=Usted no ha accedido").forward(request, response);
}
%>