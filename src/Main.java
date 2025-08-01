import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;

        for (int a = 1; a <= 5; a++) {
            System.out.print(" number " + a + ": ");
            int number = scanner.nextInt();
            total += number;
        }

        System.out.println("\ntotal : " + total);

        scanner.close();
    }
}