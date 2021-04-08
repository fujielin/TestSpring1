package com.yc.dao;


import com.yc.biz.StudentBizImpl;
import junit.framework.TestCase;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-04 14:55
 */
public class StudentDaoTest extends TestCase {
    private StudentDao studentDao;
    private StudentBizImpl studentBizImpl;

    @Override
    public void setUp() throws Exception{

        studentDao = new StudentDaoJpaImpl();


        studentBizImpl = new StudentBizImpl();


        studentBizImpl.setStudentDao(studentDao);
    }


    public void testAdd(){
        studentDao.add("zhangsan");
    }
    public void testUpdate(){
        studentDao.update("zhangsan");
    }
    public void testBizAdd(){
        studentBizImpl.add("zhangsan");
    }


}
