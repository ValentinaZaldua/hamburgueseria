package Hamburgueseria.Logic;

import java.util.ArrayList;

public class TipoProducto {

	private int id_tipo_producto;
	private String nombre;
	private ArrayList<Producto> productos;

	public TipoProducto(int id_tipo_producto, String nombre) {
		this.id_tipo_producto = id_tipo_producto;
		this.nombre = nombre;
		this.productos = new ArrayList<Producto>();
	}

	public int getId_tipo_producto() {
		return id_tipo_producto;
	}

	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public void ingresarProducto(int id_producto, String nombre, int precio) {
		Producto producto = new Producto(id_producto, nombre, precio);
		this.productos.add(producto);
	}

}
