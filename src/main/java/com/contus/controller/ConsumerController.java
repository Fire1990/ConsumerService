package com.contus.controller;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.contus.service.ConsumerService;
import com.contus.util.Util;

@Component
public class ConsumerController {
	
	private static final Logger logg=Logger.getLogger(ConsumerController.class.getName());
	
	@Value("${new_line}")
	private String newLine;
	
	@Value("${host_message}")
	private String hostMessage;
	
	@Value("${port_message}")
	private String portMessage;
	
	@Value("${method_message}")
	private String methodMessage;
	
	@Value("${exit_message}")
	private String exitMessage;
	
	@Value("${last_message}")
	private String lastMessage;
	
	@Autowired
	private ConsumerService ConsumerService;
	
	@Value("${welcome_message}")
	private String welcomeMessage;
	
	@Scheduled(fixedDelay=1000,initialDelay=1000)
	public void main() {
		Scanner name=new Scanner(System.in);
		logg.info("\n"+Util.DESIGN_LINE + "\n");
		logg.info(welcomeMessage);

		logg.info(hostMessage);
		String host = name.nextLine();

		logg.info(portMessage);
		String port = name.nextLine();


		boolean s = true;
		while (s) {
			logg.info(methodMessage);
			String methodName = name.nextLine();
			switch (methodName) {
			case "test":
				ConsumerService.test(host, port);
		
				break;

			case "get":
				ConsumerService.get(host, port);
		
				break;
			case "post":
				ConsumerService.post(host, port);
		
				break;
			case "delete":
				ConsumerService.delete(host, port);
		
				break;
			case "put":
				ConsumerService.put(host, port);
		
				break;
			}
			s = methodName.equalsIgnoreCase(exitMessage) ? false : true;
			continue;
		}
		logg.info(lastMessage);
	}

}
