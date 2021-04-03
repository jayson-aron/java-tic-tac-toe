package za.co.example.tic_tac_toe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    public void testGetNames() {
        InputStream mockedInput = new ByteArrayInputStream("Jayson\nAron\n".getBytes());
        System.setIn(mockedInput);
        Players players = new Players();
        players.inputPlayerNames();
        String actualOutput = outputStreamCaptor.toString().trim();
        assertEquals("Jayson", players.getPlayer1Name());
        assertEquals("Aron", players.getPlayer2Name());
    }

    @Test
    public void testGetNamesPlayer1Default() {
        InputStream mockedInput = new ByteArrayInputStream("\nAron\n".getBytes());
        System.setIn(mockedInput);
        Players players = new Players();
        players.inputPlayerNames();
        String actualOutput = outputStreamCaptor.toString().trim();
        assertEquals("Player 1", players.getPlayer1Name());
        assertEquals("Aron", players.getPlayer2Name());
    }

    @Test
    public void testGetNamesPlayer2Default() {
        InputStream mockedInput = new ByteArrayInputStream("Jayson\n\n".getBytes());
        System.setIn(mockedInput);
        Players players = new Players();
        players.inputPlayerNames();
        String actualOutput = outputStreamCaptor.toString().trim();
        assertEquals("Jayson", players.getPlayer1Name());
        assertEquals("Player 2", players.getPlayer2Name());
    }

    @Test
    public void testGetNamesAllDefaults() {
        InputStream mockedInput = new ByteArrayInputStream("\n\n".getBytes());
        System.setIn(mockedInput);
        Players players = new Players();
        players.inputPlayerNames();
        String actualOutput = outputStreamCaptor.toString().trim();
        assertEquals("Player 1", players.getPlayer1Name());
        assertEquals("Player 2", players.getPlayer2Name());
    }
}
