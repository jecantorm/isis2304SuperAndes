package uniandes.isis2304.superAndes.negocio;

public class Empresa extends Cliente{
	
	private String nit;
	
	private String direccion;
	
	private String correo;
	
	public Empresa()
	{
		super();
		nit = "";
		direccion = "";
		correo = "";
	}
	
	public Empresa(String nombre, String correo, int puntosFidelizacion, String documento, String nit, String direccion)
	{
		super(nombre,correo,puntosFidelizacion);
		this.direccion = direccion;
		this.nit = nit;
		this.correo = correo;
	}
	
	public String getNombre(){return super.getNombre();}
	public String getCorreo(){return super.getCorreo();}
	public int getPuntosFidelizacion(){return super.getPuntosFidelizacion();}
	public String getDireccion(){return direccion;}
	public String getNIT(){return nit;}
	
	
	public void setNombre(String nombre){super.setNombre(nombre);}
	public void setCorreo(String correo){super.setCorreo(correo);}
	public void setPuntosFidelizacion(int puntosFidelizacion){super.setPuntosFidelizacion(puntosFidelizacion);}
	public void setDocumento(String direccion){ this.direccion = direccion;}
	public void setNIT(String nit){this.nit = nit;}

}
