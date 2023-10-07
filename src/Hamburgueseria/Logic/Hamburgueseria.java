package Hamburgueseria.Logic;

import java.util.ArrayList;

import Hamburgueseria.Persistencia.Archivo;

public class Hamburgueseria {
	private  ArrayList<TipoProducto> tipoProductos;
	
	public Hamburgueseria() {
		this.tipoProductos = new ArrayList<TipoProducto>();
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

}
