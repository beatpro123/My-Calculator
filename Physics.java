import java.util.Scanner;

public class Physics {
    public static final Scanner input = new Scanner(System.in);
    public static int userNum = CalculatorUI.userNum;

    public static void phyCheck() {
        System.out.println("\nwould you like to use it again type (yes)");
        System.out.println("if you want to return to the physics selection \"q\"");
        System.out.println("if you want to return home type \"home\"");
        String userInput = input.next();
        if (userInput.equals("home")) {
            userNum *= 0;
            System.out.println();
            CalculatorUI.userInterface();
        }
        if (userInput.equals("q")) {
            userNum *= 0;
            System.out.println();
            physisicsInterface();
        }
        if (userInput.equals("yes")) {
            if (userNum < 1 || userNum > 2) {
                System.out.println("That is not a option yet!");
                phyCheck();
            }
            if (userNum == 1) {
                System.out.println();
                projectileMotionDistance();
            }
        }
    }

    public static void physisicsInterface() {
        System.out.println("\nType the number of the equation you want to use");
        System.out.println("(0) Return home");
        System.out.println("(1) Projectile motion");
        System.out.println("(2) FBD's (Under Constuction)");
        userNum = input.nextInt();
        if (userNum < 0 || userNum > 3) {
            System.out.println("That is not a option or it is currently being worked on");
            physisicsInterface();
        }
        if (userNum == 0) {
            System.out.println();
            CalculatorUI.userInterface();
        }
        if (userNum == 1) {
            projectileMotionDistance();
        }
        if (userNum == 2) {
            uiFBDS();
        }
    }

    public static void projectileMotionDistance() {
        String unit = "meters";
        double Δy, angle, initialVelocity;
        boolean metricCheck = true;
        System.out.println("\nWhat unit? \n(1) meters \n(2) feet");
        int unitCheck = input.nextInt();
        if (0 > unitCheck || unitCheck > 2) {
            System.out.println("\nThat is not a option");
            System.out.println("try again");
            projectileMotionDistance();
        }
        if (unitCheck == 2) {
            unit = "feet";
            metricCheck = false;
        }
        System.out.print("\nwhat is Δy (" + unit + "): ");
        Δy = input.nextDouble();
        System.out.print("\nwhat is the initial velicity (" + unit + "/seconds): ");
        initialVelocity = input.nextDouble();
        System.out.print("\nwhat is the angle of the launch: ");
        angle = Math.toRadians((input.nextDouble()));
        double[] answers = MyMath.projectileCalc(Δy, initialVelocity, angle, metricCheck);
        if (answers.length == 2) {
            double range = MyMath.round(answers[0], 1);
            double time = MyMath.round(answers[1], 2);
            System.out.println("\nThe projectile travled " + range + " " + unit + ", it took " + time + " seconds");
        } else {
            double time = MyMath.round(answers[1], 2);
            double Δx = MyMath.round(answers[0], 1);
            double maxHight = MyMath.round(answers[3], 1);
            double finalVelicity = MyMath.round(answers[2], 1);
            double finalAngle = MyMath.round(answers[4],1);
            System.out.println("\nThe projectile travled " + Δx + " " + unit + ", it took " + time + " seconds");
            System.out.println("It hit the ground with a velocity of " + finalVelicity + " " + unit + "/seconds with a angle of " + finalAngle + ".");
            System.out.println("It reached a maximum hight of " + (maxHight) + " " + unit);
        }
        phyCheck();
    }


    public static void uiFBDS() {
        // add unit check if neccisary 
        System.out.println("\nWhat are you solving for?");
        System.out.println("(1) draw FBD");
        System.out.println("(2) solve for acceleration");
        System.out.println("(3) solve for a unknow vector");
        System.out.println("(4) solve for unkown vector and acceleration");
        int solveFor = input.nextInt();
        if (solveFor < 1 || solveFor > 4) {
            System.out.println("That is not a option or it is currently being worked on");
            uiFBDS();
        }
        if (solveFor == 1) { // just draw FBD
            System.out.println("\nWhat is the mass of the object (Kg)");
            double mass = input.nextDouble();
            System.out.println("How many force vectors are there (not including gravity)");
            int vectorCount = input.nextInt();
            System.out.println("         -90");
            System.out.println("         270");
            System.out.println("          |");
            System.out.println("          |");
            System.out.println("          |");
            System.out.println("          |");
            System.out.println("180 ------+-------- 0");
            System.out.println("          |");
            System.out.println("          |");
            System.out.println("          |");
            System.out.println("          |");
            System.out.println("          90");
            System.out.println("         -270");
            int count = 0;
            String[] vectorTypes = {" Applyed ", " Friction ", " Tencion ", " Normal "};
            String[] myVectorTypes = new String[vectorCount];
            double[][] myVectors = new double[vectorCount][2];
            for (int i = 0; i < vectorCount; i++) {
                int degORmag = 0;
                System.out.println("\nWhat is the type of force for vector " + (i+1));
                for (int j = 0; j < vectorTypes.length; j++) {
                    System.out.print("(" + (j+1) + ")" + vectorTypes[j]); 
                    if (j+1 == vectorTypes.length) {
                        System.out.println();
                    }
                }
                int vectorTypeNum = input.nextInt()-1;
                vectorTypes[count] = vectorTypes[vectorTypeNum];
                count++;
                System.out.println("What is the angle of the vector?");
                myVectors[i][degORmag] = input.nextDouble();
                degORmag++;
                System.out.println("What is the Magnitude of the force?");
                myVectors[i][degORmag] = input.nextDouble();
            }
        }
        if (solveFor == 2) {
            projectileMotionDistance();
        }
        if (solveFor == 3) {
            uiFBDS();
        }
        if (solveFor == 4) {

        }




        System.out.println("\nWhat is the mass of the object (Kg)");
        double mass = input.nextDouble();
        System.out.println("How many force vectors are there (not including gravity)");
        int vectorCount = input.nextInt();
        //System.out.println("What is the degee of the serface.");
        //int inclinedPlane = input.nextInt();
        //System.out.println("what do you want to sovle for?");
        //String[] solvibility = {" Acceleration ", " An Unknown Force"};
        //for (int i = 0; i < 1; i++) {
        //
        //}
        //System.out.println("what do you know?");
        //for (int i = 0; i < solvibility.length; i++) {
        //    System.out.print("("+(i+1)+")" + solvibility[i]);
        //    if (i+1 == solvibility.length) {
        //        System.out.println();
        //    }
        //}        
        System.out.println("         -90");
        System.out.println("         270");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("180 ------+-------- 0");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          90");
        System.out.println("         -270");
        int count = 0;
        String[] vectorTypes = {" Applyed ", " Friction ", " Tencion ", " Normal "};
        String[] myVectorTypes = new String[vectorCount];
        double[][] myVectors = new double[vectorCount][2];
        for (int i = 0; i < vectorCount; i++) {
            int degORmag = 0;
            System.out.println("\nWhat is the type of force for vector " + (i+1));
            for (int j = 0; j < vectorTypes.length; j++) {
                System.out.print("(" + (j+1) + ")" + vectorTypes[j]); 
                if (j+1 == vectorTypes.length) {
                    System.out.println();
                }
            }
            int vectorTypeNum = input.nextInt()-1;
            vectorTypes[count] = vectorTypes[vectorTypeNum];
            count++;
            System.out.println("What is the angle of the vector?");
            myVectors[i][degORmag] = input.nextDouble();
            degORmag++;
            System.out.println("What is the Magnitude of the force?");
            myVectors[i][degORmag] = input.nextDouble();
        }
    }
    
}
