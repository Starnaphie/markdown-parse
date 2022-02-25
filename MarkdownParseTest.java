// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void snippet1Test() throws IOException {
        List<String> result = List.of("`google.com", "google.com", "ucsd.edu");
        String contents= Files.readString(Path.of("./snippet1.md"));

        assertEquals(result, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet2Test() throws IOException {
        List<String> result = List.of("a.com", "a.com(())", "example.com");
        String contents= Files.readString(Path.of("./snippet2.md"));

        assertEquals(result, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet3Test() throws IOException {
        List<String> result = List.of("https://ucsd-cse15l-w22.github.io/");
        String contents= Files.readString(Path.of("./snippet3.md"));
    
        assertEquals(result, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet1OtherTest() throws IOException {
        List<String> result = List.of("`google.com", "google.com", "ucsd.edu");
        String contents= Files.readString(Path.of("./snippet1.md"));

        assertEquals(result, MarkdownParseOther.getLinks(contents));
    }

    @Test
    public void snippet2OtherTest() throws IOException {
        List<String> result = List.of("a.com", "a.com(())", "example.com");
        String contents= Files.readString(Path.of("./snippet2.md"));

        assertEquals(result, MarkdownParseOther.getLinks(contents));
    }

    @Test
    public void snippet3OtherTest() throws IOException {
        List<String> result = List.of("https://ucsd-cse15l-w22.github.io/");
        String contents= Files.readString(Path.of("./snippet3.md"));
    
        assertEquals(result, MarkdownParseOther.getLinks(contents));
    }

}