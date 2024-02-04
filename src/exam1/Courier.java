import java.util.Scanner;

public class Courier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = 5;

        for (int f = 1; f < 11; f++) {
            for (int n = 1; n <= r; n++) {
                System.out.print("Did you submit the order?");
                int answer = in.nextInt();
                if (answer == 1) {
                    int nf = (f - 1) * r + n;
                    System.out.println("Congratulations, you have delivered your order to " + f + " floor and " + nf + " room");
                }
            }
        }
        in.close();
    }
}