# Student-Registration-System
Student registration system 

--> Purpose:
 Analyse, develop, and implement software solutions
 Choose and compare appropriate data structures and algorithms in program design
 Apply classes, inheritance, polymorphism, and exception handling
 Test software implementations to ensure correctness and maintainability

* Case Study:
--> This is a Java Application that uses an interactive Graphical User Interface (GUI) based on the JFrame class using SWING GUI components. 
Year 11 and 12 students study five subjects. There are many assessments for these subjects indifferent formats and the grade of these assessments are summative contributing to a student’s results. Your task is to extend the Java Application developed for Assignment One
such that an administrator can enter details of students with their assessment details for all enrolled subjects and set grade. Students or parents can view the details by entering a student name and year level.

The database will have the following tables:
1. Student table having studentId (primary key): a 4 digit number, studentName: string (30 characters), and yearLevel: 2 digit number
2. Subject table: In addition to the existing attributes this table will have subjectId (primary key): 2 digit number, and studentId as the foreign key
3. Assessment table: extend the Assessment attributes from Assignment One to include an Assessment Id: a single digit number starting at 1. The primary key will be a composite key consisting of subjectId and AssessmentId
4. Grades table: store the values of Grade shown in Table 3. Use the Degree of achievement as the primary key
5. StudentGrade to store the set grade for an Assessment item of a student (use composite key of StudentId, subjectId, AssessmentId, and gradeId. 
