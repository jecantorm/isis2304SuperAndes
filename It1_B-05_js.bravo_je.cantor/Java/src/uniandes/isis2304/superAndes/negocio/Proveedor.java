package uniandes.isis2304.superAndes.negocio;

public class Proveedor {
	
	private String nit;
	private String nombre;
	private int    calificacion;
	private String tipoProveedor;
	
	public Proveedor()
	{
		nit = "";         
	    nombre = "";      
		calificacion = 0;
		tipoProveedor = "";
		
	}
	
	public Proveedor(String nit, String nombre, int calificacion, String tipoProveedor)
	{
		this.nit = nit;         
	    this.nombre = nombre;      
		this.calificacion = calificacion;
		this.tipoProveedor = tipoProveedor;
		
	}
	
	public String getNit(){return nit;}          
	public String getNombre(){return nombre;}       
	public int getCalificacion(){return calificacion;} 
	public String getTipoProveedor(){return tipoProveedor;}
	
	public void setNit(String nit){this.nit=nit;}          
	public void setNombre(String nombre){this.nombre=nombre;}       
	public void setCalificacion(int calificacion){this.calificacion=calificacion;} 
	public void setTipoProveedor(String tipoProveedor){this.tipoProveedor=tipoProveedor;}
	
	

}
