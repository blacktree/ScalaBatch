package jag.batch.job

import org.junit.Test
import org.junit.runner.RunWith
import org.scalatest.junit.AssertionsForJUnit
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.batch.core.Job
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.JobParametersBuilder
import java.util.Date

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration
class BatchJobTest extends AssertionsForJUnit {

  @Autowired
  var jdbcTemplate: JdbcTemplate = _
  
  @Autowired
  var job: Job = _
  
  @Autowired
  var jobLauncher: JobLauncher = _
  
  @Test def test: Unit = {
    val jpb = new JobParametersBuilder
    jpb.addDate("", new Date)
    jpb.addString("INPUT.FILE", "data/books.data")
    val jobExecution = jobLauncher.run(job, jpb.toJobParameters)
    
	val result = jdbcTemplate.queryForInt("select count(*) from books")
	println("#### " + result)
  }
}