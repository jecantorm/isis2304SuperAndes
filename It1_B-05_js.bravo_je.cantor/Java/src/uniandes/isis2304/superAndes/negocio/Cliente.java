package uniandes.isis2304.superAndes.negocio;

public class Cliente {
	
	private String nombre;
	
	private String correo;
	
	private int puntosFidelizacion;
	
	public Cliente()
	{
		nombre ="";
		correo ="";
		puntosFidelizacion = 0;
	}
	
	public Cliente(String nombre, String correo, int puntosFidelizacion)
	{
		this.nombre = nombre;
		this.correo = correo;
		this.puntosFidelizacion = puntosFidelizacion;
	}
	
	public String getNombre(){return nombre;}
	public String getCorreo(){return correo;}
	public int getPuntosFidelizacion(){return puntosFidelizacion;}

	
	public void setNombre(String nombre){this.nombre = nombre;}
	public void setCorreo(String correo){this.correo = correo;}
	public void setPuntosFidelizacion(int puntosFidelizacion){this.puntosFidelizacion = puntosFidelizacion;}


}
