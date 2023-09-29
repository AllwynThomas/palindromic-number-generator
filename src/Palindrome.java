import java.util.Arrays;

public class Palindrome {
    private static final Integer[] Lychrel = new Integer[]{196, 295, 394, 493, 592, 689, 691, 788, 790, 879, 887, 978, 986, 1495, 1497, 1585, 1587, 1675, 1677, 1765, 1767, 1855, 1857, 1945, 1947, 1997, 2494, 2496, 2584, 2586, 2674, 2676, 2764, 2766, 2854, 2856, 2944, 2946, 2996, 3493, 3495, 3583, 3585, 3673, 3675};

    // reverses input number with error checking if bigger than long max
    private static long reverse(long num){
        long x = num;
        StringBuilder rx = new StringBuilder();
        while (x != 0){
            if (x >= 10){
                rx.append(x % 10);
                x = x/10;
            }
            if (x < 10){
                rx.append(x);
                x = x/10;
            }
        }
        try {
            return Long.parseLong(rx.toString());
        } catch (NumberFormatException nfe) {
            System.out.println("Your number resulted in calculations with numbers that were too large for Java to handle.\n");
            return 0;
        }
    }

    // x + reverse(x) and repeat until palindrome
    public static void find(long num){
        int numTries = 1;
        if (Arrays.asList(Lychrel).contains((int)num)){
            System.out.println("Since " + num + " is a Lychrel number, a palidrome cannot be formed.\n");
            return;
        }
        if (num == reverse(num)){
            System.out.println(num + " is already a palindrome.\n");
            return;
        }
        long pal = num + reverse(num);
        if (pal == num){
            return;
        }
        while (pal != reverse(pal)){
            pal = pal + reverse(pal);
            if (reverse(pal) == 0){
                return;
            }
            numTries++;
        }
        System.out.println("From " + num + ", the palindrome " + pal + " is created in " + numTries + " iteration(s) of the 196-algorithm.\n");
    }
}
