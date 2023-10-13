package Hamburgueseria.Presentacion;
import java.util.*;
import java.text.DateFormat;

import Hamburgueseria.Logic.Hamburgueseria;
import Hamburgueseria.Logic.Producto;

public class Principal {

	private Hamburgueseria hamburgueseria;
	
	public Principal() {
		this.hamburgueseria = new Hamburgueseria();
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		System.out.println("Hola, bienvenido a la Hamburgueseria, a continuacion te presento las siguientes opciones para tu compra: \n");
		principal.menuPrincipal();
	}
	
	private void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		
		int opcion, agregar;
		
		do {
			String texto = "0. Salir \n";
			texto += "1. productos individuales (hamburguesas, bebidas, papas) \n";
			texto += "2. combos (hamburguesas + bebida + papas) \n";
			texto += "3. productos ajustados (hamburguesas sin cebolla,hamburguesa con tocineta) \n";
			System.out.println(texto);
			opcion = sc.nextInt();
			
			if (opcion == 1) {
				hamburgueseria.mostrarListaProductos(true);
				do {
					hamburgueseria.mostrarListaProductos(false);
					System.out.println("Por favor indiquue el codigo del producto a comprar\n");
					int codProducto = sc.nextInt();
					System.out.println("Por favor indiquue la cantidad del producto a comprar\n");
					int cantProducto = sc.nextInt();
					System.out.println("Desea comprar otro producto\n");
					System.out.println("0. NO\n");
					System.out.println("1. SI\n");	
					agregar = sc.nextInt();
				} while (agregar != 0);
				
			}
			
		} while (opcion == 0);
		sc.close();
		
	}
	
	private void menuSeleccionProductos() {
		Scanner sc = new Scanner(System.in);
		
		
		
		
	}

}
