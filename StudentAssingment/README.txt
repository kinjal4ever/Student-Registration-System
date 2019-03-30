Note :for run this application you must have MySql as database
Please follow below steps to execute application.

1. Create DB:
Open databaseSetup.sql file and run it in mySql.
2.Change connection string in DatabaseUtility.java file. Give proper user name and password
	dbConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassessment","root1","root123");  
2.Copy Mysql jar (from ./dist/lib into <javapath>/lib/)
3.Then compile all files
4.run studyMonitarInterface file



