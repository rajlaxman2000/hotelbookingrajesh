package com.hostel.commandline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.hostel.util.AppUtil;

import java.util.Scanner;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CommandLineStart {
	
	//public static CommandDTO commandDTO;
	
	public static void main (String[] args){
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();		
		context.load("classpath:spring-beans-dao.xml");
		context.load("classpath:spring-beans-command.xml");
		context.load("classpath:spring-beans-services.xml");
		context.refresh();
		
	
		/*GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-beans-actions.xml");
		context.load("classpath:spring-beans-dao.xml");
		context.refresh();
		*/
			System.out.println("Enter command");
			CommandProcessor commandProcessor;
			Scanner scanner = new Scanner(System.in);  
			
			do{		          
		        String command = scanner.nextLine();  
		        if(command.trim().equalsIgnoreCase("exit")){
		        	break;
		        }
		        commandProcessor= (CommandProcessor)context.getBean("command.processor");
		        String prvCommand = new String();
		        if(commandProcessor!=null && commandProcessor.commandDTO!=null 
		        		&& commandProcessor.commandDTO.getCmdName()!=null && commandProcessor.commandDTO.getCmdName().equalsIgnoreCase("search")){
		        	prvCommand = commandProcessor.commandDTO.getCmdName();
		        }
				CommandDTO commandDTO = processCmdString(command.trim());
				if(prvCommand!=null && prvCommand.length()>0 ){
					commandDTO.setPrvCmdName(prvCommand);
				}
				boolean result  = validateCommandDTO(commandDTO);				
				if(result){						
					commandProcessor.startProcessing(commandDTO);
				}else{
					System.out.println("Please provide the correct command to execute further, type 'exit' to quit");
				}
		        
			}while(true);
		
		/*String cmd1 = new String("search --start_date adad --end_date 20130702 --beds 7");		
		String cmd2 = new String("book add --search_id 1234 --user_id 678");	
		*/
		/*
		CommandProcessor commandProcessor= (CommandProcessor)context.getBean("command.processor");
		Scanner scanner = new Scanner(System.in);  
		String command = scanner.nextLine(); 
		
		CommandDTO commandDTO = processCmdString(command.trim());
		boolean result  = validateCommandDTO(commandDTO);
		
		if(result){
			commandDTO.setPrvCmdName(commandDTO.getCmdName());
			commandProcessor.startProcessing(commandDTO);
		}else{
			System.out.println("Please provide the correct command to execute further, type 'exit' to quit");
		}*/
	}	
	
	public static CommandDTO processCmdString(String cmd){		
		System.out.println("Processing the command");
		
		CommandDTO commandDTO = new CommandDTO(); 
		Map<String, String> params = new HashMap<String, String>();
		String[] retval = cmd.split("--");
		for (int i=0;i<retval.length;i++){
			String[] vals = retval[i].split(" ");
			if(i==0){				
				commandDTO.setCmdName(vals[0]);
				if(vals.length>1){
					commandDTO.setSubCmdName(vals[1]);
				}	
			}else{
				if(vals.length>1)params.put(vals[0], vals[1]);
			}
		}
		commandDTO.setCmdParams(params);
		return commandDTO;
	}
	
	public static boolean validateCommandDTO(CommandDTO commandDTO){
		
		boolean result = false; 
		List<String> actualParamsList;
		
		if(commandDTO.getCmdName().equalsIgnoreCase("search") ){
			if(commandDTO.getCmdParams().size()>0){
				result = checkParmsFineness(commandDTO.getCmdParams(),AppUtil.searchSearchMap.get("search"));
			}else{
				result = true;
			}	
		}
		else if(commandDTO.getCmdName().equalsIgnoreCase("book") && (commandDTO.getSubCmdName().equalsIgnoreCase("add") || 
				commandDTO.getSubCmdName().equalsIgnoreCase("cancel") || commandDTO.getSubCmdName().equalsIgnoreCase("view")) ){			
			actualParamsList = AppUtil.bookCmdMap.get("book_"+commandDTO.getSubCmdName());
			result = checkParmsFineness(commandDTO.getCmdParams(),actualParamsList);			
			if(commandDTO.getCmdName().equalsIgnoreCase("book") && commandDTO.getSubCmdName().equalsIgnoreCase("add")){
				result = (commandDTO.getPrvCmdName().equalsIgnoreCase("search"))?true:false;
				System.out.println("Please make sure you run search before booking");
			}			
		}else if(commandDTO.getCmdName().equalsIgnoreCase("user") && (commandDTO.getSubCmdName().equalsIgnoreCase("add") || 
				commandDTO.getSubCmdName().equalsIgnoreCase("edit") || commandDTO.getSubCmdName().equalsIgnoreCase("view")) ){
			actualParamsList = AppUtil.userCmdMap.get("user_"+commandDTO.getSubCmdName());
			result = checkParmsFineness(commandDTO.getCmdParams(),actualParamsList);
			
		}else if(commandDTO.getCmdName().equalsIgnoreCase("admin") && (commandDTO.getSubCmdName().equalsIgnoreCase("load") || 
				commandDTO.getSubCmdName().equalsIgnoreCase("revenue") || commandDTO.getSubCmdName().equalsIgnoreCase("occupancy")) ){
			actualParamsList = AppUtil.adminCmddMap.get("admin_"+commandDTO.getSubCmdName());
			result = checkParmsFineness(commandDTO.getCmdParams(),actualParamsList);
		}
		return result;
	}
	
	public static boolean checkParmsFineness(Map<String, String> givenParms, List<String> actualParams){
		
		boolean result = false;
		for (String s: givenParms.keySet()){
			result  = actualParams.contains(s);
			if (result == false){
				break;
			}
		}		
		return result;
	}
	
}
