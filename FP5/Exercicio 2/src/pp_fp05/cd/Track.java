package pp_fp05.cd;

public class Track {
    protected int number;
    protected String name;
    protected int duration;
    protected String author;

    public Track(int tempNumber, String tempName, int tempDuration, String tempAuthor) {
        this.number = tempNumber;
        this.name = tempName;
        this.duration = tempDuration;
        this.author = tempAuthor;
    }
}
