package com.SpringBatch.config;

import com.SpringBatch.batch.BatchLauncher;
import com.SpringBatch.batch.TransactionProcessor;
import com.SpringBatch.batch.TransactionWriter;
import com.SpringBatch.beans.Transaction;
import com.SpringBatch.beans.TransactionDto;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;

import javax.sql.DataSource;

@EnableBatchProcessing
@EnableScheduling
@Configuration
public class AppConfig {


    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Autowired
    PlatformTransactionManager dataSourceTransactionManager;


    @Bean
    public ItemReader<? extends TransactionDto> reader() {
        FlatFileItemReader<TransactionDto> reader = new FlatFileItemReader<>();
        reader.setResource((new FileSystemResource("src/main/resources/transactions.txt")));
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"idTransaction","idCompte","montant", "dateTransaction"});
                setDelimiter(",");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(TransactionDto.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemWriter<Transaction> writer() {
        return (ItemWriter<Transaction>) new TransactionWriter();
    }

    @Bean
    public ItemProcessor<TransactionDto, Transaction> processor() {
        return (ItemProcessor<TransactionDto, Transaction>) new TransactionProcessor();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<TransactionDto, Transaction>chunk(2).
                reader(reader()).processor(processor()).writer(writer()).build();
    }

    @Bean(name = "importTransactions")
    public Job importTransactions(JobBuilderFactory jobs) {
        return jobs.get("importTransactions")
                .start(step1())
                .build();
    }

    @Bean(name = "transactionJobRepository")
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(dataSourceTransactionManager);
        return factory.getObject();
    }

    @Bean(name = "joblancher")
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());
        return jobLauncher;
    }

    @Bean
    public BatchLauncher launchBatch() {
        return new BatchLauncher();
    }

    //@Scheduled(cron = "0,10,20,30 * * * * *")
    public void scheduleFixedDelayTask() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        launchBatch().run();
    }


}
