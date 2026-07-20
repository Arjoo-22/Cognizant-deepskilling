
=========================
HQL vs JPQL
=========================

HQL (Hibernate Query Language)
- Hibernate specific
- Works on Entity classes
- Supports SELECT, UPDATE, DELETE and INSERT
- More features than JPQL

JPQL (Java Persistence Query Language)
- JPA Standard
- Works on Entity classes
- Supports SELECT, UPDATE and DELETE
- Portable across JPA providers

Example HQL
-----------
SELECT e FROM Employee e

Example JPQL
------------
SELECT e FROM Employee e

Both use Entity names instead of table names.
