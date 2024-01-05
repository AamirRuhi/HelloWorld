package max.cron;

import max.dao.LoginDAO;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ClassJOB implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		LoginDAO loginDAO=new LoginDAO();
		loginDAO.updateLock();
		System.out.println("update Lock User by cron");
	}

}
