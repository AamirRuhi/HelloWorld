package max;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import max.cron.CronSdular;
import max.dao.LoginDAO;

public class ListnerClass implements HttpSessionListener,ServletContextListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sd) {
		HttpSession s = sd.getSession();
		
		String uid=(String)s.getAttribute("uid");
		LoginDAO n=new LoginDAO();
		n.logout(uid);
		System.out.println("User session time out");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		new CronSdular();
	}

}
