package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto BODEGA del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Bodega extends Almacenamiento {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */
	
	private String nombreBodega;
	
	public Bodega(String nombreBodega)
	{
		super();
		setNombreBodega(nombreBodega);
	}

	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id de la bodega.
	 * @param cantidadProductos - La cantidad de productos que posee la bodega.
	 * @param capacidadPeso - El peso máximo que soporta la bodega en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta la bodega en cm3.
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece la bodega.
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece la bodega.
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece la bodega.
	 */
	public Bodega (long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen, String nombreSucursal, String direccionSucursal, String ciudadSucursal)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen, nombreSucursal, direccionSucursal, ciudadSucursal);
	}
	public void setNombreBodega(String nombreBodega){this.nombreBodega = nombreBodega;}


}
