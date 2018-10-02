package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto ESTANTE del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Estante extends Almacenamiento {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

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
		super();
		this.setNivelDeAbastecimiento(0.0);
	}
	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id del estante.
	 * @param cantidadProductos - La cantidad de productos que posee el estante.
	 * @param capacidadPeso - El peso máximo que soporta el estante en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta el estante en cm3.
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece el estante.
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece el estante.
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece el estante.
	 * @param nivelDeAbastecimiento - El nivel de abastecimiento del producto que tiene el estante.
	 */
	public Estante(long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen, String nombreSucursal, String direccionSucursal, String ciudadSucursal, double nivelDeAbastecimiento)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen, nombreSucursal, direccionSucursal, ciudadSucursal);
		this.setNivelDeAbastecimiento(nivelDeAbastecimiento);
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
