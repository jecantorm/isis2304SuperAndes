package uniandes.isis2304.superAndes.negocio;

<<<<<<< HEAD
/**
 * Clase para modelar el concepto ESTANTE del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Estante extends Almacenamiento {
=======
public class Estante extends Almacenamiento{
	
	private Long estanteId;
	
	private String tipoEstante;
>>>>>>> be693d3685fb54ba130e13d7115c6e5f543723bc
	
	/**
	 * El nivel de abastecimiento que tiene un estante de los productos.
	 */
	private double nivelDeAbastecimiento;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	
	 /**
     * Constructor sin parámetros por defecto
     */
	public Estante()
	{
<<<<<<< HEAD
		super();
		setNivelDeAbastecimiento(0.0);
	}
	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id del estante.
	 * @param cantidadProductos - La cantidad de productos que posee el estante.
	 * @param capacidadPeso - El peso máximo que soporta el estante en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta el estante en cm3.
	 * @param nivelDeAbastecimiento - El nivel de abastecimiento del producto que tiene el estante.
	 */
	public Estante(long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen, double nivelDeAbastecimiento)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen);
		setNivelDeAbastecimiento(nivelDeAbastecimiento);
	}
	
	/**
     * Retorna el nivel de abastecimiento del estante.
     * 
   	 * @return El id del abastecimiento.
   	 */
	public double getNivelDeAbastecimiento() {
		return nivelDeAbastecimiento;
	}
	/**
     * Asigna el nivel de abastecimiento del estante.
     * 
   	 * @param nivelDeAbastecimiento -  El nivel de abastecimiento del estante.
   	 */
	public void setNivelDeAbastecimiento(double nivelDeAbastecimiento) {
		this.nivelDeAbastecimiento = nivelDeAbastecimiento;
	}
=======
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
>>>>>>> be693d3685fb54ba130e13d7115c6e5f543723bc

}
