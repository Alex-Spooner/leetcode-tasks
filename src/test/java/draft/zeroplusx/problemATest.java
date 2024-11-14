package draft.zeroplusx;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class problemATest {

    @Test
    public void testSolution() throws IOException {
        String inputData = "2\n3\n5\n76\n100\n2001\n4\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemA.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "2 1\n3 1\n5 1\n23 2\n5 5\n5 6\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void test2ToPrimes() throws IOException {
        String inputData = "2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemA.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "2 1\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void test5ToPrimes() throws IOException {
        String inputData = "3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemA.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "3 1\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

//    @Test
//    public void test4ToPrimes() throws IOException {
//        String inputData = "4\n";
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
//        System.setIn(inputStream);
//
//        // Capture output
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        // Run the main method
//        PrimeReduction.main(new String[]{"1"});
//
//        // Expected output data
//        String expectedOutput = "2 2\n";
//
//        // Assert output is as expected
//        assertEquals(expectedOutput, outputStream.toString());
//
//        outputStream.close();
//    }

    @Test
    public void test19ToPrimes() throws IOException {
        String inputData = "19\n4\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemA.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "19 1\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void test76ToPrimes() throws IOException {
        String inputData = "76\n4\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemA.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "23 2\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void test100ToPrimes() throws IOException {
        String inputData = "100\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemA.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "5 5\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

}