import java.util.Scanner;

public class CalculatorUI {
    public static final Scanner input = new Scanner(System.in);
    public static int userNum = 0;
    // add test cases here: 
    // public static double[] dividen = {1.0, 0.0, -4.0}; 
    // public static double[] devisor = {1.0, -5.0};
    // public static
    // public static
    // public static
    // public static
    public static void main(String[] args) {
        System.out.print("\n\033[H\033[2J");
        System.out.flush();
        //userInterface();
        Physics.uiFBDS();
        //DrawFBD.drawFBD();
    }

    public static void userInterface() {
        System.out.print("\n\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to the calculator");
        System.out.println("Type the number of what class you want to cheat on");
        System.out.println("(1) pre-calc");
        System.out.println("(2) Physiscs ");
        System.out.println("(3) Games");
        userNum = input.nextInt();
        if (userNum < 1 || userNum > 3) {
            System.out.println("That is not a option!\n");
            userInterface();
        }
        if (userNum == 1) {
            PreCalc.preCalcInterface();
        }
        if (userNum == 2) {
            Physics.physisicsInterface();
        }
        if (userNum == 3) {
            Games.gameUI();
        }
    }
}
