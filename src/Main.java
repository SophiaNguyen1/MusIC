import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("http.agent", "Mozilla/5.0 (X11; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0");
        File br = new File("MusicXML/Bohemian_Rhapsody.musicxml");
        File osd = new File("MusicXML/One_Summer's_Day.musicxml");
        File reprise = new File("MusicXML/Reprise.musicxml");
        File output = new File ("aaaa.wav");
        MusicXMLFileHelper.xml2midi(br,output);
    }
}
