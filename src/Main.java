import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("MusicXML/Bohemian_Rhapsody.musicxml");
        File output = new File ("aaaa.mid");
        MusicXMLFileHelper.xml2midi(file,output);
    }
}
