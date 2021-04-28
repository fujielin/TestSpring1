package com.yc.springboot_bank.dao;



import com.yc.springboot_bank.bean.OpRecord;

import java.util.List;

public interface OpRecordDao {
    public void saveOpRecord(OpRecord opRecord);

    public List<OpRecord> findAll();

    public List<OpRecord> findByAccountid(int accountid);
}
