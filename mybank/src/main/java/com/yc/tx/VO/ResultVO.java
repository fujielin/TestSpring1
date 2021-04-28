package com.yc.tx.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-24 20:46
 */
@Data
public class ResultVO<T> implements Serializable {

    private Integer code;
    private  T data;
    private String msg;
}
