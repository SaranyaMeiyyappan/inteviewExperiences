1. A REST API Endpoint is making a DB call and has performance issues. How to resolve the issues.? 
    DB Table Indexing
    DB Sharding and Partioning
    Query Refactoring -
        Avoid PL/SQL Queries
        Avoid JOINS, Subqueries etc
        Use Pagination and filters

2. How to choose between RDBMS Vs No-SQL in new Project.?
   1. RDBMS - High Transactions related, multiple table updates
   2. No-SQL - Just for Data Storage with no tranactions or relations between the tables

3. How to monitor application health check
   4. spring-boot actuator /healthcheck endpoint
   5. prometheus and grafana tools

4. Best Practices to implement while developing spring boot project
   5. use sprinboot initializr.io for latest version
   6. Use Open-API, Swagger for Documentation
   6. spring cloud-config for Externalizing the configuration
   7. Implement Design Patterns, SOLID Principles etc
   8. Implement REST API Standards - Naming Conventions, Request and Response Entity