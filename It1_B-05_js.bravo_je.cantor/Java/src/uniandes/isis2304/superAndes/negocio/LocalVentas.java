package uniandes.isis2304.superAndes.negocio;

public class LocalVentas {
	
	private String nombreLocalVentas;
	
	private Long idEstante;
	
	public LocalVentas()
	{
		this.nombreLocalVentas = "";
		this.idEstante = 0L;
	}
	
	public LocalVentas(String nombreLocalVentas, Long idEstante)
	{
		this.nombreLocalVentas = nombreLocalVentas;
		this.idEstante = idEstante;
	}
	
	public String getNombreLocalVentas(){return nombreLocalVentas;}
	public Long getIdEstante(){return idEstante;}
	
	public void setNombreLocalVentas(String nombreLocalVentas){this.nombreLocalVentas = nombreLocalVentas;}
	public void setNombreEstante(Long idEstante){this.idEstante = idEstante;}

}
