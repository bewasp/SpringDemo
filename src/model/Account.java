package model;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private String accountNo;
    private BigDecimal balance;
    private Date lastPaidOn;
    
    public Account(String accountNo, BigDecimal balance, Date lastPaidOn){
        this.accountNo = accountNo;
        this.balance = balance;
        this.lastPaidOn = lastPaidOn;
    }
    public String getAccountNo() {return accountNo;}
    
    public BigDecimal getBalance() {return balance;}
    
    public Date getLastPaidOn() {return lastPaidOn;}
}
