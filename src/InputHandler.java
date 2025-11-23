import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public char readChar(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    public void waitForEnter(String message) {
        System.out.print(message);
        scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}