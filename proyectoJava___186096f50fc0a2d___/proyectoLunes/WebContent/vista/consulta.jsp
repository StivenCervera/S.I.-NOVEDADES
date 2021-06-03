<%@ include file="header.jsp" %>

<%@ include file="footer.jsp" %>
<%@ page import="modelo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>actualizar</title>
</head>
<body>
  <%
     usuarioDA0 dao= new usuarioDA0();
              int id=Integer.parseInt((String)request.getAttribute("usuario"));//el tipo de dato es string y se pasa a int para pasarselo a list
             usuario l= dao.list(id);//l me trae los datos del list 
   
          
          %>
       


<h1><b><i>Actualizar Usuario</i></b></h1>
<hr>
<div class="card" style="width: 18rem; margin:50px auto;">
      <input type="image" name="perfil" src="controladorimg?id=<%=l.getIdUsuario()%>" width="300"  height="300">
    </div>
 </div>
<div class="container">
  <form class="form-horizontal" action="usuarioControlador" method="post" enctype="multipart/form-data">
  <input type="hidden" name="idUsuario" value="<%=l.getIdUsuario()%>">
    <div class="row">
      <div class="col-sm-6">
        <div class="form-group">
       
            <input  class="form-control"  type="text" name="nombre" value="<%=l.getNombreUsuario()%>">
            <br>
            <input type="text" class="form-control" name="correo" value="<%=l.getDireccionUsuario()%>">
            <br>
              <input type="text" class="form-control" name="pass" value="<%=l.getPassUsuario()%>">
          
        </div>
      </div>
      <div class="col-sm-6">
        <div class="form-group">
          
            <input type="text" class="form-control" name="apellido" value="<%=l.getApellidoUsuario()%>">
            <br>
             <input type="text" class="form-control" name="usuario"value="<%=l.getNomUsuario()%>">
             <br> 
       
             <select name="selec" class="form-control">
     <c:forEach var="tipoDoc" items="${tipodoc}"  >
<option value="${tipoDoc.getIdtipoDocumento()}"
<c:if  test="${tipoDoc.getIdtipoDocumento()== usuarioSeleccionado.getIdtipodocumentoFK() }">selected="selected"</c:if>>
   ${tipoDoc.getTipoDocumento()}
</option>
		</c:forEach>
			</select>
         
        </div>
      </div>
      <center>
      <br>
        <div class="btn-group">
				   	<input type="submit" name="accion" value="Actualizar" class="btn btn-primary" Style="background-color:gray; border:gray;">
							</div></center>
    </div>
    <br>
     <br>
  </form>
</div>
		
</body>
</html>
<%@ include file="footer.jsp" %>