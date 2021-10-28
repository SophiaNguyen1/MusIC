import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("MusicXML/One_Summer's_Day.musicxml");
        File output = new File ("aaaa.midi");
        MusicXMLFileHelper.xml2midi(file,output);
    }
}
