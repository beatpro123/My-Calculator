
public class Vector {
    private double magnitude;
    private double angle;
    private String type;
    private Double accleration;
    public static final int SIZE = DrawFBD.SIZE;
    public static final int INITIAL = SIZE / 2;

    // TODO move the vector head() in here and make it work

    public Vector(double magnitude, double angle, String type) {
        this.magnitude = magnitude;
        this.angle = angle;
        this.type = type;
    }

    public Vector(double magnitude, double angle, String type, double acceleraion) {
        this.magnitude = magnitude;
        this.angle = angle;
        this.type = type;
        this.accleration = acceleraion;
    }

    public double getAngle() {
        return angle;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getType() {
        return type;
    }

    public double getAcclerarion() {
        return accleration;
    } 

    public int[] calcPos() {
        int[] output = new int[2];
        if (angle < 0) {
            angle = 360 + angle - 180;
        }
        output[0] = INITIAL + (int) MyMath.round(magnitude * Math.cos(Math.toRadians(angle)), 0);
        output[1] = INITIAL + (int) MyMath.round(magnitude * Math.sin(Math.toRadians(angle)), 0);
        return output;
    }

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
        if (yPos > INITIAL) {
            output[1] = yPos + 10;
        } else if (yPos < INITIAL) {
            output[1] = yPos - 5;
        } else {
            if (xPos < INITIAL) {
                output[0] =  xPos - (output[0]) + 5;
                output[1] = yPos - 3;
            } else {
                output[1] = xPos + 5;
            }
        }
        return output;
    }

}
 