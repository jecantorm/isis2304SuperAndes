package uniandes.isis2304.superAndes.negocio;

public class Sucursal {
	
	private String direccion;
	
	private String nombre;
	
	private String ciudad;
	
	private double reordenProducto;
	
	private double capacidad;
	
	private String idBodega;
	
	private String nombreLocalVentas;
	
	public Sucursal()
	{
		this.direccion = "";
		this.nombre = "";
		this.ciudad = "";
		this.reordenProducto =  0.0;
		this.capacidad = 0.0;
		this.idBodega = "";
		this.nombreLocalVentas = "";
	}
	
	public Sucursal(String pDireccion, String pNombre, String pCiudad, double pReordenProducto, double pCapacidad, String pIdBodega, String pLocalVentas)
	{
		direccion = pDireccion;
		nombre = pNombre;
		ciudad = pCiudad;
		reordenProducto = pReordenProducto;
		capacidad = pCapacidad;
		idBodega = pIdBodega;
		nombreLocalVentas = pLocalVentas;
	}
	
	public String getDireccion(){return direccion;}
	public String getNombre(){return nombre;}
	public String getCiudad(){return ciudad;}
	public double getReordenProducto(){return reordenProducto;}
	public double getCapacidad(){return capacidad;}
	public String getIdBodega(){return idBodega;}
	public String getNombreLocalVentas(){return nombreLocalVentas;}
	
	public void setDireccion(String direccion){this.direccion = direccion;}
	public void setNombre(String nombre){this.nombre = nombre;}
	public void setCiudad(String ciudad){this.ciudad = ciudad;}
	public void setReordenProducto(double reOrdenProducto){this.reordenProducto= reOrdenProducto;}
	public void setCapacidad(double capacidad){this.capacidad = capacidad;}
	public void setIdBodega(String idBodega){this.idBodega = idBodega;}
	public void setNombreLocalVentas(String nombreLocalVentas){this.nombreLocalVentas = nombreLocalVentas;}

}
