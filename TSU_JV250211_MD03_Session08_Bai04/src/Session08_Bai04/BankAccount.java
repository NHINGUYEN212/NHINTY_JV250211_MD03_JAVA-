package Session08_Bai04;

class BankAccount implements  IBank{
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;
    public BankAccount(String accountId, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.balance = balance;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Đã nhận tiền: " + amount);
    }
    @Override
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Đã rút tiền: " + amount);
        } else {
            System.out.println("Không đủ số dư để rút tiền.");
        }
    }

    public void displayBalance() {
        System.out.println("Số dư tài khoản (" + accountId + "): " + balance);
    }

    public String getAccountId() {
        return accountId;
    }
}
