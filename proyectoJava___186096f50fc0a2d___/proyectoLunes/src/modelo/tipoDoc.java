package modelo;

public class tipoDoc {
	private int idtipoDocumento;
	private String tipoDocumento;
	
	
	
	public tipoDoc() {
		
	}
	
	
	
	public tipoDoc(int idtipoDocumento,String tipoDocumento) {
		this.idtipoDocumento=idtipoDocumento;
		this.tipoDocumento=tipoDocumento;
	}
	
	
	
	public int getIdtipoDocumento() {
		return idtipoDocumento;
	}
	public void setIdtipoDocumento(int idtipoDocumento) {
		this.idtipoDocumento = idtipoDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
