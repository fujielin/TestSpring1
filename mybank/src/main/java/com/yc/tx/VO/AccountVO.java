package com.yc.tx.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: testSpring
 * @description: lin
 * @author: Bauer
 * @create: 2021-04-24 20:43
 */
@Data
public class AccountVO implements Serializable {

    private Integer accountId;
    private Double money;
    private Integer inAccountId;


}
