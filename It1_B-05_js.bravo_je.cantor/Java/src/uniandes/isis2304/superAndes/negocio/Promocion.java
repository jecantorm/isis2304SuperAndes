package uniandes.isis2304.superAndes.negocio;

public class Promocion {
	
	private Long idPromocion;
	
	private String codigoBarrasProducto;
	
	private String nitProveedor;
	
	private String tipoPromocion;
	
	private String nombrePromocion;
	
	private String fechaInicial;
	
	private String fechaFinal;
	
	public Promocion()
	{
		idPromocion = 0L;
		codigoBarrasProducto = "";
		nitProveedor = "";
		tipoPromocion = "";
		nombrePromocion = "";
		fechaInicial = "";
		fechaFinal = "";
	}
	
	public Promocion(Long idPromocion, String codigoBarrasProducto, String nitProveedor, String tipoPromocion, String nombrePromocion, String fechaInicial, String fechaFinal)
	{
		this.idPromocion = idPromocion;         
	    this.codigoBarrasProducto = codigoBarrasProducto;
	    this.nitProveedor = nitProveedor;        
	    this.tipoPromocion = tipoPromocion;       
	    this.nombrePromocion = nombrePromocion;
	    this.fechaInicial = fechaInicial;
	    this.fechaFinal = fechaFinal;
	}
	
	public Long getidPromocion (){return idPromocion;}         
	public String getcodigoBarrasProducto (){return codigoBarrasProducto;}
	public String getnitProveedor (){return nitProveedor;}        
	public String gettipoPromocion (){return tipoPromocion;}       
	public String getnombrePromocion (){return nombrePromocion;}
	public String getFechaInicial(){return fechaInicial;}
	public String getFechaFinal(){return fechaFinal;}
	
	
	public void setidPromocion (Long idPromocion){this.idPromocion = idPromocion;}                      
	public void setcodigoBarrasProducto (String codigoBarrasProducto){this.codigoBarrasProducto = codigoBarrasProducto;}  
	public void setnitProveedor (String nitProveedor){this.nitProveedor = nitProveedor;}                  
	public void settipoPromocion (String tipoPromocion){this.tipoPromocion = tipoPromocion;}                
	public void setnombrePromocion (String nombrePromocion){this.nombrePromocion = nombrePromocion;}      
	public void setFechaInicial(String fechaInicial){this.fechaInicial = fechaInicial;}
	public void setFechaFinal(String fechaFinal){this.fechaFinal = fechaFinal;}
	

}
