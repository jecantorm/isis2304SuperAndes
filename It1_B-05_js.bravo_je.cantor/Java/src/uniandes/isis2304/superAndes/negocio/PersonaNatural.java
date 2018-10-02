package uniandes.isis2304.superAndes.negocio;

public class PersonaNatural extends Cliente{
	
	private String numeroIdentificacion;
	
	private String tipoIdentificacion;
	
	public PersonaNatural()
	{
		super();
		numeroIdentificacion = "";
		tipoIdentificacion = "";
	}
	
	public PersonaNatural(String nombre, String correo, int puntosFidelizacion, String documento, String tipoDocumento)
	{
		super(nombre,correo,puntosFidelizacion);
		this.numeroIdentificacion = documento;
		this.tipoIdentificacion = tipoDocumento;
	}
	
	public String getNombre(){return super.getNombre();}
	public String getCorreo(){return super.getCorreo();}
	public int getPuntosFidelizacion(){return super.getPuntosFidelizacion();}
	public String getDocumento(){return numeroIdentificacion;}
	public String getTipoDocumento(){return tipoIdentificacion;}
	
	public void setNombre(String nombre){super.setNombre(nombre);}
	public void setCorreo(String correo){super.setCorreo(correo);}
	public void setPuntosFidelizacion(int puntosFidelizacion){super.setPuntosFidelizacion(puntosFidelizacion);}
	public void setDocumento(String documento){ this.numeroIdentificacion = documento;}
	public void setTipoDocumento(String tipoDocumento){this.numeroIdentificacion = tipoDocumento;}

}
