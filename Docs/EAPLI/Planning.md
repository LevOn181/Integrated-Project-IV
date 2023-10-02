 # Members of the group #

+------------------+----------------+------------+
|       NAME       | Student Number | User Story |
+------------------+----------------+------------+
|Gonçalo Ribeiro   |    1210792     | G002, G005 |
+------------------+----------------+------------+
|Ricardo Guimarães |    1212125     | G003, G006 |
+------------------+----------------+------------+
|Levente Onodi     |    1222490     | G004, G001 |
+------------------+----------------+------------+
|Jorge Sousa       |    1210820     | G005, G004 |
+------------------+----------------+------------+
|Gabriel Ferreira  |    1211919     | G006, G001 |
+------------------+----------------+------------+

## Requirement ##
 In sprint A we had to develop a project in JAVA from a given base. The goal for the sprint is to make the project support either in memory or relational database.
The project need to be following the typical layered approach.
 The project need to have Source Control. The source code and all related artifacts should be versioned in a GitHub repository.
 The pogram should be able to run from scipt on a variety of systems.
 The program need to have and authentication and authorization system for the users and funcionalities.

 # Creating the use case diagram #

 -Identify the actors: 
   Actors are the external entities (i.e., users, systems, or devices) that interact with the system. 
   We identified the actors that are relevant to the system.

 -Identify the use cases: 
   A use case is a specific interaction between an actor and the system that achieves a particular goal. 
   We identified the use cases are required for the system to fulfill its purpose.

 -Model the relationships:
   The entities and their value objects were placed in one aggregate. 
   Value objects are the objects characterizing the entity.
   To indicate relationships between entities we connected them with lines having a small explanation text on it.
   
 # Entities and their use cases #
  According to the project description we found the following use-cases:
  Thee DDD diagram is to be found in the same directory as this document.
  Managers:
    Manage users, courses, and student enrollment
    Authenticate users
    Create and use shared boards and meetings

  Teachers:
    Schedule classes for their courses
    Create exams
    Create and use shared boards and meetings

  Students:
    Enroll in courses
    Take exams
    View exam results
    Create and use shared boards and meetings

  Course:
    Characterized by title and a unique code
    Open and close for enrollment and classes
    Can have a minimum and maximum number of enrolled students

  Classes and Meetings:
    Recurring weekly events with a unique title, date, and duration
    Participants include teachers and students

  Shared Boards:
    Digital implementation of a post-it board
    Divided into columns and rows with a certain number of cells
    Maximum number of rows and columns defined in a property file
    Users can have read or write access and may be shared with other users
    Users with write permission can post content (text or image) to a cell
    System maintains a history/log of all updates
    System generates real-time HTML rendering of the board
    Users can edit, move, or delete their own posts
    Owners can archive the board

  Exams:
    Related to a specific course
    Characterized by a unique title and small description
    Open and close for submissions
    Automatically graded
    System provides a language to support the specification and execution of exams

## Analysis ##

 We deeply analised the project description in order to create the most suitable domain model for the client's specifications.
 After each decision we overviewed the the description and the previously created parts of the domain model to ensure
 the domain model is implemented according to the client's demand.

## Implementetion ##

 The functions required for the sprint (database, authentication, authorization) were implemented and working properly.
 
