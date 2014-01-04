<%@taglib uri="/struts-tags" prefix="s"%>
<div>
	<s:form method="post" validate="true" action="search">
      <s:textfield label="city" name="cityName"/>
      <s:textfield label="Start Date" name="startDate"/>
      <s:textfield label="End Date" name="endDate"/>
      <s:submit cssClass="btn btn-primary"/>
	</s:form>
</div>