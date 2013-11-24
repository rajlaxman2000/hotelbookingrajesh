package com.hostel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;


public abstract class AllCmdMaps {
		
	public static final HashMap<String, ArrayList<String>> searchSearchMap = new HashMap<String, ArrayList<String>>()
	{{put("search",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));}};
    
	public static final HashMap<String, ArrayList<String>> bookCmdMap = new HashMap<String, ArrayList<String>>()
    	{{put("book_add",new ArrayList<String>(Arrays.asList("city","start_date","end_date", "beds")));
    	  put("book_cancel",new ArrayList<String>(Arrays.asList("order_id")));
    	  put("book_view",new ArrayList<String>(Arrays.asList("start_date","end_date","user_id", "user_emailId")));
    	}};
    	
    public static final HashMap<String, ArrayList<String>> userCmdMap = new HashMap<String, ArrayList<String>>()
    	{{put("user_add",new ArrayList<String>(Arrays.asList("first_name","last_name","email", "cc_number",
    			"expiration_date","security_code","phone")));
    	  put("user_change",new ArrayList<String>(Arrays.asList("user_id","first_name","last_name","email", "cc_number",
      			"expiration_date","security_code","phone")));
     	  put("user_view",new ArrayList<String>(Arrays.asList("first_name","last_name","email")));
    	}};
    	
    public static final HashMap<String, ArrayList<String>> adminCmddMap = new HashMap<String, ArrayList<String>>()
    	{{put("admin_load",new ArrayList<String>(Arrays.asList("path")));
    	  put("admin_revenue",new ArrayList<String>(Arrays.asList("start_date","end_date")));
    	  put("admin_occupancy",new ArrayList<String>(Arrays.asList("start_date","end_date")));
    	}};
}
