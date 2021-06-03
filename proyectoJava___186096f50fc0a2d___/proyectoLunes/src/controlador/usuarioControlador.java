package controlador;
import modelo.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



/**
 * Servlet implementation class usuarioControlador
 */
@WebServlet("/usuarioControlador")
@MultipartConfig
public class usuarioControlador extends HttpServlet {
	usuario u =new usuario();
	usuarioDA0 ud= new usuarioDA0(); 
       String accion = "";
       String inicio="vista/login.jsp";
       String Principal="vista/principal.jsp";

      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("accion");
		HttpSession sesiones=request.getSession();
		if(action == null) {
			request.getRequestDispatcher("usuarioControlador?accion=login&men=Usted no ha accedido").forward(request, response);
			accion=Principal;
		}else {
			if(action.equalsIgnoreCase("login")) {
			accion=inicio;
		}else if(action.equalsIgnoreCase("Principal")){
			accion=Principal;
		}else if(action.equalsIgnoreCase("salir")) {
			 sesiones.invalidate(); 
			 request.getRequestDispatcher("usuarioControlador?accion=login&men=Se cerró la sesión").forward(request, response);
			 
		}
		
		else if(action.equalsIgnoreCase("Ingresar")) {
				
				String nomUsuario=request.getParameter("usuario");
				String passUsuario=request.getParameter("password");
				
				u.setNomUsuario(nomUsuario);
				u.setPassUsuario(passUsuario);		
					
				u=ud.validarUsuario(nomUsuario, passUsuario);
				
				if(u.getNombreUsuario()!=null) {
					System.out.println("Usuario encontrado");
					sesiones.setAttribute("usuarios", u);
			    	 request.getRequestDispatcher("usuarioControlador?accion=Principal&men=Bienvenido").forward(request, response);
					
				} else {
					request.getRequestDispatcher("usuarioControlador?accion=login&men=Datos no encontrados").forward(request, response);}
			}if(action.equalsIgnoreCase("registrar")) {
				
				accion="vista/registar.jsp";
				List lista=ud.listar();
		         request.setAttribute("tipodoc", lista);
			}else if (action.equalsIgnoreCase("Guardar")) {
				String nom=(request.getParameter("nombre"));
				String ape=(request.getParameter("apellido"));
				String corr=request.getParameter("correo");
				String usu=(request.getParameter("usuario"));
				String pass=(request.getParameter("pass"));
				int tipo=Integer.parseInt(request.getParameter("selec"));
			
				Part part=request.getPart("foto");
				InputStream InputStream=part.getInputStream();
		u.setNombreUsuario(nom);
		u.setApellidoUsuario(ape);
		u.setDireccionUsuario(corr);
		u.setNomUsuario(usu);
		u.setPassUsuario(pass);
		u.setIdtipodocumentoFK(tipo);
		u.setPerfil(InputStream);
		ud.Insertar(u);
		request.getRequestDispatcher("usuarioControlador?accion=consultar&men=USUARIO REGISTRADO CORRECTAMENTE").forward(request, response);
			}else if(action.equalsIgnoreCase("consultar")) {
			List<usuario>lista= ud.listusu();
			request.setAttribute("lista", lista);
			accion="vista/listar.jsp";
		}
			else if(action.equalsIgnoreCase("Eliminar")) {
				int id=Integer.parseInt(request.getParameter("id"));
				u.setIdUsuario(id);
				ud.eliminar(id);
				request.getRequestDispatcher("usuarioControlador?accion=consultar&men=ELIMINADO CORRECTAMENTE").forward(request, response);
			}else if (action.equalsIgnoreCase("editar")) {
				
		     	request.setAttribute("usuario", request.getParameter("id"));
				List lista=ud.listar();
		         request.setAttribute("tipodoc", lista);
		         int id= Integer.parseInt(request.getParameter("id"));
		            usuario  u=ud.list(id);
		            request.setAttribute("usuarioSeleccionado", u);
		            accion ="vista/consulta.jsp";
			}else if(action.equalsIgnoreCase("Actualizar")) {
				int id=Integer.parseInt(request.getParameter("idUsuario"));
				String nom=(request.getParameter("nombre"));
				String ape=(request.getParameter("apellido"));
				String corr=request.getParameter("correo");
				String pass=(request.getParameter("pass"));
				int tipo=Integer.parseInt(request.getParameter("selec"));
						u.setIdUsuario(id);
		u.setNombreUsuario(nom);
		u.setApellidoUsuario(ape);
		u.setDireccionUsuario(corr);
		u.setPassUsuario(pass);
		u.setIdtipodocumentoFK(tipo);

		ud.Actualizar(u);
		
		request.getRequestDispatcher("usuarioControlador?accion=consultar&men=USUARIO ACTUALIZADO CORRECTAMENTE").forward(request, response);
			}
		}
		
		
		RequestDispatcher vista =request.getRequestDispatcher(accion);
		vista.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
