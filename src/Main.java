import java.io.*;

/* Where the program breaks:
 * - multiple voices starting at different spots
 * - time signatures that aren't 4/4 (just plays at the wrong tempo)
 * - uneven subdivisions of notes (crazy tuplets and whatever)
 */

public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("http.agent", "Mozilla/5.0 (X11; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0");
        File br = new File("MusicXML/Bohemian_Rhapsody.musicxml");
        File output = new File ("aaaa.wav");
        MusicXMLFileHelper.xml2midi(br,output);
    }
}
