import java.io.File;
import java.io.IOException;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.DocType;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.integration.MusicXmlParser;
import org.jfugue.midi.MidiParserListener;

import javax.sound.midi.Sequence;
import javax.xml.parsers.ParserConfigurationException;

public class MusicXMLFileHelper {
    public static void xml2midi(File inputFile, File outputFile) {
        MidiParserListener listener = new MidiParserListener();

        MusicXmlParser parser = null;
        try {
            parser = new MusicXmlParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        parser.addParserListener(listener);
        try {
            parser.parse(inputFile);
        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sequence midiSequence = listener.getSequence();
        try {
            MidiFileManager.save(midiSequence, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}