package com.yc.springboot_bank.dao;


import com.yc.springboot_bank.bean.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-15 20:03
 */
@Repository
public class AccountsDaoImpl implements AccountsDao {
    //在dao中要使用JdbcTemplate的模板对象，这个对象要通过datasource创建
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveAccount(Accounts account) {
        String sql = "insert into accounts(balance) values ( ?  ) ";
//        //利用KeyHolder 来获取新增的这条数据的id
        KeyHolder keyHolder = new GeneratedKeyHolder();
//        //connection由spring调用的时候注入
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"accountid"});
            ps.setDouble(1, account.getBalance());
            return ps;
        }, keyHolder);
        //方案一:用匿名内部类书写
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement pstmt = connection.prepareStatement(sql,new String[]{"accountid"});//第二个参数：返回这个字段生成的值
//                pstmt.setDouble(1,account.getBalance());
//                return pstmt;
//            }
//        },keyHolder);

// keyHolder.getKey() now contains the generated key
        return ((BigInteger) keyHolder.getKey()).intValue();
    }

    @Override
    public Accounts updateAccount(Accounts account) {
        String sql = "update accounts set balance =? where accountid =?";
        this.jdbcTemplate.update(sql, account.getBalance(), account.getAccountId());
        return account;
    }

    @Override
    public Accounts findAccount(int accountid) {
        String sql = "select * from accounts where accountid =? ";
        return this.jdbcTemplate.queryForObject(sql,
                (resultSet, rowNum) -> {
                    Accounts a = new Accounts();
                    a.setAccountId(resultSet.getInt("accountid"));
                    a.setBalance(resultSet.getDouble("balance"));
                    return a;
                },
                accountid);
    }

    @Override
    public List<Accounts> findAll() {
        String sql = "select * from accounts";
        List<Accounts> list = this.jdbcTemplate.query(
                //lambda表达式
                sql, (resultSet, rowNum) -> {
                    System.out.println("当前取的是第" + rowNum + "行的数据");
                    Accounts a = new Accounts();
                    a.setAccountId(resultSet.getInt("accountid"));
                    a.setBalance(resultSet.getDouble("balance"));
                    return a;
                });

        //方案一：
//        List<Accounts> list = this.jdbcTemplate.query(sql, new RowMapper<Accounts>() {
//            @Override
//            public Accounts mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//                System.out.println("当前取的是第"+rowNum+"行的数据");
//                Accounts a = new Accounts();
//                a.setAccountId(resultSet.getInt("accountid"));
//                a.setBalance(resultSet.getDouble("balance"));
//                return a;
//            }
//        });
        return list;
    }

    @Override
    public void delete(int accountid) {
        String sql = "delete from accounts where accountid =?";
        this.jdbcTemplate.update(sql, accountid);
    }
}
