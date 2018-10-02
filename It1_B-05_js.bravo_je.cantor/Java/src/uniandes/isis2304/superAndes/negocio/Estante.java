package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto ESTANTE del negocio de SuperAndes.
 *
 * @author Juan Sebasti�n Bravo
 */
public class Estante extends Almacenamiento {

	/**
	 * El nivel de abastecimiento que tiene un estante de los productos.
	 */
	private double nivelDeAbastecimiento;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	 /**
     * Constructor sin par�metros por defecto
     */
	public Estante()
	{
		super();
		setNivelDeAbastecimiento(0.0);
	}
	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id del estante.
	 * @param cantidadProductos - La cantidad de productos que posee el estante.
	 * @param capacidadPeso - El peso m�ximo que soporta el estante en gr.
	 * @param capacidadVolumen - El volumen m�ximo que soporta el estante en cm3.
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

}
