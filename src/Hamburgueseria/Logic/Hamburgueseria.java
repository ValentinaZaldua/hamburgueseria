package Hamburgueseria.Logic;

import java.util.ArrayList;
import java.util.Date;

import Hamburgueseria.Persistencia.Archivo;

public class Hamburgueseria {
	private  ArrayList<TipoProducto> tipoProductos;
	private ArrayList<Factura> facturas;
	private ArrayList<Añadidos> añadidos;
	
	public Hamburgueseria() {
		this.tipoProductos = new ArrayList<TipoProducto>();
		this.facturas = new ArrayList<Factura>();
		this.añadidos = new ArrayList<Añadidos>();
	}
	

	public void mostrarListaProductos(Boolean leerArchvio) {
		if(leerArchvio) {
			leerArchivos();
		}	
		
		int contador = 1;
		for (TipoProducto tipoProducto : this.tipoProductos) {
			for (Producto producto : tipoProducto.getProductos()) {
				System.out.println("\n");
				System.out.println("-------------------------------");
				System.out.println("Tipo Producto: " + tipoProducto.getNombre());
				System.out.println("Codigo Producto: " + producto.getId_producto());
				System.out.println("Producto: " + producto.getNombre());
				System.out.println("Precio: " + producto.getPrecio());
			}
		}
	}
	
	private void ingresarTipoProducto(int id_tipo_producto, String nombre) {
		TipoProducto tipoProducto = new TipoProducto(id_tipo_producto, nombre);
		this.tipoProductos.add(tipoProducto);
	}
	
	private void leerArchivos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("TipoProducto.dat");
		for (String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarTipoProducto(Integer.parseInt(datos[0]), datos[1]);
		}

		lineas = Archivo.leerArchivo("Productos.dat");
		for (String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarProducto(Integer.parseInt(datos[3]), Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]));
		}
	}

	
	private void ingresarProducto(int id_tipo_producto, int id_producto, String nombre, int precio) {
		TipoProducto tipoProducto = this.buscarTipoProducto(id_tipo_producto);
		if(tipoProducto != null) {
			tipoProducto.ingresarProducto(id_producto, nombre, precio);
		}
	}
	
	private TipoProducto buscarTipoProducto(int id_tipo_producto) {
		for (TipoProducto tipoProducto : this.tipoProductos) {
			if(tipoProducto.getId_tipo_producto() == id_tipo_producto) {
				return tipoProducto;
			}
		}
		return null;
	}
	//para la factura, pero no se como continuarlo, tambien falta añadir añadidos pues si el cliente solicita una porcion de x ingrediente 
	//o algun tipo de complemento, para eso va a ser esa clase, tambien falta la clase combos para armar los combos y por ultimo unir
	//cada clase a hambugueseria y llevarlo a principal para la visualizacion
	
	//de todos modos no se que tan efectivo sea el uso de esa clase añadidos
	public void ingresarFactura(Date fecha ) {
		
	}

}
