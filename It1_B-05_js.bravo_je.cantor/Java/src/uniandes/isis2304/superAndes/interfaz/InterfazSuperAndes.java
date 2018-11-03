package uniandes.isis2304.superAndes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.superAndes.negocio.Bodega;
import uniandes.isis2304.superAndes.negocio.Estante;
import uniandes.isis2304.superAndes.negocio.Factura;
import uniandes.isis2304.superAndes.negocio.LocalVentas;
import uniandes.isis2304.superAndes.negocio.Pedido;
import uniandes.isis2304.superAndes.negocio.PersonaNatural;
import uniandes.isis2304.superAndes.negocio.Producto;
import uniandes.isis2304.superAndes.negocio.Promocion;
import uniandes.isis2304.superAndes.negocio.Proveedor;
import uniandes.isis2304.superAndes.negocio.Sucursal;
import uniandes.isis2304.superAndes.negocio.SuperAndes;


/**
 * Clase principal de la interfaz
 * @author Juan Cantor
 */
@SuppressWarnings("serial")
public class InterfazSuperAndes extends JFrame implements ActionListener{
	

		/* ****************************************************************
		 * 			Constantes
		 *****************************************************************/

		
		/**
		 * Ruta al archivo de configuraci�n de la interfaz
		 */
		private static final String CONFIG_INTERFAZ = "./resources/config/interfaceConfig.json"; 
		
		/**
		 * Ruta al archivo de configuraci�n de los nombres de tablas de la base de datos
		 */
		private static final String CONFIG_TABLAS = "./resources/config/TablasBD_A.json"; 
		
		/* ****************************************************************
		 * 			Atributos
		 *****************************************************************/
	    /**
	     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
	     */
	    private JsonObject tableConfig;
	    
	    /**
	     * Asociaci�n a la clase principal del negocio.
	     */
	    private SuperAndes superAndes;
	    
		/* ****************************************************************
		 * 			Atributos de interfaz
		 *****************************************************************/
	    /**
	     * Objeto JSON con la configuraci�n de interfaz de la app.
	     */
	    private JsonObject guiConfig;
	    
	    /**
	     * Panel de despliegue de interacci�n para los requerimientos
	     */
	    private PanelDatos panelDatos;
	    
	    /**
	     * Men� de la aplicaci�n
	     */
	    private JMenuBar menuBar;

		/* ****************************************************************
		 * 			M�todos
		 *****************************************************************/
	    /**
	     * Construye la ventana principal de la aplicaci�n. <br>
	     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
	     */
	    public InterfazSuperAndes( )
	    {
	        // Carga la configuraci�n de la interfaz desde un archivo JSON
	        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
	        
	        // Configura la apariencia del frame que contiene la interfaz gr�fica
	        configurarFrame ( );
	        if (guiConfig != null) 	   
	        {
	     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
	        }
	        
	        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
	        superAndes = new SuperAndes (tableConfig);
	        
	    	String path = guiConfig.get("bannerPath").getAsString();
	        panelDatos = new PanelDatos ( );

	        setLayout (new BorderLayout());
	        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
	        add( panelDatos, BorderLayout.CENTER );        
	    }
	    
		/* ****************************************************************
		 * 			M�todos de configuraci�n de la interfaz
		 *****************************************************************/
	    /**
	     * Lee datos de configuraci�n para la aplicaci�, a partir de un archivo JSON o con valores por defecto si hay errores.
	     * @param tipo - El tipo de configuraci�n deseada
	     * @param archConfig - Archivo Json que contiene la configuraci�n
	     * @return Un objeto JSON con la configuraci�n del tipo especificado
	     * 			NULL si hay un error en el archivo.
	     */
	    private JsonObject openConfig (String tipo, String archConfig)
	    {
	    	JsonObject config = null;
			try 
			{
				Gson gson = new Gson( );
				FileReader file = new FileReader (archConfig);
				JsonReader reader = new JsonReader ( file );
				config = gson.fromJson(reader, JsonObject.class);
				System.out.println("Se encontr� un archivo de configuraci�n v�lido: " + tipo);
			} 
			catch (Exception e)
			{
				e.printStackTrace ();
				System.out.println("NO se encontr� un archivo de configuraci�n v�lido");			
				JOptionPane.showMessageDialog(null, "No se encontr� un archivo de configuraci�n de interfaz v�lido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
			}	
	        return config;
	    }
	    
	    /**
	     * M�todo para configurar el frame principal de la aplicaci�n
	     */
	    private void configurarFrame(  )
	    {
	    	int alto = 0;
	    	int ancho = 0;
	    	String titulo = "";	
	    	
	    	if ( guiConfig == null )
	    	{
	    		System.out.println( "Se aplica configuraci�n por defecto" );			
				titulo = "Parranderos APP Default";
				alto = 300;
				ancho = 500;
	    	}
	    	else
	    	{
				System.out.println( "Se aplica configuraci�n indicada en el archivo de configuraci�n" );
	    		titulo = guiConfig.get("title").getAsString();
				alto= guiConfig.get("frameH").getAsInt();
				ancho = guiConfig.get("frameW").getAsInt();
	    	}
	    	
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        setLocation (50,50);
	        setResizable( true );
	        setBackground( Color.WHITE );

	        setTitle( titulo );
			setSize ( ancho, alto);        
	    }

	    /**
	     * M�todo para crear el men� de la aplicaci�n con base em el objeto JSON le�do
	     * Genera una barra de men� y los men�s con sus respectivas opciones
	     * @param jsonMenu - Arreglo Json con los men�s deseados
	     */
	    private void crearMenu(  JsonArray jsonMenu )
	    {    	
	    	// Creaci�n de la barra de men�s
	        menuBar = new JMenuBar();       
	        for (JsonElement men : jsonMenu)
	        {
	        	// Creaci�n de cada uno de los men�s
	        	JsonObject jom = men.getAsJsonObject(); 

	        	String menuTitle = jom.get("menuTitle").getAsString();        	
	        	JsonArray opciones = jom.getAsJsonArray("options");
	        	
	        	JMenu menu = new JMenu( menuTitle);
	        	
	        	for (JsonElement op : opciones)
	        	{       	
	        		// Creaci�n de cada una de las opciones del men�
	        		JsonObject jo = op.getAsJsonObject(); 
	        		String lb =   jo.get("label").getAsString();
	        		String event = jo.get("event").getAsString();
	        		
	        		JMenuItem mItem = new JMenuItem( lb );
	        		mItem.addActionListener( this );
	        		mItem.setActionCommand(event);
	        		
	        		menu.add(mItem);
	        	}       
	        	menuBar.add( menu );
	        }        
	        setJMenuBar ( menuBar );	
	    }
	    
		/* ****************************************************************
		 * 			CRUD de Producto
		 *****************************************************************/
	    /**
	     * Adiciona un tipo de producto con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de Producto en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void adicionarProducto( )
	    {
	    	try 
	    	{
	    		JTextField codigoDeBarras = new JTextField();
	    		JTextField idPromocion = new JTextField();
	    		JTextField nombre = new JTextField();
	    		JTextField marca = new JTextField();
	    		JTextField precio_unitario = new JTextField();
	    		JTextField volumen_empaquetado = new JTextField();
	    		JTextField peso = new JTextField();
	    		JTextField precioUnidadMedida = new JTextField();
	    		JTextField cantidadPresentacion = new JTextField();
	    		JTextField unidadDeMedida= new JTextField();
	    		JTextField categoria = new JTextField();
	    		JTextField nivel_reorden = new JTextField();
	    		JTextField numeroFactura = new JTextField();
	    		JTextField idAlmacenamiento = new JTextField();
	    		JTextField nitProveedor = new JTextField();
	    		
	    		Object[]parametros =
	    			{
	    			"Codigo de barras:",		   codigoDeBarras      ,
	    			"idPromocion:",		   idPromocion         ,
	    			"Nombre:",		   nombre              ,
	    			"Marca:",		   marca               ,
	    			"Precio Unitario:",		   precio_unitario     ,
	    			"Volumen empaquetado:",		   volumen_empaquetado ,
	    			"Peso:",		   peso                ,
	    			"Precio por Unidad de Medida:",		   precioUnidadMedida                ,
	    			"Cantidad de Presentacion:",		   cantidadPresentacion                ,
	    			"Unidad de Medida:",		   unidadDeMedida                ,
	    			"Categoria:",		   categoria           ,
	    			"Nivel Reorden:",		   nivel_reorden       ,
	    			"Numero Factura:",		   numeroFactura       ,
	    			"idAlmacenamiento:",		   idAlmacenamiento    ,
	    			"NIT:",		   nitProveedor 
	    			};
	    		
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del producto", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		Producto p = superAndes.adicionarProducto(codigoDeBarras.getText() ,Long.parseLong(idPromocion.getText()) ,nombre.getText(),marca.getText(),
	        								Double.parseDouble(precio_unitario.getText()),Double.parseDouble(volumen_empaquetado.getText()),
	        								Double.parseDouble(peso.getText()),categoria.getText(),Double.parseDouble(nivel_reorden.getText()),Integer.parseInt(numeroFactura.getText()),
	        								Long.parseLong(idAlmacenamiento.getText()), 
	        				                Long.parseLong(nitProveedor.getText()),Double.parseDouble(precioUnidadMedida.getText()),Integer.parseInt(cantidadPresentacion.getText()),unidadDeMedida.getText());
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear un producto con codigo de barras: " + codigoDeBarras.getText());
	        		}
	        		String resultado = "En adicionarProducto\n\n";
	        		resultado += "Producto adicionado exitosamente: " + codigoDeBarras.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
	    }
	    
	    /* ****************************************************************
		 * 			CRUD de Producto
		 *****************************************************************/
	    /**
	     * Adiciona un tipo de producto con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de Producto en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void crearProveedor( )
	    {
	    	try 
	    	{
	    		JTextField nit = new JTextField();
	    		JTextField nombre = new JTextField();
	    		JTextField calificacion = new JTextField();
	    		JTextField tipoProveedor = new JTextField();
	    		
	    		Object[]parametros =
	    			{
	    			"NIT:",nit ,
	    			"Nombre:",nombre,
	    			"Calificacion:",calificacion,
	    			"Tipo de Proveedor:",tipoProveedor
	    			};
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del proveedor", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		Proveedor p = superAndes.adicionarProveedor(Integer.parseInt(nit.getText()),nombre.getText(),Integer.parseInt(calificacion.getText()),tipoProveedor.getText());
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear un proveedor con NIT: " + nit.getText());
	        		}
	        		String resultado = "En adicionarProveedor\n\n";
	        		resultado += "Proveedor adicionado exitosamente: " + nit.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
	    }
	    
	    /* ****************************************************************
		 * 			CRUD de PersonaNatural
		 *****************************************************************/
	    /**
	     * Adiciona un tipo de persona natural con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de PersonaNatural en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void crearPersonaNatural( )
	    {
	    	try 
	    	{
	    		JTextField correo = new JTextField();
	    		JTextField nombre = new JTextField();
	    		JTextField puntos = new JTextField();
	    		JTextField numIdentificacion = new JTextField();
	    		JTextField tipoIdentificacion = new JTextField();
	    		
	    		Object[]parametros =
	    			{
	    			"Correo:",correo ,
	    			"Nombre:",nombre,
	    			"Puntos Fidelizacion:",puntos,
	    			"Tipo Identificacion:",tipoIdentificacion,
	    			"Numero Identificacion:",numIdentificacion
	    			};
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del Cliente", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		PersonaNatural p = superAndes.adicionarPersonaNatural(correo.getText(),nombre.getText(),Integer.parseInt(puntos.getText()),
	        															  tipoIdentificacion.getText(),Long.parseLong(numIdentificacion.getText()));
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear un cliente con Correo: " + correo.getText());
	        		}
	        		String resultado = "En adicionarCliente\n\n";
	        		resultado += "Cliente adicionado exitosamente: " + correo.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado + " " + e.getMessage());
			}
	    }
	    
	    /* ****************************************************************
		 * 			CRUD de Empresa
		 *****************************************************************/
	    /**
	     * Adiciona un tipo de empresa con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de Empresa en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void crearEmpresa( )
	    {
	    	try 
	    	{
	    		JTextField correo = new JTextField();
	    		JTextField nombre = new JTextField();
	    		JTextField puntos = new JTextField();
	    		JTextField nit = new JTextField();
	    		JTextField direccion = new JTextField();
	    		
	    		Object[]parametros =
	    			{
	    			"Correo:",correo ,
	    			"Nombre:",nombre,
	    			"Puntos Fidelizacion:",puntos,
	    			"NIT:",nit,
	    			"Direccion:",direccion
	    			};
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del Cliente", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		PersonaNatural p = superAndes.adicionarPersonaNatural(correo.getText(),nombre.getText(),Integer.parseInt(puntos.getText()),
	        															  direccion.getText(),Long.parseLong(nit.getText()));
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear un cliente con Correo: " + correo.getText());
	        		}
	        		String resultado = "En adicionarCliente\n\n";
	        		resultado += "Cliente adicionado exitosamente: " + correo.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
	    }
	    
	    /* ****************************************************************
		 * 			CRUD de Sucursal
		 *****************************************************************/
	    /**
	     * Adiciona una sucursal con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de Sucursal en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void crearSucursal( )
	    {
	    	try 
	    	{
	    		JTextField nombre = new JTextField();
	    		JTextField direccion = new JTextField();
	    		JTextField ciudad = new JTextField();
	    		JTextField idLV = new JTextField();
	    		
	    		Object[]parametros =
	    			{
	    			"Nombre:",nombre ,
	    			"Direccion:",direccion,
	    			"Ciudad:",ciudad,
	    			"id Local Ventas:",idLV
	    			};
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos de la Sucursal", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		Sucursal p = superAndes.adicionarSucursal(nombre.getText(),direccion.getText(),ciudad.getText(),
	        															  Long.parseLong(idLV.getText()));
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear una sucursal de Nombre: " + nombre.getText());
	        		}
	        		String resultado = "En adicionarSucursal\n\n";
	        		resultado += "Sucursal adicionada exitosamente: " + nombre.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
	    }
	    
	    /* ****************************************************************
		 * 			CRUD de Local Ventas
		 *****************************************************************/
	    /**
	     * Adiciona un local de ventas con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de LocalVentas en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void crearLocalVentas( )
	    {
	    	try 
	    	{
	    		JTextField idLocalVentas = new JTextField();
	    		JTextField ingresos = new JTextField();

	    		
	    		Object[]parametros =
	    			{
	    			"Id Local:",idLocalVentas ,
	    			"Ingresos:",ingresos
	    			};
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del Local de Ventas", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		LocalVentas p = superAndes.adicionarLocalVentas(Long.parseLong(idLocalVentas.getText()),Double.parseDouble(ingresos.getText())
	        															 );
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear el local de Ventas de Id: " + idLocalVentas.getText());
	        		}
	        		String resultado = "En adicionarLocalVentas\n\n";
	        		resultado += "LocalVentas adicionada exitosamente: " + idLocalVentas.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
	    }
	    
	    /* ****************************************************************
		 * 			CRUD de Bodega
		 *****************************************************************/
	    /**
	     * Adiciona una bodega con la informaci�n dada por el usuario
	     * Se crea una nueva tupla de Bodega en la base de datos, si un tipo de bebida con ese nombre no exist�a
	     */
	    public void crearBodega( )
	    {
	    	try 
	    	{
	    		JTextField idAlmacenamiento = new JTextField();
	    		JTextField nombreSucursal = new JTextField();
	    		JTextField direccionSucursal = new JTextField();
	    		JTextField ciudadSucursal = new JTextField();
	    		JTextField capacidad_volumen = new JTextField();
	    		JTextField capacidad_peso = new JTextField();
	    		JTextField cantidad_productos = new JTextField();
	    		JTextField nombreBodega = new JTextField();

	    		
	    		Object[]parametros =
	    			{
	    				"ID Almacenamiento:", idAlmacenamiento    ,
	    				"Nombre Sucursal:", nombreSucursal      ,
	    				"Direccion Sucursal:", direccionSucursal   ,
	    				"Ciudad Sucursal:", ciudadSucursal      ,
	    				"Capacidad Volumen:", capacidad_volumen   ,
	    				"Capacidad Peso:", capacidad_peso      ,
	    				"Cantidad Productos:",	cantidad_productos,
	    				"Nombre Bodega:",nombreBodega 	   
	    			};
	    		
	    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos de la bodega", JOptionPane.OK_CANCEL_OPTION);
	    		if (option == JOptionPane.OK_OPTION)
	    		{
	    			
	    			
	        		Bodega p = superAndes.adicionarBodega(Long.parseLong(idAlmacenamiento.getText()),nombreSucursal.getText(),direccionSucursal.getText(),
	        														ciudadSucursal.getText(),Double.parseDouble(capacidad_volumen.getText()),Double.parseDouble(capacidad_peso.getText()),
	        														Integer.parseInt(cantidad_productos.getText()),nombreBodega.getText());
	        		if (p == null)
	        		{
	        			throw new Exception ("No se pudo crear la Bodega de Nombre: " + nombreBodega.getText());
	        		}
	        		String resultado = "En adicionarBodega\n\n";
	        		resultado += "Bodega adicionada exitosamente: " + nombreBodega.getText();
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
	    		}
			} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
	    }
	    
	    /* ****************************************************************
			 * 			CRUD de Estante
			 *****************************************************************/
		    /**
		     * Adiciona un estante con la informaci�n dada por el usuario
		     * Se crea una nueva tupla de Estante en la base de datos, si un tipo de bebida con ese nombre no exist�a
		     */
		    public void crearEstante( )
		    {
		    	try 
		    	{
		    		JTextField idAlmacenamiento = new JTextField();
		    		JTextField nombreSucursal = new JTextField();
		    		JTextField direccionSucursal = new JTextField();
		    		JTextField ciudadSucursal = new JTextField();
		    		JTextField capacidad_volumen = new JTextField();
		    		JTextField capacidad_peso = new JTextField();
		    		JTextField cantidad_productos = new JTextField();
		    		JTextField tipoEstante = new JTextField();
		    		JTextField nivelAbastecimiento = new JTextField();

		    		
		    		Object[]parametros =
		    			{
		    				"ID Almacenamiento:", idAlmacenamiento    ,
		    				"Nombre Sucursal:", nombreSucursal      ,
		    				"Direccion Sucursal:", direccionSucursal   ,
		    				"Ciudad Sucursal:", ciudadSucursal      ,
		    				"Capacidad Volumen:", capacidad_volumen   ,
		    				"Capacidad Peso:", capacidad_peso      ,
		    				"Cantidad Productos:",	cantidad_productos,
		    				"Tipo Estante:",tipoEstante,
		    				"Nivel Abastecimiento:",nivelAbastecimiento,
		    			};
		    		
		    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del estante", JOptionPane.OK_CANCEL_OPTION);
		    		if (option == JOptionPane.OK_OPTION)
		    		{
		    			
		    			
		        		Estante p = superAndes.adicionarEstante(Long.parseLong(idAlmacenamiento.getText()),nombreSucursal.getText(),direccionSucursal.getText(),
		        														ciudadSucursal.getText(),Double.parseDouble(capacidad_volumen.getText()),Double.parseDouble(capacidad_peso.getText()),
		        														Integer.parseInt(cantidad_productos.getText()),tipoEstante.getText(),Double.parseDouble(nivelAbastecimiento.getText()));
		        		if (p == null)
		        		{
		        			throw new Exception ("No se pudo crear el Estante de Tipo: " + tipoEstante.getText());
		        		}
		        		String resultado = "En adicionarEstante\n\n";
		        		resultado += "Estante adicionada exitosamente: " + tipoEstante.getText();
		    			resultado += "\n Operaci�n terminada";
		    			panelDatos.actualizarInterfaz(resultado);
		    		}
		    		else
		    		{
		    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
		    		}
				} 
		    	catch (Exception e) 
		    	{
		    		e.printStackTrace();
					String resultado = generarMensajeError(e);
					panelDatos.actualizarInterfaz(resultado);
				}
		    }
		    
		    /* ****************************************************************
			 * 			CRUD de Pedido
			 *****************************************************************/
		    /**
		     * Adiciona un Pedido con la informaci�n dada por el usuario
		     * Se crea una nueva tupla de Pedido en la base de datos, si un tipo de bebida con ese nombre no exist�a
		     */
		    public void crearPedido( )
		    {
		    	try 
		    	{
		    		JTextField numeroPedido = new JTextField();
		    		JTextField nit = new JTextField();
		    		JTextField nombreSucursal = new JTextField();
		    		JTextField direccionSucursal = new JTextField();
		    		JTextField ciudadSucursal = new JTextField();
		    		JTextField codigoBarrasProducto = new JTextField();
		    		JTextField fechaEntrega = new JTextField();
		    		JTextField calidad = new JTextField();
		    		JTextField calificacion = new JTextField();
		    		JTextField precio = new JTextField();
		    		JTextField cantidad_volumen = new JTextField();

		    		
		    		Object[]parametros =
		    			{
		    				"NumeroPedido:", numeroPedido 	     ,
		    				"NIT:", nit                  ,
		    				"Nombre Sucursal:", nombreSucursal 	     ,
		    				"Direccion Sucursal:", direccionSucursal	 ,
		    				"Ciudad Sucursal:", ciudadSucursal 	     ,
		    				"Codigo Barras Producto:",	codigoBarrasProducto ,
		    				"FechaEntrega:", fechaEntrega 	     ,
		    				"Calidad:", calidad 	         ,
		    				"Calificacion:", calificacion 	     ,
		    				"Precio:", precio 	             ,
		    				"Cantidad_volumen:", cantidad_volumen     ,
		    					
		    			};
		    		
		    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos del Pedido", JOptionPane.OK_CANCEL_OPTION);
		    		if (option == JOptionPane.OK_OPTION)
		    		{
		    			
		    			
		        		Pedido p = superAndes.adicionarPedido(Long.parseLong(numeroPedido.getText()),Double.parseDouble(nit.getText()),nombreSucursal.getText(),direccionSucursal.getText(),
		        														ciudadSucursal.getText(),codigoBarrasProducto.getText(),fechaEntrega.getText(),calidad.getText(),
		        														Integer.parseInt(calificacion.getText()),Double.parseDouble(precio.getText()),Integer.parseInt(cantidad_volumen.getText()));
		        		if (p == null)
		        		{
		        			throw new Exception ("No se pudo crear el Pedido con Numero: " + numeroPedido.getText());
		        		}
		        		String resultado = "En adicionarPedido\n\n";
		        		resultado += "Pedido adicionado exitosamente: " + numeroPedido.getText();
		    			resultado += "\n Operaci�n terminada";
		    			panelDatos.actualizarInterfaz(resultado);
		    		}
		    		else
		    		{
		    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
		    		}
				} 
		    	catch (Exception e) 
		    	{
		    		e.printStackTrace();
					String resultado = generarMensajeError(e);
					panelDatos.actualizarInterfaz(resultado);
				}
		    }
		    
		    /* ****************************************************************
			 * 			CRUD de Factura
			 *****************************************************************/
		    /**
		     * Adiciona una Factura con la informaci�n dada por el usuario
		     * Se crea una nueva tupla de Factura en la base de datos, si un tipo de bebida con ese nombre no exist�a
		     */
		    public void crearFactura( )
		    {
		    	try 
		    	{
		    		JTextField numeroFactura = new JTextField();
		    		JTextField fechaCompra = new JTextField();
		    		JTextField valorBase = new JTextField();
		    		JTextField descuento = new JTextField();
		    		JTextField iva = new JTextField();
		    		JTextField valorTotal = new JTextField();
		    		JTextField correoCliente = new JTextField();
		    		JTextField nombreSucursal = new JTextField();
		    		JTextField direccionSucursal = new JTextField();
		    		JTextField ciudadSucursal = new JTextField();

		    		
		    		Object[]parametros =
		    			{
		    				"NumeroFactura:", numeroFactura,
		    				"Fecha Compra:", fechaCompra,
		    				"Valor Base:", valorBase ,
		    				"Descuento:", descuento,
		    				"IVA:", iva ,
		    				"Valor Total:",	valorTotal ,
		    				"Correo Cliente:", correoCliente,
		    				"Nombre Sucursal:", nombreSucursal ,
		    				"DireccionSucursal:", direccionSucursal,
		    				"Ciudad Sucursal:", ciudadSucursal,
		    					
		    			};
		    		
		    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos de la Factura", JOptionPane.OK_CANCEL_OPTION);
		    		if (option == JOptionPane.OK_OPTION)
		    		{
		    			
		    			
		        		Factura p = superAndes.adicionarFactura(Long.parseLong(numeroFactura.getText()),fechaCompra.getText(),Double.parseDouble(valorBase.getText()),Double.parseDouble(descuento.getText()),
		        												Double.parseDouble(iva.getText()),Double.parseDouble(valorTotal.getText()),correoCliente.getText(),nombreSucursal.getText(),
		        														direccionSucursal.getText(),direccionSucursal.getText(),ciudadSucursal.getText());
		        		if (p == null)
		        		{
		        			throw new Exception ("No se pudo crear la Factura con Numero: " + numeroFactura.getText());
		        		}
		        		String resultado = "En adicionarFactura\n\n";
		        		resultado += "Factura adicionada exitosamente: " + numeroFactura.getText();
		    			resultado += "\n Operaci�n terminada";
		    			panelDatos.actualizarInterfaz(resultado);
		    		}
		    		else
		    		{
		    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
		    		}
				} 
		    	catch (Exception e) 
		    	{
		    		e.printStackTrace();
					String resultado = generarMensajeError(e);
					panelDatos.actualizarInterfaz(resultado);
				}
		    }
		    
		    
		    /* ****************************************************************
			 * 			CRUD de Promocion
			 *****************************************************************/
		    /**
		     * Adiciona una Promocion con la informaci�n dada por el usuario
		     * Se crea una nueva tupla de Promocion en la base de datos, si un tipo de bebida con ese nombre no exist�a
		     */
		    public void crearPromocion( )
		    {
		    	try 
		    	{
		    		JTextField idPromocion = new JTextField();
		    		JTextField nit = new JTextField();
		    		JTextField tipoPromocion = new JTextField();
		    		JTextField nombrePromocion = new JTextField();
		    		JTextField fechaInicial = new JTextField();
		    		JTextField fechaFinal = new JTextField();
		
		    		Object[]parametros =
		    			{
		    				"Id Promocion:", idPromocion,
		    				"NIT:", nit,
		    				"Tipo Promocion:", tipoPromocion ,
		    				"Nombre Promocion:", nombrePromocion,
		    				"Fecha Inicial:", fechaInicial ,
		    				"Fecha Final:",	fechaFinal 

		    			};
		    		
		    		int option = JOptionPane.showConfirmDialog(null, parametros, "Ingrese los datos de la Factura", JOptionPane.OK_CANCEL_OPTION);
		    		if (option == JOptionPane.OK_OPTION)
		    		{
		    			
		    			
		        		Promocion p = superAndes.adicionarPromocion(Long.parseLong(idPromocion.getText()),Long.parseLong(nit.getText()),tipoPromocion.getText(),nombrePromocion.getText(),
		        												fechaInicial.getText(),fechaFinal.getText());
		        		if (p == null)
		        		{
		        			throw new Exception ("No se pudo crear la Promocion con Id: " + idPromocion.getText());
		        		}
		        		String resultado = "En adicionarPromocion\n\n";
		        		resultado += "Promocion adicionada exitosamente: " + idPromocion.getText();
		    			resultado += "\n Operaci�n terminada";
		    			panelDatos.actualizarInterfaz(resultado);
		    		}
		    		else
		    		{
		    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
		    		}
				} 
		    	catch (Exception e) 
		    	{
		    		e.printStackTrace();
					String resultado = generarMensajeError(e);
					panelDatos.actualizarInterfaz(resultado);
				}
		    }




	  


		/* ****************************************************************
		 * 			M�todos administrativos
		 *****************************************************************/
	


		/**
		 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
		 * Muestra en el panel de datos el n�mero de tuplas eliminadas de cada tabla
		 */
		public void limpiarBD ()
		{
			try 
			{
	    		// Ejecuci�n de la demo y recolecci�n de los resultados
				long eliminados [] = superAndes.limpiarSuperAndes();
				
				// Generaci�n de la cadena de caracteres con la traza de la ejecuci�n de la demo
				String resultado = "\n\n************ Limpiando la base de datos ************ \n";
				resultado += eliminados [0] + " Gustan eliminados\n";
				resultado += eliminados [1] + " Sirven eliminados\n";
				resultado += eliminados [2] + " Visitan eliminados\n";
				resultado += eliminados [3] + " Bebidas eliminadas\n";
				resultado += eliminados [4] + " Tipos de bebida eliminados\n";
				resultado += eliminados [5] + " Bebedores eliminados\n";
				resultado += eliminados [6] + " Bares eliminados\n";
				resultado += "\nLimpieza terminada";
	   
				panelDatos.actualizarInterfaz(resultado);
			} 
			catch (Exception e) 
			{
//				e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			}
		}
		


	    /**
	     * Genera una cadena de caracteres con la descripci�n de la excepcion e, haciendo �nfasis en las excepcionsde JDO
	     * @param e - La excepci�n recibida
	     * @return La descripci�n de la excepci�n, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
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
		 * Genera una cadena para indicar al usuario que hubo un error en la aplicaci�n
		 * @param e - La excepci�n generada
		 * @return La cadena con la informaci�n de la excepci�n y detalles adicionales
		 */
		private String generarMensajeError(Exception e) 
		{
			String resultado = "************ Error en la ejecuci�n\n";
			resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
			return resultado;
		}

		

		/* ****************************************************************
		 * 			M�todos de la Interacci�n
		 *****************************************************************/
	    /**
	     * M�todo para la ejecuci�n de los eventos que enlazan el men� con los m�todos de negocio
	     * Invoca al m�todo correspondiente seg�n el evento recibido
	     * @param pEvento - El evento del usuario
	     */
	    @Override
		public void actionPerformed(ActionEvent pEvento)
		{
			String evento = pEvento.getActionCommand( );		
	        try 
	        {
				Method req = InterfazSuperAndes.class.getMethod ( evento );			
				req.invoke ( this );
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			} 
		}
	    
		/* ****************************************************************
		 * 			Programa principal
		 *****************************************************************/
	    /**
	     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
	     * @param args Arreglo de argumentos que se recibe por l�nea de comandos
	     */
	    public static void main( String[] args )
	    {
	        try
	        {
	        	
	            // Unifica la interfaz para Mac y para Windows.
	            InterfazSuperAndes interfaz = new InterfazSuperAndes( );
	            interfaz.setVisible( true );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }
	    }




}
