package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.PersonaNatural;

public class SQLPersonaNatural {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes psa;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLPersonaNatural (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarPersonaNatural(PersistenceManager pm,String tipoIdentificacion, Long numeroIdentificacion,String correo)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaPersonaNatural () + "(tipoIdentificacion, numeroIdentificacion, correo) values (?, ?, ?)");
	     q.setParameters(tipoIdentificacion, numeroIdentificacion, correo);
	     return (long) q.executeUnique();
	}
	
	public Long eliminarPersonaNaturalPorCorreo(PersistenceManager pm,String correo)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaPersonaNatural() + "WHERE correo = ?");
		q.setParameters(correo);
		return (long) q.executeUnique();
	}
	
	public Long eliminarPersonaNaturalPorNombre(PersistenceManager pm,String nombre)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaPersonaNatural() + "WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();
	}
	
	public PersonaNatural darPersonaNaturalPorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPersonaNatural () + " WHERE correo = ?");
		q.setResultClass(PersonaNatural.class);
		q.setParameters(correo);
		return (PersonaNatural) q.executeUnique();
	}
	
	public PersonaNatural darPersonaNaturalPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPersonaNatural () + " WHERE nombre = ?");
		q.setResultClass(PersonaNatural.class);
		q.setParameters(nombre);
		return (PersonaNatural) q.executeUnique();
	}
	
	public List<PersonaNatural> darPersonasNaturales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPersonaNatural ());
		q.setResultClass(PersonaNatural.class);
		return (List<PersonaNatural>) q.executeList();
	}

}
