package uniandes.isis2304.superAndes.negocio;


public class Factura {
	
	private Long numeroFactura;
	
	private String fecha;
		
	private String nombreCliente;
	
	private String nombreSucursal;
	
	private double valorTotal;
	
	public Factura()
	{
		numeroFactura = 0L;
		fecha = "";
		nombreCliente = "";
		nombreSucursal = "";
		valorTotal = 0;
	}
	
	public Factura(Long numeroFactura,String tipoCliente, String nombreCliente, String nombreSucursal, String idFactura, String fecha, double valorTotal)
	{
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.valorTotal = valorTotal;
		this.nombreCliente = nombreCliente;
		this.nombreSucursal = nombreSucursal;
	}
	
	public Long getNumeroFactura(){return numeroFactura;}
	public String getFecha(){return fecha;}
	public String getNombreCliente(){return nombreCliente;}
	public String getNombreSucursal(){return nombreSucursal;}
	public double getValorTotal(){return valorTotal;}
	
	public void setNumeroFactura(Long numeroFactura){this.numeroFactura = numeroFactura;}
	public void setFecha(String fecha){this.fecha = fecha;}
	public void setNombreCliente(String nombreCliente){this.nombreCliente = nombreCliente;}
	public void setNombreSucursal(String nombreSucursal){this.nombreSucursal = nombreSucursal;}
	public void setValorTotal(double valorTotal){this.valorTotal = valorTotal;}

}
