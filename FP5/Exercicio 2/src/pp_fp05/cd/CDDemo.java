package pp_fp05.cd;

public class CDDemo {

    public static void main(String[] args) {
        Artist artist1 = new Artist("Artista 1", "German", "1977-03-04");
        Artist[] artists = {artist1};

        Track track1 = new Track(1, "Ho Hey", 90, "Lumineers");
        Track track2 = new Track(2, "Stubborn Love", 105, "Wesley Schltz");
        Track[] tracks = {track1, track2};

        CD cd1 = new CD("The Lumineers", "The Lumineers", 480, 2012, "Dualtone Records", artists, tracks);
        cd1.tracks[0] = track1;
        cd1.tracks[14] = track2;

        System.out.println("Nome do cd: " + cd1.name);
        System.out.println("Ano de lançamento: " + cd1.year);
        System.out.println("Editora: " + cd1.editor);

        int nTracks = cd1.tracks.length;
        for (int i = 0; i < nTracks; i++) {
            if (cd1.tracks[i] != null) {
                Track t = cd1.tracks[i];
                System.out.println("Música número: " + t.number + " com titulo: " + t.name);
                System.out.println("Duração (em segundos): " + t.duration);
                System.out.println("Autor da música: " + t.author);
            }
        }
    }
}