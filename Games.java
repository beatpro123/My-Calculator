import java.util.Scanner;

public class Games {
    public static int userNum = CalculatorUI.userNum;
    public static Scanner input = new Scanner(System.in);

    public static void gameUI() {
        System.out.println("\nType the number of the game you want to play");
        System.out.println("(0) Return home");
        System.out.println("(1) Guess the number");
        System.out.println("(2) Hang-man \"not implemented\"");
        userNum = input.nextInt();
        if (userNum < 0 || userNum > 2) {
            System.out.println("That is not a option or it is currently being worked on");
            gameUI();
        }
        if (userNum == 0) {
            CalculatorUI.userInterface();
        }
        if (userNum == 1) {
            guessNumber();
        }
        if (userNum == 2) {
            hangMan();
        }
    }

    public static void gameCheck() {
        System.out.println("\nWould you like to use it again type (yes)");
        System.out.println("If you want to return to the game selection \"q\"");
        System.out.println("If you want to return home type \"home\"");
        String userInput = input.next();
        if (userInput.equals("yes")) {
            if (userNum < 1 || userNum > 2) {
                System.out.println("that is not a option yet");
            }
            if (userNum == 1) {
                guessNumber();
            }
            if (userNum == 2) {
                hangMan();
            }
        } else if (userInput.equals("q")) {
            gameUI();
        } else if (userInput.equals("home")) {
            CalculatorUI.userInterface();
        } else {
            System.out.println("that is not a option try again");
            gameCheck();
        }
    }

    public static void guessNumber() {
        System.out.println("\nWhat is the minimum number?");
        int min = input.nextInt();
        System.out.println("What is the maximum number?");
        int max = input.nextInt();
        System.out.println("What is the number you want guessed?");
        int guessNum = input.nextInt();
        if (guessNum < min || guessNum > max) {
            System.out.println("that is not between ");
            while (guessNum < min || guessNum > max) {
                guessNum = input.nextInt();
            }
        }
        System.out.println("it took " + MyMath.numberGuess(min, max, guessNum) + " guesses");
        gameCheck();
    }

    public static void hangMan() {
        String[] possibleWords = {"calculator", "oligarchy",  };
        String word = possibleWords[(int) MyMath.round(MyMath.randomNum(0, possibleWords.length - 1), 0)];
        int guesses = 5;
        int trys = 0;
        String tempPrintWord = "";
        for (int i = 0; i < word.length(); i++) {
            tempPrintWord += "_ ";
        }
        char[] charList = new char[word.length()];
        while (guesses > 0) {
            System.out.println("you have " + guesses + " incorrect guesses left");
            if (trys == 0) {
                System.out.println(tempPrintWord);
            }
            if (trys > 0) {
                System.out.println("\ndo you want yo guess the word?(y or n)");
                System.out.println("if it is wrong you loose 2 guesses");
                String YoN = input.next();
                if (YoN.equals("y")) {
                    System.out.println("");
                    String wordGuess = input.next();
                    if (wordGuess.equals(word)) {
                        trys++;
                        System.out.println("\ncondradulations you won with only " + trys + " trys");
                        gameCheck();
                    } else {
                        guesses -= 2;
                    }
                }
            }
            System.out.println("\ntype the letter you want to guess");
            String currentChar = input.next();
            int correctChars = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == currentChar.charAt(0)) {
                    correctChars++;
                    charList[i] = currentChar.charAt(0);
                }
            }
            if (correctChars > 0) {
                System.out.println("\nthere is " + correctChars + " " + currentChar.charAt(0));
            } else {
                System.out.println("there are no " + currentChar.charAt(0) + "'s");
                guesses--;
            }
            trys++;
            int test = 0;
            String printWord = "";
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == charList[i]) {
                    printWord += charList[i];
                    if ((test + 1) != charList.length) {
                        test++;
                    }
                } else {
                    printWord += "_";
                }
                printWord += " ";
            }
            System.out.println(printWord);
            String winCheck = "";
            for (int i = 0; i < charList.length; i++) {
                winCheck += charList[i];
            }
            if (winCheck.equals(word)) {
                System.out.println("Congradulations! You won with only " + trys + " trys!");
                gameCheck();
            }
        }
        System.out.println("\nthe word was \"" + word + "\"");
        System.out.println("Sorry you lost, better luck next time.");
        gameCheck();
    }
}
