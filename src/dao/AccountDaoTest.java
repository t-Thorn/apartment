package dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoTest {

    private AccountDao accountDao=new AccountDao();


    @Test
    public void getOrder() {

        assertEquals(accountDao.getOrder(),37);
    }
}