# todo-app-aws
ToDo App deployed on AWS

Here, We have created a simpple ToDo spring boot application.

Steps to deploy on AWS-

1. For database we are using MySQL (AWS RDS).
In application.properties file we have configured our database connection.

spring.datasource.url = jdbc:mysql://database-2.cbuomai6mjta.us-east-1.rds.amazonaws.com:3306/todo_app
spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.username = admin
spring.datasource.password = roshanpatil
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto = update

Here, "database-2.cbuomai6mjta.us-east-1.rds.amazonaws.com" is the endpoint of AWS RDS which will work as a Host.
![image](https://github.com/roshan2610/todo-app-aws/assets/84975574/d52243f0-b5d6-4275-857b-98251fa47b2b)
While connecting to the MySQL Workbench give username and password that you have given while creating the database.

Make sure that your RDS is publically accessible with ACLs enabled.
 *In case you are getting error while connecting to the database -
   1. Strictly check Hostname(i.e Endpoint), Port number, ussername and password correctly.
   2. Make sure your security group is configured with all required inbound rules(i.e Port No 3306 for MySL, 8080 for webservers, 22 to access shell) for now we can enable All Traffic.
   3. If this doesn't work then create a new VPC and security group and add save inbound rules for the security group as above.

2. Now, Create an EC2
   I used Ubuntu image, do all necessary configurations, now lauch an EC2 instance.
   ![image](https://github.com/roshan2610/todo-app-aws/assets/84975574/8adf7524-ba89-423f-8465-2f00663d92e5)

   Connect to SSH -
   Steps to connect EC2 to gitbach shell -
     Give required access to the .pem file(keypair)-
     chmod 400 "filename or path"

     Now, for connection do - 
      ssh -i /E/AWS/Keys/newkp.pem ubuntu@public ip addredd of your instance
     We can associate elastic IP adress to make it static.

  Install Java in EC2, the java version tha we are installing should be same as our project(i.e Java 17).
    sudo su - 
    apt get update
    apt install openjdk-17-jdk openjdk-17-jre
  To check installed version
    java -version

3. Now, go to the project (Eclipse)
   Do, Maven clean -> Maven build (make Package), Now your .jar file will be created at target folder.

   Go the AWS S3,
   Create a bucker -> Upload .jar file to the bucket (Grant public access while uploading the file)

   Now, open ssh
   wget "object url of uploaded jar in the bucket" 
   ls (to check file added or not)
   ![image](https://github.com/roshan2610/todo-app-aws/assets/84975574/86b5acd7-6be6-4c13-9b19-4f59bacbe3cd)

  Now, run the file
  java -jar "jar file name"

  ![image](https://github.com/roshan2610/todo-app-aws/assets/84975574/d5bb834a-9409-4351-92e0-9bdf3733b347)

  
  
   
