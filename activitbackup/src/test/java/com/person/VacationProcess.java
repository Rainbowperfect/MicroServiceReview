package com.person;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * 简单的流程图
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2020/2/1/22:00
 */

public class VacationProcess {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void deployTest () {
        RepositoryService service = processEngine.getRepositoryService();
        DeploymentBuilder builder = service.createDeployment();
        System.out.println("builder:===="+builder);
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("diagrams/helloworld.bpmn ");
        // builder.addClasspathResource("resources/diagrams/HelloWord.xml");
        DeploymentBuilder deployment = builder.addInputStream("diagrams/helloworld", in);
        // URL resource = this.getClass().getClassLoader().getResource("HelloWord.bpmn");
        deployment.deploy();
    }

    /**部署流程定义*/
    @Test
    public void deploymentProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("helloworld入门程序")//添加部署的名称
                .addClasspathResource("diagrams/helloworld.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("diagrams/helloworld.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署名称："+deployment.getName());//helloworld入门程序
    }
}
