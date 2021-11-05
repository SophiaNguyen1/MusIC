import java.io.*;

import nu.xom.ParsingException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.midi.MidiParserListener;
//import org.jfugue.integration.MusicXmlParser;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.xml.parsers.ParserConfigurationException;

public class MusicXMLFileHelper {
    public static File xmlEdit(File file) throws IOException {
        File output = new File ("MusicXML/output.musicxml");
        String line;
        BufferedReader in = new BufferedReader(new FileReader(file));
        BufferedWriter out = new BufferedWriter(new PrintWriter(output));
        while ((line = in.readLine()) != null) {
            if (line.contains("sound tempo")) {
                int tempo = (int)Double.parseDouble(line.substring(line.indexOf("\"")+1, line.lastIndexOf("\"")));
                out.write("<sound tempo=\"" + tempo +"\"/>\n");
            } else if (line.contains("sound dynamics")) {
                int dynamics = (int)Double.parseDouble(line.substring(line.indexOf("\"")+1, line.lastIndexOf("\"")));
                out.write("<sound dynamics=\"" + dynamics +"\"/>\n");
            } else {
                out.write(line+"\n");
            }
        }
        in.close();
        out.close();
        return output;
    }

    public static void xml2midi(File inputFile, File outputFile) throws MidiUnavailableException, InvalidMidiDataException, IOException, ParsingException, ParserConfigurationException {
        MidiParserListener listener = new MidiParserListener();

        MusicXmlParser parser = new MusicXmlParser();

        parser.addParserListener(listener);
        parser.parse(inputFile);

        Sequence midiSequence = listener.getSequence();
        Midi2WavRenderer renderer = new Midi2WavRenderer();
        //MidiFileManager.save(midiSequence, new File("aaaa.mid"));
        renderer.createWavFile(midiSequence, outputFile);
    }
}