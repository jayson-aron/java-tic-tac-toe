package za.co.example.tic_tac_toe;

public class Game {
    private final Character[] gameData;

    /**
     * Game constructor initializes a new Character Array
     */
    public Game() {
        this.gameData = new Character[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    }

    /**
     * Draws the tic-tac-toe grid
     */
    public void drawGrid() {
        System.out.println("\n\t" + gameData[6] + "|" + gameData[7] + "|" + gameData[8]);
        System.out.println("\t-----");
        System.out.println("\t" + gameData[3] + "|" + gameData[4] + "|" + gameData[5]);
        System.out.println("\t-----");
        System.out.println("\t" + gameData[0] + "|" + gameData[1] + "|" + gameData[2]);
    }

    /**
     * Returns the Character Array
     * @return: (Character[]) the Character Array
     */
    public Character[] getGameData() {
        return this.gameData;
    }

    /**
     * Sets a mark at the given index
     * @param mark: (char) A naught or a cross as a players mark
     * @param index: (int) The index where to insert the mark
     */
    public void setPlayerMark(char mark, int index) {
        this.gameData[index] = mark;
    }

    /**
     * Returns true if there's at lest one space character(' ') in the Character Array
     * @return: (boolean) True if there is at least one space character and false otherwise
     */
    public boolean shouldContinue() {
        for (Character mark: this.gameData)
            if (mark.equals(' '))
                return true;
        return false;
    }

    /**
     * Checks if the game has been won
     * @return: (boolean) True if player has won a game and false otherwise
     */
    public boolean gameIsWon() {
        if (this.gameData[0].equals(gameData[1]) && gameData[1].equals(gameData[2]) && !(gameData[0].equals(' ')))
            return true;
        else if (this.gameData[3].equals(gameData[4]) && gameData[4].equals(gameData[5]) && !(gameData[3].equals(' ')))
            return true;
        else if (this.gameData[6].equals(gameData[7]) && gameData[7].equals(gameData[8]) && !(gameData[6].equals(' ')))
            return true;
        else if (this.gameData[0].equals(gameData[3]) && gameData[3].equals(gameData[6]) && !(gameData[0].equals(' ')))
            return true;
        else if (this.gameData[1].equals(gameData[4]) && gameData[4].equals(gameData[7]) && !(gameData[1].equals(' ')))
            return true;
        else if (this.gameData[2].equals(gameData[5]) && gameData[5].equals(gameData[8]) && !(gameData[2].equals(' ')))
            return true;
        else if (this.gameData[0].equals(gameData[4]) && gameData[4].equals(gameData[8]) && !(gameData[0].equals(' ')))
            return true;
        else return this.gameData[2].equals(gameData[4]) && gameData[4].equals(gameData[6]) && !(gameData[2].equals(' '));
    }
}
