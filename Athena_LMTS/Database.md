1. Given student table - Write a query to print the student name or student names who has highest sum of marks in all subjects.

| Student ID | Student Name | Subject     | Mark |
|------------|--------------|-------------|------|
| 1          | John Smith   | Mathematics | 90   |
| 2          | Emily Johnson| English     | 85   |
| 1          | John Smith   | English     | 90   |
| 3          | Michael Lee  | Science     | 92   |
| 4          | Sarah Brown  | History     | 78   |
| 5          | David Chen   | Geography   | 88   |

SELECT StudentName, TotalMarks
FROM (
    SELECT StudentName, SUM(Mark) as TotalMarks
    FROM student
    GROUP BY StudentID, StudentName
) AS StudentTotals
WHERE TotalMarks = (
    SELECT Max(TotalMarks)
    FROM(
        SELECT SUM(Mark) As TotalMarks
        FROM Student
        GROUP BY StudentID
    ) As MaxMarks
);

2. Functions Vs Procedures
   1. Functions - 
      2. performs a specific task
      3. has return value
      4. can be used in SQL Queries
      5. Cannot perform transaction control statements (like COMMIT, ROLLBACK)
      6. Used for computations and can be integrated into SQL expressions, returning a value
      7. Example - SELECT employee_name, calculate_bonus(salary) FROM employees;
   
   2. Procedures
      3. Procedure: A procedure is a stored program that performs
      4. does not return a value
      5. can execute complex operations, such as updating multiple records, but they do not return a value directly.
      6. Cannot be used directly in SQL statements. Instead, they are executed using the CALL or EXECUTE statement.
      7. Example - CALL update_employee_salary(123, 5000);
      8. Can include transaction control statements, allowing for more complex operations that may require committing or rolling back transactions.
        