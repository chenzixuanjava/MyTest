package com.segi.activiti5.dbconfig;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author chenzx
 * @date 2018-11-21 下午 4:02
 */
public class CreateTableAuto {
    public static void main(String[] args) {
        ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault()
                .setDatabaseSchemaUpdate("create")
                .buildProcessEngine();
    }
}
