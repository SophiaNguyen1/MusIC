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

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.xml.parsers.ParserConfigurationException;

public class MusicXMLFileHelper {
    public static void xml2midi(File inputFile, File outputFile) throws MidiUnavailableException, InvalidMidiDataException, IOException, ParsingException, ParserConfigurationException {
        MidiParserListener listener = new MidiParserListener();

        MusicXmlParser parser = null;
        parser = new MusicXmlParser();

        parser.addParserListener(listener);
        parser.parse(inputFile);

        Sequence midiSequence = listener.getSequence();
        Midi2WavRenderer renderer = new Midi2WavRenderer();
        //MidiFileManager.save(midiSequence, outputFile);
        renderer.createWavFile(midiSequence, outputFile);
    }
}