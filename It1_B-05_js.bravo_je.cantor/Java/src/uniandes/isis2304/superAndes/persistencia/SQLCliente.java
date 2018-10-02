package uniandes.isis2304.superAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLCliente {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicaci�n
	 */
	private PersistenciaSuperAndes psa;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicaci�n
	 */
	public SQLCliente (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarCliente(PersistenceManager pm,String nombre, String correo,String tipoCliente)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaCliente () + "(nombre, correo, puntosFidelizacion, idTipoCliente) values (?, ?, ?, ?)");
	     q.setParameters(nombre, correo, 0, tipoCliente);
	     return (long) q.executeUnique();
	}

}
