package com.segi.activiti.spring;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @author chenzx
 * @date 2018-11-22 下午 2:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-activiti.xml"})
public class SpringActiviti {
    @Autowired
    ProcessEngine processEngine;

    @Test
    public void testGetProcessEngine() {
//        processEngine.getTaskService().createTaskQuery().list().forEach(System.out::println);
    }

    @Test
    public void testDepWorkDoc() throws FileNotFoundException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\activitiTest.zip"), Charset.forName("GBK"));
        processEngine.getRepositoryService().createDeployment()
                .addZipInputStream(zipInputStream)
                .deploy();
    }

    @Test
    public void testDepPng() {
        processEngine.getRepositoryService().createDeployment()
                .name("haha.zip")
                .addClasspathResource("activiti/VacationRequest.bpmn20.xml")
                .addClasspathResource("activiti/VacationRequest.vacationRequest.jpg")
                .deploy();
    }

    @Test
    public void testGetPng() throws Exception {
        ProcessDefinition processDefinition = processEngine.getRepositoryService().createProcessDefinitionQuery()
                .processDefinitionKey("vacationRequest2")
                .processDefinitionId("vacationRequest2:3:27505")
                .singleResult();
        String diagramResourceName = processDefinition.getDiagramResourceName();
        InputStream imageStream = processEngine.getRepositoryService().getResourceAsStream(processDefinition.getDeploymentId(), diagramResourceName);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\getPng.jpg");
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = imageStream.read(b)) != -1) {
            outputStream.write(b, 0, len);
        }
        if (outputStream != null) {
            outputStream.close();
        }
        if (imageStream != null) {
            imageStream.close();
        }
    }

    @Test
    public void deploy() {
        processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("activiti/myProcess2.bpmn20.xml")
                .deploy();
    }

    @Test
    public void startIns() {
        processEngine.getRuntimeService().startProcessInstanceByKey("myProcess_1");
    }

    @Test
    public void getTask() {
        List<Task> tasks = processEngine.getTaskService().createTaskQuery()
                .taskName("Verify monthly financial report")
                .list();
        tasks.forEach(System.out::println);
    }

    @Test
    public void claimTask() {
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateUser("kermit")
                .taskDefinitionKey("verifyReportTask").list();
        tasks.forEach(System.out::println);
        tasks.forEach((t) -> {
            taskService.claim(t.getId(), "fozzie");
        });
    }

    @Test
    public void testComplete() {
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService
                .createTaskQuery()
                .taskDefinitionKey("verifyReportTask")
                .list();
        tasks.forEach((t) -> {
            taskService.complete(t.getId());
            System.out.println("完成任务：" + t.getName());
        });
    }

    @Test
    public void testHist() {
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId("66154")
                .list();
        historicProcessInstances.forEach(h -> {
            System.out.println(h.getName() + ": " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(h.getEndTime()));
        });
    }

}
