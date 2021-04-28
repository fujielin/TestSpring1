package com.yc.tx.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-15 22:57
 */
@Data
public class OpRecord {
    private Integer id;
    private Integer accountid;
    private Double opmoney;
    private Timestamp optime;
    private String optype;
    private String transferid;
}
