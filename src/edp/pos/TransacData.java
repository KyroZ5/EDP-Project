package edp.pos;

import java.util.*;

public class TransacData {
    public static List<TransacData> transData = new ArrayList<>();

    private int transactionNo;
    private double total;
    private double balance;

    public TransacData(int transactionNo, double total, double balance) {
        this.transactionNo = transactionNo;
        this.total = total;
        this.balance = balance;
    }

    public int getTransactionNo() { return transactionNo; }
    public double getTotal() { return total; }
    public double getBalance() { return balance; }
}
