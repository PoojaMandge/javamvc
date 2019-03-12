package com.clc.config;

public class SpringMVCRemarks {
/**
 * 



application start	
	WEb.xml -- Dispatcherserlet-- bean.xml
	all beans will be created..
		scan all controllers..prepare handler mapping table
				controller..method..mapping..methodtype -- allcontrollers..
		
		
	http://localhost:8080/
	
			/index -- dispatcherservlet -- handlermapping--dispatcherservlet--
			
			
			controller -- service/impl/--dao/impl --db
			db -- dao/impl -service/impl -- controller-- modelviewObj --
			
			dispatcherservlet-- viewresolver -- prefix/suffiex...dispatcherservlet--
			view render -- End user..
			
		
		Handler Mapping.. Dispatcher Servlet- Spring APplicatin Instantiation time..
All Controllers not for one...
	base-package-- scan controllers -- 
		@controller
		class EMp
			@Requestmapping("/", method)
			

//http://localhost:8080/empform  --GET -- showform -- EmpController
//http://localhost:8080/save   -- POST -- save -- EmpController
//http://localhost:8080/viewemp  --GET -- viewemp -- EmpController
//http://localhost:8080/editemp/{id}  -- GET --edit --EmpController
//http://localhost:8080/editsave/  -- POST -- editsave--EmpController
//http://localhost:8080/deleteemp/{id}  -- GET  --delete  - EmpController




Browser -- Address url enter  --- GET
links -- GET

<html>
	<form action, method=POST
</html>



web.xml -- dispathcerservlet - bean.xml -- base-package--
		db-- tables...
		all beans wil be created inside spring container -- APplicationCOntext
		Scan Controllers-- requestmappings..prepare Handlermappingtable
		
		



	Boileplate code..Unnecessarycode..
	connection
		
		
		JDBC Steps-
			Load the drivers -- Driverclass - ClassNotFound..
			create the connection -- SQLException../IOException
			create statement --
			execute query -- insert query...
			execute query -- insert query...10 -- 10 mapping
						fetch..
			resource cleanup
			
			mapping -- developer..
			
EmpOB								Relational ..Database...
	id								ID
	fname							First_name
	lname							Last_Name
	age								Age
	salary							Salary
			
			JPA
	HIbernate iBatis TopLink
	ORM - HIbernate 
	
	
	Xml -- 
		Hibernate configuration file -- database configuration
		hibernate mapping file -- Mapping -- one time activity
		
	Annotations
		configuration file -- Database Configurations
		Annotated classes. -- Annoations...
		
		
		

		
		HibernateRemarks...
		
 * 
 * 
 * 
 */
	
	
}
