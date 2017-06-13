SELECT * FROM study.cz88_ip WHERE inet_aton('192.247.24.30') BETWEEN inet_aton (minIp) AND inet_aton(maxIp);

SELECT *
FROM study.cz88_ip;

SELECT location FROM study.cz88_ip WHERE inet_aton("192.168.1.1") BETWEEN inet_aton (minIp) AND inet_aton(maxIp);

SHOW FULL COLUMNS FROM study.cz88_ip

