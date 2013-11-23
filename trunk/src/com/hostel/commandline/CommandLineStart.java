package com.hostel.commandline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.expression.spel.generated.SpringExpressionsParser.startNode_return;

import com.hostel.model.command.AllCmdMaps;

//import java.util.Scanner;

//import org.springframework.context.support.GenericXmlApplicationContext;

public class CommandLineStart {
	
	public static void main (String[] args){
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-beans-actions.xml");
		context.load("classpath:spring-beans-dao.xml");
		context.refresh();
		
			System.out.pradintln("Enter command");
			CommandProcessor commandProcessor= new CommandProcessor();
			Scanner scanner = new Scanner(System.in);  
			
			do{		          
		        String command = scanner.nextLine();  
		        if(command.trim().equalsIgnoreCase("exit")){
		        	break;
		        }
		        
		        
		        
			}while(true);
			*/
		CommandProcessor commandProcessor= new CommandProcessor();
		/*String cmd1 = new String("search --start_date adad --end_date 20130702 --beds 7");		
		String cmd2 = new String("book add --search_id 1234 --user_id 678");	
		*/
		Scanner scanner = new Scanner(System.in);  
		String command = scanner.nextLine(); 
		
		CommandDTO commandDTO = processCmdString(command.trim());
		boolean result  = validateCommandDTO(commandDTO);
		System.out.println("command sytax result :"+result);
		commandProcessor.startProcessing(commandDTO);
		
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
	/*
	 * Commands
    search
    book add, cancel, view
    user add, change, view
    admin load, revenue, occupancy
	 */
	public static boolean validateCommandDTO(CommandDTO commandDTO){
		
		boolean result = false; 
		List<String> actualParamsList;
		
		if(commandDTO.getCmdName().equalsIgnoreCase("search") ){
			result = checkParmsFineness(commandDTO.getCmdParams(),AllCmdMaps.searchSearchMap.get("search"));			
		}
		else if(commandDTO.getCmdName().equalsIgnoreCase("book") && (commandDTO.getSubCmdName().equalsIgnoreCase("add") || 
				commandDTO.getSubCmdName().equalsIgnoreCase("cancel") || commandDTO.getSubCmdName().equalsIgnoreCase("view")) ){
			
			actualParamsList = AllCmdMaps.bookCmdMap.get("book_"+commandDTO.getSubCmdName());
			result = checkParmsFineness(commandDTO.getCmdParams(),actualParamsList);			
			
		}else if(commandDTO.getCmdName().equalsIgnoreCase("user") && (commandDTO.getSubCmdName().equalsIgnoreCase("add") || 
				commandDTO.getSubCmdName().equalsIgnoreCase("change") || commandDTO.getSubCmdName().equalsIgnoreCase("view")) ){
			actualParamsList = AllCmdMaps.userCmdMap.get("user_"+commandDTO.getSubCmdName());
			result = checkParmsFineness(commandDTO.getCmdParams(),actualParamsList);
			
		}else if(commandDTO.getCmdName().equalsIgnoreCase("admin") && (commandDTO.getSubCmdName().equalsIgnoreCase("load") || 
				commandDTO.getSubCmdName().equalsIgnoreCase("revenue") || commandDTO.getSubCmdName().equalsIgnoreCase("occupancy")) ){
			actualParamsList = AllCmdMaps.adminCmddMap.get("admin_"+commandDTO.getSubCmdName());
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
		//givenParms.keySet().containsAll(actualParams);
		return result;
	}
	
}
