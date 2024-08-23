
package encapsulation;
import AcessModifier.Cube;

public class ProtectedAcessModifier extends Cube {

    public static void main(String[] args) {
        ProtectedAcessModifier cube = new ProtectedAcessModifier();
        System.out.println(cube.x);
        cube.msg1();
    }
    
}
