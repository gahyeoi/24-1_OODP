import java.util.Random;

public class ATM extends Thread implements ATMInterface{
    String Location;
    Account account;

    int depositAmount;
    int withdrawalAmount;

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    ATM(){}
    ATM (String location, Account account){
        this.Location = location;
        this.account = account;
    }
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 5; i++){
            Random random = new Random();
            int randomIndex = random.nextInt(2);
            int randomMoney = random.nextInt(2000);
            switch (randomIndex) {
                case 0: // deposit
                    account.deposit(randomMoney);
                    System.out.println("Deposit to account " + this.getAccount().getName() + " (Balance: " + this.getAccount().getBalance() + ") at " + this.getLocation());
                    System.out.println("Deposit Amount: " + randomMoney);
                    System.out.println("New balance: " + this.getAccount().getBalance() + "\n");
                    this.depositAmount += randomMoney;
                    break;
                case 1: //  withdrawal
                    int index = account.withdraw(randomMoney);
                    System.out.println("Withdrawal from account " + this.getAccount().getName() + " (Balance: " + this.getAccount().getBalance() + ") at " + this.getLocation());
                    System.out.println("Withdrawal Amount: " + randomMoney);

                    if(index == 0){ // Failed to withdraw
                        System.out.println("Withdrawal Not Allowed - Short Balance\n");
                    } else { // Successed to withdraw
                        System.out.println("New balance: " + this.getAccount().getBalance() + "\n");
                        this.depositAmount += randomMoney;
                    }
                    break;
            }
        }
    }
}
