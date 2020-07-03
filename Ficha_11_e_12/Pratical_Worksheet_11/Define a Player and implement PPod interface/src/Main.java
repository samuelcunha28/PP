import player.File;
import player.PPlayer;
import player.PPod;
import player.exceptions.InvalidFileException;
import player.exceptions.InvalidPlayerStateException;

public class Main {
    public static void main(String[] args) {

        File f1 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 3400, 5);
        File f2 = new File("Legendary Tiger Man - Big Black Boat", "mp4", 5000, 15);
        System.out.println(f1.toString());
        System.out.println(f2.toString());


// ToDo: (Optional) Add Custom tests to the application

    }
}