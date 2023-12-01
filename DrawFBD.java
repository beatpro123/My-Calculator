import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.lang.Math;
public class DrawFBD extends Canvas{
    public static final int SIZE = 600;
    public static void drawFBD() {
        JFrame frame = new JFrame("FBD");
        Canvas canvas = new DrawFBD();
        canvas.setSize(SIZE, SIZE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

    }
    
    public static int[][] newArrowHead(double slope, int fx, int ix ,int fy, int iy) {
        int[][] output = new int[2][2];
        if (-1 < slope && slope < 1) {
            if (fx > ix) {
                output[0][0] = fx-5;
                output[0][1] = fx-5;
                output[1][0] = fx-5;
                output[1][1] = fx+5;
            } else {
                output[0][0] = fx+5;
                output[0][1] = fx-5;
                output[1][0] = fx+5;
                output[1][1] = fx+5;
            }
        } else if (-1 > slope || slope < 1) {
            if (iy > fy) {
                output[0][0] = fx-5;
                output[0][1] = fx+5;
                output[1][0] = fx+5;
                output[1][1] = fx+5;
            } else {
                output[0][0] = fx-5;
                output[0][1] = fx-5;
                output[1][0] = fx+5;
                output[1][1] = fx-5;
            }

        } else if (slope == 1 || slope == -1) {
            if (fx > ix) {
                if (fy < iy) {
                    output[0][0] = fx-5;
                    output[1][1] = fy+5;
                } else {
                    output[0][1] = fy-5;
                    output[1][0] = fx-5;
                }
            } else {
                if (fy < iy) {
                    output[0][0] = fx+5;
                    output[1][1] = fx+5;
                } else {
                    output[0][1] = fy+5;
                    output[1][0] = fx-5;
                }
            }
        }
        return output;
    }

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

    public void paint(Graphics g) {
        int ix = (SIZE/2), iy = (SIZE/2);
        int arrowCount = 5;
        int[] fys = {300, 200, 50, 500, 250};
        int[] fxs = {450, 200, 300, 350, 210};
        g.fillOval((SIZE/2) - 5, (SIZE/2) - 5, 10, 10);
        for (int i = 0; i < arrowCount; i++) {
            int fy = fys[i];
            int fx = fxs[i];
            double slope = (double)(fy-iy) / (double) (fx-ix);
            g.drawLine(ix, iy, fx, fy);
            // arrow directions
            int[][] heads = newArrowHead(slope, fx, ix, fy, iy);
            for(int j = 0; j < 2; j++) {
                for (int l =0; l < 2; l++) {
                    System.out.println(j + " " + l + " " + heads[j][l]); 
                }
            }
            //g.drawLine(fx, fy, heads[0][0], heads[0][1]);
            //g.drawLine(fx, fy, heads[1][0], heads[1][1]);
            g.drawLine(fx, fy, fx-7, fy-7);
            g.drawLine(fx, fy, fx-7, fy+7);
            if (i+1 != arrowCount) {
                System.out.println("-------");
            }
        }
        // Line: (pos1 x, pos1 y, pos2 x, pos2 y)
    }
}
