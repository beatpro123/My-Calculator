
public class Vector {
    private double magnitude;
    private double angle;
    private String type;
    private Double accleration;
    public static int scale;
    private int fx;
    private int fy;
    public static final int SIZE = DrawFBD.SIZE;
    public static final int INITIAL = SIZE / 2;
    private static final int CONST = 5;

    public Vector(double magnitude, double angle, String type) {
        this.magnitude = MyMath.round(magnitude, 1);
        this.angle = 360 - MyMath.round(angle, 1);
        this.type = type;
        fx = calcPos()[0];
        fy = calcPos()[1];
    }

    public Vector(double magnitude, double angle, String type, double acceleraion) {
        this.magnitude = magnitude;
        this.angle = angle;
        this.type = type;
        this.accleration = acceleraion;
        fx = calcPos()[0];
        fy = calcPos()[1];
    }

    // accsessors 
    public double getAngle() {
        return MyMath.roundToInt(angle);
    }

    public double getMagnitude() {
        return MyMath.roundToInt(magnitude);
    }

    public String getType() {
        return type;
    }

    public double getAcclerarion() {
        return accleration;
    } 
    
    public int[] getEndPos() {
        int[] output = {fx, fy};
        return output;
    }

    // getting the position for the tip of the line, based on the angle and magnitude and also determines scale
    public int[] calcPos() {
        int[] output = new int[2];
        boolean test = true;
        if (angle < 0) {
            angle = 360 + angle - 180;
        }
        output[0] = INITIAL + (int) MyMath.round(magnitude * Math.cos(Math.toRadians(angle)), 0);
        output[1] = INITIAL + (int) MyMath.round(magnitude * Math.sin(Math.toRadians(angle)), 0);
        // determining the scale
        int placeHolder = output[1];
        int mag = output[1];
        if (type.equals("Gravity")) {
            for (int i = 1; test == true; i++) {
                if (placeHolder < 300) {
                    i++;
                    test = false;
                    scale = i;
                } else if (placeHolder < 550 ) {
                    test = false;
                    scale = i;
                }  else {
                    placeHolder = mag / i;
                }

            }
            output[1] = output[1] / scale; 
            //output[0] = output[0] / scale;
            fx = output[0];
            fy = output[1];
        } else {
            if (angle == 0 || angle == 180) {
                output[0] = output[0] / scale;
            } else if (angle == 90 || angle == 270) {
                output[1] = output[1] / scale;
            }
            //output[0] = output[0] / scale;
            //output[1] = output[1] / scale;
            fx = output[0];
            fy = output[1];
        }
        return output;
    }
    // calculating the center position for the label for the vectors
    public int[] calcAvePos(int xPos, int yPos) {
        int [] output = new int[2];
        String discription = "";
        if (accleration != null) {
            discription = (type + magnitude + accleration);
            output[0] = xPos - ((discription.length() + 9) * 5) / 2;
        } else {
            discription = (type + magnitude );
            output[0] = xPos - ((discription.length() + 3) * 5) / 2;
        }
        if (yPos >= INITIAL) {
            output[1] = yPos + CONST * 3;
        } else {
            output[1] = yPos - CONST * 3;
        }
        return output;
    }
    // geting the postions for the arrow heads 
    public int[][] calcArrowHead() {
        int[][] output = new int[2][2]; 
        if (magnitude == 0) {
            return output;
        }
        int angle1 = (MyMath.roundToInt(angle)-225);
        if (angle1 < 0) {
            angle1 = 360 + angle1;
        }
        int angle2 = (MyMath.roundToInt(angle)+225) % 360;
        // calculating the point for the first arrow head
        output[0][0] = fx + CONST * MyMath.roundToInt(Math.cos(Math.toRadians(angle1)));
        output[0][1] = fy + CONST * MyMath.roundToInt(Math.sin(Math.toRadians(angle1)));
        // calculating the point for the second arrow head 
        output[1][0] = fx + CONST * MyMath.roundToInt(Math.cos(Math.toRadians(angle2)));
        output[1][1] = fy + CONST * MyMath.roundToInt(Math.sin(Math.toRadians(angle2)));
        return output;
    }

} 