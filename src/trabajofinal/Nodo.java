
package trabajofinal;


public class Nodo {
    
    private Nodo liga;
    private Compra compra;
    
    
    public Nodo(String pCod,float pValor)
    {
        compra = new Compra(pCod,pValor);
        liga= null;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    
}
