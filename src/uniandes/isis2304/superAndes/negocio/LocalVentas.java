package uniandes.isis2304.superAndes.negocio;

public class LocalVentas {
	
	private String nombreLocalVentas;
	
	private String nombreEstante;
	
	public LocalVentas()
	{
		this.nombreLocalVentas = "";
		this.nombreEstante = "";
	}
	
	public LocalVentas(String nombreLocalVentas, String nombreEstante)
	{
		this.nombreLocalVentas = nombreLocalVentas;
		this.nombreEstante = nombreEstante;
	}
	
	public String getNombreLocalVentas(){return nombreLocalVentas;}
	public String getNombreEstante(){return nombreEstante;}
	
	public void setNombreLocalVentas(String nombreLocalVentas){this.nombreLocalVentas = nombreLocalVentas;}
	public void setNombreEstante(String nombreEstante){this.nombreEstante = nombreEstante;}

}
