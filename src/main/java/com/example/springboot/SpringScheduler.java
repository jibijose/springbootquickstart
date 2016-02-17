package com.example.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.example.springboot.task.MyTask;

@Configuration
public class SpringScheduler implements SchedulingConfigurer, ApplicationContextAware {

	private static final Log LOGGER = LogFactory.getLog(SpringScheduler.class);
	private static final int SCHEDULE_THREAD_POOL_SIZE = 100;
	
	@Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
		//	ThreadPool doesn't overlap for same tasks...
        return Executors.newScheduledThreadPool(SCHEDULE_THREAD_POOL_SIZE);
    }

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		LOGGER.debug("Starting DSS V2 schedule creation");
		scheduledTaskRegistrar.setScheduler(taskExecutor());

		//	TODO fetch json configuration, parse stores and cron expressions.
		List<CronTask> cronTasks = new ArrayList<>();
		cronTasks.add(getCronTask(1234, "0/2 * * * * ?"));
//		cronTasks.add(getCronTask(4567, "0/3 * * * * ?"));
		
		scheduledTaskRegistrar.setCronTasksList(cronTasks);
		
		LOGGER.debug("Ending DSS V2 schedule creation");
	}
	
	private CronTask getCronTask(int storeId, String cronExpression) {
		MyTask myTask = applicationContext.getBean(MyTask.class);
		myTask.setStoreId(storeId);
		return new CronTask(myTask, cronExpression);
	}

	ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
