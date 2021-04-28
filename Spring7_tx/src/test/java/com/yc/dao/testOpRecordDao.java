package com.yc.dao;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.bean.OpTypes;
import com.yc.tx.dao.OpRecordDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-17 14:48
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class testOpRecordDao {
    @Autowired
    private OpRecordDao accountsDao;

    @Test
    public void testSave() {
        OpRecord op = new OpRecord();
        op.setAccountid(1);
        op.setOpmoney(1.0);
        op.setOptype(OpTypes.deposite.getName());
        op.setOptime(new Timestamp(new Date().getTime()));
        op.setTransferid(" ");
        accountsDao.saveOpRecord(op);
    }

    @Test
    public void testAll() {
        List<OpRecord> list = accountsDao.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void testFindById() {
        List<OpRecord> list = accountsDao.findByAccountid(1);
        Assert.assertNotEquals(0, list.size());
    }
}
