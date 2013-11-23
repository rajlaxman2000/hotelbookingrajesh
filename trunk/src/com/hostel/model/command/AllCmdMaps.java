package com.hostel.model.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;


public abstract class AllCmdMaps {
	
	  /*
     * 
    Commands
    search
    book add, cancel, view
    user add, change, view
    admin load, revenue, occupancy
    
    search  :  
		$ h21 search [--city] [--start_date] [--end_date] [--beds] 	
	book 	: 
		$ h21 book add --search_id 1234 --user_id 678 
		book add --search_id --user_id  (If some one do this with out doing serach as last we will notify them by asking to do latest search)
	  	book cancel   ?? (please wht would for this) --order_id 
		book cancel --order_id
	  	view	   this command will be used to view orders with in the range or by user email id
		book view --start_date 20140702 --end_date 20141003 [--user_id --user_emailId]
	user commands
		add    : $ h21 user add --first_name --last_name --email [ --cc_number --expiration_date --security_code --phone ] 
		change : $ h21 user change --user_id [ --first_name --last_name --email [ --cc_number --expiration_date --security_code --phone ]] 
		view   : ?? (please wht would for this)
			user view --user_id --user_email_id --user_facebookId --user_twitterId
	Admin : 
		load  		:?? (please wht would for this)
			admin load --filepath
		revenue     :?? (please wht would for this)
			admin revenue [--hostel_id --start_date --end_date]
			So if he gives hoestl_id we will revenue of that hostel, if he gives dates we will provide revenu for that hostel with in that date
	occupancy   :?? (please wht would for this)
		admin occupancy [--hostel_id --start_date --end_date]
     */

	
	public static final HashMap<String, ArrayList<String>> searchSearchMap = new HashMap<String, ArrayList<String>>()
	{{put("search",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));}};
    
	public static final HashMap<String, ArrayList<String>> bookCmdMap = new HashMap<String, ArrayList<String>>()
    	{{put("book_add",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	  put("book_cancel",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	  put("book_view",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	}};
    
    public static final HashMap<String, ArrayList<String>> userCmdMap = new HashMap<String, ArrayList<String>>()
    	{{put("user_add",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	  put("user_change",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
     	  put("user_view",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	}};
    	
    public static final HashMap<String, ArrayList<String>> adminCmddMap = new HashMap<String, ArrayList<String>>()
    	{{put("admin_load",new ArrayList<String>(Arrays.asList("path")));
    	  put("admin_revenue",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	  put("admin_occupancy",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	}};
    
   
    
  
}
