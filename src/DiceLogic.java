import java.security.SecureRandom;

public class DiceLogic {

    int die1, die2, die3, die4, sum;

    public void rollDie() {
        SecureRandom secureRandom = new SecureRandom();

        die1 = 1 + secureRandom.nextInt(6);
        die2 = 1 + secureRandom.nextInt(6);
        die3 = 1 + secureRandom.nextInt(6);
        die4 = 1 + secureRandom.nextInt(6);

        System.out.println("First Die: " + die1);
        System.out.println("Second Die: " + die2);
        System.out.println("Third Die: " + die3);
        System.out.println("Fourth Die: " + die4);
        System.out.println();
        sum = die1 + die2 + die3 + die4;
        System.out.println("Sum of first roll: " + sum);
        System.out.println();
        switchLogic(sum);
    }


    public void switchLogic(int sum) {
        switch (sum) {
            case 7:
            case 11:
            case 15:
            case 21:
                System.out.println("You win!");
                break;
            case 10:
            case 12:
            case 19:
            case 20:
            case 22:
            case 23:
            case 24:
                System.out.println("You lose!");
                break;
            case 13:
                System.out.println("You lose!");
                break;
            default:
                int goal = sum;
                System.out.println();
                System.out.println("Second roll: " + goal);
                System.out.println("You need to roll again");
                System.out.println();
                rollDie();
                break;

        }
    }

}
