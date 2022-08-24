# Book-Supplier-App (BSA)

### Ayeni Abimbola 

## Contents <br>
   _Overview_<br>
   _Abstract_<br>
 1.   Documentation
 2.   Deliverables
 3.   Entity Relationship Diagram (ERD) of the BSA
 4.   Scope and Limitations of the Project
 5.   Aim and Objectives of the Project
 6.   ERD of the BSA Area of Concentration
 7.   App Features
 8.   Tools and Technology Used
 9.   Agile & Project Management (Git, Jira)
 10.   Databases & Cloud Fundamentals (MySQL Configuration)
10.   API Development (Spring Boot Project Structure)
11.   Database Configuration
12.   The Postman CRUD Execution
13.   Automated Testing (JUnit, Mockito)
14.   Installation
15.   Conclusions
16.   Recommendations
17.   Future Work <br>
    _Acknowledgement_<br>
    _Reference_<br>

#
### Overview
_This app allows book suppliers to manage their books. It will allow suppliers to login and get information about request to supply book to library, schools, company and individual._ 
#
### Abstract
_This app was created using a **Spring Boot API**, with utilization of supporting tools, methodologies, and technologies that encapsulate an application of back-end developed using **Java** Programming Fundamentals, a managed database **(MySQL)** hosted locally on **Port 8086**, a means of making API Calls using **Postman** and a means of checking persistence using **Workbench 8.0 console**. The whole concept of this project is as detailed in **Entity Relationship Diagram (ERD)** presented here, but due to time constraints and for the purpose of fulfilling the Software Developement Training, only two entities are our focus, that is, Employee **(Supplier)** and Resources **(Book)**.  Since, we are implementing in **Agile environment**, the project would be updated with other features in the future work._   
#
### 1.   Documentation
* Why Book Supplier App <br>
  The motivation for building this App stems from:
  * minimizing time spent on maintaining record of books and customer needs
  * eliminating delays in book supply to library, schools etc
  * efficiency in seraching for books
  * reduction of cubersome of maintaining several documents
  * overall reduction of operating cost and time spent.
 
 * Expectation of the Project <br>
   There are several entities required to complete the functionality of this system with the expectation    of making it avalaible to the appropriate stakeholders within a short period of time.
 
 * What Went Well <br>
   * The work done showed my capability as at the time of executing this project.
   * Culmination of all the topics I have learnt as part of my training
   * The reports includes evidence of my understanding of the topics I have learnt and wider reading
   * Ability provision by qualified and experienced QA trainer, "Upasana", gave me the confidence
   * The commitment given to help by my trainer, "Upasana", is a testimony to the success of this            project.
   * Ongoing learning during the execution of the project is one of the of the things I really liked          about my project.
   * The general support of the QA via access to QA Community and Cloud Academy has given me the              opportunity to always go back to learn whenever I am stucked.
   * Also, I think what equally helped me was always asking questions in class whenever I lack                understanding of what we are doing.
   * I think I did well in my conceptual design.  I thought, it was detailed and had good information.
   * Two entities have been coded and completed and the results have somewhat successful.

 * What didn't go as Planned <br>
   * Inability to implement all features
   * Lauching to website
   * More depth and detail of the two entities implemented
   * Full implementation in agile framework
 
 * Improvements for Future Revisions of the Project <br>   
   * more depth of analysis and detail for some of other entities
   * improvement on the structure of the project
   * improvement on the structure of the report
   * comprehensiveness of the tools and technology like including web security
   * Project excution in DevOps and Agile enviroments
   * More hands on coding skills
   * Researchiing more into book management systems
   
 * Screenshots showing Postman Requests and the Output from the API<br>
   This is as shown in section 12 of the contents<br>
 * Screenshots of Database to Prove that data is being Persisted<br>
   This is as shown in section 9 of the contents<br>  
 * Screenshot of Test Results<br>
   This is as shown in section 13 of the contents<br>
 * Link to Jira Board<br>
   Although, Jira Board was not utilized, Microsoft Excell was used to produced the User Stories, the      detailed is as shown in section 8 of the conents.
 
  #
### 2.   Deliverables
   * Codebase
     * Spring Boot API with full CRUD functionality
     * Project Structure (back-end)
   
   * Testing
     * Unit and integration testing for the project back-end
     * Test coverage of the src/main/java folder.
 
   * Continous Integration
     * GitHub Repository
     * A build of the application present in the root folder of git repo
     * A .jar which can be deployed from the command-line (java -jar <filename.jar>)
 
   * Entity Relationship Diagram (ERD)
   * Use of Custom Queries
   * Use of Custom Exceptions
   * Use of DTOs
   * Use of Lombok

 #
### 3.   Entity Relationship Diagram (ERD) of the BSA
* Conceptual ERD Drawn using Lucidchart <br>
  Conceptual ERD1 <br> 
<img src="BookSupApScreenshot/conceptual ERD of BSMS1.jpg"> <br>
  Conceptual ERD2 <br> 
<img src="BookSupApScreenshot/conceptual ERD of BSMS2.jpg"> <br>
* Logical ERD Drawn using Lucidchart <br>
  Logical ERD1 <br> 
<img src="BookSupApScreenshot/Logical ERD of BSMS1.jpg"> <br>
Logical ERD2 <br> 
<img src="BookSupApScreenshot/Logical ERD of BSMS2.jpg"> <br>

 #
### 4. Scope and Limitations of the Project
The scope of this project at the time of submission is limted to just two functionalities.  The          development to optimize the full functionalties of this app is a continous process.   At this            stage, the most importantant limitations lies in the fact that the level of obtainable result is        far below other apps in existence because of the limited number of available features. 

#
### 5.   Aim and Objectives of the Project
The aim of this project is to develop a unique Application for suppliers for book management through the listed objective:
*  Development in Agile environment
*  Database creation
*  coding using Java
*  API development using Spring Boot
*  Automated Testing
