package com.yc.tx.service;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpTypes;
import com.yc.tx.dao.AccountsDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountsDao accountsDao;


    @Test
    public void testOpenAccount() {
        Accounts a = new Accounts();
        a.setBalance(10.0);
//       int accountsid = accountsDao.saveAccount(a);
        Integer accountsid = accountService.openAccount(a, 10);
        System.out.println(accountsid);

    }

    @Test
    public void testDeposite() {
        Accounts a = new Accounts();
        a.setAccountId(3);
        Accounts aa = accountService.deposite(a, 10, OpTypes.deposite.getName(), null);
        System.out.println(aa);
    }

    @Test
    public void testWithdraw() {
        Accounts a = new Accounts();
        a.setAccountId(3);
        Accounts aa = accountService.withdraw(a, 999, OpTypes.withdraw.getName(), null);
        System.out.println(aa);

    }

    @Test
    public void testTransfer() {
        Accounts out = new Accounts();
        out.setAccountId(2);

        Accounts inA = new Accounts();
        inA.setAccountId(3);

        this.accountService.transfer(inA, out, 500);

    }


    @Test
    public void testShowBalance() {
        Accounts a = new Accounts();
        a.setAccountId(2);
        a = this.accountService.showBalance(a);
        System.out.println(a);
    }

    @Test
    public void testFindById() {
    }
}