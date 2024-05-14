public class Account implements AccountInterface {
    String name;
    int balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int money) {
        int currentMoney = getBalance();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setBalance(currentMoney + money);
    }

    public int withdraw(int money) {
        synchronized (this) {
            int currentMoney = getBalance();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (currentMoney >= money) {
                setBalance(currentMoney - money);
                return money;
            } else {
                return 0;
            }
        }
    }
}
