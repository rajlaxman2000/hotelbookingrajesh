<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all hostels</title>
</head>
<body>

	<s:form action="rooms" method="post">
	<h1>This will display all the hostels associated to Hostel-21 Brand</h1>
	
	Please select the Hostels from Drop down :
	<br>
	Select : <s:select id="hostelId" name="hostelId" tabindex="true" headerKey="0" headerValue="Select" list="hostels" listKey="hostelId" listValue="hostelName" />
	<s:submit  value="go"/>
	</s:form>
	<div>
	<s:iterator var="room" value="rooms" status="rowstatus" >
		<tr><b>Room Name:</b> <s:property value="#room.roomName"/>		  
		<s:iterator var="bed" value="room.beds" status="rowstatus">
			<td><span>Bed Details:</span>
				 <s:property value="#bed.bedId"/>		
				 <s:property value="#bed.bedName"/>		
				 <s:property value="#bed.price"/>
				 <s:property value="#bed.available"/>				
			</td>				
		</s:iterator>		
		</tr>
	</s:iterator>
	</div>
		
</body>
</html>