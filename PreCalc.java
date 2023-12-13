import java.util.Scanner;
import java.lang.Math;
public class PreCalc {
    public static final Scanner input = new Scanner(System.in); 
    public static final String ALPABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static int userNum = CalculatorUI.userNum;

    public static void preCalcInterface() {
        System.out.println("\nType the number of the equation you want to use");
        System.out.println("(0) return home");
        System.out.println("(1) Factoring quadratics");
        System.out.println("(2) find the roots of a polynomial");
        System.out.println("(3) solve ratinal functions");
        userNum = input.nextInt();
        if (userNum < 0 || userNum > 3) {
            System.out.println("That is not a option or it is currently being worked on");
            preCalcInterface();
        }
        if (userNum == 0) {
            System.out.println();
            CalculatorUI.userInterface();
        }
        if (userNum == 1) {
            factorQuadratic();
        }
        if (userNum == 2) {
            dirrectSubstitution();
        }
        if (userNum == 3) {
            rationalSolver();
        }
    }

    public static void calcCheck() {
        System.out.println("\nwould you like to use it again type \"yes\"");
        System.out.println("if you want to return to the pre calculus selection \"q\" or \"quit\"");
        System.out.println("if you want to return home type \"home\"");
        String userInput = input.next();
        if (userInput.equals("home")) {
            userNum *= 0;
            System.out.println();
            CalculatorUI.userInterface();
        }
        if (userInput.equals("q") || userInput.equals("quits")) {
            userNum *= 0;
            System.out.println();
            preCalcInterface();
        }
        if (userInput.equals("yes")) {
            if (userNum < 1 || userNum > 3) {
                System.out.println("That is not a option yet!");
                calcCheck();
            }
            if (userNum == 1) {
                System.out.println();
                factorQuadratic();
            }
            if (userNum == 2) {
                System.out.println();
                dirrectSubstitution();
            }
            if (userNum == 3) {
                System.out.println();
                rationalSolver();
            }
        } else {
            System.out.println("try again");
            calcCheck();
        }

    }

    public static void factorQuadratic() {
        System.out.println("a*X^2 + b*X + c");
        System.out.println("what is a?");
        double a = input.nextDouble();
        System.out.println("what is b?");
        double b = input.nextDouble();
        System.out.println("what is c?");
        double c = input.nextDouble();
        double[] xs = MyMath.quadFunc(a, b, c);
        for (int i = 0; i < xs.length; i++) {
            System.out.println("X = " + xs[i]);
        }
        calcCheck();
    }

    public static void dirrectSubstitution() {
        // TODO show if imagenary
        System.out.println("\nWhat is the degree of the function");
        int degree = input.nextInt() + 1;
        double[] function = new double[degree];
        for (int i = 0; i < degree; i++) {
            System.out.print(ALPABET.charAt(i%26) + " = ");
            function[i] = input.nextInt();
        }
        double[] theRoots = MyMath.findFactor(function, degree);
       for (int i = 0; i < theRoots.length; i++) {
        System.out.println("your root is: " + theRoots[i]);
       }
        if (theRoots.length == 0) {
            System.out.println("there are no real roots");
        }
        calcCheck();
    }

    public static void factoring() {
        System.out.println("\nWhat is the degree of the first function?");
        int degree1 = input.nextInt() + 1;
        double[] factor1Nums = new double[degree1];
        for(int i = 0; i < degree1; i++) {
            System.out.print(ALPABET.charAt(i%26) + " = ");
            factor1Nums[i] = input.nextDouble();
        }
        System.out.println("\nWhat is the degree of the second function?");
        int degree2 = input.nextInt() + 1;
        double[] factor2Nums = new double[degree2];
        for(int i = 0; i < degree2; i++) {
            System.out.print(ALPABET.charAt(i%26) + " = ");
            factor2Nums[i] = input.nextDouble();
        }
        
    }

    public static void rationalSolver() {
        System.out.println("\nNumerator  ");
        System.out.println("===========   + K");
        System.out.println("Denominator");
        System.out.println("\nWhat is the degree of the numerator?");
        int numerDegree = input.nextInt() + 1;
        double[] funcOfNumer = new double[numerDegree];
        for (int i = 0; i < numerDegree; i++) {
            System.out.print(ALPABET.charAt(i % 26) + " = ");
            funcOfNumer[i] = input.nextDouble();
        }
        System.out.println("\nWhat is the degree of the denominator?");
        int denomDegree = input.nextInt() + 1;
        double[] funcOfDenom = new double[denomDegree];
        for (int i = 0; i < denomDegree; i++) {
            System.out.print(ALPABET.charAt(i % 26) + " = ");
            funcOfDenom[i] = input.nextDouble();
        }
        System.out.println("\nWhat is k?");
        int k = input.nextInt();
        double[] numerFactors = MyMath.findFactor(funcOfNumer, numerDegree);
        double[] denomFactors = MyMath.findFactor(funcOfDenom, denomDegree);
        System.out.println("\n\n");
        if (MyMath.checkOverlap(numerFactors, denomFactors) == true) {
            double[] hole = MyMath.findHole(numerFactors, denomFactors);
            // TODO check for more then 1 hole
            System.out.println("There is a hole at:");
            System.out.println("(" + hole[0] + " , " + hole[1] + ")\n");
            numerFactors = MyMath.cleanArray(numerFactors, hole[0]);
            numerDegree = numerFactors.length;
            denomFactors = MyMath.cleanArray(denomFactors, hole[0]);
            denomDegree = denomFactors.length;
        } else {
            System.out.println("There is no hole\n");
        }
        System.out.println("the symplifided function is:");
        if (numerFactors.length == 0) {
            System.out.print(funcOfNumer[0]);
        }
        for (int i = 0; i < numerFactors.length; i++) {
            if (numerFactors[i] > 0) {
                double x = numerFactors[i];
                System.out.print("(x - " + Math.abs(x) + ") ");
            } else {
                System.out.print("(x + " + Math.abs(numerFactors[i]) + ") ");
            }
        }
        System.out.print("/ ");
        if (denomFactors.length == 0) {
            System.out.println(funcOfDenom[0]);
        }
        for(int i = 0; i < denomFactors.length; i++) {
            if (denomFactors[i] < 0) {
                double x = denomFactors[i];
                System.out.print("(x + " + Math.abs(x) + ") ");
            } else if (denomFactors.length == 0) {
                System.out.println(funcOfDenom[0]);
            } else {
                System.out.print("(x - " + Math.abs(denomFactors[i]) + ") ");
            }
        } 
        System.out.println();
        if (numerDegree > denomDegree) {
            System.out.println("\nthere is no Horizantal Asymtote");
        } else {
            System.out.println("\nyour Horizantal Asymtote is:");
            System.out.println( " y = "  +  MyMath.findHAsymtote(numerDegree, funcOfNumer, denomDegree, funcOfDenom, k));
        }
        // test case 1, -2, -4, 8, / 1, 0, -9,
        if (numerDegree - 1 == denomDegree) {
            System.out.println("\nYour Slant Asymtote is:");
            double[] test = MyMath.findSlantAsymtote(funcOfNumer, funcOfDenom);
            if (test[0] == 1.0) {
                System.out.print("y = x ");
            } else {
                System.out.print("y = " + test[0] + "x ");
            }
            if (test[1] >= 0) {
                System.out.print("+ " + Math.abs(test[1]) + "\n");
            } else {
                System.out.print("- " + Math.abs(test[1]) + "\n");
            } 
        }
        if (denomDegree != 0) {
            double[] vAsymtote = MyMath.findVAsymtote(denomFactors);
            System.out.println("\nYour Vertical Asymtote is:");
            for (int i = 0; i < vAsymtote.length; i++) {
                System.out.println("x = " + -(vAsymtote[i]));
            }
        } else {
            System.out.println("\nThere is no Veritcal Hsymtotes.");
        }
        System.err.println("\nY-intercept:");
        System.out.println((funcOfNumer[funcOfNumer.length-1] / funcOfDenom[funcOfDenom.length-1]) + k);
        System.out.println("\nX-interceps");
        for (int i = 0; i < numerFactors.length; i++) {

        }
        calcCheck();               
    }

}
  