package ucu.edu.uy.tda;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
//        if (esVacio())
//        {
//            return null;
//        }
//        else
//        {
//            return raiz.buscar(unaEtiqueta);
//        }

        return esVacio() ? null : raiz.buscar(unaEtiqueta);
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    @Override
    public Lista<T> inOrden() {
        Lista<T> unaLista = new Lista<>();
        if (!esVacio()) {
            raiz.inOrden(unaLista);
        }
        return unaLista;
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String preOrden() {
//        if (esVacio())
//        {
//            return null;
//        }
//        else
//        {
//            return raiz.preOrden();
//        }
        return esVacio() ? null : raiz.preOrden();
    }

    /**
     * @return recorrida en postOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String postOrden() {
//        if (esVacio())
//        {
//            return null;
//        }
//        else
//        {
//            return raiz.postOrden();
//        }
        return esVacio() ? null : raiz.postOrden();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * @return
     */
    @Override
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    @Override
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public int altura() {
//        if (esVacio())
//        {
//            return -1;
//        }
//        return raiz.altura();
        return esVacio() ? -1 : raiz.altura();
    }

    @Override
    public int tamanio() {
//        if (esVacio())
//        {
//            return -1;
//        }
//        return raiz.tamanio();
        return esVacio() ? -1 : raiz.tamanio();
    }

    @Override
    public int nivel(Comparable etiqueta) {
//        if (esVacio())
//        {
//            return -1;
//        }
//        return raiz.nivel(etiqueta, 0);
        return esVacio() ? -1 : raiz.nivel(etiqueta, 0);
    }

    @Override
    public IElementoAB<T> getRaiz() {
        return this.raiz;
    }

    @Override
    public long calcularCosto(int[] frecExito, int[] frecNoExito) {
        long resultado = -1;
        int indiceFNE[] = {0};
        int indiceFE[] = {1};
        if (this.getRaiz() != null) {
            resultado = this.getRaiz().calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, 0);
        }
        return resultado;

    }

    public Lista listaDatosNivelMasProfundo() {
        Lista<T> resultado = new Lista<T>();
        if (this.raiz != null) {
            int nivel = this.altura();
            resultado = this.raiz.listaDatosNivelMasProfundo(nivel, resultado);

        }
        return resultado;
    }

    public int Iti() {
        int resultado = 0;
        if (this.raiz != null) {
            resultado = this.raiz.Iti(1);
        }
        return resultado;
    }

    @Override
    public void cuentaFrec(Comparable<T> unArgumento) {
        if (this.getRaiz() != null) {
            this.getRaiz().cuentaFrec(unArgumento);
        }
    }

    @Override
    public void completaVectores(Comparable [] claves, int[] frecExito, int[] frecNoExito) {
        int[] indiceFE = {1};
        int[] indiceFNE = {0};
        if (this.getRaiz() != null) {
            this.getRaiz().completaVectores(claves, frecExito, frecNoExito, indiceFE, indiceFNE);
        }
    }
    
        /**
    * Método encargado de completar los nodos externos, creando nodos "especiales"
    * del árbol, los cuales contendrán los valores b[j]
    */
    public void completarNodosExternos(int[] vectorBetas) {
        if (! esVacio()) {
            Integer[] contador = new Integer[1];
            contador[0] = 0;
            raiz.completarNodosExternos(vectorBetas, contador);
        }
}
    
    
    /**
    * Retorna el costo del árbol
    * @return costo del árbol
    */
    public int obtenerCosto(){
        if (!esVacio()){
            return raiz.obtenerCosto(1);
        }
        return 0;
    } //delega en la raíz
    /**
    * variables a usar en el Main:
    * 1) int[] vectorBetas // 0 a cant_claves.
    * 2) int cantClaves // cantidad de claves en el arbol – se puede saber al leer el archivo o al ejecutar
    TArbol.tamanio.
    *
    en el método TArbol.completarNodosExternos:
    *int[] contador // vector de 1 sola posición, utilizado para completar los nodos externos (para referir a la
    entrada correspondiente en el vector de betas).
    */

}
