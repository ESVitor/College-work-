SELECT
(SELECT COUNT(*) FROM timestamp) AS 'Timestamp Table',
(SELECT COUNT(*) FROM windspeed WHERE sampleTime like '2008%') AS 'WindSpeed Table';
