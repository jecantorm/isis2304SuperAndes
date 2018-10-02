package uniandes.isis2304.superAndes.negocio;

public class PersonaNatural extends Cliente{
	
	private String documento;
	
	private String tipoDocumento;
	
	public PersonaNatural()
	{
		super();
		documento = "";
		tipoDocumento = "";
	}
	
	public PersonaNatural(String nombre, String correo, int puntosFidelizacion, String documento, String tipoDocumento)
	{
		super(nombre,correo,puntosFidelizacion,"Persona Natural");
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNombre(){return super.getNombre();}
	public String getCorreo(){return super.getCorreo();}
	public int getPuntosFidelizacion(){return super.getPuntosFidelizacion();}
	public String getDocumento(){return documento;}
	public String getTipoDocumento(){return tipoDocumento;}
	
	public void setNombre(String nombre){super.setNombre(nombre);}
	public void setCorreo(String correo){super.setCorreo(correo);}
	public void setPuntosFidelizacion(int puntosFidelizacion){super.setPuntosFidelizacion(puntosFidelizacion);}
	public void setDocumento(String documento){ this.documento = documento;}
	public void setTipoDocumento(String tipoDocumento){this.tipoDocumento = tipoDocumento;}

}
