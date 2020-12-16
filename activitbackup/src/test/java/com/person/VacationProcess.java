package com.person;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 简单的流程图
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2020/2/1/22:00
 */

public class VacationProcess {
    // 获取流程引擎
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 定义流程实例
     */
    @Test
    public void deployTest () throws Exception{

        String filePath = "/diagrams/HelloWord.bpmn";
        InputStream is = InitTable.class.getClass().getResource(filePath).openStream();
        Deployment deploy = processEngine.getRepositoryService().createDeployment().name("请假流程开始").addInputStream(
                "/diagrams/QingJProcess.bpmn",is).deploy();
        System.out.println("名字" + deploy.getName() +"===" +"流程实例ID"+deploy.getId());

    }

    /**
     * 启动流程实例
     */
    @Test
    public void startProcess () {
        // 对应的act_re_procdef
        ProcessInstance word = processEngine.getRuntimeService().startProcessInstanceByKey("HelloWord");
        System.out.println("启动流程实列:" + word.getId());

    }

    /**
     * 获取流程变量
     */
    @Test
    public void getVarables() {
        TaskService taskService = processEngine.getTaskService();

    }
}
