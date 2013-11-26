package com.hostel.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class AppUtil {
	
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
    	  put("user_edit",new ArrayList<String>(Arrays.asList("user_id","first_name","last_name","email", "cc_number",
      			"expiration_date","security_code","phone")));
     	  put("user_view",new ArrayList<String>(Arrays.asList("first_name","last_name","email")));
    	}};
    	
    public static final HashMap<String, ArrayList<String>> adminCmddMap = new HashMap<String, ArrayList<String>>()
    	{{put("admin_load",new ArrayList<String>(Arrays.asList("path")));
    	  put("admin_revenue",new ArrayList<String>(Arrays.asList("start_date","end_date")));
    	  put("admin_occupancy",new ArrayList<String>(Arrays.asList("start_date","end_date")));
    	}};
    
    public static final String numbRegEx="\\d+";
    
    /**
     * 
     * @param val
     * @return
     * sql date Str format - yyyy-mm-dd
     * App date str format yyyyddmm , ex: 20140701
     */
    public static Date getSqlDateByString(String val ){
    	
    	StringBuilder dateStringBuilder = new StringBuilder();		
		dateStringBuilder.append(val.substring(0,4)).append("-").append(val.substring(6)).append("-").append(val.substring(4,6));
		return Date.valueOf(dateStringBuilder.toString());
    }
    
    public static boolean checkValidDateStr(String str){
		boolean result = false;
		int year=0,month=0,day=0;
		if(str.trim().length()==8 && str.matches(AppUtil.numbRegEx) ){			
			year = Integer.valueOf(str.substring(0,4));
			month = Integer.valueOf(str.substring(6));
			day=Integer.valueOf(str.substring(4,6));
			result =true;
		}		
		if( result && (year>=1900 && year<=3000) && (month>=1 && month<=12) && (day>=1 && day<=31)){
			result =true;
		}
		return  result;
	}


}
