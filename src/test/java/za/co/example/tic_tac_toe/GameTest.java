package za.co.example.tic_tac_toe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testNewGame() {
        Game game = new Game();
        assertEquals(' ', game.getGameData()[1]);
    }

    @Test
    public void testSetPlayerMark() {
        Game game = new Game();
        assertEquals(' ', game.getGameData()[0]);
        game.setPlayerMark('X', 0);
        assertEquals('X', game.getGameData()[0]);
    }

    @Test
    public void testShouldContinueTrue() {
        Game game = new Game();
        game.setPlayerMark('X', 0);
        game.setPlayerMark('O', 5);
        game.setPlayerMark('X', 3);
        assertTrue(game.shouldContinue());
    }

    @Test
    public void testShouldContinueFalse() {
        Game game = new Game();
        game.setPlayerMark('X', 0);
        game.setPlayerMark('O', 5);
        game.setPlayerMark('X', 3);
        game.setPlayerMark('O', 1);
        game.setPlayerMark('X', 8);
        game.setPlayerMark('O', 7);
        game.setPlayerMark('X', 2);
        game.setPlayerMark('O', 4);
        game.setPlayerMark('X', 6);
        assertFalse(game.shouldContinue());
    }

    @Test
    public void testPlayerHasWonTrue() {
        Game game = new Game();
        game.setPlayerMark('X', 0);
        game.setPlayerMark('O', 6);
        game.setPlayerMark('X', 4);
        game.setPlayerMark('O', 3);
        game.setPlayerMark('X', 8);
        assertTrue(game.gameIsWon());
    }

    @Test
    public void testPlayerHasWonFalse() {
        Game game = new Game();
        game.setPlayerMark('X', 0);
        game.setPlayerMark('O', 6);
        game.setPlayerMark('X', 4);
        game.setPlayerMark('O', 3);
        game.setPlayerMark('X', 7);
        assertFalse(game.gameIsWon());
    }
}
