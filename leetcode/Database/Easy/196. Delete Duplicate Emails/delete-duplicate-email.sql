-- Please write a DELETE statement and DO NOT write a SELECT statement.
-- Write your MySQL query statement below

DELETE FROM Person WHERE id NOT IN (
    SELECT minid FROM (
        SELECT email, min(id) as minid FROM Person GROUP BY email
    ) multiple_minid
)
