package chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.google.common.collect.Lists;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Basic unit tests for the CLITest
 */
@RunWith(MockitoJUnitRunner.class)
public class CLITest {

    @Mock
    private PrintStream testOut;

    @Mock
    private InputStream testIn;

    /**
     * Make sure the CLI initially prints a welcome message
     */
    @Test
    public void testCLIWritesWelcomeMessage() {
        new CLI(testIn, testOut);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(testOut, times(1)).println(captor.capture());

        String message = captor.getValue();

        assertTrue("The CLI should initially print a welcome message", message.startsWith("Welcome"));
    }

    /**
     * Test that the CLI can initially accept input
     */
    @Test
    public void testHelpCommand() throws Exception {
        runCliWithInput("help");

        List<String> output = captureOutput();
        assertEquals("Should have 13 output calls", 13, output.size());
    }

    @Test
    public void testNewCommand() throws Exception {
        runCliWithInput("new");
        List<String> output = captureOutput();

        assertEquals("Should have had 6 calls to print strings", 6, output.size());
        assertEquals("It should have printed the board first", 700, output.get(2).length());
        assertEquals("It should have printed the board again", 700, output.get(4).length());
    }

    @Test
    public void testBoardCommand() throws Exception {
        runCliWithInput("new", "board");
        List<String> output = captureOutput();

        assertEquals("Should have had 9 output calls", 9, output.size());
        assertEquals("It should have printed the board three times", output.get(2), output.get(4));
    }

    @Test
    public void testNewBoard() throws Exception {
        runCliWithInput();
        List<String> output = captureOutput();

        assertEquals("Should have 4 output calls", 4, output.size());
        assertTrue("It's the white's move", output.get(3).contains("White's Move"));

        Stack<String> rows = splitBoardByRow(output.get(2));

        assertEquals(
                "The board print's the black player's first row",
                "8 | R | N | B | Q | K | B | N | R | 8",
                rows.get(7)
        );
        assertEquals(
                "The board print's the black player's second row",
                "7 | P | P | P | P | P | P | P | P | 7",
                rows.get(6)
        );
        assertEquals(
                "The board print's the white player's first row",
                "1 | r | n | b | q | k | b | n | r | 1",
                rows.get(0)
        );
        assertEquals(
                "The board print's the black player's second row",
                "2 | p | p | p | p | p | p | p | p | 2",
                rows.get(1)
        );
    }

    /**
     * Helper method which splits the single board string into a list of individual lines
     *
     * @param board
     * @return
     */
    private Stack<String> splitBoardByRow(String board) {
        // Create a new arraylist of the board's rows by line
        List<String> rows = Lists.newArrayList(board.split(System.getProperty("line.separator")));

        Stack<String> stack = new Stack<String>();
        for (String row : Lists.reverse(rows)) {
            if (row.substring(0, 1).matches("\\d")) {
                stack.push(row);
            }
        }

        return stack;
    }

    private List<String> captureOutput() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // 9 times means we printed Welcome, the input prompt twice, and the 'help' screen
        verify(testOut, atLeastOnce()).println(captor.capture());

        return captor.getAllValues();
    }

    private CLI runCliWithInput(String... inputLines) {
        StringBuilder builder = new StringBuilder();
        for (String line : inputLines) {
            builder.append(line).append(System.getProperty("line.separator"));
        }

        ByteArrayInputStream in = new ByteArrayInputStream(builder.toString().getBytes());
        CLI cli = new CLI(in, testOut);
        cli.startEventLoop();

        return cli;
    }
}
