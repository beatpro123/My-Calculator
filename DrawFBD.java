import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.lang.Math;
import java.util.Scanner;

public class DrawFBD extends Canvas{
    public static final Scanner input = new Scanner(System.in);
    public static final int SIZE = 600;
    public static final double GRAVITY = MyMath.GRAVITY;
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
        // TODO fix the arrow heads 
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
        g.drawLine(ix, fyg, gravityHeads[0][0], gravityHeads[0][1]);
        g.drawLine(ix, fyg, gravityHeads[1][0], gravityHeads[1][1]);
        System.out.println("How many vectors? (not incluging gravity)");
        int numOfVectors = input.nextInt();
        double[][] vectorValues = new double[numOfVectors+1][2];
        vectorValues[0][0] = fyg - iy;
        vectorValues[0][1] = 90;
        while (count != numOfVectors) {
            System.out.println("vector " + (count+1) + ":");
            System.out.println("what is the magnitude?");
            double magnitude = input.nextDouble();
            System.out.println("what is the angle?");
            double angle = Math.toRadians(input.nextInt());
            int xpos = ix + (int) Math.round(magnitude*Math.cos(angle)); 
            System.out.println("x = " + xpos); 
            int ypos = iy + (int) Math.round(magnitude*Math.sin(angle));
            System.out.println("y = " + ypos);
            double slope = (double)(iy-ypos) /(double) (ix-xpos);
            g.drawLine(ix, iy, xpos, ypos);
            int[][] heads = MyMath.newArrowHead(slope, xpos, ix, ypos, iy);
            g.drawLine(xpos, ypos, heads[0][0], heads[0][1]);
            g.drawLine(xpos, ypos, heads[1][0], heads[1][1]);
            count++;
            int magOrDeg = 0;
            vectorValues[count][magOrDeg] = magnitude;
            magOrDeg++;
            vectorValues[count][magOrDeg] = Math.toDegrees(angle);            
        }
        System.out.println(MyMath.solveForAcceleration(vectorValues, mass));
    }
}
