package com.example.springboot.job;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

@DisallowConcurrentExecution
public class MyQuartzJob implements Job {

	private static final Log LOGGER = LogFactory.getLog(MyQuartzJob.class);

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		// TODO invoke /draft or /final based on config...
		try {
			System.out.println("******************************************************************");
			int storeId = jobExecutionContext.getJobDetail().getJobDataMap().getInt("storeId");
			Random random = new Random();
			int sleepTime = random.nextInt(5) + 1;
			LOGGER.debug("Job started for storeId = " + storeId + " running for " + sleepTime + " seconds");
			Thread.sleep(sleepTime * 1000);
			LOGGER.debug("Job ended for storeId = " + storeId + " ran for " + sleepTime + " seconds");
		} catch (InterruptedException ie) {
			LOGGER.error("Error in running task: " + ie.getMessage(), ie);
		}
	}

}
