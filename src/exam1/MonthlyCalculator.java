package exam1;
import java.util.*;

public class MonthlyCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите вашу зарплату:");
        double salary = sc.nextDouble();
        System.out.println("Введите планируемые затраты на транспорт:");
        double expensesOfTransport = sc.nextDouble();
        System.out.println("Введите планируемые затраты на еду:");
        double expensesOfFood = sc.nextDouble();
        System.out.println("Введите сумму возможных сбережений:");
        double save = sc.nextDouble();

        function(salary, expensesOfTransport, expensesOfFood, save);
    }
    public static void function (double salary, double expensesOfTransport, double expensesOfFood, double save) {
        double allExpenses = expensesOfTransport + expensesOfFood;
        double Balance = salary - allExpenses + save;
        System.out.println("Ваши планируемые ежемесячные расходы составляют: " + allExpenses);
        System.out.println("Ваш ежемесячный баланс после вычета расходов: " + Balance);
        if (Balance > 0) {
            System.out.println("У вас есть излишек средств. Рекомендуется отложить некоторую сумму на сбережения.");
        } else if (Balance < 0) {
            System.out.println("У вас недостаточно средств для покрытия всех расходов. Рекомендуется пересмотреть бюджет и сократить расходы.");
        } else {
            System.out.println("У вас ровно столько, сколько вам нужно на покрытие расходов. Рекомендуется внимательно следить за бюджетом.");
        }
    }
}
