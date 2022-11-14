
package trabajofinal;

import java.util.Scanner;


public class TrabajoFinal {


    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);
        Compra pCompra;
        int nColas, x;   
        String a;
        float c;
        char opc;
        
        //Preguntar por el n de las colas
        System.out.print("Ingrese el número de cajas de supermercado a encolar: ");
        nColas = lector.nextInt();
        
        
        //Crear los dos vectores que apuntan a cabeceras y ultimos, respectivamente
        ListaLigada [] vectorColas = new ListaLigada[nColas];
        
        //Crear las n listas ligadas
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
                    System.out.print("Ingrese el numero de la caja de la cola a encolar: ");
                    x = lector.nextInt()-1;
                    System.out.print("Ingrese el valor de la compra: ");
                    c = lector.nextFloat();
                    System.out.print("Ingrese el código de la compra a encolar: ");
                    a = lector.nextLine();
                    lector.nextLine();
                    vectorColas[x].encolar(a,c);
                    break;
                case '2':
                    //Desencolar
                    System.out.print("Ingrese el numero de la caja de la cola a desencolar: ");
                    x = lector.nextInt()-1;
                    if(vectorColas[x].colaVacia())
                    {
                        System.out.println("Cola vacia");
                    } else 
                    {
                        pCompra = vectorColas[x].desencolar();
                        System.out.println("La compra desencolada fue "+pCompra.getCodigo());
                    }
                    break;
                case '3':
                    //Mostrar cola
                    System.out.print("Ingrese el numero de la caja de la cola a mostrar: ");
                    x = lector.nextInt()-1;
                    if(vectorColas[x].colaVacia())
                    {
                        System.out.println("Cola vacia");
                    } else 
                    {
                        System.out.println("Cola: ");
                        pCompra = vectorColas[x].mostrarCompra();
                        while(pCompra.getValorCompra() != 0) //diferente a nodo cabeza
                        {
                            System.out.println("Compra con código "+pCompra.getCodigo()+"y valor "+pCompra.getValorCompra());
                            pCompra = vectorColas[x].mostrarCompra();
                        }
                    }
                    break;
                case '4':
                    //Mostrar acumulado (de valor compra)
                    System.out.print("Ingrese el numero de la caja de la cola a mostrar el acumulado: ");
                    x = lector.nextInt()-1;
                    if(vectorColas[x].colaVacia())
                    {
                        System.out.println("Cola vacia");
                    } else 
                    {
                        c=0;
                        pCompra = vectorColas[x].mostrarCompra();
                        while(pCompra.getValorCompra() != 0) //diferente a nodo cabeza
                        {
                            c=c+pCompra.getValorCompra();
                            pCompra = vectorColas[x].mostrarCompra();
                        }
                        System.out.println("Para la cola "+(x+1)+", el valor acumulado del valor compra es: "+c);
                    }
                    break;
                case '5':
                    System.out.println("Finde la ejecución");
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
        System.out.println("\t1. Encolar una cola especifica");
        System.out.println("\t2. Desencolar una cola especifica");
        System.out.println("\t3. Mostrar cola especifica");
        System.out.println("\t4. Mostrar acumulado del valor de compra para una cola especifica");
        System.out.println("\t5. Salir");
        do {            
            System.out.print("\tOpcion: ");
            opcion = lector.next().charAt(0);
        } while (opcion<'1' || opcion >'5');
        return opcion;
    }
    
}
