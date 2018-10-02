package uniandes.isis2304.superAndes.negocio;

<<<<<<< HEAD
/**
 * Clase para modelar el concepto BODEGA del negocio de SuperAndes.
 *
 * @author Juan Sebasti�n Bravo
 */
public class Bodega extends Almacenamiento {
=======
public class Bodega extends Almacenamiento{
>>>>>>> be693d3685fb54ba130e13d7115c6e5f543723bc
	
	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/
	
	/**
     * Constructor sin par�metros por defecto
     */
	public Bodega()
	{
		super();
	}
	
	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id de la bodega.
	 * @param cantidadProductos - La cantidad de productos que posee la bodega.
	 * @param capacidadPeso - El peso m�ximo que soporta la bodega en gr.
	 * @param capacidadVolumen - El volumen m�ximo que soporta la bodega en cm3.
	 */
	
	public Bodega (long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen);
	}
	
           
}
