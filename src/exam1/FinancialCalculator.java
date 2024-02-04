import java.util.Scanner;

public class FinancialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] Month = new double[30];

        while (true) {
            firstFunc();
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    enterExpenses(sc, Month);
                    break;
                case 2:
                    displayExpenses(Month, "руб");
                    break;
                case 3:
                    findMaxSum(Month);
                    break;
                case 4:
                    AnotherCurrencies(Month);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static void firstFunc() {
        System.out.print("Для выполнения функции введите цифру:\n" +
                "1 - Внести расходы за месяц на каждый день\n" +
                "2 - Показать расходы за месяц в рублях\n" +
                "3 - Максимальная сумма за месяц\n" +
                "4 - Показать расходы за месяц в других валютах\n" +
                "0 - Завершить программу\n");
    }

    private static void enterExpenses(Scanner sc, double[] Month) {
        int day;
        do {
            System.out.println("Выберите день на который хотите внести траты, введите от 1 до 30");
            day = sc.nextInt();

            if (day < 1 || day > 30) {
                System.out.println("Число должно быть от 1 до 30!");
            } else {
                if (Month[day - 1] != 0) {
                    System.out.println("На этот день уже написаны расходы! Перезаписать?\n1 - да\n2 - нет");
                    int anotherchoice = sc.nextInt();
                    if (anotherchoice == 2) {
                        return;
                    }
                }
            }
        } while (day < 1 || day > 30);

        System.out.println("Хорошо! Теперь внесите сумму на " + day + " день: ");
        double amount = sc.nextDouble();
        Month[day - 1] = amount;
        System.out.println("Хорошо! Вы хотите еще внести траты?\n1 - да\n2 - нет");
        int ans = sc.nextInt();
        if (ans == 1) {
            enterExpenses(sc, Month);
        }
    }

    private static void displayExpenses(double[] Month, String currency) {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день - " + Month[i] + " " + currency);
        }
    }

    private static void AnotherCurrencies(double[] Month) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Вы можете посмотреть расходы в разных валютах:\n1 - Евро\n2 - Доллары\n3 - Юани");
        int moneyChoice = scan.nextInt();

        switch (moneyChoice) {
            case 1:
                displayExpenses(Euro(Month), "Евро");
                break;
            case 2:
                displayExpenses(Dollars(Month), "Доллары");
                break;
            case 3:
                displayExpenses(Yuans(Month), "Юани");
                break;
            default:
                System.out.println("Неверный выбор валюты.");
        }
    }

    private static double[] Euro(double[] rubAmounts) {
        double[] euro = new double[30];
        for (int i = 0; i < 30; i++) {
            euro[i] = rubAmounts[i] * 0.01;
        }
        return euro;
    }

    private static double[] Dollars(double[] rubAmounts) {
        double[] dollars = new double[30];
        for (int i = 0; i < 30; i++) {
            dollars[i] = rubAmounts[i] * 0.011;
        }
        return dollars;
    }

    private static double[] Yuans(double[] rubAmounts) {
        double[] yuans = new double[30];
        for (int i = 0; i < 30; i++) {
            yuans[i] = rubAmounts[i] * 0.078;
        }
        return yuans;
    }

    private static void findMaxSum(double[] Month) {
        double max = Month[0];
        int mostExpensiveDay = 1;

        for (int i = 1; i < 30; i++) {
            if (Month[i] > max) {
                max = Month[i];
                mostExpensiveDay = i + 1;
            }
        }

        System.out.println("\nСамая большая трата была " + max + " в " + mostExpensiveDay + " день");
    }
}
