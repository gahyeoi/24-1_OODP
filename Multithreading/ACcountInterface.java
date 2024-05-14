public interface AccountInterface {
    String getName();
    void setName(String name);

    int getBalance();
    void setBalance(int balance);

    void deposit(int money);
    int withdraw(int money);
}
