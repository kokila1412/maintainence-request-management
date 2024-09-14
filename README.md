

Tech:
‘Computer/laptop set-up with 
-JDK 17 or above
-Springboot 3 or above
-Build tools: GMaven
-Github account with working git command line or your choice of tool for git vcs
-Node setup for building UI application.
-Your choice of IDE
-Docker running locally for containerisation.’

Scenario:
Create a ‘Maintenance Request Management’ web application for customers to lodge a maintenance request. Application is required to have following capabilities.

Task 1
You are required to implement role-based access control using two types of actors as described below:

Actor 1: An admin user who has capability to
  Approves/Rejects request with/without comments (max 100 chars)

Actor 2: Customer/normal user who can
Submits requests with priority specification (low/med/high urgency)
View their requests as a data grid/list which gives them the ability to do basic operations viz. edit, delete, sort, find etc
Each request will contain at least these attributes: id, type, priority, description (500 chars), owner, approver, datetime created and any other attribute which the developer feels is necessary.

Task 2
Nice to have auditing, exception handling and swagger.

Task 3
Write some unit test cases

Task 4
Build a solution as a single JAR to be deployed in a container.


Above is the task assigned

Would like to say a few words on what I did 

Would like to add the below. I have added the same in the Readme file in the projects
1. Built sign up, login apis using Spring Security 
2. Built Post and get api for operations on request table
3. Used spring h2 database
4. Built a React APP UI, which takes the Maintenance Request and uses axios to hit the backend apis
5. Written Unit test cases for some classes
6. Used Audit Listeners , Logging, Swagger APi and Actuators
7. Tried a POC with docker .compose.yml to sue both UI and spring boot ina  single container
8. Attempted to build a single FAT Jar using maven frontend plugin
9. Used Spring Jib maven plugin to build and push the docker image
10. 
   Screenshot FROM Local
   ![image](https://github.com/user-attachments/assets/77d03a32-0899-403e-a345-920090091b1b)
