<%@ include file="header.jsp" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Registrar</title>
</head>
<body>
<h1><b><i>Registrar Usuario</i></b></h1>
<hr>

<div class="container">
  <form class="form-horizontal" action="usuarioControlador" method="post"  enctype="multipart/form-data">
    <div class="row">
      <div class="col-sm-6">
        <div class="form-group">
       
            <input  class="form-control"  type="text" name="nombre" placeholder="Ingresa nombre">
            <br>
            <input type="text" class="form-control" name="correo" placeholder="Ingresa correo">
            <br>
              <input type="text" class="form-control" name="pass" placeholder="Ingresa contraseñá">
          
        </div>
      </div>
      <div class="col-sm-6">
        <div class="form-group">
          
            <input type="text" class="form-control" name="apellido" placeholder="Ingresa apellido">
            <br>
             <input type="text" class="form-control" name="usuario" placeholder="Ingresa usuario">
             <br>
             <select name="selec" class="form-control"><c:forEach var="tipoDoc" items="${tipodoc}">
		
		<option value="${tipoDoc.getIdtipoDocumento()}">${tipoDoc.getTipoDocumento()}</option>
		</c:forEach>
			</select>
         
        </div>
      </div>
       <div class="col-sm-12">
        <div class="form-group">
          <div class="col-md-13">
       <input type="file" name="foto" class="form-control">
       <br>
          </div>
        </div>
      </div>
      <center>
        <div class="btn-group">
				   	<input type="submit" name="accion" value="Guardar"class="btn btn-primary">
							</div></center>
    </div>
  </form>
</div>
</body>
</html>
<%@ include file="footer.jsp" %>