package bank.application;

public class Main {
    public static void main(String[] args) {

        SBI account1 = new SBI(500000, "123", "Deb");
        SBI account2 = new SBI(1000000, "123", "Suraj");

       int balance = account1.checkBalance("123");
        System.out.println("The balance for account1 is: "+ balance);

        int balanceCheck = account1.checkBalance("123");
        System.out.println("The balance for account1 is "+balanceCheck);

        String bankMessage =  account2.addMoney(50000);
        System.out.println(bankMessage);

    }
}