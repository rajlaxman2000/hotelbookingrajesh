<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<s:iterator var="room" value="rooms" status="rowstatus" >
		<td>Room Name: <s:property value="#room.roomName"/>	
		<br/>	  
		<s:iterator var="bed" value="#room.beds" status="rowstatus">
			<tr><span>Bed Details:</span></tr>
			 <br/>
			 <tr>Bed Id:<s:property value="#bed.bedId"/></tr>		
			 <tr>Bed Name : <s:property value="#bed.bedName"/></tr>		
			 <tr>Bed Price : <s:property value="#bed.price"/></tr>
			 <tr>Bed Availability  :<s:property value="#bed.available"/></tr>	
			 <br/>
		</s:iterator>
		<br/>		
		</td>
	</s:iterator>
	</div>