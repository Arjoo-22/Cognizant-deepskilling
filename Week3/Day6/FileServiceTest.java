import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Custom File Reader Interface
interface FileReader {
    String read();
}

// Custom File Writer Interface
interface FileWriter {
    void write(String content);
}

// Service Class
class FileService {

    private FileReader fileReader;
    private FileWriter fileWriter;

    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public String processFile() {

        String content = fileReader.read();

        fileWriter.write("Processed " + content);

        return "Processed " + content;
    }
}

// Test Class
public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {

        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        when(mockFileReader.read()).thenReturn("Mock File Content");

        FileService fileService =
                new FileService(mockFileReader, mockFileWriter);

        String result = fileService.processFile();

        assertEquals("Processed Mock File Content", result);

        verify(mockFileReader).read();
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}