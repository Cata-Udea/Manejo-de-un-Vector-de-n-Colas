
package trabajofinal;

public class Compra {
    
    private String codigo;
    private float valorCompra;

    public Compra(String codigo, float valorCompra) {
        this.codigo = codigo;
        this.valorCompra = valorCompra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    
    
}
