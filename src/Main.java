import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        long n;
        while (true){
            System.out.print("Enter your starting number to find a palindrome (positive integer) or 0 to quit: ");
            try{
                n = s.nextLong();
            } catch (InputMismatchException ime) {
                System.out.println("Your number was too large for Java to handle, or you didn't enter one.\n");
                s.nextLine();
                continue;
            }
            if(n == 0){
                System.out.println("Quitting...");
                s.close();
                return;
            }
            if (n < 0){
                System.out.println("Your number was not a positive integer.\n");
            }
            else{
                Palindrome.find(n);
            }
        }
    }
}
