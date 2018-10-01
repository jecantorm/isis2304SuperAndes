package uniandes.isis2304.superAndes.negocio;

public class PersonaNatural extends Cliente{
	
	private String documento;
	
	public PersonaNatural()
	{
		super();
		documento = "";
	}
	
	public PersonaNatural(String nombre, String correo, int puntosFidelizacion, String documento)
	{
		super(nombre,correo,puntosFidelizacion);
		this.documento = documento;
	}
	
	public String getNombre(){return super.getNombre();}
	public String getCorreo(){return super.getCorreo();}
	public int getPuntosFidelizacion(){return super.getPuntosFidelizacion();}
	public String getDocumento(){return documento;}
	
	public void setNombre(String nombre){super.setNombre(nombre);}
	public void setCorreo(String correo){super.setCorreo(correo);}
	public void setPuntosFidelizacion(int puntosFidelizacion){super.setPuntosFidelizacion(puntosFidelizacion);}
	public void setDocumento(String documento){ this.documento = documento;}

}
