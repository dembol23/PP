package L8;

public class Main {
    public static void printAll(Object ... args) {
        printAllRecursive(args, 0);
    }

    public static void printAllRecursive(Object[] args, int index) {
        if (index == args.length ) {
            return;
        }
        Object current = args[index];
        if (current == null) {
            System.out.println("// NULL: null");
            printAllRecursive(args, index + 1);
        }
        else{
            String typeName = current.getClass().getSimpleName();
            System.out.println("// " + typeName + " " + current);
            printAllRecursive(args, index + 1);
        }

    }

    public static void main(String[] args) {
        System.out.println("Test 1 (zgodny z przykładem):");
        printAll(1, "hello", 3.14);

        System.out.println("\nTest 2 (Różne typy proste i obiektowe):");
        printAll(true, 'A', 100L);

        System.out.println("\nTest 3 (Tylko jeden element):");
        printAll("Single");

        System.out.println("\nTest 4 (Tylko jeden element):");
        printAll(null, "test");

        System.out.println("\nTest 5 (Puste wywołanie):");
        printAll();
    }
}