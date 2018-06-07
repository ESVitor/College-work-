
-- Records of Each Month on the windspeed table
SELECT DISTINCT(
	SUBSTRING(sampleTime, 1, 7))AS Months,
    COUNT(*) AS Total
FROM  windspeed
	GROUP BY SUBSTRING(sampleTime, 1, 7);