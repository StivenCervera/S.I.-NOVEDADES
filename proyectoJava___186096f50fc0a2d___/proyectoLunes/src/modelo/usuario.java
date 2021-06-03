package modelo;

import java.io.InputStream;
import java.sql.Blob;

public class usuario {
		private int idUsuario;
		private String nombreUsuario;
		private String apellidoUsuario;
		private String direccionUsuario;
		private String nomUsuario;
		private String passUsuario;
		private int idtipodocumentoFK;
		private InputStream perfil;
		
		
		public usuario () {
			
		}
		public usuario(int idUsuario,String nombreUsuario,String apellidoUsuario,String direccionUsuario,String nomUsuario,String passUsuario,int idtipodocumentoFK,InputStream perfil) {
			this.idUsuario=idUsuario;
			this.nombreUsuario=nombreUsuario;
			this.apellidoUsuario=apellidoUsuario;
			this.direccionUsuario=direccionUsuario;
			this.nombreUsuario=nomUsuario;
			this.passUsuario=passUsuario;
			this.idtipodocumentoFK=idtipodocumentoFK;
			this.perfil=perfil;
		}
		
		
		
		
		
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		public String getNombreUsuario() {
			return nombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		public String getApellidoUsuario() {
			return apellidoUsuario;
		}
		public void setApellidoUsuario(String apellidoUsuario) {
			this.apellidoUsuario = apellidoUsuario;
		}
		public String getDireccionUsuario() {
			return direccionUsuario;
		}
		public void setDireccionUsuario(String direccionUsuario) {
			this.direccionUsuario = direccionUsuario;
		}
		public String getNomUsuario() {
			return nomUsuario;
		}
		public void setNomUsuario(String nomUsuario) {
			this.nomUsuario = nomUsuario;
		}
		public String getPassUsuario() {
			return passUsuario;
		}
		public void setPassUsuario(String passUsuario) {
			this.passUsuario = passUsuario;
		}
	
		public int getIdtipodocumentoFK() {
			return idtipodocumentoFK;
		}
		public void setIdtipodocumentoFK(int idtipodocumentoFK) {
			this.idtipodocumentoFK = idtipodocumentoFK;
		}
		public InputStream getPerfil() {
			return perfil;
		}
		public void setPerfil(InputStream inputStream) {
			this.perfil = inputStream;
		}
		
		
		
}
