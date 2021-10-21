CREATE DATABASE Everest;
USE Everest;
select * from 2000to2021expeditions;
select success1,success2,success3,success4,totalSuccess from 2000to2021expeditions;

DROP TABLE Expeditions;
CREATE TABLE Expeditions(
expID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
expName VARCHAR(100),
year INT,
nation VARCHAR(20),
success boolean,
duration INT 
);

ALTER TABLE 2000to2021expeditions ADD totalSuccess INT;

UPDATE 2000to2021expeditions SET totalSuccess=
CASE
WHEN success1='TRUE' THEN 1
WHEN success2='TRUE' THEN 1
WHEN success3='TRUE' THEN 1
WHEN success4='TRUE' THEN 1
ELSE 0
END;

--UPDATE 2000to2021expeditions SET totalSuccess= 1 
--WHERE success1>0 OR success2>0 OR success3>0 OR success4>0;

INSERT INTO Expeditions (expName,year, nation, success,duration) SELECT expID,year, nation,totalSuccess, totdays from 2000to2021expeditions;
SELECT * FROM expeditions;

SELECT year AS 'Expedition Year', COUNT(success) AS 'Successful Climbs'
FROM expeditions
GROUP BY year;

SELECT nation AS 'Country', COUNT(success) AS 'Successful Climbs'
FROM expeditions
GROUP BY nation;
