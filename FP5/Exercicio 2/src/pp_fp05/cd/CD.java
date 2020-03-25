package pp_fp05.cd;

public class CD {
    protected String bandName;
    protected String name;
    protected int time;
    protected int year;
    protected String editor;
    protected Artist[] artist;
    protected Track[] tracks;

    public CD(String tempBandNname, String tempName, int tempTime, int tempYear, String tempEditor, Artist[] tempArtist, Track[] tempTracks) {
        this.bandName = tempBandNname;
        this.name = tempName;
        this.time = tempTime;
        this.year = tempYear;
        this.editor = tempEditor;
        this.artist = tempArtist;
        this.tracks = new Track[tempTracks.length];
        for(int i = 0; i < tempTracks.length; i++) {
            this.tracks[i] = tempTracks[i];
        }
    }
}
