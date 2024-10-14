//Veronica Leal

public class MainProjectOne 
{
    public static void main(String[] args) 
    {

        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " * " + b + " = " + a.mul(b));
        System.out.println(a + " / " + b + " = " + a.div(b));
    }
}
class Rational
{
     public Rational(int num, int denom) {
         numerator = num;
         denominator = denom;
     }
     public Rational add(Rational o) {
         return new Rational(numerator * o.denominator + o.numerator * denominator, denominator * o.denominator);
         
     }
     public Rational div(Rational o) {
         return new Rational (numerator * o.denominator, o.numerator * denominator);
         
     }
     public Rational mul(Rational o) {
         return new Rational(numerator * o.numerator, denominator * o.denominator);

     }
     public Rational sub(Rational o) {
         return new Rational(numerator * o.denominator - o.numerator * denominator, denominator * o.denominator);

     }
     public String toString() {
       return "(" + numerator + " / " + denominator + ")";

     }
         
     private int numerator;
     private int denominator;

}