package modelo;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuarioDA0 {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	config c=new config();
	int r;
	usuario u=new usuario();
	public usuario validarUsuario(String nomUsuario,String passUsuario) {
		
		String sql="SELECT * FROM usuario WHERE  nomUsuario=? AND passUsuario=?";
		
		try {
			
			con=c.getConexion();//Abrir la conexión
			ps=con.prepareStatement(sql); //preparando la sentencia
			ps.setString(1, nomUsuario);
			ps.setString(2, passUsuario);
			rs=ps.executeQuery();//Ejecutar la sentencia
			
			while(rs.next()) {
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setNombreUsuario(rs.getString("nombreUsuario"));
				u.setApellidoUsuario(rs.getString("apellidoUsuario"));
				u.setDireccionUsuario(rs.getString("direccionUsuario"));
				u.setNomUsuario(rs.getString("nomUsuario"));
				u.setPassUsuario(rs.getString("passUsuario"));
				u.setIdtipodocumentoFK(rs.getInt("idtipodocumentoFK"));
				
			}
			
			ps.close(); // Cerrar el Statetment
			con.close(); //Devolver al pool
			
		}catch(Exception e) {
			System.out.println("Usuario no fue encontrado "+e.getMessage().toString());
			
		}
		
		return u;
	}
	
	public List listar() {
        ArrayList<tipoDoc>list=new ArrayList<>();//es una clase que permite almacenar datos en memoria de forma similar a los Arrays,
        //con la ventaja de que el numero de elementos que almacena, lo hace de forma dinámica
        String sql="select * from tipo_documento";
        try {
            con=c.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();//se usa cuando se hace una consulta 
            while(rs.next()){//para que nos de el siguiente elemento del iterador
tipoDoc l=new tipoDoc();
            	  l.setIdtipoDocumento(rs.getInt("idtipodocumento"));
            	  l.setTipoDocumento(rs.getString("tipodocumento"));
                list.add(l);
                
               
            }
        } catch (Exception e) {
        }
        return list;//retorna list 
    }
	
	public boolean Insertar(usuario u) {
		String sql= "insert into usuario(nombreUsuario,apellidoUsuario,direccionUsuario,nomUsuario,passUsuario,idtipodocumentoFK,perfil) value(?,?,?,?,?,?,?)";
		//sql es una sentencia para guardar registro que viene del controlador y se concatena los metodos (mostrar (get) o modificar (set) )
		try {
			con=c.getConexion();
			ps=con.prepareStatement(sql);
			ps.setString(1, u.getNombreUsuario());
			ps.setString(2, u.getApellidoUsuario());
			ps.setString(3, u.getDireccionUsuario());
			ps.setString(4, u.getNomUsuario());
			ps.setString(5, u.getPassUsuario());
			ps.setInt(6, u.getIdtipodocumentoFK());
			ps.setBlob(7, u.getPerfil());
		
			ps.executeUpdate();// se usa para insertar modificar y eliminar
			
			
		}catch(Exception e) {
			System.out.print("no se pudo insertar el Usuario"+e.getMessage().toString());
		}
		return false;
	}
	
	public List listusu() {
        ArrayList<usuario>list=new ArrayList<>();//es una clase que permite almacenar datos en memoria de forma similar a los Arrays,
        //con la ventaja de que el numero de elementos que almacena, lo hace de forma dinámica
        String sql="select *from usuario";
        try {
            con=c.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();//se usa cuando se hace una consulta 
            while(rs.next()){//para que nos de el siguiente elemento del iterador
usuario l=new usuario();
            	  l.setIdUsuario(rs.getInt("idUsuario"));
            	  l.setNombreUsuario(rs.getString("nombreUsuario"));
            	  l.setApellidoUsuario(rs.getString("apellidoUsuario"));
            	  l.setDireccionUsuario(rs.getString("direccionUsuario"));
            	  l.setNomUsuario(rs.getString("nomUsuario"));
            	  l.setPassUsuario(rs.getString("passUsuario"));
            	  l.setIdtipodocumentoFK(rs.getInt("idtipodocumentoFK"));
            	  l.setPerfil(rs.getBinaryStream("perfil"));
                list.add(l);
                
               
            }
        } catch (Exception e) {
        	System.out.print("no se pudo insertar el Usuario"+e.getMessage().toString());
        }
        return list;//retorna list 
    }
	
	public void listarimg (int id , HttpServletResponse response )
	{
		
		String sql="Select *from usuario where idUsuario="+id;
		InputStream  InputStream=null;//La clase abstracta InputStream declara los métodos para leer datos desde una fuente concreta
		OutputStream outputStream=null;//OutputStream es una clase abstracta que representa la salida de escritura
		BufferedInputStream BufferedInputStream=null;
		BufferedOutputStream BufferedOutputStream=null;
		response.setContentType("image/*");//guarda la ruta del,
		try {
			outputStream=response.getOutputStream();
            con=c.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();//se usa cuando se hace una consulta 
            if(rs.next()) {
            	InputStream=rs.getBinaryStream("perfil");
            }
            BufferedInputStream= new BufferedInputStream(InputStream);
            BufferedOutputStream= new BufferedOutputStream(outputStream);
            int i =0;
            while((i=BufferedInputStream.read())!=-1) {
            	BufferedOutputStream.write(i);
            }
           
        } catch (Exception e) {
        }
      
    
	}	
	
	public boolean eliminar(int id) {
	
		String sql=   "delete from usuario where idUsuario="+id;
		try {con=c.getConexion();
		ps=con.prepareStatement(sql);
		ps.executeUpdate();
		}
		catch(Exception e) {
			
		}
		return false;
				
	}

	 public usuario list(int id) {
		 usuario l =new usuario();
	        String sql="select *from usuario where idUsuario="+id;
	        try {
	        
	            con=c.getConexion();
	            ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            while(rs.next()){
	            	
	            	   l.setIdUsuario(rs.getInt("idUsuario"));
	 	              l.setNombreUsuario(rs.getString("nombreUsuario"));
	 	                l.setApellidoUsuario(rs.getString("apellidoUsuario"));
	 	                l.setDireccionUsuario(rs.getString("direccionUsuario"));
	 	             l.setNomUsuario(rs.getString("nomUsuario"));
	 	               l.setPassUsuario(rs.getString("passUsuario"));
	 	              l.setIdtipodocumentoFK(rs.getInt("idtipodocumentoFK"));
	 	             l.setPerfil(rs.getBinaryStream("perfil"));
	 	           
	            }
	        } catch (Exception e) {
	        }
	        return l;
	    }
	 public boolean Actualizar(usuario u) {
			String sql= "update usuario set nombreUsuario=?,apellidoUsuario=?,direccionUsuario=?,passUsuario=?,idtipodocumentoFK=?	 where idUsuario=?";
			try {
				con=c.getConexion();
				ps=con.prepareStatement(sql);
				ps.setString(1, u.getNombreUsuario());
				ps.setString(2, u.getApellidoUsuario());
				ps.setString(3, u.getDireccionUsuario());
			
				ps.setString(4, u.getPassUsuario());
				ps.setInt(5, u.getIdtipodocumentoFK());
				ps.setInt(6, u.getIdUsuario());
				ps.executeUpdate();
			}catch(Exception e) {}
			return false;
		}
	
}
