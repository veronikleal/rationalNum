// Project 4 
public class MainProjectFour {
    public static void main(String[] args) {
        Rational a = new Rational(2, 4);
        Rational b = new Rational(2, 6);

        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " * " + b + " = " + a.mul(b));
        System.out.println(a + " / " + b + " = " + a.div(b));

        Rational[] arr = {new Rational(7, 1), new Rational(6, 1), new Rational(5, 1),
                          new Rational(4, 1), new Rational(3, 1), new Rational(2, 1),
                          new Rational(1, 1), new Rational(1, 2), new Rational(1, 3),
                          new Rational(1, 4), new Rational(1, 5), new Rational(1, 6),
                          new Rational(1, 7), new Rational(1, 8), new Rational(1, 9),
                          new Rational(0, 1)};

        selectSort(arr);

        for (Rational r : arr) {
            System.out.println(r);
        }

        Number n = new Rational(3, 2); // Corrected to instantiate Number with Rational

        System.out.println(n.doubleValue());
        System.out.println(n.floatValue());
        System.out.println(n.intValue());
        System.out.println(n.longValue());
    }

    public static <T extends Comparable<? super T>> void selectSort(T[] array) {
        T temp;
        int mini;
        for (int i = 0; i < array.length - 1; ++i) {
            mini = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j].compareTo(array[mini]) < 0) {
                    mini = j;
                }
            }
            if (i != mini) {
                temp = array[i];
                array[i] = array[mini];
                array[mini] = temp;
            }
        }
    }
}
//My rational Rational class 
class Rational extends Number implements Comparable<Rational> {
    private int numerator;
    private int denominator;

    public Rational(int num, int denom) {
        numerator = num;
        denominator = denom;
        simplify(); //calling the method Simplify to simplify fractions once initialized
    }

    // Simplify the fractions
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        //In case of negative denoms
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    //gcd
    private int gcd(int a, int b) 
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Rational add(Rational o) 
    {
        int newNumerator = this.numerator * o.denominator + o.numerator * this.denominator;
        int newDenominator = this.denominator * o.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational sub(Rational o) 
    {
        int newNumerator = this.numerator * o.denominator - o.numerator * this.denominator;
        int newDenominator = this.denominator * o.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational mul(Rational o) 
    {
        int newNumerator = this.numerator * o.numerator;
        int newDenominator = this.denominator * o.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational div(Rational o) 
    {
        int newNumerator = this.numerator * o.denominator;
        int newDenominator = this.denominator * o.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    
    public String toString() 
    {
        return "(" + numerator + " / " + denominator + ")";
    }

    
    public int compareTo(Rational o) 
    {
        long thisValue = (long) numerator * o.denominator;
        long otherValue = (long) o.numerator * denominator;
        return Long.compare(thisValue, otherValue);
    }

    
    public double doubleValue() 
    {
        return (double) numerator / denominator;
    }

    
    public float floatValue() 
    {
        return (float) numerator / denominator;
    }

    
    public int intValue() 
    {
        return numerator / denominator;
    }

    
    public long longValue() 
    {
        return (long) numerator / denominator;
    }
}
