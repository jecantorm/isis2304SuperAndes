package uniandes.isis2304.superAndes.negocio;

public class Estante extends Almacenamiento{
	
	private Long estanteId;
	
	private String tipoEstante;
	
	private double abastecimiento;
	
	private double capacidadPeso;
	
	private int cantidadProductos;
	
	public Estante()
	{
		estanteId = 0L;
		tipoEstante = "";
		abastecimiento = 0.0;
		capacidadPeso = 0.0;
		cantidadProductos = 0;
	}
	
	public Estante(double abastecimiento, double capacidadPeso, int cantidadProductos, String tipoEstante)
	{
		this.estanteId = 0L;
		this.tipoEstante = tipoEstante;
		this.abastecimiento = abastecimiento;
		this.capacidadPeso = capacidadPeso;
		this.cantidadProductos = cantidadProductos;
	}
	
	public Long getEstanteId(){return estanteId;}
	public String getTipoEstante(){return tipoEstante;}
	public double getCapacidadVolumen(){return abastecimiento;}
	public double getCapacidadPeso(){return capacidadPeso;}
	public double getCapacidadProductos(){return cantidadProductos;}
	
	public void setEstanteId(Long estanteId){this.estanteId = estanteId;}
	public void setTipoEstante(String tipoEstante){this.tipoEstante = tipoEstante;}
	public void setCapacidadVolumen(double capacidadVolumen){this.abastecimiento = capacidadVolumen;}
	public void setCapacidadPeso(double capacidadPeso){this.capacidadPeso = capacidadPeso;}
	public void setCapacidadProductos(int cantidadProductos){this.cantidadProductos = cantidadProductos;}

}
