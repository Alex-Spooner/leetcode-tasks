package draft.zeroplusx;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class problemBForthTest {

    @Test
    public void zeroLineSmokeTest() throws IOException {
        String inputData = "0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: IMPOSSIBLE\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void minimalCaseTest() throws IOException {
        String inputData = "1\n" +
                "a a\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        problemBForth.main(new String[]{"1"});

        String expectedOutput = "Case 1: a\n";
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void incorrectOneLineSmokeTest() throws IOException {
        String inputData = "1\n" +
                "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: IMPOSSIBLE\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void oneLineSmokeTest() throws IOException {
        String inputData = "1\n" +
                "peo peo\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: peo\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void twoLinesSmokeTest() throws IOException {
        String inputData = "2\n" +
                "p pe\n" +
                "eople ople\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: people\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void twoLinesSmokeTest2() throws IOException {
        String inputData = "2\n" +
                "aaaaa aaaa\n" +
                "aa aaa\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: aaaaaaa\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void incorrectTwoLinesSmokeTest() throws IOException {
        String inputData = "2\n" +
                "eople ople\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: IMPOSSIBLE\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }


    @Test
    public void threeLinesTest() throws IOException {
        String inputData = "3\n" +
                "efgh efgh\n" +
                "d cd\n" +
                "abc ab\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: abcd\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void incorrectThreeLinesTest() throws IOException {
        String inputData = "0\n" +
                "efgh efgh\n" +
                "d cd\n" +
                "abc ab\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: IMPOSSIBLE\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void threeLinesTest2() throws IOException {
        String inputData = "3\n" +
                "aaaaa aaaaa\n" +
                "bbbbb bb\n" +
                "bbbb bbb\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: aaaaa\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void threeLinesNegativeTest() throws IOException {
        String inputData = "3\n" +
                "a ab\n" +
                "b bb\n" +
                "c cc\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: IMPOSSIBLE\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void fiveLinesTest() throws IOException {
        String inputData = "5\n" +
                "are yo\n" +
                "you u\n" +
                "how nhoware\n" +
                "alan arala\n" +
                "dear de\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: dearalanhowareyou\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void eightLinesTest() throws IOException {
        String inputData = "8\n" +
                "i ie\n" +
                "ing ding\n" +
                "resp orres\n" +
                "ond pon\n" +
                "oyc y\n" +
                "hello hi\n" +
                "enj njo\n" +
                "or c\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        problemBForth.main(new String[]{"1"});

        // Expected output data
        String expectedOutput = "Case 1: ienjoycorresponding\n";

        // Assert output is as expected
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }

    @Test
    public void complexSequenceTest() throws IOException {
        String inputData = "11\n" +
                "ab abc" + "\n" +
                "bc bcd" + "\n" +
                "cd cde" + "\n" +
                "de def" + "\n" +
                "ef efg" + "\n" +
                "fg fgh" + "\n" +
                "gh ghi" + "\n" +
                "hi hij" + "\n" +
                "ij ijk" + "\n" +
                "jk jkl" + "\n" +
                "kl klm" + "\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        problemBForth.main(new String[]{"1"});

        String expectedOutput = "Case 1: abcdefghijklm\n";
        assertEquals(expectedOutput, outputStream.toString());

        outputStream.close();
    }
}