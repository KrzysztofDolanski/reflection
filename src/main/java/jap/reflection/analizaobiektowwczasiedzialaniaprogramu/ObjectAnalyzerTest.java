package jap.reflection.analizaobiektowwczasiedzialaniaprogramu;

import java.util.ArrayList;

/**
 * Ten program analizuje obiekty za pomoca refleksji.
 *
 * @author Cay Horstmann
 */
class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        squares.add(123);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
