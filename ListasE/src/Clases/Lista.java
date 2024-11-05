
package Clases;

/**
 *
 * @author JSantoyo
 */
public class Lista {
    private Nodo cabeza=null;
    private int longitud=0;
	//nodo
    private class Nodo{
        public Libros libro;
        public Nodo siguiente=null;
        public Nodo(Libros libro){
            this.libro=libro;
        }
    }
	
	//insertar
    public void insertarInicio(Libros libro){
      Nodo nodo = new Nodo(libro);
      nodo.siguiente=cabeza;
      cabeza=nodo;
      longitud++;
    }
    public void insertarFinal(Libros libro){
        Nodo nodo=new Nodo(libro);
        Nodo puntero=cabeza;
        while(puntero.siguiente != null){
            puntero=puntero.siguiente;
        }
        puntero.siguiente=nodo;
        longitud++;
    }
    public void insertarDespues(int n,Libros libro){
        Nodo nodo=new Nodo(libro);
        if(cabeza==null){
            cabeza=nodo;
        }else{
            Nodo puntero=cabeza;
            int contador=0;
            while(contador<n && puntero.siguiente !=null){
                puntero=puntero.siguiente;
                contador++;
            }
            nodo.siguiente=puntero.siguiente;
            puntero.siguiente=nodo;
        }
        longitud++;
    }
	
    public Libros buscarLibro(int n){
        if(cabeza==null){
            return null;
        }else{
            Nodo puntero=cabeza;
            int contador=0;
            while(contador<n && puntero.siguiente !=null){
                puntero=puntero.siguiente;
                contador++;
            } 
            if(contador !=n){
                return null;
            }else{
                return puntero.libro;
            }
        }   
    }
    public int totalLibros(){
        return longitud;
    }
    public boolean isEmpty(){
        return cabeza==null;
    }
	//eliminar
    public void eliminarPrimerNodo(){
        if(cabeza!=null){
            Nodo primer=cabeza;
            cabeza=cabeza.siguiente;
            primer.siguiente=null;
            longitud--;
        }
    }
    public void eliminarUltimoElemento(){
        if(cabeza!=null){
            if(cabeza.siguiente==null){
                cabeza=null;
            }else{
                Nodo puntero=cabeza;
                while(puntero.siguiente.siguiente !=null){
                   puntero=puntero.siguiente;
                }
                puntero.siguiente=null;
                longitud--;
            }
        }
    }
    public void borrarLibro(int n){
        if(cabeza!=null){
            if(n==0){
                Nodo primer=cabeza;
                cabeza=cabeza.siguiente;
                primer.siguiente=null;
                longitud--;
            }else if(n<longitud){
                Nodo puntero=cabeza;
                int contador=0;
                while(contador < (n-1)){
                    puntero=puntero.siguiente;
                    contador++;
                }
                Nodo temp=puntero.siguiente;
                puntero.siguiente=temp.siguiente;
                temp.siguiente=null;
                longitud--;            
            }
        }
    }
}
