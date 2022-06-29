/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grupo2.ej3domiciliario;

import ucu.edu.uy.tda.IElementoAB;
import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.tda.TElementoAB;
import ucu.edu.uy.util.ManejadorArchivosGenerico;

/**
 *
 * @author Administrador
 */
public class Ej3Domiciliario {

    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        for (String l : lineas) {
            String[] datos = l.split(" ");
            IElementoAB elem = new TElementoAB(datos[0], Integer.parseInt(datos[1]), null);
            arbol.insertar(elem);
        }
        int cant_claves = arbol.tamanio();
        String[] lineasBetas = ManejadorArchivosGenerico.leerArchivo("nopalabras.txt");
        int[] vectorBetas = new int[cant_claves+1];
        for (int h = 0; h < lineasBetas.length; h++) {
            String linea = lineasBetas[h];
            String[] datos = linea.split(" ");
            //vectorBetas[h] = Integer.parseInt(datos[1]);
            vectorBetas[h] = Integer.parseInt(datos[0]);
        }
        int[] vectorAlfas = new int[cant_claves+1];
        String[] vectorClaves = new String[cant_claves+1];
        arbol.completarNodosExternos(vectorBetas);
        System.out.println(arbol.obtenerCosto());
        }

}
