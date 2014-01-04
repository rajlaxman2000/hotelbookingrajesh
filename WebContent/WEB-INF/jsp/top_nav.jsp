<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hostel 21 System </title>
<style type="text/css">
#apnd div { 
        height: 50px; 
        width: 100px; 
        /*border: 1px solid red;
        background: orange;
        */ 
        margin-left: 5px; 
        float: left; /*Here you can also use display: inline-block instead of float:left*/
         
}
</style>
</head>
<%@taglib uri="/struts-tags" prefix="s"%>
<div id="apnd">
	<div>
		<a href="<s:url action="admin"/>" >Admin</a><br>
	</div>
	
	<div>	
		<a href="<s:url action="search"/>" >Search</a><br>
	</div>
		
	</div>
		<a href="<s:url action="user"/>" >Customer</a><br>
	</div>	
</div>	

<body>

</body>
</html>