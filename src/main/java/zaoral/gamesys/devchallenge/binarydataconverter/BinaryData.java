package zaoral.gamesys.devchallenge.binarydataconverter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryData {

    @Parameter(
            required = true,
            names = {"-i", "--inputFilePath"},
            description = "Input file which will be written as an binary string to and output file",
            validateValueWith = FileWithReadAccess.class)
    private String inputFilePath;

    @Parameter(
            required = true,
            names = {"-o", "--output"},
            description = "Output file to which input file will be written as an binary string",
            validateValueWith = FileWithWriteAccess.class)
    private String outputFilePath;

    @Parameter(
            names = {"-l", "--length"},
            description = "Number of bytes that should be read from input file"
    )
    private Long bytesToRead = Long.MAX_VALUE;

    @Parameter(
            names = {"-s", "--skip"},
            description = "Skips first N bytes",
            validateWith = PositiveInteger.class
    )
    private Long skipBytes = 0L;

    @Parameter(
            help = true,
            names = {"-h", "--help"},
            description = "Prints usage"
    )
    private boolean help = false;

    public static void main(String[] argv) {
        BinaryData binaryData = new BinaryData();
        JCommander jCommander = new JCommander(binaryData, argv);
        jCommander.setProgramName("Binary Data Converter", "convert any input file into textual binary sequence");
        if (binaryData.help) {
            jCommander.usage();
            return;
        }

        binaryData.convert();
    }

    private void convert() {
        try (
            FileInputStream in = new FileInputStream(inputFilePath);
            FileWriter out = new FileWriter(outputFilePath)) {

            int b;
            long readBytes = 0;

            while ((b = in.read()) != -1 && readBytes < bytesToRead) {
                if (skipBytes == 0) {
                    readBytes++;
                    writeInBinary(b, out);
                } else {
                    skipBytes--;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void writeInBinary(int b, FileWriter out) throws IOException {
        for (int i = Byte.SIZE - 1; i >= 0; i--) {
            out.append((b >> i & 1) == 1 ? '1' : '0');
        }
    }

}
