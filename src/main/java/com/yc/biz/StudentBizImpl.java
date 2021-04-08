package com.yc.biz;

import com.yc.dao.StudentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-04 14:50
 */

@Service
public class StudentBizImpl {

    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public StudentBizImpl(){

    }
    public int add(String name){
        System.out.println("========业务层=======");
        int result = studentDao.add(name);
        System.out.println("========业务结束======");
        return result;
    }

    public void update(String name){
        System.out.println("========业务层=======");
        studentDao.update(name);
        System.out.println("========业务结束======");
    }
    //@Inject   //javax中的依赖注入，如果有多个对象（比如这里有 StudentDaoJpaImpl 和StudentDaoMybatisImpl对象）
                //因为有多个对象可以注入，这里必须用@Named("studentDaoJpaImpl") ，若只有一个对象，则不需要写
    @Autowired
    @Qualifier("studentDaoJpaImpl")//如果有多个对象（比如这里有 StudentDaoJpaImpl 和StudentDaoMybatisImpl对象）
                    //因为有多个对象可以注入，这里必须用@Named("studentDaoJpaImpl") ，若只有一个对象，则不需要写
    //@Resouce(name = "studentDaoJpaImpl)
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao=studentDao;
    }

}
