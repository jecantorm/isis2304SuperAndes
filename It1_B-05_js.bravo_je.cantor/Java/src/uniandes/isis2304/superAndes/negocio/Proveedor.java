package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto PROVEEDOR del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Proveedor {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El nit ÚNICO del proveedor.
	 */
	private int nit;

	/**
	 * El nombre ÚNICO del proveedor.
	 */
	private String nombre;

	/**
	 * La calificación cuantificable del proveedor.
	 */
	private int calificacion;

	/**
	 * El tipo de proveedor, puede ser parte de un conjunto de proveedores o el proveedor específico de un producto.
	 */
	private String tipoProveedor;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */
	public Proveedor()
	{
		this.setNit(0);
		this.setNombre("");
		this.setCalificacion(0);
		this.setTipoProveedor("");
	}

	/**
	 * Constructor con valores.
	 * @param nit - El nit único del proveedor.
	 * @param nombre - El nombre único del proveedor.
	 * @param calificacion - La calificación cuantificable del proveedor.
	 * @param tipoProveedor - El tipo del proveedor.
	 */
	public Proveedor(int nit, String nombre, int calificacion, String tipoProveedor)
	{
		this.setNit(nit);
		this.setNombre(nombre);
		this.setCalificacion(calificacion);
		this.setTipoProveedor(tipoProveedor);
	}

	/**
	 * Retorna el nit del proveedor.
	 * 
	 * @return El nit del proveedor.
	 */
	public int getNit() {
		return nit;
	}

	/**
	 * Asigna el nit del proveedor.
	 * 
	 * @param nit - El nit del proveedor.
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}

	/**
	 * Retorna el nombre del proveedor.
	 * 
	 * @return El nombre del proveedor.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el nombre del proveedor.
	 * 
	 * @param nombre - El nombre del proveedor.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna la calificación cuantificable del proveedor.
	 * 
	 * @return La calificación cuantificable del proveedor.
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * Asigna la calificación cuantificable del proveedor.
	 * 
	 * @param calificacion - La calificación cuantificable del proveedor.
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Retorna el tipo de proveedor. 
	 * 
	 * @return El tipo de proveedor. 
	 */
	public String getTipoProveedor() {
		return tipoProveedor;
	}

	/**
	 * Asigna el tipo de proveedor. 
	 * 
	 * @param tipoProveedor - El tipo de proveedor. 
	 */
	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}




}
