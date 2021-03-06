/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author carloscarrascal
 */


import static java.nio.file.StandardOpenOption.APPEND;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import Modelo.Tipo_productos;


public class FileInventariosDAO implements InventariosDAO {

	
	private static final String NOMBRE_ARCHIVO = "Tipo_productos";
	private static final Path file= Paths.get(NOMBRE_ARCHIVO);
	private static final int LONGITUD_REGISTRO = 40;
	private static final int CANTIDAD_LONGITUD = 20;
	private static final int ID_PRODUCTO_LONGITUD = 20;
        private static final int CODIGO_ALMACEN_LONGITUD = 20;
	
	
	
	private static final Map<String, Tipo_productos> CACHE_TIPO_PRODUCTOS = new HashMap<String, Tipo_productos>();
	

	@Override
	public boolean saveTipo_productos(Tipo_productos t_productos) {
		
		String registro=parseTipoProductoString(t_productos);

		byte data[] = registro.getBytes();
		ByteBuffer out = ByteBuffer.wrap(data);	
		try (FileChannel fc = (FileChannel.open(file, APPEND))) {
			fc.write(out);
			return true;
		} catch (IOException x) {
			System.out.println("I/O Exception: " + x);
		}
		return false;
	}
	
	
	@Override
	public Tipo_productos getTipo_productos(String ref_tipo) {
		//se busca el objeto en memoria cach�
		Tipo_productos tipo_productos = CACHE_TIPO_PRODUCTOS.get(ref_tipo);
		
		if(tipo_productos!=null){
			System.out.println("ocurri� un hit en cach� de personas");//contraejemplo, no hacer, no recomendable, usar Logger como log4J
			return tipo_productos; //ocurri� un hit de cach�
		}
		System.out.println("ocurri� un miss en cach� de personas");
		//ocurri� un miss de cach�
		try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
		    ByteBuffer buf = ByteBuffer.allocate(LONGITUD_REGISTRO);		    
		    // Se utiliza la propiedad del sistema que indica la codificaci�n de los archivos 
		    String encoding = System.getProperty("file.encoding");
		    while (sbc.read(buf) > 0) {
		        buf.rewind();
		        CharBuffer registro= Charset.forName(encoding).decode(buf);
		        String identificacion = registro.subSequence(0, CANTIDAD_LONGITUD).toString().trim();
		        if(identificacion.equals(ref_tipo)){
		        	tipo_productos = parseTipoProductos(registro);
		        	CACHE_TIPO_PRODUCTOS.put(ref_tipo, tipo_productos);
		        	return tipo_productos;
		        }
		        buf.flip();		        		        
		    }
		} catch (IOException x) {
		    System.out.println("caught exception: " + x);
		}
		return null;		
	}

	

	
	@Override
	public List<Tipo_productos> getAllTipo_producto() {	
		List<Tipo_productos> productos= new ArrayList<Tipo_productos>();
		try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
		    ByteBuffer buf = ByteBuffer.allocate(LONGITUD_REGISTRO);  
		    
		    // Se utiliza la propiedad del sistema que indica la codificaci�n de los archivos 
		    String encoding = System.getProperty("file.encoding");
		    while (sbc.read(buf) > 0) {
		        buf.rewind();
		        Tipo_productos producto = parseTipoProductos(Charset.forName(encoding).decode(buf));
		        buf.flip();
		        productos.add(producto);		        
		    }
		} catch (IOException x) {
		    System.out.println("caught exception: " + x);
		}
		return productos;
	}
		


	
	private Tipo_productos parseTipoProductos(CharBuffer registro){		
		String ref_tipo = registro.subSequence(0, CANTIDAD_LONGITUD ).toString();
		registro.position(CANTIDAD_LONGITUD);
		registro=registro.slice();
				
		String nombre = registro.subSequence(0, IDPRODUCTO_LONGITUD).toString();
		registro.position(IDPRODUCTO_LONGITUD);	
		registro=registro.slice();		
		
				
		
		Tipo_productos p=new Tipo_productos(ref_tipo, nombre);
		return p;
	}
	
	private String parseTipoProductoString(Tipo_productos tipo_producto){
		StringBuilder registro = new StringBuilder(LONGITUD_REGISTRO);
		registro.append(completarCampoConEspacios(tipo_producto.getReferencia_tipo(),CANTIDAD_LONGITUD));
		registro.append(completarCampoConEspacios(tipo_producto.getNombre(), IDPRODUCTO_LONGITUD));
			
		return registro.toString();
	}
	
	/**
	 * Rellena con espacios a la derecha el String que se env�e como par�metro. Si el tama�o del String
	 * supera el valor del tama�o que se env�a como par�metro, se ajusta el contenido del String a dicho tama�o
	 * @param campo, tamanio
	 * @return String
	 */
	private String completarCampoConEspacios(String campo, int tamanio){
		if(campo.length()>tamanio){//Ser responsable y lanzar una excepci�n
			campo=campo.substring(0, tamanio);
			return campo;
		}
		return String.format("%1$-" + tamanio + "s", campo);
	}


}
/**
 *
 * @author carloscarrascal
 */