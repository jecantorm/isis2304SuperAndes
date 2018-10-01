package uniandes.isis2304.superAndes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class PersistenciaSuperAndes {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaSuperAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a la tabla BODEGA de la base de datos
	 */
	private SQLBodega sqlBodega;
	
	private SQLEmpresa sqlEmpresa;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLCliente sqlCliente;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLEstante sqlEstante;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLFactura sqlFactura;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLLocalVentas sqlLocalVentas;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLPedido sqlPedido;
	
	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	private SQLPedidoProductos sqlPedidoProductos;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLPersonaNatural sqlPersonaNatural;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLProducto sqlProducto;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLPromocion sqlPromocion;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLSucursal sqlSucursal;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add("SuperAndes_sequence");
		tablas.add ("BODEGA");         
		tablas.add ("CLIENTE");        
		tablas.add ("EMPRRESA");       
		tablas.add ("ESTANTE");        
		tablas.add ("FACTURA");        
		tablas.add ("LOCALVENTAS");    
		tablas.add ("PEDIDO");         
		tablas.add ("PEDIDOPRODUCTOS");
        tablas.add ("PERSONANATURAL"); 
	    tablas.add ("PRODUCTO");       
	    tablas.add ("PROMOCION");
	    tablas.add ("SUCURSAL");        
	
	}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	
	
	/**
	 * @return Retorna el único objeto PersistenciaSuperAndes existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaSuperAndes existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de superandes
	 */                                                                       
	public String darTablaBodega ()                                           
	{                                                                         
		return tablas.get (1);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Cliente de superandes 
	 */                                                                       
	public String darTablaCliente ()                                          
	{                                                                         
		return tablas.get (2);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Empresa de superandes 
	 */                                                                       
	public String darTablaEmpresa ()                                          
	{                                                                         
		return tablas.get (3);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Estante de superandes 
	 */
	public String darTablaEstante ()
	{
		return tablas.get (4);
	}

	/**                                                                      
	 * @return La cadena de caracteres con el nombre de la tabla de Factura de superAndes 
	 */                                                                    
	public String darTablaFactura ()                                       
	{                                                                      
		return tablas.get (5);                                             
	}                                                                      
                                                                           
	/**                                                                    
	 * @return La cadena de caracteres con el nombre de la tabla de LocalVenta de superAndess
	 */                                                                       
	public String darTablaLocalVentas ()                                      
	{                                                                         
		return tablas.get (6);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Pedidos de superAndes 
	 */                                                                        
	public String darTablaPedidos ()                                           
	{                                                                          
		return tablas.get (7);                                                 
	}                                                                          
	                                                                           
	/**                                                                        
	 * @return La cadena de caracteres con el nombre de la tabla de PedidoProductos de superAndes
	 */                                                                       
	public String darTablaPedidoProductos ()                                  
	{                                                                         
		return tablas.get (8);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de PersonaNatural de superAndes
	 */
	public String darTablaPersonaNatural ()
	{
		return tablas.get (9);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Producto de superAndes 
	 */                                                                         
	public String darTablaProducto ()                                           
	{                                                                           
		return tablas.get (10);                                                 
	}                                                                           
                                                                                
	/**                                                                         
	 * @return La cadena de caracteres con el nombre de la tabla de Promocion de superAndese
	 */                                                                       
	public String darTablaPromocion ()                                        
	{                                                                         
		return tablas.get (11);                                               
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Sucursal de superAndes 
	 */
	public String darTablaSucursal ()
	{
		return tablas.get (12);
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlBodega = new SQLBodega(this);
		sqlCliente = new SQLCliente(this);
		sqlEmpresa = new SQLEmpresa(this);
		sqlEstante = new SQLEstante(this);
		sqlFactura = new SQLFactura(this);
		sqlLocalVentas = new SQLLocalVentas (this);
		sqlPedido = new SQLPedido(this);		
		sqlPedidoProductos = new SQLPedidoProductos(this);
		sqlPersonaNatural = new SQLPersonaNatural (this);
		sqlProducto = new SQLProducto(this);		
		sqlPromocion = new SQLPromocion(this);
		sqlSucursal = new SQLSucursal(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqSuperAndes ()
	{
		return tablas.get (0);
	}
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de SuperAndes
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarSuperAndes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarSuperAndes (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}

	

}
