package springdemo;

import java.util.List;
import model.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

public class SpringDemo {
     public static void main(String[] args) throws Exception {
         ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
         AccountService accountService = (AccountService)appCtx.getBean("accountService");
         List<Account> delinquentAccounts = accountService.findDeliquentAccounts();
            for(Account a : delinquentAccounts) {
                System.out.println(a.getAccountNo());
            }
     }
}

