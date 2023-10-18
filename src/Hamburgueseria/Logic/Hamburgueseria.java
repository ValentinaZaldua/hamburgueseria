package Hamburgueseria.Logic;

import java.util.ArrayList;
import java.util.Date;

import Hamburgueseria.Persistencia.Archivo;

public class Hamburgueseria {
	private  ArrayList<TipoProducto> tipoProductos;
	private ArrayList<Factura> facturas;
	private ArrayList<Añadidos> añadidos;
	private ArrayList<Combos> combos;
	
	public Hamburgueseria() {
		this.tipoProductos = new ArrayList<TipoProducto>();
		this.facturas = new ArrayList<Factura>();
		this.añadidos = new ArrayList<Añadidos>();
		this.combos = new ArrayList<Combos>();
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
		
		lineas =Archivo.leerArchivo("Añadidos.dat");
		for (String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarAñadidos(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]));
		}
	}

	
	private void ingresarAñadidos(int id_añadido, String nombre_añadido, int precio_añadido) {
		Producto Producto = this.buscarProducto(id_añadido);
		if(Producto != null) {
			Producto.ingresarAñadidos(id_añadido, nombre_añadido, precio_añadido);
		}			
	}


	private void ingresarProducto(int id_tipo_producto, int id_producto, String nombre, int precio) {
		TipoProducto tipoProducto = this.buscarTipoProducto(id_tipo_producto);
		if(tipoProducto != null) {
			tipoProducto.ingresarProducto(id_producto, nombre, precio);
		}
	}
	
	private Producto buscarProducto(int idProducto) {
		for(TipoProducto tipoProducto : this.tipoProductos) {
			for(Producto producto : tipoProducto.getProductos()) {
				if(producto.getId_producto() == idProducto) {
					return producto;
				}
			}
		}
		return null;
	}
	
	private TipoProducto buscarTipoProducto(int id_tipo_producto) {
		for (TipoProducto tipoProducto : this.tipoProductos) {
			if(tipoProducto.getId_tipo_producto() == id_tipo_producto) {
				return tipoProducto;
			}
		}
		return null;
	}
	
	private Añadidos buscarAñadidos(int id_añadidos) {
		for (Añadidos añadidos : this.añadidos) {
			if(añadidos.getId_añadido() == id_añadidos) {
				return añadidos;
			}
		}
		return null;
	}
	
	
	public void ingresarFactura(Date fecha, ArrayList<int[]> productosComprados) {
		int numero = this.facturas.size() + 1;
		Factura factura = new Factura(numero, fecha);
		for(int[] datos : productosComprados) {
			Producto producto = this.buscarProducto(datos[0]);
			factura.adicionarProducto(producto, datos[1]);
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}
	

	


	public void imprimirFactura() {
		for(Factura factura : this.facturas) {
			System.out.println("----HAMNURGUESERIA SAS----\n");;
			System.out.println("---Factura # " +  factura.getNumero() + "---\n");
			System.out.println("---Fecha # " +  factura.getFecha() + "---\n");
			System.out.println("Productos: \n");	
			
			for(FacturaProducto facturaProducto : factura.getFacturaProductos()) {
				System.out.println("***" + facturaProducto.getProducto().getNombre() + " *** Cantidad: " + facturaProducto.getCantidad() + " *** Precio unidad:  " + facturaProducto.getPrecio());
			}
			
			System.out.println("---------------------------------\n");
			System.out.println("Total a pagar: " + factura.getValorTotal());
		}		
	}


	public void mostrarListaCombos(boolean leerArchivo) {
		// TODO Auto-generated method stub
		
	}

}
