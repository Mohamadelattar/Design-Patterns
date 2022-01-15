package com.SpringBatch;

import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobRestartException;

@SpringBootApplication
public class SpringBatchApplication {

	public static void main(String[] args) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		ApplicationContext ctx = SpringApplication.run(SpringBatchApplication.class,args);
		Job job = (Job) ctx.getBean("Transactions");
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		JobExecution jobex = jobLauncher.run(job, new JobParameters());
		System.out.println(jobex.getStatus());
	}

}
