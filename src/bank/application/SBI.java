package bank.application;

import java.util.UUID;

public class SBI implements Bankinterface{

    private int balance;
    private UUID accountNo;
    private String password;
    private String name;
    private int rateOfInterest;

    public SBI(int balance, String password, String name){
        this.accountNo = UUID.randomUUID();
        this.balance = balance;
        this.password = password;
        this.name  = name;
    }
    @Override
    public int checkBalance(String password) {
         if (password == this.password){
             return balance;
         }
        return -1;
    }

    @Override
    public String addMoney(int money) {

        balance = balance + money;
        String message =  money + " has been added to bank account no. "+accountNo +" the total balance is now "+balance;

        return message;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {

        if(password == this.password)
        {
            if (drawMoney>balance)
            {
                return "Insufficient balance";
            }
            else
            {
                balance = balance - drawMoney;
                return "Money withdraw successfully. Remaining balance: "+balance;
            }
        }
        return "Wrong password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password == oldPassword){
            this.password = newPassword;
            return "Password has been updated sucessfully";
        }else {
            return "Wrong Password";
        }
    }

    @Override
    public double calculateTotalInterest(int years, String password) {

        double interest = balance * rateOfInterest * years/100;
        return interest;
    }
}
