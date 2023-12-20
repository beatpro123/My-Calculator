import java.lang.Math;

public class MyMath {

    public static final double GRAVITY = -9.81;
    public static final double INFINITY = Double.POSITIVE_INFINITY;

    public static boolean yesnoCheck(String input) {
        if (input.equals("y") || input.equals("yes")) {
            return true;
        }
        return false;
    }

    public static double randomNum(double min, double max) {
        return min + Math.random() * (max - min);
    }

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

    public static double pow(double num, double pow) {
        double output = 1;
        for (int i = 0; i < pow; i++) {
            output *= num;
        }
        return output;
    }

    public static double cultMath(double x, double y) {
        double output;
        output = pow(x, 2) + pow(y, 2);
        output = Math.sqrt(output);
        return output;
    }

    public static double[] getFactor(double x) {
        int arraylength = 0;
        x = Math.abs(x);
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                arraylength++;
            }
        }
        int count = 0;
        double[] a = new double[arraylength * 2];
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                a[count] = i;
                count++;
            }
        }
        for (int i = -1; i >= -x; i--) {
            if (x % i == 0) {
                a[count] = i;
                count++;
            }
        }
        return a;
    }

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

    public static double[] quadFunc(double a, double b, double c) {
        double[] output = new double[2];
        double answer1 = pow(b, 2) + (-4 * a * c);
        if (answer1 < 0) {
            answer1 = answer1 * -1;
        }
        answer1 = -b + Math.sqrt(answer1);
        answer1 = answer1 / (2 * a);
        output[0] = answer1;
        double answer2 = pow(b, 2) + (-4 * a * c);
        if (answer2 < 0) {
            answer2 = answer2 * -1;
        }
        answer2 = -b - Math.sqrt(answer2);
        answer2 = answer2 / (2 * a);
        output[1] = answer2;
        return output;
    }

    public static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

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

    public static double[] findFactor(double[] realInput, int degree) {
        int numPossibleRoots = 0;
        int rootCount = 0;
        double[] roots = new double[degree - 1];
        double[] input;
        if (degree == 0) {
            return realInput;
        }
        double[] factorsOfFirst = getFactor(realInput[0]);
        // finding x = 0 roots TODO make check for multiple
        if (realInput[realInput.length - 1] == 0) {
            realInput[realInput.length - 1] = roots[rootCount];
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
                roots[rootCount] = possibleRoots[i];
                rootCount++;
                numPossibleRoots++;
            }
        }
        // solving for 2 imaginary roots
        if ((degree - 1) - numPossibleRoots == 2) {
            double[] imagenaryFunction = factorOutRoot(input, roots, degree);
            Double a, b, c;
            a = imagenaryFunction[0];
            b = imagenaryFunction[1];
            c = imagenaryFunction[2];
            double[] imagenaryRoots = quadFunc(a, b, c);
            for (int i = 0; i < imagenaryRoots.length; i++) {
                roots[rootCount] = imagenaryRoots[i];
                rootCount++;
            }
        }
        return roots;
    }

    public static double findHAsymtote(int numerDegree, double[] funcOfNumer, int denomDegree, double[] funcOfDenom,
            int k) {
        if (numerDegree < denomDegree) {
            return k;
        } else {
            return (funcOfNumer[0] / funcOfDenom[0]);
        }
    }

    public static double[] findVAsymtote(double[] denomFactors) {
        double[] output = new double[denomFactors.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = -denomFactors[i];
        }
        return output;
    }

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

    public static int[][] newArrowHead(double slope, int fx, int ix, int fy, int iy) {
        //     \quad 4/
        //      \    /
        //       \  /
        // quad 3 \/ quad 1
        //        /\
        //       /  \
        //      /    \
        //     /quad 2\
        // [n][0] = x, [n][1] = y
        if (slope == INFINITY) {
            slope = 0;
        }
        int[][] output = new int[2][2];
        if (slope == 1 || slope == -1) {
            if (fx > ix) {
                if (fy < iy) { // (+x -y)
                    output[0][0] = fx - 5;
                    output[0][1] = fy;
                    output[1][0] = fx;
                    output[1][1] = fy + 5;
                } else { // (+x +y) done
                    output[0][0] = fx;
                    output[0][1] = fy - 5;
                    output[1][0] = fx - 5;
                    output[1][1] = fy;
                }
            } else {
                if (fy < iy) { // (-x -y) done
                    output[0][0] = fx + 5;
                    output[0][1] = fy;
                    output[1][0] = fx;
                    output[1][1] = fy + 5;
                } else { // (-x +y)
                    output[0][0] = fx;
                    output[0][1] = fy - 5;
                    output[1][0] = fx + 5;
                    output[1][1] = fy;
                }
            }
        } else if (-1 > slope || slope < 1 || (slope == 0.0 && ix == fx )) {
            if (iy > fy) { // quad 4
                output[0][0] = fx - 5;
                output[0][1] = fy + 5;
                output[1][0] = fx + 5;
                output[1][1] = fy + 5;
            } else { // quad 2
                output[0][0] = fx - 5;
                output[0][1] = fy - 5;
                output[1][0] = fx + 5;
                output[1][1] = fy - 5;
            }
        } else if (-1 < slope && slope < 1 || (slope == 0.0 && iy == fy) ) {
            if (fx > ix) { // quad 1
                output[0][0] = fx - 5;
                output[0][1] = fy - 5;
                output[1][0] = fx - 5;
                output[1][1] = fy + 5;
            } else { // quad 3
                output[0][0] = fx + 5;
                output[0][1] = fy - 5;
                output[1][0] = fx + 5;
                output[1][1] = fy + 5;
            }
        }
        return output;
    }

    public static int numberGuess(int min, int max, int guessNum) {
        int guessingNum = (min + max) / 2;
        int count = 1;
        //bianary search
        for (int i = 0; i < max; i++) {
            if (guessingNum == guessNum) {
                return i + 1;
            } else if (guessingNum < guessNum) {
                if (count % 2 == 0) {
                    guessingNum += (int) Math.round((double) (guessingNum / 2));
                } else {
                    guessingNum += guessingNum / 2;
                }
            } else if (guessingNum > guessNum) {
                if (count % 2 == 0) {
                    guessingNum -= (int) Math.round((double) (guessingNum / 2));
                } else {
                    guessingNum -= guessingNum / 2;
                }
            }
        }
        return -1;
    }

    public static double[][] getSumOfFX(Vector[] myVectors) {
        int xcount = 0;
        int testx = 0;
        int ycount = 0;
        int testy = 0;
        // determining what axis the vector belongs to 
        for (int i = 0; i < myVectors.length; i++) {
            if ((int) Math.abs(myVectors[i].getAngle()) == 0 ||(int) Math.abs(myVectors[i].getAngle()) == 180.0) {
                xcount++;
            }
        }
        int[] indexOFxs = new int[xcount];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int) Math.abs(myVectors[i].getAngle()) == 0 ||(int) Math.abs(myVectors[i].getAngle()) == 180.0) {
                indexOFxs[testx] = i;
                testx++;
            }
        }
        for (int i = 0; i < myVectors.length; i++) {
            if ((int)Math.abs(myVectors[i].getAngle()) == 90.0 || (int)Math.abs(myVectors[i].getAngle()) == 270.0) {
                ycount++;
            }
        }
        int[] indexOFys = new int[ycount];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int)Math.abs(myVectors[i].getAngle()) == 90.0 || (int)Math.abs(myVectors[i].getAngle()) == 270.0) {
                indexOFys[testy] = i;
                testy++;
            }
        }
        if (xcount + ycount == myVectors.length) {
            // saving the data of the if all the vectors are ideal
            double[][] output = new double[xcount][2];
            for (int i = 0; i < xcount; i++) {
                output[i][0] = myVectors[indexOFxs[i]].getMagnitude();
                output[i][1] = myVectors[indexOFxs[i]].getAngle();
            }
            return output;
        } else {
            int numOfDividedVectors = myVectors.length - (xcount + ycount);
            int[] specialIndex = new int[numOfDividedVectors];
            int count = 0;
            int count2 = 0; 
            int count4 = 0; 
            for (int i = 0; i < myVectors.length; i++) {
                // getting the indexes of the vectors that need to be parced 
                if (indexOFxs[count] == i) {
                    if (count+1 != indexOFxs.length) {
                        count++;
                    }
                } else if (indexOFys[count4] == i) {
                    if (count4+1 != indexOFys.length) {
                        count4++;  
                    }
                } else {
                    specialIndex[count2] = i;
                    count2++;
                    xcount++;
                }
            }
            double[][] output = new double[xcount][2];
            int count3 = 0;
            for(int i = 0; i < xcount; i++) {
                // gettint the vectors a degree of 0 or 180
                if (i < indexOFxs.length) {
                    output[i][0] = myVectors[indexOFxs[i]].getMagnitude();
                    output[i][1] = myVectors[indexOFxs[i]].getAngle();
                } else {
                    // getting the angle of the trig triangle 
                    double angle = 0;
                    for(int j = 0; j < 4; j++) {
                        if (myVectors[specialIndex[count3]].getAngle() > 0 && myVectors[specialIndex[count3]].getAngle() < 90 ) {
                            angle = myVectors[specialIndex[count3]].getAngle();
                        } else {
                            angle = myVectors[specialIndex[count3]].getAngle() - 90;
                        }
                    } 
                    // saving the data for the parced vector
                    output[i][0] = Math.abs(round(myVectors[specialIndex[count3]].getMagnitude() * 
                    Math.cos(Math.toRadians(angle)), 1));
                    if ((myVectors[specialIndex[count3]].getAngle() > 270 && myVectors[specialIndex[count3]].getAngle() < 360) ||
                        (myVectors[specialIndex[count3]].getAngle() > 0 && myVectors[specialIndex[count3]].getAngle() < 90)) {
                        output[i][1] = 0;
                    } else {
                        output[i][1] = 180;
                    }
                count3++;                    
                }
            }
            return output;
        }
    }

    public static double[][] getSumOfFY(Vector[] myVectors) {
        //  almost the same as the getSumOfFX() 
        int xcount = 0;
        int testx = 0;
        int ycount = 0;
        int testy = 0;
        for (int i = 0; i < myVectors.length; i++) {
            if ((int) Math.abs(myVectors[i].getAngle()) == 0 ||(int) Math.abs(myVectors[i].getAngle()) == 180.0) {
                xcount++;
            }
        }
        int[] indexOFxs = new int[xcount];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int) Math.abs(myVectors[i].getAngle()) == 0 ||(int) Math.abs(myVectors[i].getAngle()) == 180.0) {
                indexOFxs[testx] = i;
                testx++;
            }
        }
        for (int i = 0; i < myVectors.length; i++) {
            if ((int)Math.abs(myVectors[i].getAngle()) == 90.0 || (int)Math.abs(myVectors[i].getAngle()) == 270.0) {
                ycount++;
            }
        }
        int[] indexOFys = new int[ycount];
        for (int i = 0; i < myVectors.length; i++) {
            if ((int)Math.abs(myVectors[i].getAngle()) == 90.0 || (int)Math.abs(myVectors[i].getAngle()) == 270.0) {
                indexOFys[testy] = i;
                testy++;
            }
        }
        if (xcount + ycount == myVectors.length) {
            double[][] output = new double[ycount][2];
            for (int i = 0; i < ycount; i++) {
                output[i][0] = myVectors[indexOFys[i]].getMagnitude();
                output[i][1] = myVectors[indexOFys[i]].getAngle();
            }
            return output;
        } else {
            int numOfDividedVectors = myVectors.length - (xcount + ycount);
            int[] specialIndex = new int[numOfDividedVectors];
            int count = 0;
            int count2 = 0; 
            int count4 = 0; 
            for (int i = 0; i < myVectors.length; i++) {
                if (indexOFxs[count] == i) {
                    if (count+1 != indexOFxs.length) {
                        count++;
                    }
                } else if (indexOFys[count4] == i) {
                    if (count4+1 != indexOFys.length) {
                        count4++;  
                    }
                } else {
                    specialIndex[count2] = i;
                    count2++;
                    ycount++;
                }
            }
            double[][] output = new double[ycount][2];
            int count3 = 0;
            for(int i = 0; i < ycount; i++) {
                if (i < indexOFys.length) {
                    output[i][0] = myVectors[indexOFys[i]].getMagnitude();
                    output[i][1] = myVectors[indexOFys[i]].getAngle();
                } else {
                    double angle = 0;
                    for(int j = 0; j < 4; j++) {
                        if (myVectors[specialIndex[count3]].getAngle() > 0 && myVectors[specialIndex[count3]].getAngle() < 90 ) {
                            angle = myVectors[specialIndex[count3]].getAngle();
                        } else {
                            angle = myVectors[specialIndex[count3]].getAngle() - 90;
                        }
                    } 
                    output[i][0] = Math.abs(round(myVectors[specialIndex[count3]].getMagnitude() * 
                    Math.cos(Math.toRadians(angle)), 1));
                    if ((myVectors[specialIndex[count3]].getAngle() > 270 && myVectors[specialIndex[count3]].getAngle() < 360) ||
                        (myVectors[specialIndex[count3]].getAngle() > 0 && myVectors[specialIndex[count3]].getAngle() < 90)) {
                        output[i][1] = 0;
                    } else {
                        output[i][1] = 180;
                    }
                count3++;                    
                }
            }
            return output;
        }
    }

    public static double[] solveForAcceleration(Vector[] myVectors, double mass) {
        double[] output = new double[4];
        double[][] xVectors = getSumOfFX(myVectors);
        double[][] yVectors = getSumOfFY(myVectors);
        // x acceleration 
        double[][] realXVectorVal = new double[xVectors.length][2];
        for(int i = 0; i < xVectors.length; i++) {
            if (xVectors[i][1] == 180.0) {
                realXVectorVal[i][0] = (-1 * xVectors[i][0]);
            } else {
                realXVectorVal[i][0] = xVectors[i][0];
            }
        } 
        double xAcceleration = 0;
        for (int i = 0; i < realXVectorVal.length; i++) {
            xAcceleration += realXVectorVal[i][0];
        }
        // y acceleraion 
        double[][] realYVectorVal = new double[yVectors.length][2];
        for(int i = 0; i < yVectors.length; i++) {
            if (yVectors[i][1] == 90.0) {
                realYVectorVal[i][0] = (-1*yVectors[i][0]);
            } else {
                realYVectorVal[i][0] = yVectors[i][0];
            }
        } 
        double yAcceleration = 0;
        for (int i = 0; i < realYVectorVal.length; i++) {
            yAcceleration += realYVectorVal[i][0];
        }
        yAcceleration = round(yAcceleration/mass, 1);
        xAcceleration = round((xAcceleration / mass), 1);
        output[0] = xAcceleration;
        output[1] = yAcceleration;
        output[2] = round(cultMath(xAcceleration, yAcceleration), 1); // magnitude
        output[3] = round(Math.toDegrees(Math.atan(Math.abs(yAcceleration)/Math.abs(xAcceleration))), 1); // angle
        if (output[2] != 0) {
            if (xAcceleration > 0 && yAcceleration < 0) {
                return output;
            } else if (xAcceleration > 0 && yAcceleration < 0) {
                output[3] += 270;
            } else if (xAcceleration < 0 && yAcceleration < 0) {
                output[3] += 90;
            } else {
                output[3] += 180;
            }
        }
        return output;
    }

    
}