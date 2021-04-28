package com.yc.tx.dao;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-15 23:01
 */
@Repository
public class OpRecordDaoImpl implements OpRecordDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOpRecord(OpRecord opRecord) {
        String sql = "insert into oprecord(accountid,opmoney,optime,optype,transferid) values (?,?,?,?,?) ";
        //KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, opRecord.getAccountid());
            ps.setDouble(2, opRecord.getOpmoney());
            ps.setTimestamp(3, opRecord.getOptime());
            ps.setString(4, opRecord.getOptype());
            ps.setString(5, opRecord.getTransferid());
            return ps;
        });
    }

    @Override
    public List<OpRecord> findAll() {
        String sql = "select * from oprecord";
        List<OpRecord> list = this.jdbcTemplate.query(
                //lambda表达式
                sql, (resultSet, rowNum) -> {
                    OpRecord a = new OpRecord();
                    a.setId(resultSet.getInt("id"));
                    a.setAccountid(resultSet.getInt("accountid"));
                    a.setOpmoney(resultSet.getDouble("opmoney"));
                    a.setOptime(resultSet.getTimestamp("optime"));
                    a.setOptype(resultSet.getString("optype"));
                    a.setTransferid(resultSet.getString("transferid"));
                    return a;
                });
        return list;
    }

    @Override
    public List<OpRecord> findByAccountid(int accountid) {
        String sql = "select * from oprecord where accountid=?";
        List<OpRecord> list = this.jdbcTemplate.query(
                //lambda表达式
                sql, (resultSet, rowNum) -> {
                    OpRecord a = new OpRecord();
                    a.setId(resultSet.getInt("id"));
                    a.setAccountid(resultSet.getInt("accountid"));
                    a.setOpmoney(resultSet.getDouble("opmoney"));
                    a.setOptime(resultSet.getTimestamp("optime"));
                    a.setOptype(resultSet.getString("optype"));
                    a.setTransferid(resultSet.getString("transferid"));
                    return a;
                }, accountid);
        return list;
    }
}
