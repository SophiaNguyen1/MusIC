import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("http.agent", "Mozilla/5.0 (X11; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0");
        File file = new File("MusicXML/Bohemian_Rhapsody.musicxml");
        File output = new File ("aaaa.mid");
        MusicXMLFileHelper.xml2midi(file,output);
    }
}
