package main;

import config.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Update {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        EmpDao empDao = ctx.getBean(EmpDao.class);
        Emp emp = new Emp();
        emp.setEMPNO(1);
        emp.setENAME("직원2");
        empDao.update(emp);
        ctx.close();
        //오류는 나는데 실행은 됨...
    }
}
