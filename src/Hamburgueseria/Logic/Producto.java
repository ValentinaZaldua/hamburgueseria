package Hamburgueseria.Logic;

import java.util.ArrayList;

import java.util.Iterator;

import Hamburgueseria.Persistencia.Archivo;

public class Producto {

	private int id_producto;
	private String nombre;
	private int precio;
	private ArrayList<Añadidos> añadidos;

	public Producto(int id_producto, String nombre, int precio) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.añadidos = new ArrayList<Añadidos>();;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	

	public ArrayList<Añadidos> getAñadidos() {
		return añadidos;
	}

	public void setAñadidos(ArrayList<Añadidos> añadidos) {
		this.añadidos = añadidos;
	}

	public void ingresarAñadidos(int id_añadido, String nombre_añadido, int precio_añadido) {
		Añadidos añadidos = new Añadidos(id_añadido, nombre_añadido, precio_añadido);
		this.añadidos.add(añadidos);
	}
	
}
