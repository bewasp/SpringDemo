package service;

import dao.AccountDao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.Account;

public class AccountService {
    private AccountDao accountDao;
    public AccountService() {}
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;}
    public List<Account> findDeliquentAccounts() throws Exception {
        List<Account> delinquentAccounts = new ArrayList<Account>();
        List<Account> accounts = accountDao.findAll();
        Date thirtyDaysAgo = daysAgo(30);
        for(Account account : accounts) {
            boolean owesMoney = account.getBalance().compareTo(BigDecimal.ZERO) > 0;
            boolean thirtyDaysLate = account.getLastPaidOn().compareTo(thirtyDaysAgo) <= 0;
            if (owesMoney && thirtyDaysLate) {
                delinquentAccounts.add(account);
            }
        }
        return delinquentAccounts;
    }
private static Date daysAgo(int days) {
    GregorianCalendar gc = new GregorianCalendar();
    gc.add(Calendar.DATE, -days);
    return gc.getTime();
    }    
}
