package com.nttdata.EmployeeApp2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nttdata.EmployeeApp2.dao.SchedulerConfig;
import com.nttdata.EmployeeApp2.dao.SchedulerRepository;

@Component
public class SimpleScheduler {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	/*
	@Autowired
	private SchedulerRepository schedulerRepository;
	
	public Integer getMillisecond(SchedulerConfig sg, Integer id) {
		
		Optional<SchedulerConfig> sc =  schedulerRepository.findById(id);
		
		return sg.getValore();
		
	}
	
	@Scheduled(fixedDelay = getMillisecond(sg,1))
	public void scheduledLookup2() throws InterruptedException {
		System.out.println("\nSono le: " + dateFormat.format(new Date()));
		System.out.println("\n\nRicorda di salvare spesso la tua applicazione per non perderne i progessi! \n\n");
		
		Thread.sleep(30000);
	} 
	 */
	@Scheduled(fixedDelay = 30000)
	public void scheduledLookup() throws InterruptedException {
		System.out.println("\nSono le: " + dateFormat.format(new Date()));
		System.out.println("\n\nRicorda di salvare spesso la tua applicazione per non perderne i progessi! \n\n");
		
		Thread.sleep(30000);
	}

}
