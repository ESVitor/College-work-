-- QUERY TO PROJECT P, R, W, Y AND PI INTO A NEW TABLE.--

DROP TABLE IF EXISTS p;
CREATE TABLE p(turbineID VARCHAR(10),
					sampleTime TIMESTAMP NULL,
					val DOUBLE NULL
					);
						
INSERT INTO p (turbineID, sampleTime, val)
SELECT turbineID, sampleTimeP, p
FROM inputdata;

DROP TABLE IF EXISTS r;
CREATE TABLE r(turbineID VARCHAR(10),
					sampleTime TIMESTAMP NULL,
					val DOUBLE NULL
					);
						
INSERT INTO r (turbineID, sampleTime, val)
SELECT turbineID, sampleTimeR, r
FROM inputdata;

DROP TABLE IF EXISTS w;
CREATE TABLE w(turbineID VARCHAR(10),
					sampleTime TIMESTAMP NULL,
					val DOUBLE NULL
					);
						
INSERT INTO w (turbineID, sampleTime, val)
SELECT turbineID, sampleTimeW, w
FROM inputdata;

DROP TABLE IF EXISTS y;
CREATE TABLE y(turbineID VARCHAR(10),
					sampleTime TIMESTAMP NULL,
					val DOUBLE NULL
					);
						
INSERT INTO y (turbineID, sampleTime, val)
SELECT turbineID, sampleTimeY, y
FROM inputdata;

DROP TABLE IF EXISTS pi;
CREATE TABLE pi(turbineID VARCHAR(10),
					sampleTime TIMESTAMP NULL,
					val DOUBLE NULL
					);
						
INSERT INTO pi (turbineID, sampleTime, val)
SELECT turbineID, sampleTimePi, pi
FROM inputdata;


-- QUERY TO DO THE LEFT JOIN

SELECT turbineID, timestamp, val
FROM timestamp
LEFT JOIN p
ON p.sampleTime = timestamp.timestamp
ORDER BY turbineID, sampleTime;
