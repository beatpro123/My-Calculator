import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;
import java.util.Scanner;

public class DrawFBD extends Canvas{
    public static final Scanner input = new Scanner(System.in);
    public static final int SIZE = 600;
    public static final double GRAVITY = MyMath.GRAVITY;
    public static final String[] FORCETYPES = {"Normal", "Applyed", "Friction", "Tension"};
    public static void drawFBD() {
        JFrame frame = new JFrame("FBD");
        Canvas canvas = new DrawFBD();
        canvas.setSize(SIZE, SIZE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    // Leaving this as a example to not over complicate things
    public static int[][] arrowHead(double slope, int fx, int ix ,int fy, int iy) {
        int[][] output = new int[2][2];
        double slopeAngle = Math.atan(slope);
        double headSlope1 = Math.tan(slopeAngle + Math.toRadians(45));
        double headSlope2 = Math.tan(slopeAngle - Math.toRadians(45));
        // might be a way better solition
        if (slope >= 0 && slope < 1 || slope == 0) {
            if (fx > ix) {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx-5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx-5) - fx) + fy);
                            }                     
                        }
                    }
                }
            } else {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx+5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx+5) - fx) + fy);
                            }                     
                        }
                    }
                }
            }
        } else if (slope < 0 && slope > -1) {
            if (fx > ix) {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx+5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx-5) - fx) + fy);
                            }                     
                        }
                    }
                }
            } else {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx-5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx+5) - fx) + fy);
                            }                     
                        }
                    }
                } 
            }
        } else if ( slope < -1) {
            if (fy <= iy) {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx+5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx+5) - fx) + fy);
                            }                     
                        }
                    }
                }
            } else {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx-5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx-5) - fx) + fy);
                            }                     
                        }
                    }
                }
            }
        } else if (slope >= 1) {
            if (fy > iy) {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx+5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy-5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx+5) - fx) + fy);
                            }                     
                        }
                    }
                }
            } else {
                for (int r = 0; r < output.length; r++) {
                    for (int c = 0; c < output.length; c++) {
                        if (r == 0) {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope1 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope1 * ((fx-5) - fx) + fy);
                            }                    
                        } else {
                            if (c == 0) {
                                output[r][c] = (int)Math.round(((fy+5) - fy) / headSlope2 + fx);
                            } else {
                                output[r][c] = (int)Math.round(headSlope2 * ((fx+5) - fx) + fy);
                            }                     
                        }
                    }
                }
            }
        }
        return output;
    }

    public void paint(Graphics g) {
        // making the center poind for the FBD
        int ix = (SIZE/2), iy = (SIZE/2);
        int count = 0;
        g.fillOval((ix-5), (iy-5), 10, 10);
        System.out.println("(1) Net force \n(2) Net acceleration ");
        int forceOrAcceleration = input.nextInt();
        System.out.println("What is the mass of the object? (Kg)");
        double mass = input.nextDouble();
        Vector gravity = new Vector(mass * (-GRAVITY), 270, "Gravity");
        int fyg = gravity.calcPos()[1];        
        g.drawLine(ix, iy, ix, fyg);
        int gravityHeads[][] = gravity.calcArrowHead();       
        g.drawLine(ix, fyg, gravityHeads[0][0], gravityHeads[0][1]);
        g.drawLine(ix, fyg, gravityHeads[1][0], gravityHeads[1][1]);
        g.drawString(gravity.getType() + " " + MyMath.roundToInt(gravity.getMagnitude()) + " N", gravity.calcAvePos(ix, fyg)[0], gravity.calcAvePos(ix, fyg)[1]);
        System.out.println("How many vectors? (not incluging gravity)");
        int numOfVectors = input.nextInt();
        Vector[] vectorValues = new Vector[numOfVectors+1];
        vectorValues[0] = gravity;
        while (count != numOfVectors) {
            System.out.println("vector " + (count+1) + ":");
            System.out.println("what is the magnitude?");
            double magnitude = input.nextDouble();
            System.out.println("what is the angle?");
            double angle = input.nextInt();
            if (angle == 0) {
                angle = 360;
            }
            angle = Math.toRadians(angle % 360);
            System.out.println("What is the type of force?");
            for(int i = 0; i < FORCETYPES.length; i++) {
                System.out.print("(" + (i+1) + ") " + FORCETYPES[i]); 
                if (i+1 != FORCETYPES.length) {
                    System.out.print(", ");
                } else { 
                    System.out.println();
                }
            }
            int whatForce = input.nextInt() - 1;
            Vector tempVector = new Vector(magnitude, Math.toDegrees(angle), FORCETYPES[whatForce]);
            int xpos = tempVector.getEndPos()[0];
            int ypos = tempVector.getEndPos()[1];
            g.drawLine(ix, iy, xpos, ypos);
            int[][] heads = tempVector.calcArrowHead();

            g.drawLine(xpos, ypos, heads[0][0], heads[0][1]);
            g.drawLine(xpos, ypos, heads[1][0], heads[1][1]);
            g.drawString(tempVector.getType() + " " + tempVector.getMagnitude() + " N", tempVector.calcAvePos(xpos, ypos)[0], tempVector.calcAvePos(xpos, ypos)[1]);
            count++;
            vectorValues[count] = tempVector; 
        } 
        double[] acceleration = MyMath.solveForAcceleration(vectorValues, mass);
        String prefrence = "";
        if (forceOrAcceleration == 2) {
            prefrence = "Acceleration";
            System.out.println("X-acceleration = " + acceleration[0] + " M/S^2, Y-accleration = " + acceleration[1] + " M/S^2." +
            "\nAccleration = " + acceleration[2] + " M/S^2, with an angle of " + (360-acceleration[3]) % 360);
        } else {
            prefrence = "Force";
            System.out.println("X-Force = " + (acceleration[0]*mass)+ " N, Y-Force = " + (acceleration[1]*mass) + " N." +
            "\nNet-Force = " + (acceleration[2]*mass) + " N, with an angle of " + (360-acceleration[3]) % 360);
        }
        if (MyMath.round(acceleration[2], 0) != 0.0) {
            Vector finalAccleration = new Vector(acceleration[2] * mass, acceleration[3], "Net-"+prefrence, acceleration[2]);
            g.setColor(Color.red);
            int accelX = finalAccleration.calcPos()[0], accelY = finalAccleration.calcPos()[1];
            g.drawLine(ix, iy, accelX, accelY);
            int[][] accelerationHeads = finalAccleration.calcArrowHead();
            g.drawLine(accelX, accelY, accelerationHeads[0][0], accelerationHeads[0][1]);
            g.drawLine(accelX, accelY, accelerationHeads[1][0], accelerationHeads[1][1]);
            g.drawString(finalAccleration.getType() + " " + finalAccleration.getMagnitude() + " N " + 
            finalAccleration.getAcclerarion() + " M/S^2" , finalAccleration.calcAvePos(accelX, accelY)[0], 
            finalAccleration.calcAvePos(accelX, accelY)[1]);
        }
        Physics.phyCheck();
    }
}