package uniandes.isis2304.superAndes.negocio;

import java.awt.image.BufferedImage;
import java.io.File;

public class Producto {
	
	private String categoria;
	
	private String nombre;
	
	private String marca;
	
	private double precio;
	
	private double precioUnitario;
	
	private String codigoDeBarras;
	
	private double volumenEmpaquetado;
	
	private double peso;
	
	private double precioPorUnidadMedida;
	
	private String unidadMedida;
	
	public Producto()
	{
		this.categoria = "";
		this.nombre = "";
		this.marca = "";
		this.precio = 0.0;
		this.precioUnitario = 0.0;
		this.codigoDeBarras = "./data/scanme.png";
		this.volumenEmpaquetado = 0.0;
		this.peso = 0.0;
		this.precioPorUnidadMedida = 0.0;
		this.unidadMedida = "";
		
	}
	
	public Producto(String pCategoria, double pVolumenEmpaquetado, String pNombre, String pMarca, double pPrecio, double pPrecioUnitario, String pUbicacionCodigoDeBarras, double pPeso, double pPrecioUnidadMedida, String pUnidadMedida)
	{
		this.categoria = pCategoria;
		this.nombre = pNombre;
		this.marca = pMarca;
		this.precio = pPrecio;
		this.precioUnitario = pPrecioUnitario;
		this.codigoDeBarras = pUbicacionCodigoDeBarras;
		this.volumenEmpaquetado = pVolumenEmpaquetado;
		this.peso = pPeso;
		this.precioPorUnidadMedida = pPrecioUnidadMedida;
		this.unidadMedida = pUnidadMedida;
	}
	
	public String getCategoria(){return categoria;}
	
	public String getNombre() {return nombre;}
	
	public String getMarca() {return marca;}
	
	public double getPrecio() {return precio;}
	
	public double getPrecioUnitario () {return precioUnitario;}
	
	public String getCodigoBarras () { return codigoDeBarras;}
	
	public double getVolumenEmpaquetado () {return volumenEmpaquetado;}
	
	public double getPeso () {return peso;}
	
	public double getPrecioUnidadMedida() {return precioPorUnidadMedida;}
	
	public String getUnidadMedida() {return unidadMedida;}
	
	
	
	public void setCategoria(String categoria){this.categoria = categoria;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public void setMarca(String marca) {this.marca = nombre;}
	
	public void setPrecio(double precio) {this.precio = precio;}
	
	public void setPrecioUnitario(double precioUnitario) {this.precioUnitario = precioUnitario;}
	
	public void setCodigoBarras (String codigoDeBarras) {this.codigoDeBarras = codigoDeBarras;}
	
	public void setVolumenEmpaquetado (double volumenEmpaquetado) {this.volumenEmpaquetado = volumenEmpaquetado;}
	
	public void setPeso (double peso) {this.peso = peso;}
	
	public void setPrecioUnidadMedida(double precioPorUnidadMedida) {this.precioPorUnidadMedida = precioPorUnidadMedida;}
	
	public void setUnidadMedida(String unidadMedida) {this.unidadMedida = unidadMedida;}
	
	@Override
	public String toString()
	{
		return "Producto [nombre=" + nombre + ", categoria= " + categoria + ", marca= " + marca + ", precio= " + precio +
				", precioUnitario=" + precioUnitario + ", volumenEmpaquetado=" + volumenEmpaquetado + ", peso=" + peso +
				", precioUnidadMedida=" + precioPorUnidadMedida + ", unidadMedida" + unidadMedida +"]";
	}

}
