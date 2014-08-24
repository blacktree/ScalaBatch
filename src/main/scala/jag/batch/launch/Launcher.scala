package jag.batch.launch

import org.springframework.batch.core.Job
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.batch.core.JobParametersBuilder
import java.util.Date

object Launcher extends App {
	val applicationContext = new ClassPathXmlApplicationContext("BATCHJOB-context.xml")
	
	val job = applicationContext.getBean(classOf[Job])
	val launcher = applicationContext.getBean(classOf[JobLauncher])
	
	val jpb = new JobParametersBuilder
	jpb.addDate("timestamp", new Date)
	jpb.addString("INPUT.FILE", "data/books.data")
	
	val jobExecution = launcher.run(job, jpb.toJobParameters())
}