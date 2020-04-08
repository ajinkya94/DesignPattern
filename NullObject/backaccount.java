interface Log{
    void addPayment(String msg);
    void generateInvoice(String msg);
}
class BankAccount{
    private Log log;
    private int balance;
    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount){
        balance+=amount;
        log.generateInvoice("Deposited "+amount);
    }
    public void addPayment(){
        log.addPayment("Balance "+balance);
    }
}

class ConsoleLog implements Log{

    @Override
    public void addPayment(String msg) {
        System.out.println(msg);
    }

    @Override
    public void generateInvoice(String msg) {
        System.out.println(msg);
    }
}

class NullLog implements Log{

    @Override
    public void addPayment(String msg) {
        System.out.println("No user");

    }

    @Override
    public void generateInvoice(String msg) {
        System.out.println("No user");

    }
    
}
class Demo{
    public static void main(String args[]) {
        ConsoleLog log = new ConsoleLog();
        BankAccount b = new BankAccount(log); 
        b.deposit(100);
        NullLog lognull = new NullLog();
        BankAccount bnull = new BankAccount(lognull);
        bnull.deposit(100);
    }
}