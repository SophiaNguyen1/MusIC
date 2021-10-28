// from http://sizustech.blogspot.com/2014/12/reading-and-writing-files-in-java.html

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHelper {

    public String read(File inputFile) throws Exception {
        String string = "";
        String line;

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        while ((line = in.readLine()) != null) {
            string += line;
        }
        in.close();

        return string;
    }

    public void write(File outputFile, String string) throws Exception {
        outputFile.createNewFile();

        BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
        out.write(string);
        out.close();
    }
}