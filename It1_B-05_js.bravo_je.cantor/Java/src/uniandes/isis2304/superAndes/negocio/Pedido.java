package uniandes.isis2304.superAndes.negocio;

public class Pedido {
	
private String  fechaEntrega;
	
	private int cantidadProductos;
	
	private int calidad;
	
	private int calificacion;
	
private double  precio;
	
private double  cantidadVolumen;
	
	public Pedido()
	{
		 fechaEntrega = "";                 
		 cantidadProductos = 0; 		                    
		 calidad = 0;          
		 calificacion = 0;      		                    
		 precio = 0.0;            		                    
		 cantidadVolumen = 0.0;   
	}
	
	public Pedido(String fechaEntrega, int cantidadProductos, int calidad, int calificacion, double precio, double cantidadVolumen)
	{
		 this.fechaEntrega = fechaEntrega;                 
		 this.cantidadProductos = cantidadProductos; 		                    
		 this.calidad = calidad;          
		 this.calificacion = calificacion;      		                    
		 this.precio = precio;            		                    
		 this.cantidadVolumen = cantidadVolumen;   
	}
	
	
	
	public String getFechaEntrega(){return fechaEntrega;}
	public int getCantidadProductos(){return cantidadProductos;}
	public int getCalidad(){return calidad;}
	public int getCalificacion(){return calificacion;}
	public double getPrecio(){return precio;}
	public double getCantidadVolumen(){return cantidadVolumen;}
	
	
	public void setFechaEntrega(String fechaEntrega){this.fechaEntrega = fechaEntrega;}
	public void setCantidadProductos(int cantidadProductos){this.cantidadProductos = cantidadProductos;}
	public void setCalidad(int calidad){this.calidad = calidad;}
	public void setCalificacion(int calificacion){this.calificacion = calificacion;}
	public void setPrecio(double precio){this.precio = precio;}
	public void setCantidadVolumen(double cantidadVolumen){this.cantidadVolumen = cantidadVolumen;}
	
	
	
}
