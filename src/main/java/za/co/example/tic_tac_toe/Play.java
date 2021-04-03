package za.co.example.tic_tac_toe;


import java.util.Random;

public class Play {
    private static final Random randomNum = new Random();

    public static void main(String[] args) {
        int playerTracker = randomNum.nextInt(2);
        boolean win = false;
        Players players = new Players();
        Game game = new Game();
        char mark;
        String name = "";
        int index;

        players.inputPlayerNames();

        while(game.shouldContinue() && !win) {
            game.drawGrid();
            mark = getNextPlayerMark(playerTracker);
            name = getNextPlayerName(players, playerTracker);
            index = Players.getPlayerInput(game.getGameData(), name);
            game.setPlayerMark(mark, index);
            win = game.gameIsWon();
            playerTracker += 1;
        }

        game.drawGrid();
        Players.printGameDetails(name, win);
    }

    /**
     * Returns player1 name if playerTracker is even and player2 name if odd
     * @param players: (Players) the Players object
     * @param playerTracker: (int) the playerTracker which keeps track of which player plays next
     * @return: (String) the player name
     */
    private static String getNextPlayerName(Players players, int playerTracker) {
        if (playerTracker % 2 == 0)
            return players.getPlayer1Name();
        return players.getPlayer2Name();
    }

    /**
     * Returns character 'X' if playerTracker is even and 'O' if it is odd
     * @param playerTracker: (int) the playerTracker which keeps track of which player plays next
     * @return: (char) the character
     */
    private static char getNextPlayerMark(int playerTracker) {
        if (playerTracker % 2 == 0)
            return 'X';
        return 'O';
    }
}
