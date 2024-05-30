import java.util.Scanner;

public class Planetary_Math {

    public static final Scanner input = new Scanner(System.in);

    public static void solvePeriod() {
        System.out.println(" T = √((4* π^2 * r^3) / (G * M))\n");
        System.out.println("do you want sintific notation?"); 
        boolean siNote = MyMath.yesnoCheck();
        if (siNote) {
            System.out.println("(center to center)");
            System.out.println("r = x * 10^y m");
            System.out.print("x = "); 
            double xV = input.nextDouble();
            System.out.print("y = ");
            int yV = input.nextInt();
            double r = MyMath.siNote(xV, yV);
            System.out.println("M = x * 10^y Kg");
            System.out.print("x = "); 
            double xM = input.nextDouble();
            System.out.print("y = ");
            int yM = input.nextInt();
            double M = MyMath.siNote(xM, yM);
            double period = MyMath.round(MyMath.calcPeriod(M, r),1);
            System.out.println( period + " Seconds or " + MyMath.round(period / 31536000, 2) + " Years" );
            Physics.phyCheck();
        } else {
            System.out.println();
            System.out.println("(center to center)");
            System.out.print("r (meters) = ");
            double r = input.nextDouble();
            System.out.print("M (kilograms)= ");
            double M = input.nextDouble();
            double period = MyMath.round(MyMath.calcPeriod(M, r),1);
            System.out.println( period + " Seconds or " + MyMath.round(period / 31536000, 2) + " Years" );
            Physics.phyCheck();
        }
    }

    public static void solveVelocity() {
        System.out.println(" V = (G * M) / r");
        System.out.println("do you want sintific notation?"); 
        boolean siNote = MyMath.yesnoCheck();
        if (siNote) {
            System.out.println("(center to center)");
            System.out.println("r = x * 10^y m");
            System.out.print("x = "); 
            double xV = input.nextDouble();
            System.out.print("y = ");
            int yV = input.nextInt();
            double r = MyMath.siNote(xV, yV);
            System.out.println("M = x * 10^y Kg");
            System.out.println("(mass of the central body)");
            System.out.print("x = "); 
            double xM = input.nextDouble();
            System.out.print("y = ");
            int yM = input.nextInt();
            double M = MyMath.siNote(xM, yM);
            double velocity = MyMath.round(MyMath.calcVelocity(r, M),1);
            System.out.println( velocity + " m/s or " + MyMath.round(velocity * 2.23693629, 2) + " MPH");
            Physics.phyCheck();
        } else {
            System.out.println();
            System.out.println("(center to center)");
            System.out.print("r (m) = ");
            double r = input.nextDouble();
            System.out.print("M (kilo grams) = ");
            double M = input.nextDouble();
            double velocity = MyMath.round(MyMath.calcVelocity(M, r),1);
            System.out.println( velocity + " m/s or " + MyMath.round(velocity * 2.23693629, 2) + " MPH" );
            Physics.phyCheck();
        }
    }

    public static void solveMass() {
        System.out.println(" M = (4 * π^2 * r^3) / (G * T^2)");
        System.out.println("do you want sintific notation?"); 
        boolean siNote = MyMath.yesnoCheck();
        if (siNote) {
            System.out.println("(center to center)");
            System.out.println("r = x * 10^y m");
            System.out.print("x = "); 
            double xR = input.nextDouble();
            System.out.print("y = ");
            int yR = input.nextInt();
            double r = MyMath.siNote(xR, yR);
            System.out.println("T = x * 10^y seconds");
            System.out.print("x = "); 
            double xT = input.nextDouble();
            System.out.print("y = ");
            int yT = input.nextInt();
            double T = MyMath.siNote(xT, yT);
            double mass = MyMath.round(MyMath.calcVelocity(r, T),1);
            System.out.println( mass + " Kg or " + MyMath.round(mass * 2.20462262, 2) + " lb" );
            Physics.phyCheck();
        } else {
            System.out.println();
            System.out.print("T (Seconds) = ");
            double T = input.nextDouble();
            System.out.println("(center to center)");
            System.out.print("r (meters) = ");
            double R = input.nextDouble();
            double mass = MyMath.round(MyMath.calcMass(R, T),1);
            System.out.println( mass + " Kg or " + MyMath.round(mass * 2.20462262, 2) + " lb" );
            Physics.phyCheck();
        }
    }

    public static void solveRadius() {
        System.out.println(" M = ∛(4 * π^2 * r^3) / (G * T^2)");
        System.out.println("do you want sintific notation?"); 
        boolean siNote = MyMath.yesnoCheck();
        if (siNote) {
            System.out.println("(center to center)");
            System.out.println("r = x * 10^y m");
            System.out.print("x = "); 
            double xR = input.nextDouble();
            System.out.print("y = ");
            int yR = input.nextInt();
            double r = MyMath.siNote(xR, yR);
            System.out.println("T = x * 10^y seconds");
            System.out.print("x = "); 
            double xT = input.nextDouble();
            System.out.print("y = ");
            int yT = input.nextInt();
            double T = MyMath.siNote(xT, yT);
            double radius = MyMath.round(MyMath.calcRadius(r, T),1);
            System.out.println( radius + " m or " + MyMath.round(radius / 1609.344, 2) + " miles or "  + MyMath.round(radius / MyMath.siNote(1.5, 11)) + " AU");
            Physics.phyCheck();
        } else {
            System.out.println();
            System.out.print("T (Seconds) = ");
            double T = input.nextDouble();
            System.out.print("r (meters) = ");
            double R = input.nextDouble();
            double radius = MyMath.round(MyMath.calcMass(R, T),1);
            System.out.println( radius + " m or " + MyMath.round(radius / 1609.344, 2) + " miles or " +  MyMath.round(radius / MyMath.siNote(1.5, 11)) + " AU" );
            Physics.phyCheck();
        }
    }

    public static void solveGravForce() {
        
        System.out.println(" Fg =(G * M) / r^2");
        System.out.println("do you want sintific notation?"); 
        boolean siNote = MyMath.yesnoCheck();
        if (siNote) {
            System.out.println("r = x * 10^y m");
            System.out.print("x = "); 
            double xR = input.nextDouble();
            System.out.print("y = ");
            int yR = input.nextInt();
            double r = MyMath.siNote(xR, yR);
            System.out.println("mass of the heviest object");
            System.out.println("M = x * 10^y kg");
            System.out.print("x = "); 
            double xT = input.nextDouble();
            System.out.print("y = ");
            int yT = input.nextInt();
            double T = MyMath.siNote(xT, yT);
            double GravForce = MyMath.round(MyMath.calcGravForce(r, T),1);
            System.out.println( GravForce + " N/kg or " + GravForce + " m/s^2");
            Physics.phyCheck();
        } else {
            System.out.println();
            System.out.println("mass of the heviest object");
            System.out.print("M (kilogram) = ");
            double T = input.nextDouble();
            System.out.print("r (meters) = ");
            double R = input.nextDouble();
            double GravForce = MyMath.round(MyMath.calcGravForce(R, T),1);
            System.out.println( GravForce + " N/kg or " + GravForce + " m/s^2");
            Physics.phyCheck();
        }
    }
    
}