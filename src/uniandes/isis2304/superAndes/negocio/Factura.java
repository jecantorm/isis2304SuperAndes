package uniandes.isis2304.superAndes.negocio;


public class Factura {
	
	private String fecha;
	
	private String tipoCliente;
	
	private String nombreCliente;
	
	private String nombreLocalVentas;
	
	private double valorTotal;
	
	public Factura()
	{
		tipoCliente = "";
		nombreCliente = "";
		nombreLocalVentas = "";
	}
	
	public Factura(String tipoCliente, String nombreCliente, String nombreLocalVentas, String idFactura, String fecha, double valorTotal)
	{
		this.fecha = fecha;
		this.valorTotal = valorTotal;
		this.tipoCliente = tipoCliente;
		this.nombreCliente = nombreCliente;
		this.nombreLocalVentas = nombreLocalVentas;
	}
	
	public String getFecha(){return fecha;}
	public String getTipoCliente(){return tipoCliente;}
	public String getNombreCliente(){return nombreCliente;}
	public String getNombreLocalVentas(){return nombreLocalVentas;}
	public double getValorTotal(){return valorTotal;}

}
