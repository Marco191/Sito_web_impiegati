package com.nttdata.EmployeeApp2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduler {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedDelay = 30000)
	public void scheduledLookup() throws InterruptedException {
		System.out.println("\nSono le: " + dateFormat.format(new Date()));
		System.out.println("\n\nRicorda di salvare spesso la tua applicazione per non perderne i progessi! \n\n");
		
		Thread.sleep(30000);
	}

}
