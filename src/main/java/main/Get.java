package main;

import config.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Get {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        EmpDao empDao = ctx.getBean(EmpDao.class);
        empDao.get(1);
        ctx.close();
    }
}
