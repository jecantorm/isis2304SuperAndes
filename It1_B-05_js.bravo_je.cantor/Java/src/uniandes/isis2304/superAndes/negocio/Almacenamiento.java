package uniandes.isis2304.superAndes.negocio;

/**
 * Clase abstracta para modelar los posibles almacenamientos del negocio de SuperAndes
 *
 * @author Juan Sebastián Bravo
 */

public abstract class Almacenamiento {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del almacenamiento
	 */
	protected long idAlmacenamiento;
	
	/**
	 * La capacidad volumétrica máxima del almacenamiento en cm3. 
	 */
	
	protected double capacidadVolumen;

/**
 * La capacidad máxima de peso del almacenamiento en gr. 
 */
	
	protected double capacidadPeso;
	
	/**
	 * La cantidad de productos que tiene el almacenamiento.
	 */
	
	protected int cantidadProductos;
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor sin parámetros por defecto
     */
	public Almacenamiento() 
    {
    	this.setIdAlmacenamiento(0);
    	this.setCantidadProductos(0);
    	this.setCapacidadPeso(0.0);
    	this.setCapacidadVolumen(0.0);
	}

	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id del almacenamiento.
	 * @param cantidadProductos - La cantidad de productos que posee el almacenamiento.
	 * @param capacidadPeso - El peso máximo que soporta el almacenamiento en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta el almacenamiento en cm3.
	 */
    public Almacenamiento(long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen) 
    {
    	this.setIdAlmacenamiento(idAlmacenamiento);
    	this.setCantidadProductos(cantidadProductos);
    	this.setCapacidadPeso(capacidadPeso);
    	this.setCapacidadVolumen(capacidadVolumen);
	}

    /**
     * Retorna el id del almacenamiento.
     * 
   	 * @return El id del almacenamiento.
   	 */
	public long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	 /**
     * Asigna el id del almacenamiento.
     * 
   	 * @param idAlmacenamiento - El id del almacenamiento.
   	 */
	public void setIdAlmacenamiento(long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	/**
     * Retorna la capacidad volumétrica máxima del almacenamiento.
     * 
   	 * @return La capacidad volumétrica máxima del almacenamiento.
   	 */
	public double getCapacidadVolumen() {
		return capacidadVolumen;
	}

	 /**
     * Asigna la capacidad volumétrica máxima del almacenamiento.
     * 
   	 * @param capacidadVolumen - La capacidad volumétrica máxima del almacenamiento.
   	 */
	public void setCapacidadVolumen(double capacidadVolumen) {
		this.capacidadVolumen = capacidadVolumen;
	}

	/**
     * Retorna el peso máximo que soporta el almacenamiento.
     * 
   	 * @return El peso máximo que soporta el almacenamiento.
   	 */
	public double getCapacidadPeso() {
		return capacidadPeso;
	}
	
	/**
     * Asigna el peso máximo que soporta el almacenamiento.
     * 
   	 * @param capacidadPeso -  El peso máximo que soporta el almacenamiento.
   	 */
	public void setCapacidadPeso(double capacidadPeso) {
		this.capacidadPeso = capacidadPeso;
	}
	
	/**
     * Retorna la cantidad de productos que tiene el almacenamiento actualmente.
     * 
   	 * @return La cantidad de productos que tiene el almacenamiento actualmente.
   	 */
	public int getCantidadProductos() {
		return cantidadProductos;
	}

	/**
     * Asigna la cantidad de productos que tiene el almacenamiento actualmente.
     * 
   	 * @param cantidadProductos - La cantidad de productos que tiene el almacenamiento actualmente.
   	 */
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

}
