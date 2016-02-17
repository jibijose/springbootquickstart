package com.example.springboot.task;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.example.springboot.job.MyQuartzJob;

@Component
@Scope("prototype")
public class MyTask implements Runnable, ApplicationContextAware {

	private static final Log LOGGER = LogFactory.getLog(MyTask.class);
	
//	@Autowired
//	SchedulerFactoryBean schedulerFactoryBean;
	
//	@Autowired
//	MyQuartzJob myQuartzJob;

	private int storeId;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public void run() {

		// TODO invoke /draft or /final based on config...
		try {
			Random random = new Random();
			int sleepTime = random.nextInt(30) + 1;
			LOGGER.debug("Task started for storeId = " + storeId + " running for " + sleepTime + " seconds");
			Thread.sleep(sleepTime * 1000);
			
			try {
				SchedulerFactoryBean schedulerFactoryBean = applicationContext.getBean(SchedulerFactoryBean.class);
//				schedulerFactoryBean.getScheduler().shutdown();
//				schedulerFactoryBean.getScheduler().clear();
//				schedulerFactoryBean.getScheduler().
//				schedulerFactoryBean.setTriggers(trigger);
//				schedulerFactoryBean.start();
				schedulerFactoryBean.getScheduler().clear();
				schedulerFactoryBean.getScheduler().scheduleJob(getMyJob(9876), getMyCronTrigger());
			} catch(Exception e) {
				LOGGER.error("Error in Scheduling = " + e.getMessage(), e);
			}

			
			LOGGER.debug("Task ended for storeId = " + storeId + " ran for " + sleepTime + " seconds");
		} catch (InterruptedException ie) {
			LOGGER.error("Error in running task: " + ie.getMessage(), ie);
		}
	}
	
    /**************************************************************************************************************/
    
    private JobDetail getMyJob(int storeId) {
    	JobDetail jobDetail = newJob(MyQuartzJob.class)
    		    .withIdentity("job5", "group1")
    		    .build();
    	jobDetail.getJobDataMap().put("storeId", storeId);
    	return jobDetail;
    }
    
    private CronTrigger getMyCronTrigger() {
    	CronTrigger newTriggerIns = newTrigger().withIdentity("trigger5", "group1").withSchedule(cronSchedule("0/2 * * * * ?")).build();
    	return newTriggerIns;
    }
    /**************************************************************************************************************/
	
//	@Bean(name="myTrigger")
//	public Trigger getMyTrigger(@Qualifier("sampleJobTrigger") Trigger sampleJobTrigger) {
//		return sampleJobTrigger;
//	}
//	
//	@Bean(name = "sampleJobDetail")
//    public JobDetailFactoryBean sampleJobDetail() {
//        return createJobDetail(MyQuartzJob.class);
//    }
//	
//	@Bean(name = "sampleJobTrigger")
//    public SimpleTriggerFactoryBean sampleJobTrigger(@Qualifier("sampleJobDetail") JobDetail jobDetail,
//                                                     @Value("${samplejob.frequency}") long frequency) {
//        return createTrigger(jobDetail, frequency);
//    }
//	
//	private JobDetailFactoryBean createJobDetail(Class jobClass) {
//        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//        factoryBean.setJobClass(jobClass);
//        // job has to be durable to be stored in DB:
//        factoryBean.setDurability(true);
//        return factoryBean;
//    }
//	
//	private SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail, long pollFrequencyMs) {
//        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
//        factoryBean.setJobDetail(jobDetail);
//        factoryBean.setStartDelay(0L);
//        factoryBean.setRepeatInterval(pollFrequencyMs);
//        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//        // in case of misfire, ignore all missed triggers and continue :
//        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
//        return factoryBean;
//    }
//	
	ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
