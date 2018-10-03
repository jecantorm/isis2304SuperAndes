package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Bodega;
import uniandes.isis2304.superAndes.negocio.Sucursal;


class SQLBodega {
	
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
	public SQLBodega (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	
	public long adicionarBodega (PersistenceManager pm, int idAlmacenamiento, String nombreBodega) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaBodega () + "(ID_ALMACENAMIENTO, NOMBRE_BODEGA) values ("+idAlmacenamiento+", "+nombreBodega+"s)");

        return (long) q.executeUnique();
	}


	public long eliminarBodegaPorNombre (PersistenceManager pm, String nombreSucursal)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaBodega () + " WHERE nombre_bodega = "+nombreSucursal);
        q.setParameters(nombreSucursal);
        return (long) q.executeUnique();
	}
	
	public List<Bodega> darBodegas (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaBodega ());
		q.setResultClass(Bodega.class);
		return (List<Bodega>) q.executeList();
	}
	
	


}
