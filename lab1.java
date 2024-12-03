package cs145.labs.lab1;

import java.util.Random;
import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        for (; totalGames == 0; totalGames++) {
            intro(args);
        }
    }

    public static void intro(String[] args) {

        System.err.println(
                "\n\t\t\t\tI will think of a number between 1 and the number you chose.\nGuess as many times as you like, for each guess I will tell you if the answer is higher or lower than your guess.");
        game(args);
    }

    public static void game(String[] args) {

        char yN = 'y';
        do {
            // switch to choose game size for extra credit here
            System.err.println(
                    "\nPlease start by selecting a difficulty! \n\n (1) 1-50\n (2) 1-75\n (3) 1-100\n (4) 1-200\n\nEnter 1,2,3, or 4");
            Scanner input = new Scanner(System.in);

            switch (input.nextInt()) {
                case 1:// 50
                    constraint = 50;
                    System.err.printf("\nGame set to %s", constraint);
                    break;

                case 2:// 75
                    constraint = 75;
                    System.err.printf("\nGame set to %s", constraint);

                    break;

                case 3:// 100
                    constraint = 100;
                    System.err.printf("\nGame set to %s", constraint);

                    break;
                case 4:// custom?
                    constraint = 200;
                    System.err.printf("\nGame set to %s", constraint);

                    break;
            }

            gameGuesses = 0;
            totalGames++;
            System.err.printf("\nRound %s\n\n", totalGames);
            lab1.randomNumberGenerator(args);
            // System.err.println(answer);

            Scanner scanner = new Scanner(System.in);
            do {
                guess = scanner.nextInt();
                totalGuesses++;
                gameGuesses++;
                if (guess > answer) {
                    System.err.println("Lower");
                } else if (guess < answer) {
                    System.err.println("Higher");
                }
            } while (guess != answer);

            if (guess == answer && gameGuesses == 1) {
                System.err.println("You won on the first guess!");
            } else if (guess == answer) {
                System.err.printf("You won in %s guesses", gameGuesses);
            }

            if (gameGuesses < bestGame) {
                bestGame = gameGuesses;
            }

            System.err.println("\nWould you like to play again?\t(y/n)");
            Scanner scanner2 = new Scanner(System.in);
            yN = scanner2.nextLine().charAt(0);

            if (yN == 'n' || yN == 'N') {
                scanner2.close();
                scanner.close();
                input.close();
            }

        } while (yN == 'Y' || yN == 'y');
        if (yN == 'n' || yN == 'N') {
            results(args);

        }
    }

    public static void randomNumberGenerator(String[] args) {
        Random rand = new Random();
        answer = 1 + rand.nextInt(constraint);
    }

    public static void results(String[] args) {
        int guessPerGame = totalGuesses / totalGames;
        System.err.printf(
                "\nWell done, thanks for  playing \n\nGames played:\t%s\nHigh score:\t%s\nAvarage score:\t%s\n",
                totalGames, bestGame, guessPerGame);
    }

    public static int guess;
    public static int answer;
    public static int constraint;
    public static int totalGames = 0;
    public static int gameGuesses;
    public static int totalGuesses;
    public static int bestGame = 1000;

}
