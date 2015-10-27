package zaoral.gamesys.devchallenge.binarydataconverter;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.createFile;

public class FileWithWriteAccess implements IValueValidator<String> {
    @Override
    public void validate(String name, String value) throws ParameterException {
        try {
            final Path path = Paths.get(value);
            if (fileDoesNotExist(path)) {
                createFile(Paths.get(value));
            } else if (noWriteAccess(path)) {
                throw new ParameterException("Don't have write access for: " + value);
            }
        } catch (IOException e) {
            throw new ParameterException("Couldn't create output file: " + value + ", because: " + e.getMessage());
        }
    }

    private boolean fileDoesNotExist(Path path) {
        return !Files.exists(path);
    }

    private boolean noWriteAccess(Path path) {
        return !Files.isWritable(path);
    }
}
