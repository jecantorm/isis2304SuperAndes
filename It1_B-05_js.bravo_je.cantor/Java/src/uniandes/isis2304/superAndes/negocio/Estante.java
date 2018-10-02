package uniandes.isis2304.superAndes.negocio;

public class Estante extends Almacenamiento{
	
	private double abastecimiento;
	
	private double capacidadPeso;
	
	private int cantidadProductos;
	
	public Estante()
	{
		abastecimiento = 0.0;
		capacidadPeso = 0.0;
		cantidadProductos = 0;
	}
	
	public Estante(double abastecimiento, double capacidadPeso, int cantidadProductos)
	{
		this.abastecimiento = abastecimiento;
		this.capacidadPeso = capacidadPeso;
		this.cantidadProductos = cantidadProductos;
	}
	
	public double getCapacidadVolumen(){return abastecimiento;}
	public double getCapacidadPeso(){return capacidadPeso;}
	public double getCapacidadProductos(){return cantidadProductos;}
	
	public void setCapacidadVolumen(double capacidadVolumen){this.abastecimiento = capacidadVolumen;}
	public void setCapacidadPeso(double capacidadPeso){this.capacidadPeso = capacidadPeso;}
	public void setCapacidadProductos(int cantidadProductos){this.cantidadProductos = cantidadProductos;}

}
