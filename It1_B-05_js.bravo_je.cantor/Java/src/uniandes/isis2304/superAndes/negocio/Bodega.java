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
	public Bodega()
	{
		super();
	}
	
	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id de la bodega.
	 * @param cantidadProductos - La cantidad de productos que posee la bodega.
	 * @param capacidadPeso - El peso máximo que soporta la bodega en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta la bodega en cm3.
	 */
	
	public Bodega (long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen);
	}
	
           
}
