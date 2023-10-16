package Hamburgueseria.Presentacion;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Hamburgueseria.Logic.Hamburgueseria;
import Hamburgueseria.Logic.Producto;

public class Principal {

	private Hamburgueseria hamburgueseria;
	private ArrayList<int[]> productosComprados;
	
	public Principal() {
		this.hamburgueseria = new Hamburgueseria();
		this.productosComprados =  new ArrayList<int[]>(); 
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		System.out.println("Hola, bienvenido a la Hamburgueseria, a continuacion te presento las siguientes opciones para tu compra: \n");
		principal.menuPrincipal();
	}
	
	private void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		
		int opcion;
		
		do {
			String texto = "Digite una opcion: \n";
			texto += "0. Salir \n";
			texto += "1. Comprar productos \n";
			texto += "2. Imprimir factura \n";
			System.out.println(texto);
			opcion = sc.nextInt();
			
			if (opcion == 1) { //opcion comprar productos
				menuProductos();
			}else if(opcion == 2) { // opcion de imprimir factura				
				if(productosComprados.size() > 0) { // se valida si hay al menos un producto en compra para imprimir factura
					hamburgueseria.imprimirFactura();
					opcion = 0;
					System.out.println("\n");
					System.out.println("Gracias por su compra");
				}else {
					System.out.println("Para poder imprimir una factura debe comprar al menos un producto \n");
				}
			}
			
		} while (opcion != 0);
		sc.close();
		
	}
	
	private void menuProductos() {	
		Scanner sc = new Scanner(System.in);
		int opcion, agregar, otroProducto;
		// Obtener la fecha actual
		Date fechaActual = new Date();
		// formato que se quiere la fecha
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String texto = "Por favor digite una opción para continuar\n\n";
		texto += "0. Salir \n";
		texto += "1. productos individuales (hamburguesas, bebidas, papas) \n";
		texto += "2. combos (hamburguesas + bebida + papas) \n";
		texto += "3. productos ajustados (hamburguesas sin cebolla,hamburguesa con tocineta) \n";
		System.out.println(texto);
		
		opcion = sc.nextInt(); 
		
		if(opcion == 1) { //opcion productos individuales
			productosComprados = new ArrayList<int[]>();
			hamburgueseria.mostrarListaProductos(true);
			do {
				int datos[] = new int[2];
				hamburgueseria.mostrarListaProductos(false);
				System.out.println("Por favor indiquue el codigo del producto a comprar\n");
				int codProducto = sc.nextInt();
				System.out.println("Por favor indiquue la cantidad del producto a comprar\n");
				int cantProducto = sc.nextInt();				
				
				datos[0] = codProducto;
				datos[1] = cantProducto;
				
				productosComprados.add(datos);	//se añade al arraylist el producto indicado para saber cual se quiere comprar
				
				System.out.println("Desea ingresar otro producto?\n"
						+ "1. Si\n"
						+ "2. No\n");

				otroProducto = sc.nextInt();
				
			} while (otroProducto == 1);
			if(productosComprados.size() > 0) {
				this.hamburgueseria.ingresarFactura(fechaActual, productosComprados);
			}else if(opcion == 2) {
			sc.close();
		}
		} 
	}

}
