package pp_fp05.cd;

public class CD {

     public String name;
     public int year;
     public String editor;
     public Tracks[] tracks;
     public float price;

    CD(String tempName, int tempYear, String tempEditor, Tracks[] tempTracks) {
        name = tempName;
        year = tempYear;
        editor = tempEditor;
        tracks = tempTracks;
    }

    public CD(String tempName, int tempYear, String tempEditor, Tracks[] tempTracks, float tempPrice) {
        name = tempName;
        year = tempYear;
        editor = tempEditor;
        tracks = tempTracks;
        price = tempPrice;
    }

    public void printCDinfo() {
        if (price != 0.0) {
            System.out.println("Nome do CD: " + name);
            System.out.println("Ano de lançamento: " + year);
            System.out.println("Editora: " + editor);
            System.out.println("Preco: " + price + " €");
        } else {
            System.out.println("Nome do CD: " + name);
            System.out.println("Ano de lançamento: " + year);
            System.out.println("Editora: " + editor);
            System.out.println("Preco: SEM PREÇO");
        }

        for (Tracks track : tracks) {
            track.printTrack();
        }
    }
}