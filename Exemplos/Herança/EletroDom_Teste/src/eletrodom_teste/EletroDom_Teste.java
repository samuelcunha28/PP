package eletrodom_teste;

/**
 *
 * @author Samuel
 */
public class EletroDom_Teste {

    public static void main(String[] args) {
        EletroDom eletro1 = new EletroDom("EL", 900, false);
        System.out.println(eletro1.toString());
        
        Tv tv1 = new Tv("TVK", 200, true, 10, 20, 91);
        System.out.println(tv1.toString());
        
        MicroOndas micro1 = new MicroOndas("Mk1", 1200, false);
        System.out.println(micro1.toString());
        // consumo do micro-ondas desligado
        System.out.println("Consumo do MO desligado = ");
        System.out.println(micro1.consumo() + " watts/hora\n");
        // ligar o micro-ondas
        micro1.ligar(1000, 2);
        System.out.print("Estado do MO ligado!");
        System.out.println(micro1.toString());
        System.out.print("Consumo do MO ligado = ");
        System.out.println(micro1.consumo() + " watts/hora\n");
    }  
}
