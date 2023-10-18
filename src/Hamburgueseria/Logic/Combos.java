package Hamburgueseria.Logic;

import java.util.ArrayList;

public class Combos {
	
	private int id_combo;
	private String nombre_combo;
	private int precio_combo;
	private ArrayList<Combos> combo;
	
	public Combos(int id_combo, String nombre_combo, int precio_combo) {
		this.id_combo = id_combo;
		this.nombre_combo = nombre_combo;
		this.precio_combo = precio_combo;
		this.combo = new ArrayList<Combos>();
	}

	public int getId_combo() {
		return id_combo;
	}

	public void setId_combo(int id_combo) {
		this.id_combo = id_combo;
	}

	public String getNombre_combo() {
		return nombre_combo;
	}

	public void setNombre_combo(String nombre_combo) {
		this.nombre_combo = nombre_combo;
	}

	public int getPrecio_combo() {
		return precio_combo;
	}

	public void setPrecio_combo(int precio_combo) {
		this.precio_combo = precio_combo;
	}

	public ArrayList<Combos> getCombo() {
		return combo;
	}

	public void setCombo(ArrayList<Combos> combo) {
		this.combo = combo;
	}

	public void ingresarCombos(int id_combo, String nombre_combo, int precio_combo) {
		Combos combos = new Combos(id_combo, nombre_combo, precio_combo);
		this.combo.add(combos);
	}
	
	
}
