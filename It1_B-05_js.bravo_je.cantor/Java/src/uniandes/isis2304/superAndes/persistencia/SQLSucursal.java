package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Sucursal;

public class SQLSucursal {
	
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
	public SQLSucursal (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public long adicionarSucursal (PersistenceManager pm, String nombreSucursal, String direccion, String ciudad, Long idBodega, String nombreLocalVentas,double reOrden, double capacidad) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaSucursal () + "(direccion, nombreSucursal, ciudad, reorden, capacidad,idBodega,nombreLocalVentas) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(direccion, nombreSucursal, ciudad, reOrden, capacidad,idBodega,nombreLocalVentas);
        return (long) q.executeUnique();
	}


	public long eliminarSucursalPorNombre (PersistenceManager pm, String nombreSucursal)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaSucursal () + " WHERE nombreSucursal = ?");
        q.setParameters(nombreSucursal);
        return (long) q.executeUnique();
	}

	
	public Sucursal darSucursalPorNombre (PersistenceManager pm, String nombreSucursal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaSucursal () + " WHERE nombreSucursal = ?");
		q.setResultClass(Sucursal.class);
		q.setParameters(nombreSucursal);
		return (Sucursal) q.executeUnique();
	}

	
	public List<Sucursal> darSucursalesPorCiudad (PersistenceManager pm, String localVentas) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaSucursal () + " WHERE localVentas = ?");
		q.setResultClass(Sucursal.class);
		q.setParameters(localVentas);
		return (List<Sucursal>) q.executeList();
	}

	
	

}
