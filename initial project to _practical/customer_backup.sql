-- MySQL dump 10.16  Distrib 10.1.16-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: insurance
-- ------------------------------------------------------
-- Server version	10.1.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Abraham','Lincoln','1809-02-12','9 The drive, Tallaght, Dublin 24','0877035958'),(2,'Kanye','Omari West','1977-06-08','Apartment 3, Shelbourne Rd, Dublin 4','0877035958'),(3,'Aubrey','Drake Graham','1986-10-24','4 Pembroke Rd, Dublin 4','0877035958'),(4,'Marshall','Bruce Mathers III','1972-10-17','92 Baggot Street Lower, Grand Canal Dock, Dublin 2, DO2 KV77','0877035958'),(5,'Robyn','Rihanna Fenty','1988-02-20','4 Herbert Road, Dublin 4','0877035958'),(6,'Adele','Laurie Blue Adkins','1988-05-05','4 Simmonscourt Rd, Dublin 4, D04 A9K8','0877035958'),(7,'Stefani','Joanne Angelina Germanotta','1986-03-28','Cardiff Ln, Sir John Rogersons Quay, Grand Canal Dock, Dublin 2, D02 YT21','(01) 643 9500'),(8,'David','Robert Jones','1947-01-08','St. Vincent\'s University Hospital, Elm Park, Merrion Rd, Dublin 4','(01) 221 4000'),(9,'James','Paul McCartney','1942-06-18','Adelaide Rd, Saint Kevin\'s, Dublin 2','(01) 664 4600'),(10,'Madonna','Louise Ciccone','1958-08-16','Cooley Rd, Crumlin, Dublin 12','(01) 409 6100'),(11,'Taylor','Alison Swift','1989-12-13','Parnell Sq, Rotunda, Dublin 1','(01) 817 1700'),(12,'Beyoncé','Giselle Knowles-Carter','1981-09-04','Alfie Byrne Rd, North Dock, Dublin 3','(01) 855 1595'),(13,'Shawn','Corey Carter','1969-12-04','Beaumont Rd, Beaumont, Dublin 9','(01) 809 3000'),(14,'Katheryn','Elizabeth Hudson','1984-10-25','Edenmore, Dublin','(01) 877 4900'),(15,'Alicia','Augello Cook','1981-01-25','Strand Rd, Burrow, Portmarnock, Co. Dublin, D13 V2X7','(01) 846 0611'),(16,'Michael','Joseph Jackson','1958-08-29','Grove Rd, Malahide, Co. Dublin','(01) 845 0000'),(17,'Stevland','Hardaway Morris','1950-05-13','North St, Townparks, Swords, Co. Dublin','(01) 840 4384'),(18,'Mark','Daniel Ronson','1975-09-04','Lispopple Cross, Swords, Mountstuart, Dublin','(01) 813 8511'),(19,'Justin','Drew Bieber','1994-03-01','Church Rd, Cruiserath, Dublin','(01) 827 5600'),(20,'Mariah','Carey','1970-03-27','Blanchardstown, Dublin 15','(01) 822 1356'),(21,'Onika','Tanya Maraj','1982-12-08','Woodlands, Dublin 15','(01) 860 9600'),(22,'Adam','Richard Wiles','1984-01-17','1 Foxborough Rd, Balgaddy, Lucan, Co. Dublin','(01) 621 6747'),(23,'Britney','Jean Spears','1981-12-02','Dodsborough Rd, Lucan, Co. Dublin','(01) 621 9505'),(24,'Andre','Romelle Young','1965-01-18','Backwestonpark, Lucan, Co. Dublin','(01) 621 7300'),(25,'Prince','Rogers Nelson','1958-06-07','Main St, Donaghcumper, Celbridge, Co. Kildare','(01) 628 8400'),(26,'Aretha','Louise Franklin','1942-03-25','Baldonnell Upper, Co. Dublin','(01) 401 6077'),(27,'William','Martin','1949-05-09','Main St, Rathcoole, Co. Dublin','(01) 458 6134'),(28,'Curtis','James Jackson III','1975-07-06','Unit 2, Glebe Yard, Main str, Rathcoole, Co. Dublin','(01) 458 7166'),(29,'Gwen','Renée Stefani','1969-10-03','Frank Cox Park, Rathcoole, Co. Dublin','087 217 5420'),(30,'Ai','Weiwei','1957-05-18','Coolmine, Saggart, Co. Dublin','087 222 0033'),(31,'Dwayne','Michael Carter Jr.','1982-09-27','Slade Valley, Lugg, Rathcoole, Co. Dublin','086 248 6971'),(32,'Andy','Warhol','1928-08-06','Glenaraneen , Brittas, Blessington Road, Raheen, Co. Dublin','(01) 458 3567'),(33,'Salvador','Domingo Felipe Jacinto Dalí i Domènech','1904-05-11','Raheen House, Brittas, Co. Dublin','(01) 458 2640'),(34,'Elton','Hercules John','1947-03-25','Ballinascorney Lower, Dublin 24','087 395 2548'),(35,'Peter','Gene Hernandez','1985-10-08','mountpelier , bohernabreena , tallaght , dublin24, bohernabreena, Dublin 24, D24WK60','(01) 462 7980'),(36,'Leonardo','di ser Piero da Vinci','1452-04-15','Kilakee House, Kilakee Road, Jamestown, Dublin 16','(01) 493 1034'),(37,'Henri-Robert-Marcel','Duchamp','1887-07-28','Mount Venus Nursery, Mutton Ln, Kilmashogue, Dublin, Dublin 16','(01) 493 3813'),(38,'Tramar','Lacel Dillard','1979-09-16','9, Leopardstown Shopping Centre, Ballyogan Rd, Sandyford, Dublin 18','076 108 7880'),(39,'Charles','Otto','1991-12-02','Leopardstown Valley Shopping Centre, Leopardstown Valley Shopping centre Ballygan Road, Ballyogan Rd, Sandyford, Dublin 18','(01) 207 6780'),(40,'Kelly','Brianne Clarkson','1982-04-24','Churchview Rd, Kilbogget, Ballybrack, Co. Dublin','1890 928 469'),(41,'Jean-Michel','Basquiat','1960-12-22','Cherrywood Park, Cherrywood, Dublin, 18','(01) 204 4014'),(42,'Paul','Jackson Pollock','1912-01-28','Loughlinstown, Co. Dublin','(01) 282 5800'),(43,'Elena','Jane','1986-12-30','Enniskerry Rd, Glenamuck South, Dublin','(01) 295 5643'),(44,'Whitney','Elizabeth Houston','1963-08-09','Glebe, Jamestown, Stepaside, Co. Dublin','(01) 295 3326'),(45,'Céline','Marie Claudette Dion','1968-03-30','Pine Forest Road, Cruagh, Glencullen, Co. Dublin','087 218 0081'),(46,'Usher','Raymond IV','1978-10-14','Aghfarrell, Brittas, Co. Dublin','087 229 1265'),(47,'Christopher','Maurice','1989-05-05','Johnstown, Naas, Co. Kildare','(045) 882 670'),(48,'John','R. \"Johnny\" Cash','1932-02-26','Dublin Rd, Maudlings, Naas, Co. Kildare','(01) 686 9460'),(49,'Georgios','Kyriacos Panayiotou','1963-06-25','Woodstock House, Main St, Kilmacullagh, Newtown Mount Kennedy, Co. Wicklow','(01) 287 3699'),(50,'Pierre','David Guetta','1967-11-07','Colliga, Co. Wicklow','(045) 404 711'),(51,'Donald','John Trump','1946-06-14','Dublin Rd, Shamrocklodge, Athy, Co. Kildare','(059) 864 0666');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-22  4:46:12
