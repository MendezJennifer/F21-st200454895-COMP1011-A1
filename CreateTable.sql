use Everest;
select*from[dbo].['2000to2021expeditions$']WHERE success1>0 OR success2>0 OR success3>0 OR success4>0;
select*from[dbo].['2000to2021expeditions$'];
ALTER TABLE [dbo].['2000to2021expeditions$'] ADD totalSuccess int;

UPDATE [dbo].['2000to2021expeditions$'] set totalSuccess=
CASE
WHEN success1>0 then 1
WHEN success2>0 then 1
WHEN success3>0 then 1
WHEN success4>0 then 1
ELSE 0
END; 

select success1,success2,success3,success4, totalSuccess from[dbo].['2000to2021expeditions$'];
Create table Expeditions(
expID Int IDENTITY(1,1) NOT NULL,
expName varchar(20),
year int,
nation varchar(20),
success bit,
duration int 
);

select * from Expeditions;
SET CONCAT_NULL_YIELDS_NULL OFF;
INSERT INTO Expeditions (expName,year, nation, success,duration) SELECT expid,year, nation,totalSuccess, totdays from [dbo].['2000to2021expeditions$'];
