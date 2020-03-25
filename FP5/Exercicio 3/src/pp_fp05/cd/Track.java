package pp_fp05.cd;

public class Track {
    protected int number;
    protected String name;
    protected int duration;
    protected Author[] author;

    public Track(int tempNumber, String tempName, int tempDuration) {
        this.number = tempNumber;
        this.name = tempName;
        this.duration = tempDuration;
    }

    public void printTrack() {
        System.out.println("Titulo da musica numero " + number + " do CD:" + name);
        System.out.println("Duração: " + duration);
        System.out.println("Autores da musica: ");

        for (Author author : author) {
            author.authorPrint();
        }
    }
}
