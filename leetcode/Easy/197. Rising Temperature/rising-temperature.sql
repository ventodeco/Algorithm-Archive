SELECT a.id FROM weather a,
weather b WHERE a.temperature>b.temperature
AND DATEDIFF(a.recordDate,b.recordDate)=1;
