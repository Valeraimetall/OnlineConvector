import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    static Scanner scanner = new Scanner(System.in);
    static CURRENCY currency;
    static int input;

    static CURRENCY chooseCurrency() {

        boolean done = false;

        while (!done) {
            Info.currencySelection();
            try {
                input = scanner.nextInt();
                switch (input){
                    case 1:
                        currency = CURRENCY.PLN;
                        done = true;
                        break;
                    case 2:
                        currency = CURRENCY.USD;
                        done = true;
                        break;
                    case 3:
                        currency = CURRENCY.EUR;
                        done = true;
                        break;
                    default:
                        throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка введення. Спробуйте ще.");
                scanner.nextLine();
            }
        } return currency;
    }

    static int inputSum(User user) {
        Scanner scanner = new Scanner(System.in);

        boolean done = false;

        while (!done) {
            Info.whatAmount(user);
            try {
                input = scanner.nextInt();
                if (input <= 0) {
                    throw new InputMismatchException();
                }
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("Помилка введення. Спробуйте ще.");
                scanner.nextLine();
            }
        } return input;
    }
}

