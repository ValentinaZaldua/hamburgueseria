package Hamburgueseria.Logic;

public class Añadidos {

	
	private int id_añadido;
	private String nombre_añadido;
	private int precio_añadido;
	
	public Añadidos(int id_añadido, String nombre_añadido, int precio_añadido) {
		super();
		this.id_añadido = id_añadido;
		this.nombre_añadido = nombre_añadido;
		this.precio_añadido = precio_añadido;
	}

	public int getId_añadido() {
		return id_añadido;
	}

	public void setId_añadido(int id_añadido) {
		this.id_añadido = id_añadido;
	}

	public String getNombre_añadido() {
		return nombre_añadido;
	}

	public void setNombre_añadido(String nombre_añadido) {
		this.nombre_añadido = nombre_añadido;
	}

	public int getPrecio_añadido() {
		return precio_añadido;
	}

	public void setPrecio_añadido(int precio_añadido) {
		this.precio_añadido = precio_añadido;
	}
	
	
	
}
