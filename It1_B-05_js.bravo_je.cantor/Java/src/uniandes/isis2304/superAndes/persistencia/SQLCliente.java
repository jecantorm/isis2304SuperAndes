package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import java.sql.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;

class SQLCliente {
	
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
	public SQLCliente (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarCliente(PersistenceManager pm,String correo, String nombre,int puntosFidelizacion)
	{
		 String values = "('" + correo + "'," + "'" + nombre +"'," + puntosFidelizacion +")";  
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaCliente () + "(correo, nombre, puntos_Fidelizacion) values " + values);
	     
	     return (long) q.executeUnique();
	}
	
	public Long eliminarClientePorCorreo(PersistenceManager pm,String correo)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaCliente() + "WHERE correo = " + correo);
		
		return (long) q.executeUnique();
	}
	
	public Long eliminarClientePorNombre(PersistenceManager pm,String nombre)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaCliente() + "WHERE nombre = " + nombre);
		return (long) q.executeUnique();
	}
	
	public Cliente darClientePorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaCliente () + " WHERE correo = " + correo);
		q.setResultClass(Cliente.class);
		q.setParameters(correo);
		return (Cliente) q.executeUnique();
	}
	
	public List<Cliente> darClientePorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaCliente () + " WHERE nombre = " + nombre);
		q.setResultClass(Cliente.class);
		q.setParameters(nombre);
		return (List<Cliente>) q.executeList();
	}
	

	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaCliente ());
		q.setResultClass(Cliente.class);
		
		return (List<Cliente>) q.executeList();
	}
	
	public long aumentarPuntosFidelizacionCliente (PersistenceManager pm, String nombre, int puntosFidelizacion)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + psa.darTablaCliente () + " SET puntosFidelizacion = puntosFidelizacion +"+ puntosFidelizacion +"WHERE nombre = "+nombre);
        q.setParameters(puntosFidelizacion,nombre);
        return (long) q.executeUnique();
	}


}
