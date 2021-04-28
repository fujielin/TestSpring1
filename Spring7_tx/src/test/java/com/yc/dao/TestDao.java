package com.yc.dao;

import com.yc.tx.bean.Accounts;
import com.yc.tx.AppConfig;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.dao.AccountsDao;
import com.yc.tx.dao.OpRecordDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-15 19:27
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AccountsDao accountsDao;


    //数据源测试
    @Test
    public void testDataSource() throws SQLException {
        Assert.assertNotNull(dataSource);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testAccountsDaoImpl() {
        Assert.assertNotNull(dataSource);

    }

    @Test
    public void testOpenAccounts() {
        Accounts a = new Accounts();
        a.setBalance(10.0);
        int accountid = accountsDao.saveAccount(a);
        System.out.println("开户成功，新开户头id为：" + accountid);
    }

    @Test
    public void testfindAll() {
        List<Accounts> list = this.accountsDao.findAll();
        System.out.println(list);

    }


    @Test
    public void testfindById() {
        Accounts a = this.accountsDao.findAccount(2);
        System.out.println(a);
    }


}
