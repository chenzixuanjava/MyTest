package com.segi.activiti;

import com.google.common.collect.Maps;
import org.activiti.engine.*;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenzx
 * @date 2018-11-21 下午 7:32
 */
public class Commontest {

    ProcessEngine processEngine;

    @Before
    public void before() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    @Test
    public void testRepositoryService() {
        processEngine.getRepositoryService().createDeployment()
                .category("myCategory")
                .addClasspathResource("activiti/VacationRequest.bpmn20.xml")
                .deploy();
        System.out.println("nums of processDef:" + processEngine.getRepositoryService().createDeploymentQuery().count());
    }

    @Test
    public void testRuntimeService() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("employeeName", "Kermit");
        variables.put("numberOfDays", new Integer(4));
        variables.put("vacationMotivation", "I'm really tired!");
        runtimeService.startProcessInstanceByKey("vacationRequest", variables);
        System.out.println("nums of processIns:" + runtimeService.createProcessInstanceQuery().count());
    }

    @Test
    public void taskService() {
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        tasks.forEach((t) -> System.out.println("task name:" + t.getName()));
        Task task1 = tasks.get(0);
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("vacationApproved", "false");
        taskVariables.put("managerMotivation", "We have a tight deadline!");
        taskService.complete(task1.getId(), taskVariables);
        List<Task> tasks2 = taskService.createTaskQuery().taskCandidateGroup("management").list();
        tasks2.forEach((t) -> System.out.println("task name:" + t.getName()));
    }

    @Test
    public void testDefSus() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
//        repositoryService.suspendProcessDefinitionByKey("vacationRequest");
        repositoryService.activateProcessDefinitionByKey("vacationRequest");
    }

    @Test
    public void testInsSus() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
//        runtimeService.suspendProcessInstanceById("12501");
        runtimeService.activateProcessInstanceById("12501");
    }

    @Test
    public void testTaskQuery() {
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery()
                .taskAssignee("Kermit")
                .processVariableValueEquals("vacationMotivation", "I'm really tired!")
                .orderByTaskId().desc().list();
        tasks.forEach(t -> System.out.println(t));
    }

    @Test
    public void testNativeQuery() {
        TaskService taskService = processEngine.getTaskService();
        ManagementService managementService = processEngine.getManagementService();
        List<Task> tasks = taskService.createNativeTaskQuery()
//                .sql("select * from " + managementService.getTableName(Task.class) + " T where T.ID_ = 15005")
                .sql("select * from " + managementService.getTableName(Task.class) + " T where T.ID_ = #{ID_}")
                .parameter("ID_", 15005)
                .list();
        tasks.forEach(System.out::println);
    }
}
