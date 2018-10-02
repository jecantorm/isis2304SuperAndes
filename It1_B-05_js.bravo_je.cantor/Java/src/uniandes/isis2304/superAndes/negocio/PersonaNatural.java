package uniandes.isis2304.superAndes.negocio;

/**
 *  Clase para modelar el concepto PERSONA_NATURAL del negocio de SuperAndes.
 *
 * @author Juan Sebasti�n Bravo
 */

public class PersonaNatural extends Cliente {
	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El n�mero de identificaci�n de la persona natural.
	 */
	private String numeroIdentificacion;
	
	/**
	 * El tipo de identificaci�n de la persona natural.
	 */
	private String tipoDocumento;
	
	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

	/**
	 * Constructor sin par�metros por defecto
	 */
	public PersonaNatural()
	{
		super();
		this.setNumeroIdentificacion("");
		this.setTipoDocumento("");
	}

	/**
	 * Constructor con valores.
	 * @param nombre - El nombre de la persona natural.
	 * @param correo - El correo �nico de la persona natural.
	 * @param puntosFidelizacion - La cantidad de puntos de fidelizaci�n de la persona natural.
	 * @param numeroIdentificacion - El n�mero de identificaci�n de la persona natural.
	 * @param tipoDocumento - El tipo de identificaci�n de la persona natural.
	 */
	public PersonaNatural(String nombre, String correo, int puntosFidelizacion, String numeroIdentificacion, String tipoDocumento)
	{
		super(nombre, correo, puntosFidelizacion);
		this.setNumeroIdentificacion(numeroIdentificacion);
		this.setTipoDocumento(tipoDocumento);
	}

	/**
	 * Retorna el n�mero de identificaci�n de la persona natural.
	 * 
	 * @return El n�mero de identificaci�n de la persona natural.
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Asigna el n�mero de identificaci�n de la persona natural.
	 * 
	 * @param numeroIdentificacion - El n�mero de identificaci�n de la persona natural.
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Retorna el tipo de documento de la persona natural.
	 * 
	 * @return El tipo de documento de la persona natural.
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Asigna el tipo de documento de la persona natural.
	 * 
	 * @param tipoDocumento - El tipo de documento de la persona natural.
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	

}
