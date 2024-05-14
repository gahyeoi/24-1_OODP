public interface ATMInterface {

    String getLocation();
    void setLocation(String location);

    Account getAccount();
    void setAccount(Account account);
    
    int getDepositAmount();
    int getWithdrawalAmount();
}
