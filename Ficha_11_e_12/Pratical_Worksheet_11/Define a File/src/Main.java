import player.File;

/**
 * <h2>
 * Escola Superior de Tecnologia e Gestão (ESTG)<br>
 * Politécnico do Porto (PP)<br>
 * Licenciatura em Engenharia Informática (LEI)<br>
 * Licenciatura em Segurança Informática em Redes de Computadores (LSIRC)<br>
 * Paradigmas de Programação (PP)<br>
 * 2019 / 2020<br>
 * </h2>
 * <p>
 * Main file to solve ficha 11
 * </p>
 */
public class Main {

    public static void main(String[] args) {
        File f1 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 3400, 5);
        File f2 = new File("Legendary Tiger Man - Big Black Boat", "mp4", 5000, 15);
        System.out.println(f1.toString());
        System.out.println(f2.toString());

   // ToDo: (Optional) Add Custom tests to the application

    }
}