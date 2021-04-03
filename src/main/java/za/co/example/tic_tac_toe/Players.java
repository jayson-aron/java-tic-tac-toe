package za.co.example.tic_tac_toe;

import java.util.Scanner;

public class Players {
    private final String PLAYER_ONE_DEFAULT = "Player 1";
    private final String PLAYER_TWO_DEFAULT = "Player 2";
    private String name1;
    private String name2;
    private static Scanner input;

    /**
     * Players constructor instantiates the Scanner object
     */
    public Players() {
        this.input = new Scanner(System.in);
    }

    /**
     * Sets the player names to those input by the players or
     * Sets Player 1 and/or Player 2 if the player leave the names empty
     */
    public void inputPlayerNames() {
        System.out.print("\nEnter player 1 name (leave empty for default): ");
        this.name1 = input.nextLine();
        System.out.print("Enter player 2 name (leave empty for default): ");
        this.name2 = input.nextLine();

        if (this.name1.isBlank())
            this.name1 = this.PLAYER_ONE_DEFAULT;
        if (this.name2.isBlank())
            this.name2 = this.PLAYER_TWO_DEFAULT;
    }

    /**
     * Returns player1 name
     * @return: (String) player1 name
     */
    public String getPlayer1Name() {
        return name1;
    }

    /**
     * Returns player2 name
     * @return: (String) player2 name
     */
    public String getPlayer2Name() {
        return name2;
    }

    /**
     * Prints the final details after the game has ended
     * @param name: (String) the name of the player who has won the game
     * @param win: (boolean) True if someone won the game and false otherwise
     */
    public static void printGameDetails(String name, boolean win) {
        if (win)
            System.out.println("\n" + name + " has won the game!");
        else
            System.out.println("\nNone of you won the game!");
        System.out.println("Thank you for playing...");
    }

    /**
     * Gets user input and returns the index if satisfies the conditions
     * @param gameData: (Character[]) the character array cotaining the game data
     * @param name: (String) the name of the player taking a turn
     * @return: (int) the index where a player mark is to be inserterd
     */
    public static int getPlayerInput(Character[] gameData, String name) {
        int index;

        while (true) {
            try {
                System.out.print("(" + name + ") Enter number (1-9): ");
                index = Integer.parseInt(input.nextLine());
                if (gameData[index - 1].equals(' '))
                    break;
                System.out.println("(" + name + ") Your chosen grid is occupied, choose another grid.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("(" + name + ") Please enter a number in range (1-9) inclusive.");
            } catch (NumberFormatException e) {
                System.out.println("(" + name + ") Please enter a number in range (1-9) inclusive.");
            }
        }
        return index - 1;
    }
}
