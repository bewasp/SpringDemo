package dao;

import java.util.List;
import model.Account;

public interface AccountDao {
    List<Account> findAll() throws Exception;
}
