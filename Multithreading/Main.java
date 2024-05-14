import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== First Account ======");
        Scanner s = new Scanner(System.in);
        System.out.print("Type in Account Name: ");
        String name = s.next();
        System.out.print("Type in Initial Balance between 1000 ~ 2000: ");
        int balance = s.nextInt();

        Account account1 = new Account();
        account1.setName(name);
        account1.setBalance(balance);

        ATM[] atms = {
                new ATM("Handong", account1),
                new ATM("Busan", account1),
                new ATM("Downtown", account1)
        };

        // Start each ATM thread
        for (ATM atm : atms) {
            atm.start();
        }

        // Wait for each ATM thread to finish
        for (ATM atm : atms) {
            try {
                atm.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (ATM atm : atms) {
            System.out.println("Deposit Amount at " + atm.getLocation() + " Branch: " + atm.getDepositAmount());
            System.out.println("Withdrawal Amount at " + atm.getLocation() + " Branch: " + atm.getWithdrawalAmount());
        }
    }
}
