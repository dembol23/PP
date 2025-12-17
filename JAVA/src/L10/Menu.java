package L10;

import L10.Decoration.UnknownDecorationException;
import java.util.Scanner;

public class Menu {
    ChristmasTree tree;
    Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            createTree();
            boolean wantNewTree = decorateLoop();
            if (!wantNewTree) {
                isRunning = false;
            }
        }
        scanner.close();
        System.out.println("Koniec programu. Wesołych Świąt!");
    }

    private void createTree() {
        int height = 0;
        while (height < 2) {
            System.out.print("Podaj wysokość choinki (min. 2): ");
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();
                if (height < 2) {
                    System.out.println("Wysokość musi być większa lub równa 2.");
                }
            } else {
                System.out.println("To nie jest liczba.");
                scanner.next();
            }
        }
        scanner.nextLine();
        tree = new PineTree(height);
        tree.generateTree();
        System.out.println("Choinka przed dekoracją:");
        System.out.println(tree);
    }

    private boolean decorateLoop() {
        while (true) {
            System.out.print("Wybierz dekorację (Bubbles, Lights, Angel, Chain), 'exit' aby zakończyć, 'new' żeby stworzyć nowe drzewo: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                return false;
            }
            if (input.equalsIgnoreCase("new")) {
                return true;
            }
            try {
                tree.decorate(input);
                System.out.println("Choinka po dekoracji (" + input + "):");
                System.out.println(tree);
            } catch (UnknownDecorationException e) {
                System.out.println("Błąd: " + e.getMessage() + ". Spróbuj ponownie.");
            }
        }
    }
}