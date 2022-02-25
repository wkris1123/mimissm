package com.wk.listner;

import com.wk.entity.ProductType;
import com.wk.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @className: com.wk.listner.ProductTypeListener
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-22 15:16
 */
@WebListener
public class ProductTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //手工从spring容器中取出ProductTypeServiceImpl的对象。
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductTypeService productTypeService= (ProductTypeService) ac.getBean("ProductTypeServiceImpl");
        List<ProductType> typeList=productTypeService.getAllType();

        //放入全局应用作用域中，供新增页面，修改页面、前台的查询功能能提供全部商品类型的集合
        servletContextEvent.getServletContext().setAttribute("typeList",typeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
