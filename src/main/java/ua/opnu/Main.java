package ua.opnu;

public class Main {
    public static void main(String[] args) {
        //TimeSpan
        try {
            TimeSpan t1 = new TimeSpan(12, 30);
            TimeSpan t2 = new TimeSpan(0, 0);
            TimeSpan t3 = new TimeSpan(23, 59);

            System.out.println("t1: " + t1);
            System.out.println("t2: " + t2);
            System.out.println("t3: " + t3);

            TimeSpan t4 = new TimeSpan(25, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        TimeSpan span1 = new TimeSpan(2, 45);
        TimeSpan span2 = new TimeSpan(1, 20);

        System.out.println("\nДо додавання:");
        System.out.println("span1: " + span1);
        span1.add(1, 50); // додаємо 1 год 50 хв
        System.out.println("Після додавання 1:50: " + span1);

        span1.subtract(span2); // віднімаємо span2
        System.out.println("Після віднімання span2: " + span1);

        span1.scale(2); // множимо на 2
        System.out.println("Після множення на 2: " + span1);

        System.out.println("Загальна кількість годин: " + span1.getTotalHours());
        System.out.println("Загальна кількість хвилин: " + span1.getTotalMinutes());

        //BankAccount
        BankAccount acc1 = new BankAccount("Ольга", 500);
        BankAccount acc2 = new BankAccount("Егор", 300);

        acc1.setTransactionFee(10);

        System.out.println("\nБаланс 1 аккаунту: " + acc1.balance);
        System.out.println("Баланс 2 аккаунту: " + acc2.balance);

        acc1.deposit(200);
        System.out.println("Після депозиту 200 у 1 аккаунті: " + acc1.balance);

        if (acc1.withdraw(100)) {
            System.out.println("Після зняття 100 з 1 аккаунту (з комісією 10): " + acc1.balance);
        } else {
            System.out.println("Недостатньо коштів для зняття з 1 аккаунту");
        }

        if (acc1.transfer(acc2, 50)) {
            System.out.println("Після переказу 50 з 1 аккаунта на 2 аккаунт:");
            System.out.println("1 аккаунт: " + acc1.balance);
            System.out.println("2 аккаунт: " + acc2.balance);
        } else {
            System.out.println("Недостатньо коштів для переказу");
        }
    }
}
