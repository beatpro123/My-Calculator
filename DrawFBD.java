import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;
import java.util.Scanner;
import java.awt.event.KeyEvent;

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

    public void paint(Graphics g) { // TODO make the labels for the vctors 
        int ix = (SIZE/2), iy = (SIZE/2);
        int count = 0;
        g.fillOval((ix-5), (iy-5), 10, 10);
        System.out.println("What is the mass of the object? (Kg)");
        double mass = input.nextDouble();
        int fyg = iy + (int) Math.round(mass*-GRAVITY);
        g.drawLine(ix, iy, ix, fyg);
        int[][] gravityHeads = MyMath.newArrowHead(0, ix, ix, fyg, iy);
        Vector gravity = new Vector(fyg - iy, 90, "Gravity");
        g.drawLine(ix, fyg, gravityHeads[0][0], gravityHeads[0][1]);
        g.drawLine(ix, fyg, gravityHeads[1][0], gravityHeads[1][1]);
        g.drawString(gravity.getType() + " " + gravity.getMagnitude() + " N", gravity.calcAvePos(ix, fyg)[0], gravity.calcAvePos(ix, fyg)[1]);
        System.out.println("How many vectors? (not incluging gravity)");
        int numOfVectors = input.nextInt();
        Vector[] vectorValues = new Vector[numOfVectors+1];
        vectorValues[0] = gravity;
        while (count != numOfVectors) {
            System.out.println("vector " + (count+1) + ":");
            System.out.println("what is the magnitude?");
            double magnitude = input.nextDouble();
            System.out.println("what is the angle?");
            double angle = Math.toRadians(input.nextInt());
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
            int[] vecPos = tempVector.calcPos();
            int xpos = vecPos[0], ypos = vecPos[1];
            double slope = (double)(iy-ypos) /(double) (ix-xpos);
            g.drawLine(ix, iy, xpos, ypos);
            int[][] heads = MyMath.newArrowHead(slope, xpos, ix, ypos, iy);
            g.drawLine(xpos, ypos, heads[0][0], heads[0][1]);
            g.drawLine(xpos, ypos, heads[1][0], heads[1][1]);
            g.drawString(tempVector.getType() + " " + tempVector.getMagnitude() + " N", tempVector.calcAvePos(xpos, ypos)[0], tempVector.calcAvePos(xpos, ypos)[1]);
            count++;
            vectorValues[count] = tempVector; 
        } 
        double[] acceleration = MyMath.solveForAcceleration(vectorValues, mass);
        System.out.println("X-acceleration = " + acceleration[0] + " M/S^2, Y-accleration = " + acceleration[1] + " M/S^2." +
        "\nAccleration = " + acceleration[2] + " M/S^2, with an angle of " + acceleration[3]);
        if (MyMath.round(acceleration[2], 0) != 0.0) {
            Vector finalAccleration = new Vector(acceleration[2] * mass, acceleration[3], "Accleration", acceleration[2]);
            g.setColor(Color.red);
            g.drawLine(ix, iy, finalAccleration.calcPos()[0], finalAccleration.calcPos()[1]);
            double aSlope = (double)(iy-finalAccleration.calcPos()[1]) /(double) (ix-finalAccleration.calcPos()[0]);
            int[][] accelerationHeads = MyMath.newArrowHead(aSlope, finalAccleration.calcPos()[0], ix, finalAccleration.calcPos()[1], iy);
            g.drawLine(finalAccleration.calcPos()[0], finalAccleration.calcPos()[1], accelerationHeads[0][0], accelerationHeads[0][1]);
            g.drawLine(finalAccleration.calcPos()[0], finalAccleration.calcPos()[1], accelerationHeads[1][0], accelerationHeads[1][1]);
            g.drawString(finalAccleration.getType() + " " + finalAccleration.getMagnitude() + " N " + finalAccleration.getAcclerarion() + " M/S^2" , finalAccleration.calcAvePos(finalAccleration.calcPos()[0],
            finalAccleration.calcPos()[1])[0], finalAccleration.calcAvePos(finalAccleration.calcPos()[0], finalAccleration.calcPos()[1])[1]);
        }
        Physics.phyCheck();
    }
}
