package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Estante;
import uniandes.isis2304.superAndes.negocio.Sucursal;

public class SQLEstante {
	
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
	public SQLEstante (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public long adicionarEstante (PersistenceManager pm, Long estanteId, String tipoEstante, double capacidadPeso,double capacidadVolumen, int cantidadProductos, double nivelAbastecimiento) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaSucursal () + "(estanteId, tipoEstante, capacidadPeso, capacidadVolumen, cantidadProductos,nivelAbastecimiento) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(estanteId, tipoEstante, capacidadPeso, capacidadVolumen, cantidadProductos,nivelAbastecimiento);
        return (long) q.executeUnique();
	}


	public long eliminarEstantePorId (PersistenceManager pm, Long estanteId)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaEstante () + " WHERE estanteId = ?");
        q.setParameters(estanteId);
        return (long) q.executeUnique();
	}

	
	public Estante darEstantePorAbastecimiento (PersistenceManager pm, double abastecimiento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEstante () + " WHERE abastecimiento = ?");
		q.setResultClass(Estante.class);
		q.setParameters(abastecimiento);
		return (Estante) q.executeUnique();
	}

	
	public List<Estante> darEstante (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEstante ());
		q.setResultClass(Estante.class);
		return (List<Estante>) q.executeList();
	}

}
