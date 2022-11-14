
package trabajofinal;



public class ListaLigada 
{
    private Nodo cab, ult, x;
    
    public ListaLigada(){
        cab = new Nodo("*",0); // * no es un cod de caja y no hay precio cero
        ult=x=cab;
    }
    
    //Agregar un nodo a la cola, ligado a ult
    public void encolar(String pCod, float pPrecio)
    {
        Nodo p = new Nodo(pCod,pPrecio);
        ult.setLiga(p);
        ult=p;
    }
    
    //La cola tiene nodos?
    public boolean colaVacia()
    {
        return (cab.getLiga() == null);
    }

    //Quitar primer nodo, al que apunta cab
    public Compra desencolar()
    {
        Compra cajaDesencolada;
        Nodo p = cab.getLiga();
        cajaDesencolada = p.getCompra();
        cab.setLiga(p.getLiga());
        if(cab.getLiga() == null)
        {
            cab=ult;
        }
        return cajaDesencolada;
    }
    
    //Para mostrar las compras de una cola de una caja
    public Compra mostrarCompra()
    {
        x = x.getLiga();
        if (x==null)
        {x=cab;}
        return x.getCompra();
    }

    public Nodo getCab() {
        return cab;
    }

    public Nodo getUlt() {
        return ult;
    }
  
}
