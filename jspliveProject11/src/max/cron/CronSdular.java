package max.cron;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class CronSdular {
	
	
	public CronSdular()
	{
		try {
			
			SchedulerFactory sf = new   StdSchedulerFactory();	
			Scheduler s = sf.getScheduler();
			s.start();
			
			JobDetail jDetail = new JobDetail("a","bb",ClassJOB.class);
		// CronTrigger crnTrigger = new CronTrigger("c","bb","*/1 * * * *");
			
			CronTrigger crnTrigger = new CronTrigger("c","b","* * * * *");// every mint
			s.scheduleJob(jDetail, crnTrigger);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
