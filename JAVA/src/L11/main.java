package L11;

class Point {
    private int x;
    private int y;
    public Point(int x, int y) { this.x = x; this.y = y; }
}

class Osoba {
    private String imie = "Jan";
    private boolean student = true;
}

public class main {
    public static void main(String[] args) {
        Debug debug = new Debug();

        System.out.println("--- Test 1: Point ---");
        Point p = new Point(10, 20);
        debug.fields(p);

        System.out.println("\n--- Test 2: Osoba ---");
        Osoba o = new Osoba();
        debug.fields(o);

        System.out.println("\n--- Test 3: String (Systemowy) ---");
        debug.fields("Test");

        System.out.println("\n--- Test 4: null ---");
        debug.fields(null);
    }
}