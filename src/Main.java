//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    DiceLogic diceLogic = new DiceLogic();
    Scanner input = new Scanner(System.in);
    int sVal;

    System.out.println();
    System.out.println("========== Dice game ==========");
    System.out.println(" (Press [1] to roll the die)");
    sVal = input.nextInt();
    System.out.println();

    if (sVal == 1) {
        diceLogic.rollDie();
    } else {
        System.out.println("Invalid Operator!");
    }
}
