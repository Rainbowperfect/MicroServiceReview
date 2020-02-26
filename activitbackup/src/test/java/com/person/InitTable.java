package com.person;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 初始数据库
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2020/1/20/23:17
 */
// @RunWith(value = SpringJUnit4ClassRunner.class)
public class InitTable {

    @Autowired
    // private RepositoryService repositoryService;



    @Test
    public void  createTables () {
        // 创建Activi配置对象的实例
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        //连接数据库的配置
        // processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        processEngineConfiguration.setJdbcUrl
      ("jdbc:mysql://localhost:3306/activebackup?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL" +
              "=true");
      // ("jdbc:mysql://localhost:3306/activebackup?characterEncoding=utf8&ampserverTimezone=UTC");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("rootAdmin");
        processEngineConfiguration.setDatabaseSchemaUpdate("true");

        /**
         *
         * D:\workspace\idea_worksapce\MicroServiceReview\activitbackup\src\main\resources\diagrams\HelloWord.bpmn
         public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
         public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表
         public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
         */
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //工作流的核心对象，ProcessEnginee对象
        try {
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
            String filePath = "/diagrams/HelloWord.bpmn";
            InputStream is = InitTable.class.getClass().getResource(filePath).openStream();
            builder.addInputStream("/diagrams/HelloWord.xml",is);//bpmn文件的名称
            builder.deploy();
            System.out.println("builder:"+builder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void  getTime() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        Timestamp timestamp= Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp.getTime());
    }
}
