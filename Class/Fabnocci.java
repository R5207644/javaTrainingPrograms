public class Fabnocci {
    public void fabnocci(int n) {
        int a = 0, b = 1, c = 0;

        for (int i = 0; i < n; i++) {
            System.out.print(a + "\t" + b + "\t");
            c = a + b;
            b = b + c;
            a = c;
        }
        System.out.println();
    }
}
