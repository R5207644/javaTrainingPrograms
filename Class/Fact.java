public class Fact {
    public int factorial(int n) {

        int fact = 1;

        for (int i = n; i >= 1; i--) {
            fact = fact * i;
        }

        return fact;
    }
}
