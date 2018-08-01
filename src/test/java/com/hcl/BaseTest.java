package com.hcl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    配置Spring与Junit整合，Junit启东市加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit,Spring的配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
}
