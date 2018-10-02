package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Empresa;
import uniandes.isis2304.superAndes.negocio.PersonaNatural;

public class SQLEmpresa {
	
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
	public SQLEmpresa (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarEmpresa(PersistenceManager pm,String nit, String direccion,String correo)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaEmpresa () + "(nit, direccion, correo) values (?, ?, ?)");
	     q.setParameters(nit, direccion, correo);
	     return (long) q.executeUnique();
	}
	
	public Long eliminarEmpresaPorCorreo(PersistenceManager pm,String correo)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaEmpresa() + "WHERE correo = ?");
		q.setParameters(correo);
		return (long) q.executeUnique();
	}
	
	public Long eliminarEmpresaPorNIT(PersistenceManager pm,String nit)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaEmpresa() + "WHERE nit = ?");
		q.setParameters(nit);
		return (long) q.executeUnique();
	}
	
	public Empresa darEmpresaPorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEmpresa() + " WHERE correo = ?");
		q.setResultClass(Empresa.class);
		q.setParameters(correo);
		return (Empresa) q.executeUnique();
	}
	
	public Empresa darEmpresaPorNIT (PersistenceManager pm, String nit) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEmpresa () + " WHERE nit = ?");
		q.setResultClass(Empresa.class);
		q.setParameters(nit);
		return (Empresa) q.executeUnique();
	}
	
	public List<Empresa> darPersonasNaturales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEmpresa ());
		q.setResultClass(Empresa.class);
		return (List<Empresa>) q.executeList();
	}

}
