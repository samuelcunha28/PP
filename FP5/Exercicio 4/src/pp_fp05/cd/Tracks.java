package pp_fp05.cd;

public class Tracks {

    public int number;
    public String name;
    public int duration;
    public Authors[] author;

    public Tracks(int tempNumber, String tempName, int tempDuration) {

        number = tempNumber;
        name = tempName;
        duration = tempDuration;
    }

    public void printTrack() {
        System.out.println("Titulo da musica numero " + number + " do CD:" + name);
        System.out.println("Duração: " + duration);
        System.out.println("Autores da musica: ");

        for (Authors author : author) {
            author.authorPrint();
        }
    }
}
