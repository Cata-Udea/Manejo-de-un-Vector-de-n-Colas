
package trabajofinal;

import java.util.Scanner;

/*
    Jorge Mauricio Ortiz Murillo
    María Catalina Hernandez Casas
*/
public class TrabajoFinal {


    public static void main(String[] args) {
        System.out.println("TRABAJO FINAL - LOGICA Y REPRESENTACION II - UdeA");
        System.out.println("MANEJO DE CAJAS DE UN SUPERMERCADO");
        System.out.println();
        Scanner lector = new Scanner(System.in);
        Compra pCompra;
        int nColas, x;   
        String a;
        float c;
        char opc;
        
        
        System.out.print("Ingrese el número de cajas del supermercado a encolar: ");
        nColas = lector.nextInt();
        
        
        
        ListaLigada [] vectorColas = new ListaLigada[nColas];
        
        
        int i=0;
        while(i<nColas){
            vectorColas[i] = new ListaLigada();
            i++;
        }
        
        do 
        {            
            opc = menuManejoColasCajas();
            
            switch(opc)
            {
                case '1':
                    //Encolar
                    do{
                    System.out.print("Ingrese el numero de la caja en la que se va a encolar: ");
                    x = lector.nextInt()-1;
                    }while((x+1)>nColas);
                    System.out.println();
                    System.out.println("ENCOLAR EN LA CAJA No. "+(x+1));
                    System.out.print("Ingrese el código de la compra a encolar: ");
                    lector.nextLine();
                    a = lector.nextLine();
                    
                    System.out.print("Ingrese el valor de la compra: $");
                    c = lector.nextFloat();
                    
                    
                    
                    vectorColas[x].encolar(a,c);
                    break;
                case '2':
                    //Desencolar
                    System.out.print("Ingrese el numero de la caja en la que se va a desencolar: ");
                    x = lector.nextInt()-1;
                    if(vectorColas[x].colaVacia())
                    {
                        System.out.println("La Caja "+(x+1)+" posee COLA VACIA");
                    } else 
                    {
                        pCompra = vectorColas[x].desencolar();
                        System.out.println("CAJA No."+(x+1));
                        System.out.println("La compra desencolada con código "+pCompra.getCodigo()+
                                " - Valor de compra: $"+pCompra.getValorCompra());
                    }
                    break;
                case '3':
                    //Mostrar cola
                    do{
                        System.out.print("Ingrese el numero de la caja para mostrar la cola: ");
                        x = lector.nextInt()-1;
                    }while((x+1)>nColas);
                    if(vectorColas[x].colaVacia())
                    {
                        System.out.println("La Caja "+(x+1)+" posee COLA VACIA");
                    } else 
                    {
                        System.out.println();
                        System.out.println("COLA DE LA CAJA No.: "+(x+1));
                        pCompra = vectorColas[x].mostrarCompra();
                        //while(pCompra.getValorCompra() != 0) //diferente a nodo cabeza
                        while(pCompra.getCodigo() !="*") //diferente a nodo cabeza
                        {
                            System.out.println("Compra con código "+pCompra.getCodigo()+" y valor "+pCompra.getValorCompra());
                            pCompra = vectorColas[x].mostrarCompra();
                        }
                    }
                    break;
                case '4':
                    //Mostrar acumulado de compras
                    System.out.print("Ingrese el numero de la caja para mostrar el acumulado de compras: ");
                    x = lector.nextInt()-1;
                    if(vectorColas[x].colaVacia())
                    {
                        System.out.println("La Caja "+(x+1)+" posee COLA VACIA");
                    } else 
                    {
                        c=0;
                        pCompra = vectorColas[x].mostrarCompra();
                        while(pCompra.getValorCompra() != 0) //diferente a nodo cabeza
                        {
                            c=c+pCompra.getValorCompra();
                            pCompra = vectorColas[x].mostrarCompra();
                        }
                        System.out.println();
                        System.out.println("Para la caja "+(x+1)+", el valor acumulado de compra fue: $"+c);
                    }
                    break;
                case '5':
                    System.out.println("Fin de la ejecución");
                     break;
            }
        } 
        while (opc!='5');
    }
    
    
    static char menuManejoColasCajas()
    {
        char opcion;
        Scanner lector = new Scanner(System.in);
        System.out.println("\n...MENU DE OPCIONES...");
        System.out.println("\t1. Encolar en una caja");
        System.out.println("\t2. Desencolar desde una caja");
        System.out.println("\t3. Mostrar la cola de una caja");
        System.out.println("\t4. Mostrar acumulado del valor de compra de una caja");
        System.out.println("\t5. Salir");
        do {            
            System.out.print("\tOpcion: ");
            opcion = lector.next().charAt(0);
        } while (opcion<'1' || opcion >'5');
        return opcion;
    }
    
}
