CREATE USER 'prospring5'@'localhost' IDENTIFIED BY 'prospring5';

CREATE SCHEMA MUSICDB;
GRANT ALL PRIVILEGES ON MUSICDB . * TO 'prospring5'@'localhost';
FLUSH PRIVILEGES;

/* 에러(java.sql.SQLException: The server timezone value 'UTC'
 *  is unrecognized or represents more than one timezone.)가 발생할 때. 
 * DB 환경변수를 KST로 설정한다. (원서는 러시아 표준시인 +3:00이 설정돼 있었음) */
SET GLOBAL time_zone = '+9:00';