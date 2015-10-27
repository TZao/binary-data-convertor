package zaoral.gamesys.devchallenge.binarydataconverter;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWithReadAccess implements IValueValidator<String> {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!Files.isReadable(Paths.get(value))) {
            throw new ParameterException("File does not exist or doesn't have permissions for reading.");
        }
    }
}
