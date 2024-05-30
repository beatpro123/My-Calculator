public class Root { 
    private boolean imaginary;
    private double number;

    public Root(double num) {
        this(num,false);
    }

    public Root(double num, boolean imaginary) {
        number = num;
        this.imaginary = imaginary;
    }

    public double getRootNum() {
        return number;
    }
     
    public boolean getImaginary() {
        return imaginary;
    }

    public String toString() {
        if (imaginary == true) {
            return  "i " + number;
        }
        return "" + number;         
    }
}   
