package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Factura;
import uniandes.isis2304.superAndes.negocio.LocalVentas;

public class SQLLocalVentas {
	
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
	public SQLLocalVentas (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	
	public Long adicionarLocalVentas(PersistenceManager pm,String nombreLocalVentas, Long idEstante)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaLocalVentas () + "(nombreLocalVentas,idEstante) values (?, ?)");
	     q.setParameters(nombreLocalVentas,idEstante);
	     return (long) q.executeUnique();
	}
	
	public Long eliminarLocalVentasPorNombre(PersistenceManager pm,String nombreLocalVentas)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaLocalVentas() + "WHERE nombreLocalVentas = ?");
		q.setParameters(nombreLocalVentas);
		return (long) q.executeUnique();
	}
	
	
	public List<LocalVentas> darLocalesVentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaLocalVentas ());
		q.setResultClass(Cliente.class);
		return (List<LocalVentas>) q.executeList();
	}

}
