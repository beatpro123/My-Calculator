import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class MyMath {
    public static final double GRAVITY = -9.81;
    public static final double G = siNote(6.67, -11);
    public static final double INFINITY = Double.POSITIVE_INFINITY; 
    public static final Scanner input = new Scanner(System.in);

    // input sientific notaion gives number
    public static double siNote(double x, int y) {
        return x * pow(10, y);
    }
    // checks if input = "yes" or "y"
    public static boolean yesnoCheck() {
        System.out.println("y or yes");
        String in = input.nextLine();
        return in.equals("y") || in.equals("yes");
    }
    // getting a randome number between min and max
    public static double randomNum(double min, double max) {
        return min + Math.random() * (max - min);
    }
    // taking num to the power of pow
    public static double pow(double num, double pow) {
        double output = 1;
        boolean negitive = false;
        if (pow < 0) {
            negitive = !negitive;
            pow *= -1;
        }
        for (int i = 0; i < pow; i++) {
            output *= num;
        } 
        if (negitive) output = 1 / output;
        return output;
    }
    // pythagorean therem
    public static double cultMath(double x, double y) {
        return Math.sqrt(pow(x, 2) + pow(y, 2));
    }
    // getting the all the positive and negitive factors of x
    public static double[] getFactor(double x) {
        int arraylength = 0;
        x = Math.abs(x);
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                arraylength++;
            }
        }
        int count = 0;
        double[] arr = new double[arraylength * 2];
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                arr[count] = i;
                count++;
            }
        }
        for (int i = -1; i >= -x; i--) {
            if (x % i == 0) {
                arr[count] = i;
                count++;
            }
        }
        return arr;
    }
    // uses synthetic substitution to find the imaginaty roots of a function (has to be a quadratic function)
    public static double[] factorOutRoot(double[] input, double[] realRoot, int degree) {
        double[] output = new double[3];
        double[] test;
        int count = degree;
        double[] placeHolder = new double[count];
        for (int j = 0; j < realRoot.length; j++) {
            test = new double[count - 1];
            if (count == degree) {
                for (int i = 0; i < test.length; i++) {
                    if (i == 0) {
                        test[0] = input[0];
                    } else {
                        test[i] = (realRoot[j] * test[i - 1]) + input[i];
                    }
                    if (test.length == 3 && i == test.length - 1) {
                        for (int r = 0; r < test.length; r++) {
                            output[r] = test[r];
                        }
                    } else if (i == test.length - 1) {
                        for (int r = 0; r < test.length; r++) {
                            placeHolder[r] = test[r];
                        }
                    }
                }
            } else if (count > 3) {
                for (int i = 0; i < test.length; i++) {
                    if (i == 0) {
                        test[0] = placeHolder[0];
                    } else {
                        test[i] = (realRoot[j] * test[i - 1]) + placeHolder[i];
                    }
                    if (test.length == 3 && i == test.length - 1) {
                        for (int r = 0; r < test.length; r++) {
                            output[r] = test[r];
                        }
                    } else if (i == test.length - 1) {
                        for (int r = 0; r < test.length; r++) {
                            placeHolder[r] = test[r];
                        }
                    }
                }
            }
            count--;
        }
        return output;
    }
    // quadratic function
    public static double[] quadFunc(double a, double b, double c) {
        double[] output = new double[2];
        double answer1 = pow(b, 2) + (-4 * a * c);
        double answer2 = answer1;
        if (answer1 < 0) {
            answer1 = answer1 * -1;
        }
        answer1 = -b + Math.sqrt(answer1);
        answer1 = answer1 / (2 * a);
        output[0] = answer1;
        
        if (answer2 < 0) {
            answer2 = answer2 * -1;
        }
        answer2 = -b - Math.sqrt(answer2);
        answer2 = answer2 / (2 * a);
        output[1] = answer2;
        return output;
    }
    // rounds to the decimal place specified by percition
    public static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
    // rounds double to an int
    public static int round(double val) {
        return (int) round(val, 0);
    }
    // clears all the repeat doubles in a int 
    public static double[] clearReapeatArray(double[] input) {
        int end = input.length;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (input[i] == input[j]) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        input[shiftLeft] = input[k];
                    }
                    end--;
                    j--;
                }
            }
        }
        double[] output = new double[end];
        for (int i = 0; i < end; i++) {
            output[i] = input[i];
        }
        return output;
    }
    // removes the number removal from arr
    public static double[] cleanArray(double[] arr, double removal) {
        double[] arr_new = new double[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] != removal) {
                arr_new[k] = arr[i];
                k++;
            }
        }
        return arr_new;
    }
    // removing the double at a spesific index
    public static double[] removeTheElement(double[] arr, int index) {
            if (arr == null || index < 0 || index >= arr.length) {
                return arr;
            }
            double[] anotherArray = new double[arr.length - 1];
            for (int i = 0, k = 0; i < arr.length; i++) {
                if (i == index) {
                    continue;
                }
                anotherArray[k++] = arr[i];
            }
            return anotherArray;
        }
    // checks if there is a hole in a ratonal function
    public static double[] findHole(double[] numerFactors, double[] denomFactors) {
        double[] hole = new double[2];
        double holeX = 0;
        for (int i = 0; i < numerFactors.length; i++) {
            for (int j = 0; j < denomFactors.length; j++) {
                if (numerFactors[i] == denomFactors[j]) {
                    hole[0] = numerFactors[i];
                    holeX = numerFactors[i];
                }
            }
        }
        numerFactors = cleanArray(numerFactors, holeX);
        denomFactors = cleanArray(denomFactors, holeX);
        hole[1] = (holeX - numerFactors[0]) / (holeX - denomFactors[0]);
        return hole;
    }
    // checks if there is the same number in arr1 and arr2
    public static boolean checkOverlap(double[] arr1, double[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    // finds all the real and 2 imaginary roots if applicable 
    public static Root[] findFactor(double[] realInput, int degree) {
        int numPossibleRoots = 0;
        int rootCount = 0;
        double[] input;
        Root[] roots = new Root[degree-1];
        double[] factorsOfFirst = getFactor(realInput[0]);
        // finding x = 0 roots TODO make check for multiple
        if (realInput[realInput.length - 1] == 0) {
            //realInput[realInput.length - 1] = roots[rootCount];
            Root temp = new Root(realInput[realInput.length - 1]);
            roots[rootCount] = temp;
            input = removeTheElement(realInput, realInput.length - 1);
            degree--;
            numPossibleRoots++;
        } else {
            input = realInput;
        }
        double[] factorsOfLast = getFactor(input[input.length - 1]);
        // getting all possible factors
        double[] allPosibleFactors = new double[factorsOfLast.length * factorsOfFirst.length];
        int count = 0;
        for (int i = 0; i < factorsOfLast.length; i++) {
            for (int j = 0; j < factorsOfFirst.length; j++) {
                allPosibleFactors[count] = factorsOfLast[i] / factorsOfFirst[j];
                count++;
            }
        }
        double[] possibleRoots = MyMath.clearReapeatArray(allPosibleFactors);
        // finding the roots
        for (int i = 0; i < possibleRoots.length; i++) {
            double root = 0;
            for (int j = 0; j < degree; j++) {
                root += input[j] * MyMath.pow(possibleRoots[i], (degree - (1 + j)));
            }
            if (root == 0) {
                Root temp = new Root(possibleRoots[i]);
                roots[rootCount] = temp;
                rootCount++;
                numPossibleRoots++;
            }
        }
        // solving for 2 imaginary roots
        if ((degree - 1) - numPossibleRoots == 2) {
            double[] tempRoots = new double[roots.length-2];
            for (int i = 0; i < tempRoots.length; i++) {
                tempRoots[i] = roots[i].getRootNum();
            }
            double[] imagenaryFunction = factorOutRoot(input, tempRoots, degree);
            Double a, b, c;
            a = imagenaryFunction[0];
            b = imagenaryFunction[1];
            c = imagenaryFunction[2];
            double[] imagenaryRoots = quadFunc(a, b, c);
            for (int i = 0; i < imagenaryRoots.length; i++) {
                //roots[rootCount] = imagenaryRoots[i];
                Root imagin = new Root(imagenaryRoots[i], true);
                roots[rootCount] = imagin;
                rootCount++;
            }
        }
        return roots;
    }
    // finds horizantal asymtote for a ratonal function
    public static double findHAsymtote(int numerDegree, double[] funcOfNumer, int denomDegree, double[] funcOfDenom,
            int k) {
        if (numerDegree < denomDegree) {
            return k;
        } else {
            return (funcOfNumer[0] / funcOfDenom[0]);
        }
    }
    // finds the vertical asymtote fot a ratonal function
    public static double[] findVAsymtote(double[] denomFactors) {
        double[] output = new double[denomFactors.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = -denomFactors[i];
        }
        return output;
    }
    // calculates distance and more of a projectile motion
    public static double[] projectileCalc(double Δy, double initialVelocity, double angle, boolean unit) {
        double[] output;
        double gravity = GRAVITY;
        if (unit == false) {
            gravity = -32;
        }
        if (Δy == 0) {
            double range = initialVelocity * Math.cos(angle * 2);
            range = range / gravity;
            double time = range / initialVelocity;
            output = new double[2];
            output[0] = range;
            output[1] = time;
        } else {
            // getting the vx and vy
            double vx = 0;
            double vInitialY = 0;
            output = new double[5];
            if (angle == 0) {
                vx = initialVelocity;
                vInitialY = 0;
            } else {
                vx = initialVelocity * Math.cos(angle);
                vx = round(vx, 2);
                vInitialY = initialVelocity * Math.sin(angle);
                vInitialY = round(vInitialY, 2);
            }
            double time;
            double[] times = quadFunc((gravity / 2), vInitialY, -Δy);
            double t1 = times[0];
            double t2 = times[1];
            // evaluating the time
            if (t1 < 0) {
                time = t2;
            } else {
                time = t2;
            }
            // finding Δx
            double Δx = vx * time;
            // finding the Vfinal
            Double vFinalY = vInitialY + gravity * time;
            Double finalVelicity = cultMath(vFinalY, vx);
            // finding max hight
            Double maxHight = -pow(vInitialY, 2) / (2 * gravity);
            // finding the angle of the force vector when it hits the ground
            double forceAngle = Math.atan(vFinalY / vx);
            output[0] = Δx;
            output[1] = time;
            output[2] = finalVelicity;
            output[3] = maxHight + Math.abs(Δy);
            output[4] = Math.toDegrees(forceAngle);
        }
        return output;
    }
    // finds the slant asymtote of a ratonal function
    public static double[] findSlantAsymtote(double[] inputFunc, double[] devFunc) {
        double[] output = new double[2];
        double[] placeHolder = new double[inputFunc.length];
        int last = inputFunc.length - 1;
        output[0] = inputFunc[0] / devFunc[0];
        for (int j = 0; j < devFunc.length; j++) {
            placeHolder[j] = inputFunc[j] + -(devFunc[j] * output[0]);
        }
        placeHolder[last] = inputFunc[last];
        output[1] = placeHolder[1] / devFunc[0];
        return output;
    }
    // binary search (does not work that well)
    public static int numberGuess(int min, int max, int guessNum) {
        int count = 1;
        while (min < max) {
           int mid = (min + max) / 2;
            if (mid == guessNum) {
                return count;
            } else if (mid < guessNum) {
                min = mid;
            } else if (mid > guessNum) {
                max = mid;
            }
            count++;
        }   
        return -1;
    }
    // gets all the forces acting on the x axis of a object USELES Worse vertion of sumVectors()
    public static double[][] getSumOfFX(Vector[] myVectors) {
        int xcount = 0;
        int ycount = 0;
        // determining what axis the vector belongs to
        boolean[] indexX = new boolean[myVectors.length];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int) Math.abs(myVectors[i].getAngle()) == 0 || (int) Math.abs(myVectors[i].getAngle()) == 180.0 || (int) Math.abs(myVectors[i].getAngle()) == 360) {
                indexX[i] = true;
                xcount++;
            } else {
                indexX[i] = false;
            }
        }
        boolean[] indexY = new boolean[myVectors.length];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int)Math.abs(myVectors[i].getAngle()) == 90.0 || (int)Math.abs(myVectors[i].getAngle()) == 270.0) {
                indexY[i] = true;
                ycount++;
            } else {
                indexY[i] = false;
            }
        }
        if (xcount + ycount == myVectors.length) {
            // saving the data of the if all the vectors are ideal
            double[][] output = new double[xcount][2];
            int xIndex = 0;
            for (int i = 0; i < myVectors.length; i++) {
                if (indexX[i] == true) {
                    output[xIndex][0] = myVectors[i].getMagnitude();
                    output[xIndex][1] = myVectors[i].getAngle();
                }
            }
            return output;
        } else {
            int numOfDividedVectors = myVectors.length - (xcount + ycount);
            int[] specialIndex = new int[numOfDividedVectors];
            int count = 0; 
            for (int i = 0; i < myVectors.length; i++) {
                // getting the indexes of the vectors that need to be parced 
                if (indexX[i] != true && indexY[i] != true) {
                    specialIndex[count] = i;
                    count++;
                    xcount++;
                }
            }
            double[][] output = new double[xcount][2];
            int parceIndex = 0;
            int xIndex = 0;
            for(int i = 0; i < myVectors.length; i++) {
                // gettint the vectors a degree of 0 or 180
                if (indexX[i] == true) {
                    output[xIndex][0] = myVectors[i].getMagnitude();
                    output[xIndex][1] = myVectors[i].getAngle();
                    xIndex++;
                } else if (indexY[i] == true) {
                } else {
                    // getting the angle of the trig triangle 
                    double angle = 0;
                    for(int j = 0; j < 4; j++) {
                        if (myVectors[specialIndex[parceIndex]].getAngle() > 0 && myVectors[specialIndex[parceIndex]].getAngle() < 90 ) {
                            angle = myVectors[specialIndex[parceIndex]].getAngle();
                        } else {
                            angle = myVectors[specialIndex[parceIndex]].getAngle() - 90;
                        }
                    } 
                    // saving the data for the parced vector
                    output[xIndex][0] = Math.abs(round(myVectors[specialIndex[parceIndex]].getMagnitude() * Math.cos(Math.toRadians(angle)), 1));
                    if ((myVectors[specialIndex[parceIndex]].getAngle() > 270 && myVectors[specialIndex[parceIndex]].getAngle() < 360) ||
                        (myVectors[specialIndex[parceIndex]].getAngle() > 0 && myVectors[specialIndex[parceIndex]].getAngle() < 90)) {
                        output[xIndex][1] = 0;
                    } else {
                        output[xIndex][1] = 180;
                    }
                parceIndex++;                    
                }
            }
            return output;
        }
    }
    // gets all the forces acting on the y axis of a object USLES Worse vertion of sumVectors()s
    public static double[][] getSumOfFY(Vector[] myVectors) {
        //  almost the same as the getSumOfFX() 
        int xcount = 0;
        int ycount = 0;
        boolean[] indexX = new boolean[myVectors.length];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int) Math.abs(myVectors[i].getAngle()) == 0 || (int) Math.abs(myVectors[i].getAngle()) == 180.0 || (int) Math.abs(myVectors[i].getAngle()) == 360) {
                indexX[i] = true;
                xcount++;
            } else {
                indexX[i] = false;
            }
        }
        boolean[] indexY = new boolean[myVectors.length];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int)Math.abs(myVectors[i].getAngle()) == 90.0 || (int)Math.abs(myVectors[i].getAngle()) == 270.0) {
                indexY[i] = true;
                ycount++;
            } else {
                indexY[i] = false;
            }
        }
        if (xcount + ycount == myVectors.length) {
            double[][] output = new double[ycount][2];
            for (int i = 0; i < ycount; i++) {
                if (indexY[i] == true)
                output[i][0] = myVectors[i].getMagnitude();
                output[i][1] = myVectors[i].getAngle();
            }
            return output;
        } else {
            int numOfDividedVectors = myVectors.length - (xcount + ycount);
            int[] specialIndex = new int[numOfDividedVectors];
            int count = 0;
            for (int i = 0; i < myVectors.length; i++) {
                if (indexX[i] != true && indexY[i] != true) {
                    specialIndex[count] = i;
                    count++;
                    ycount++;
                }
            }
            double[][] output = new double[ycount][2];
            int parceIndex = 0;
            int yIndex = 0;
            for(int i = 0; i < ycount; i++) {
                if (indexY[i] == true) {
                    output[yIndex][0] = myVectors[i].getMagnitude();
                    output[yIndex][1] = myVectors[i].getAngle();
                } else if (indexX[i] == true) {
                } else { 
                    output[i][0] = Math.abs(round(myVectors[specialIndex[parceIndex]].getMagnitude() * Math.sin(Math.toRadians(myVectors[specialIndex[parceIndex]].getAngle())), 1));
                    if (output[yIndex][0] > 0) {
                        output[yIndex][1] = 0;
                    } else {
                        output[yIndex][1] = 180;
                    }
                parceIndex++;
                }
            }
            return output;
        }
    }
    // breaks apart the vectors into their components
    public static ArrayList<Vector> sumVectors(ArrayList<Vector> myVectors) {
        ArrayList<Vector> output = new ArrayList<Vector>();
        for(int i = myVectors.size()-1; i > 0; i--) {
            if (round(myVectors.get(i).getAngle()) == 0 || round(myVectors.get(i).getAngle()) ==180 || round(myVectors.get(i).getAngle()) == 360) {
                output.add(myVectors.get(i));
                myVectors.remove(i);
            } else if (round(myVectors.get(i).getAngle()) == 90 || round(myVectors.get(i).getAngle()) == 270 ) {
                output.add(myVectors.get(i));
                myVectors.remove(i);
            }
        }
        if (myVectors.size() == 0) {
            return output;
        } else {
            for(int i = myVectors.size()-1; i > 0; i--) {
                int angleX = 0;
                int angleY = 270;
                if(round(myVectors.get(i).getMagnitude() * Math.cos(Math.toRadians(myVectors.get(i).getAngle()))) < 0) {
                    angleX = 180;
                } 
                Vector xVector = new Vector(myVectors.get(i).getMagnitude()*Math.cos(Math.toRadians(myVectors.get(i).getAngle())), angleX, myVectors.get(i).getType() + "X");
                if (myVectors.get(i).getMagnitude() * Math.cos(Math.toRadians(myVectors.get(i).getAngle())) < 0) {
                    angleY = 90;
                }
                Vector yVector = new Vector(myVectors.get(i).getMagnitude()*Math.sin(Math.toRadians(myVectors.get(i).getAngle())), angleY, myVectors.get(i).getType() + "Y");
                myVectors.remove(i);
                output.add(xVector);
                output.add(yVector);
            }
            return output;
        }        
    }
    // takes the sum of all the vectors and solves for the final 
    public static double[] solveAcceleration(ArrayList<Vector> myVectors, double mass) {
        double[] output = new double[4];
        ArrayList<Vector> xArrayList = new ArrayList<Vector>();
        ArrayList<Vector> yArrayList = new ArrayList<Vector>();
        for(int i = 0; i < myVectors.size(); i++) {
            if (myVectors.get(i).getAngle() == 90 || myVectors.get(i).getAngle() == 270 ) {
                yArrayList.add(myVectors.get(i));
            } else {
                xArrayList.add(myVectors.get(i));
            }            
        }
        // sum of x forces
        double xSum = 0;
        for(int i = 0; i < xArrayList.size(); i++) {
            xSum += xArrayList.get(i).getMagnitude() * Math.cos(Math.toRadians(xArrayList.get(i).getAngle()));
        }
        xSum = round(xSum / mass, 1);
        // sum of y forces
        double ySum = 0;
        for(int i = 0; i < yArrayList.size(); i++) {
            ySum += yArrayList.get(i).getMagnitude() * Math.sin(Math.toRadians(yArrayList.get(i).getAngle()));
        }
        ySum = round(ySum / mass, 1);
        output[0] = xSum;
        output[1] = ySum;
        output[2] = round(cultMath(xSum, ySum), 1); // magnitude 
        output[3] = round(Math.toDegrees(Math.atan(Math.abs(ySum)/Math.abs(xSum))), 1); // angle 
        return output;
    }
    // solves for orbital period (orbits)
    public static double calcPeriod(double M, double r) {
        return Math.sqrt((4 * pow(Math.PI, 2) * pow(r, 3)) / (G * M));
    }
    // solves the velocity of a orbiting body (orbits)
    public static double calcVelocity(double r, double M) {
        return G * M / r;
    }
    // solves for mass of heviest body (orbits)
    public static double calcMass(double r, double T) {
        return (4 * pow(Math.PI, 2) * pow(r, 3)) / (G * pow(T, 2));
    }
    // solves for radius (orbits)
    public static double calcRadius(double T, double M) {
        return Math.cbrt((G * M * pow(T, 2)) / 4 * pow(Math.PI, 2));
    }
    // solve for force of gravity (orbits) 
    public static double calcGravForce(double M, double r) {
        return G * M / pow(r, 2); 
    }
}