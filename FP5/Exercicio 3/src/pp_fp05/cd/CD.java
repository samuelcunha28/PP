package pp_fp05.cd;

public class CD {
    protected String name;
    protected int year;
    protected String editor;
    protected Track[] tracks;

    public CD(String tempName, int tempYear, String tempEditor, Track[] tempTracks) {
        name = tempName;
        year = tempYear;
        editor = tempEditor;
        tracks = tempTracks;
    }


    public void printCDinfo() {
        System.out.println("Nome do CD: " + name);
        System.out.println("Ano de lançamento: " + year);
        System.out.println("Editora: " + editor);

        for (Track track : tracks) {
            track.printTrack();
        }
    }
}

