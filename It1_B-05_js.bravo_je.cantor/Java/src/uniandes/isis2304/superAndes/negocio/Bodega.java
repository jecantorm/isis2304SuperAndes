package uniandes.isis2304.superAndes.negocio;

public class Bodega extends Almacenamiento{
	
	private double capacidadVolumen;
	
	private double capacidadPeso;
	
	private int cantidadProductos;
	
	public Bodega()
	{
		capacidadVolumen = 0.0;
		capacidadPeso = 0.0;
		cantidadProductos = 0;
	}
	
	public Bodega(double capacidadVolumen, double capacidadPeso, int cantidadProductos)
	{
		this.capacidadVolumen = capacidadVolumen;
		this.capacidadPeso = capacidadPeso;
		this.cantidadProductos = cantidadProductos;
	}
	
	public double getCapacidadVolumen(){return capacidadVolumen;}
	public double getCapacidadPeso(){return capacidadPeso;}
	public double getCapacidadProductos(){return cantidadProductos;}
	
	public void setCapacidadVolumen(double capacidadVolumen){this.capacidadVolumen = capacidadVolumen;}
	public void setCapacidadPeso(double capacidadPeso){this.capacidadPeso = capacidadPeso;}
	public void setCapacidadProductos(int cantidadProductos){this.cantidadProductos = cantidadProductos;}
           
}
