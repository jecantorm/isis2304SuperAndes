package uniandes.isis2304.superAndes.negocio;

public class Pedido {
	
	private Long numeroPedido;
	
	private String  fechaEntrega;
	
	private String sucursalSolicitante;
	
	private String nitProveedorSolicitado;
	
	private int cantidadProductos;
	
	private int calidad;
	
	private int calificacion;
	
private double  precio;
	
private double  cantidadVolumen;
	
	public Pedido()
	{
		 numeroPedido = 0L;
		 fechaEntrega = "";
		 sucursalSolicitante= "";
		 nitProveedorSolicitado = "";
		 cantidadProductos = 0; 		                    
		 calidad = 0;          
		 calificacion = 0;      		                    
		 precio = 0.0;            		                    
		 cantidadVolumen = 0.0;   
	}
	
	public Pedido(Long numeroPedido,String fechaEntrega,String sucursalSolicitante,String nitProveedorSolicitado, int cantidadProductos, int calidad, int calificacion, double precio, double cantidadVolumen)
	{
		 this.numeroPedido = numeroPedido;
		 this.fechaEntrega = fechaEntrega; 
		 this.sucursalSolicitante = sucursalSolicitante;
		 this.nitProveedorSolicitado = nitProveedorSolicitado;
		 this.cantidadProductos = cantidadProductos; 		                    
		 this.calidad = calidad;          
		 this.calificacion = calificacion;      		                    
		 this.precio = precio;            		                    
		 this.cantidadVolumen = cantidadVolumen;   
	}
	
	
	public Long getNumeroPedido(){return numeroPedido;}
	public String getFechaEntrega(){return fechaEntrega;}
	public int getCantidadProductos(){return cantidadProductos;}
	public int getCalidad(){return calidad;}
	public int getCalificacion(){return calificacion;}
	public double getPrecio(){return precio;}
	public double getCantidadVolumen(){return cantidadVolumen;}
	public String getSucursalSolicitante(){return sucursalSolicitante;}
	public String getNITProveedorSolicitado(){return nitProveedorSolicitado;}
	
	
	public void setNumeroPedido(Long numeroPedido){this.numeroPedido = numeroPedido;}
	public void setFechaEntrega(String fechaEntrega){this.fechaEntrega = fechaEntrega;}
	public void setCantidadProductos(int cantidadProductos){this.cantidadProductos = cantidadProductos;}
	public void setCalidad(int calidad){this.calidad = calidad;}
	public void setCalificacion(int calificacion){this.calificacion = calificacion;}
	public void setPrecio(double precio){this.precio = precio;}
	public void setCantidadVolumen(double cantidadVolumen){this.cantidadVolumen = cantidadVolumen;}
	public void setSucursalSolicitante(String sucursalSolicitante){this.sucursalSolicitante= sucursalSolicitante;}
	public void setNITProveedorSolicitado(String nitProveedorSolicitado){this.nitProveedorSolicitado= nitProveedorSolicitado;}
	
	
	
}
