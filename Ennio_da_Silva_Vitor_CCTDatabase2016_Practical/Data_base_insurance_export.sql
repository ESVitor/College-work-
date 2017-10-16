-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: insurance
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

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
-- Table structure for table `bills_not_paid`
--

DROP TABLE IF EXISTS `bills_not_paid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bills_not_paid` (
  `id_bills_not_paid` int(11) NOT NULL AUTO_INCREMENT,
  `bills_name` varchar(50) DEFAULT NULL,
  `bill_description` varchar(50) DEFAULT NULL,
  `bill_date` date DEFAULT NULL,
  `bill_time` time DEFAULT NULL,
  `bills_expired` varchar(45) DEFAULT NULL,
  `data_analyst_id_data_analyst` int(11) NOT NULL,
  PRIMARY KEY (`id_bills_not_paid`),
  KEY `fk_bills_not_paid_data_analyist1_idx` (`data_analyst_id_data_analyst`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills_not_paid`
--

LOCK TABLES `bills_not_paid` WRITE;
/*!40000 ALTER TABLE `bills_not_paid` DISABLE KEYS */;
INSERT INTO `bills_not_paid` VALUES (1,'comprehensive','based in Dublin','2015-01-01','00:00:00','2015-12-31',12345),(2,'Third part, fire and theft','based in Dublin','2015-02-02','00:00:00','2016-01-02',12345),(3,'Third part','based in Dublin','2015-03-02','00:00:00','2016-02-02',12345),(4,'licence','based in Dublin','2015-04-02','00:00:00','2016-03-02',12345),(5,'Profession and use','based in Dublin','2015-05-02','00:00:00','2016-04-02',12345),(6,'comprehensive','based in Dublin','2015-01-01','00:00:00','2015-12-31',12345),(7,'Third part, fire and theft','based in Dublin','2015-02-02','00:00:00','2016-01-02',12345),(8,'Third part','based in Dublin','2015-03-02','00:00:00','2016-02-02',12345),(9,'licence','based in Dublin','2015-04-02','00:00:00','2016-03-02',12345),(10,'Profession and use','based in Dublin','2015-05-02','00:00:00','2016-04-02',12345),(11,'comprehensive','based in Dublin','2015-01-01','00:00:00','2015-12-31',12345),(12,'Third part, fire and theft','based in Dublin','2015-02-02','00:00:00','2016-01-02',12345),(13,'Third part','based in Dublin','2015-03-02','00:00:00','2016-02-02',12345),(14,'licence','based in Dublin','2015-04-02','00:00:00','2016-03-02',12345),(15,'Profession and use','based in Dublin','2015-05-02','00:00:00','2016-04-02',12345),(16,'comprehensive','based in Dublin','2015-01-01','00:00:00','2015-12-31',12345),(17,'Third part, fire and theft','based in Dublin','2015-02-02','00:00:00','2016-01-02',12345),(18,'Third part','based in Dublin','2015-03-02','00:00:00','2016-02-02',12345),(19,'licence','based in Dublin','2015-04-02','00:00:00','2016-03-02',12345),(20,'Profession and use','based in Dublin','2015-05-02','00:00:00','2016-04-02',12345);
/*!40000 ALTER TABLE `bills_not_paid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `id_car` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(15) DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  `engine` varchar(3) DEFAULT NULL,
  `registration` varchar(10) DEFAULT NULL,
  `maker` varchar(45) DEFAULT NULL,
  `company_id_company` int(11) NOT NULL,
  `policy_id_policy` int(11) NOT NULL,
  PRIMARY KEY (`id_car`),
  KEY `fk_cars_company1_idx` (`company_id_company`),
  KEY `fk_cars_policy1_idx` (`policy_id_policy`),
  CONSTRAINT `fk_cars_company1` FOREIGN KEY (`company_id_company`) REFERENCES `company` (`id_company`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cars_policy1` FOREIGN KEY (`policy_id_policy`) REFERENCES `policy` (`id_policy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'Aldi r8',2013,'5.2','15D0000','Aldi',1,1),(2,'Polo',2014,'2.0','15D0001','Volkswagen',2,2),(3,'Clio',2015,'1.6','15D0002','Renault',3,3),(4,'Golf',2015,'1.4','15D0003','Volkswagen',4,4),(5,'Megane',2013,'2.0','15D0004','Renault',5,5),(6,'Aldi r8',2013,'5.2','15D0005','Aldi',1,6),(7,'Polo',2014,'2.0','15D0006','Volkswagen',2,7),(8,'Clio',2015,'1.6','15D0007','Renault',3,8),(9,'Golf',2015,'1.4','15D0008','Volkswagen',4,9),(10,'Megane',2013,'2.0','15D0009','Renault',5,10),(11,'Aldi r8',2013,'5.2','15D0010','Aldi',1,11),(12,'Polo',2014,'2.0','15D0011','Volkswagen',2,12),(13,'Clio',2015,'1.6','15D0012','Renault',3,13),(14,'Golf',2015,'1.4','15D0013','Volkswagen',4,14),(15,'Megane',2013,'2.0','15D0014','Renault',5,15),(16,'Aldi r8',2013,'5.2','15D0015','Aldi',1,16),(17,'Polo',2014,'2.0','15D0016','Volkswagen',2,17),(18,'Clio',2015,'1.6','15D0017','Renault',3,18),(19,'Golf',2015,'1.4','15D0018','Volkswagen',4,19),(20,'Megane',2013,'2.0','15D0019','Renault',5,20),(21,'Aldi r8',2013,'5.2','15D0020','Aldi',1,21),(22,'Polo',2014,'2.0','15D0021','Volkswagen',2,22),(23,'Clio',2015,'1.6','15D0022','Renault',3,23),(24,'Golf',2015,'1.4','15D0023','Volkswagen',4,24),(25,'Megane',2013,'2.0','15D0024','Renault',5,25),(26,'Aldi r8',2013,'5.2','15D0025','Aldi',1,26),(27,'Polo',2014,'2.0','15D0026','Volkswagen',2,27),(28,'Clio',2015,'1.6','15D0027','Renault',3,28),(29,'Golf',2015,'1.4','15D0028','Volkswagen',4,29),(30,'Megane',2013,'2.0','15D0029','Renault',5,30),(31,'Aldi r8',2013,'5.2','15D0030','Aldi',1,31),(32,'Polo',2014,'2.0','15D0031','Volkswagen',2,32),(33,'Clio',2015,'1.6','15D0032','Renault',3,33),(34,'Golf',2015,'1.4','15D0033','Volkswagen',4,34),(35,'Megane',2013,'2.0','15D0034','Renault',5,35),(36,'Aldi r8',2013,'5.2','15D0035','Aldi',1,36),(37,'Polo',2014,'2.0','15D0036','Volkswagen',2,37),(38,'Clio',2015,'1.6','15D0037','Renault',3,38),(39,'Golf',2015,'1.4','15D0038','Volkswagen',4,39),(40,'Megane',2013,'2.0','15D0039','Renault',5,40),(41,'Aldi r8',2013,'5.2','15D0040','Aldi',1,41),(42,'Polo',2014,'2.0','15D0041','Volkswagen',2,42),(43,'Clio',2015,'1.6','15D0042','Renault',3,43),(44,'Golf',2015,'1.4','15D0043','Volkswagen',4,44),(45,'Megane',2013,'2.0','15D0044','Renault',5,45),(46,'Aldi r8',2013,'5.2','15D0045','Aldi',1,46),(47,'Polo',2014,'2.0','15D0046','Volkswagen',2,47),(48,'Clio',2015,'1.6','15D0047','Renault',3,48),(49,'Golf',2015,'1.4','15D0048','Volkswagen',4,49),(50,'Megane',2013,'2.0','15D0049','Renault',5,50),(51,'Megane',2013,'2.0','15D0050','Renault',1,51);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id_company` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_company`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'AXA Insurance','Wolfe Tone House, Wolfe Tone St, North City, Dublin 1','(01) 872 6444','Dublin','City Branch'),(2,'AXA Insurance','Apartment 3, Richmond Rd, Drumcondra, Dublin 3','(01) 810 1011','Dublin','Fairview Branch'),(3,'AXA Insurance','Unit 4 Blanchardstown Plaza, Main Street, Blanchardstown, Dublin 15','(01) 817 9733','Dublin','Blanchardstown Branch'),(4,'AXA Insurance','12 Long Mile Rd, Walkinstown, Dublin 12','(01) 450 8885','Dublin','Long Mile Road Branch'),(5,'AXA Insurance','1b, Nutgrove Shopping Centre, Nutgrove Way, Rathfarnham, Dublin 14','(01) 494 8055','Dublin','Nutgrove Branch');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Abraham','Lincoln','1809-02-12','9 The drive, Tallaght, Dublin 24','0877035958'),(2,'Kanye','Omari West','1977-06-08','Apartment 3, Shelbourne Rd, Dublin 4','0877035958'),(3,'Aubrey','Drake Graham','1986-10-24','4 Pembroke Rd, Dublin 4','0877035958'),(4,'Marshall','Bruce Mathers III','1972-10-17','92 Baggot Street Lower, Grand Canal Dock, Dublin 2, DO2 KV77','0877035958'),(5,'Robyn','Rihanna Fenty','1988-02-20','4 Herbert Road, Dublin 4','0877035958'),(6,'Adele','Laurie Blue Adkins','1988-05-05','4 Simmonscourt Rd, Dublin 4, D04 A9K8','0877035958'),(7,'Stefani','Joanne Angelina Germanotta','1986-03-28','Cardiff Ln, Sir John Rogersons Quay, Grand Canal Dock, Dublin 2, D02 YT21','(01) 643 9500'),(8,'David','Robert Jones','1947-01-08','St. Vincent\'s University Hospital, Elm Park, Merrion Rd, Dublin 4','(01) 221 4000'),(9,'James','Paul McCartney','1942-06-18','Adelaide Rd, Saint Kevin\'s, Dublin 2','(01) 664 4600'),(10,'Madonna','Louise Ciccone','1958-08-16','Cooley Rd, Crumlin, Dublin 12','(01) 409 6100'),(11,'Taylor','Alison Swift','1989-12-13','Parnell Sq, Rotunda, Dublin 1','(01) 817 1700'),(12,'Beyoncé','Giselle Knowles-Carter','1981-09-04','Alfie Byrne Rd, North Dock, Dublin 3','(01) 855 1595'),(13,'Shawn','Corey Carter','1969-12-04','Beaumont Rd, Beaumont, Dublin 9','(01) 809 3000'),(14,'Katheryn','Elizabeth Hudson','1984-10-25','Edenmore, Dublin','(01) 877 4900'),(15,'Alicia','Augello Cook','1981-01-25','Strand Rd, Burrow, Portmarnock, Co. Dublin, D13 V2X7','(01) 846 0611'),(16,'Michael','Joseph Jackson','1958-08-29','Grove Rd, Malahide, Co. Dublin','(01) 845 0000'),(17,'Stevland','Hardaway Morris','1950-05-13','North St, Townparks, Swords, Co. Dublin','(01) 840 4384'),(18,'Mark','Daniel Ronson','1975-09-04','Lispopple Cross, Swords, Mountstuart, Dublin','(01) 813 8511'),(19,'Justin','Drew Bieber','1994-03-01','Church Rd, Cruiserath, Dublin','(01) 827 5600'),(20,'Mariah','Carey','1970-03-27','Blanchardstown, Dublin 15','(01) 822 1356'),(21,'Onika','Tanya Maraj','1982-12-08','Woodlands, Dublin 15','(01) 860 9600'),(22,'Adam','Richard Wiles','1984-01-17','1 Foxborough Rd, Balgaddy, Lucan, Co. Dublin','(01) 621 6747'),(23,'Britney','Jean Spears','1981-12-02','Dodsborough Rd, Lucan, Co. Dublin','(01) 621 9505'),(24,'Andre','Romelle Young','1965-01-18','Backwestonpark, Lucan, Co. Dublin','(01) 621 7300'),(25,'Prince','Rogers Nelson','1958-06-07','Main St, Donaghcumper, Celbridge, Co. Kildare','(01) 628 8400'),(26,'Aretha','Louise Franklin','1942-03-25','Baldonnell Upper, Co. Dublin','(01) 401 6077'),(27,'William','Martin','1949-05-09','Main St, Rathcoole, Co. Dublin','(01) 458 6134'),(28,'Curtis','James Jackson III','1975-07-06','Unit 2, Glebe Yard, Main str, Rathcoole, Co. Dublin','(01) 458 7166'),(29,'Gwen','Renée Stefani','1969-10-03','Frank Cox Park, Rathcoole, Co. Dublin','087 217 5420'),(30,'Ai','Weiwei','1957-05-18','Coolmine, Saggart, Co. Dublin','087 222 0033'),(31,'Dwayne','Michael Carter Jr.','1982-09-27','Slade Valley, Lugg, Rathcoole, Co. Dublin','086 248 6971'),(32,'Andy','Warhol','1928-08-06','Glenaraneen , Brittas, Blessington Road, Raheen, Co. Dublin','(01) 458 3567'),(33,'Salvador','Domingo Felipe Jacinto Dalí i Domènech','1904-05-11','Raheen House, Brittas, Co. Dublin','(01) 458 2640'),(34,'Elton','Hercules John','1947-03-25','Ballinascorney Lower, Dublin 24','087 395 2548'),(35,'Peter','Gene Hernandez','1985-10-08','mountpelier , bohernabreena , tallaght , dublin24, bohernabreena, Dublin 24, D24WK60','(01) 462 7980'),(36,'Leonardo','di ser Piero da Vinci','1452-04-15','Kilakee House, Kilakee Road, Jamestown, Dublin 16','(01) 493 1034'),(37,'Henri-Robert-Marcel','Duchamp','1887-07-28','Mount Venus Nursery, Mutton Ln, Kilmashogue, Dublin, Dublin 16','(01) 493 3813'),(38,'Tramar','Lacel Dillard','1979-09-16','9, Leopardstown Shopping Centre, Ballyogan Rd, Sandyford, Dublin 18','076 108 7880'),(39,'Charles','Otto','1991-12-02','Leopardstown Valley Shopping Centre, Leopardstown Valley Shopping centre Ballygan Road, Ballyogan Rd, Sandyford, Dublin 18','(01) 207 6780'),(40,'Kelly','Brianne Clarkson','1982-04-24','Churchview Rd, Kilbogget, Ballybrack, Co. Dublin','1890 928 469'),(41,'Jean-Michel','Basquiat','1960-12-22','Cherrywood Park, Cherrywood, Dublin, 18','(01) 204 4014'),(42,'Paul','Jackson Pollock','1912-01-28','Loughlinstown, Co. Dublin','(01) 282 5800'),(43,'Elena','Jane','1986-12-30','Enniskerry Rd, Glenamuck South, Dublin','(01) 295 5643'),(44,'Whitney','Elizabeth Houston','1963-08-09','Glebe, Jamestown, Stepaside, Co. Dublin','(01) 295 3326'),(45,'Céline','Marie Claudette Dion','1968-03-30','Pine Forest Road, Cruagh, Glencullen, Co. Dublin','087 218 0081'),(46,'Usher','Raymond IV','1978-10-14','Aghfarrell, Brittas, Co. Dublin','087 229 1265'),(47,'Christopher','Maurice','1989-05-05','Johnstown, Naas, Co. Kildare','(045) 882 670'),(48,'John','R. \"Johnny\" Cash','1932-02-26','Dublin Rd, Maudlings, Naas, Co. Kildare','(01) 686 9460'),(49,'Georgios','Kyriacos Panayiotou','1963-06-25','Woodstock House, Main St, Kilmacullagh, Newtown Mount Kennedy, Co. Wicklow','(01) 287 3699'),(50,'Pierre','David Guetta','1967-11-07','Colliga, Co. Wicklow','(045) 404 711'),(51,'Donald','John Trump','1946-06-14','Dublin Rd, Shamrocklodge, Athy, Co. Kildare','(059) 864 0666'),(151,'Ennio','Da Silva Vitor','1986-02-13','17 Manor Green, New Castle, Dublin 22','0877035958');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_car`
--

DROP TABLE IF EXISTS `customer_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_car` (
  `customer_id_customer` int(11) NOT NULL,
  `cars_id_car` int(11) NOT NULL,
  KEY `fk_customers_cars_customer1_idx` (`customer_id_customer`),
  KEY `fk_customers_cars_cars1_idx` (`cars_id_car`),
  CONSTRAINT `fk_customers_cars_cars1` FOREIGN KEY (`cars_id_car`) REFERENCES `car` (`id_car`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customers_cars_customer1` FOREIGN KEY (`customer_id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_car`
--

LOCK TABLES `customer_car` WRITE;
/*!40000 ALTER TABLE `customer_car` DISABLE KEYS */;
INSERT INTO `customer_car` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30),(31,31),(32,32),(33,33),(34,34),(35,35),(36,36),(37,37),(38,38),(39,39),(40,40),(41,41),(42,42),(43,43),(44,44),(45,45),(46,46),(47,47),(48,48),(49,49),(50,50),(51,51);
/*!40000 ALTER TABLE `customer_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_indebt`
--

DROP TABLE IF EXISTS `customer_indebt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_indebt` (
  `customer_id_customer` int(11) NOT NULL,
  `bills_not_paid_id_bills_not_paid` int(11) NOT NULL,
  KEY `fk_customer_indebt_customer_idx` (`customer_id_customer`),
  KEY `fk_customer_indebt_bills_not_paid1_idx` (`bills_not_paid_id_bills_not_paid`),
  CONSTRAINT `fk_customer_indebt_bills_not_paid1` FOREIGN KEY (`bills_not_paid_id_bills_not_paid`) REFERENCES `bills_not_paid` (`id_bills_not_paid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_indebt_customer` FOREIGN KEY (`customer_id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_indebt`
--

LOCK TABLES `customer_indebt` WRITE;
/*!40000 ALTER TABLE `customer_indebt` DISABLE KEYS */;
INSERT INTO `customer_indebt` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20);
/*!40000 ALTER TABLE `customer_indebt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_analyst`
--

DROP TABLE IF EXISTS `data_analyst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_analyst` (
  `id_data_analyst` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(50) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `interest_area` varchar(50) DEFAULT NULL,
  `creation_date` varchar(10) DEFAULT NULL,
  `last_used_date` varchar(10) DEFAULT NULL,
  `e_mail` varchar(50) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_data_analyst`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_analyst`
--

LOCK TABLES `data_analyst` WRITE;
/*!40000 ALTER TABLE `data_analyst` DISABLE KEYS */;
INSERT INTO `data_analyst` VALUES (1,'Christopher','John','read access','2016-11-09','2016-12-22','Christopher@hotmail.com','0177035958'),(2,'Shrader Lawrence','Jennifer ','write access','2016-11-09','2016-12-22','Shrader.Lawrence@hotmail.com','0277035958'),(3,'Jeffrey Hanks','Thomas','update access','2016-11-09','2016-12-22','Jeffrey.Hanks@hotmail.com','0377035958'),(4,'Fiona Roberts','Julia','delete access','2016-11-09','2016-12-22','Fiona.Roberts@hotmail.com','0477035958'),(5,'Kong-sang','Chan','read access','2016-11-09','2016-12-22','Kong.sang@hotmail.com','0577035958');
/*!40000 ALTER TABLE `data_analyst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id_history` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_history`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (2,'Ennio','Da Silva Vitor','1986-02-13','17 Manor Green, New Castle, Dublin 22','0877035958');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy` (
  `id_policy` int(11) NOT NULL AUTO_INCREMENT,
  `policy_description` varchar(50) DEFAULT NULL,
  `policy_date` date DEFAULT NULL,
  `policy_expired_date` date DEFAULT NULL,
  `policy_price` decimal(6,2) DEFAULT NULL,
  `policy_content` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id_policy`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (1,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(2,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(3,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(4,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(5,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(6,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(7,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(8,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(9,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(10,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(11,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(12,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(13,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(14,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(15,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(16,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(17,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(18,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(19,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(20,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(21,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(22,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(23,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(24,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(25,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(26,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(27,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(28,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(29,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(30,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(31,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(32,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(33,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(34,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(35,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(36,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(37,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(38,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(39,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(40,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(41,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(42,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(43,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(44,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(45,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(46,'Comprehensive','2015-01-01','2015-12-31',6500.00,'This is the most expensive type of insurance on the market and covers you for almost every eventuality: any damage done to the vehicle regardless of how it was incurred; life/accident insurance; loss of personal belongings from the car; the cost of a hired car if the insured car is off the road as a result of an accident; windscreen breakage, etc. With more brand new cars on the road than ever before, there has been a notable rise in people taking out comprehensive insurance. A brand new car should be comprehensively insured.'),(47,'Third party, fire and theft','2015-02-02','2016-01-02',3500.00,'This is the most popular form of motor insurance in Ireland. It covers you for loss of the vehicle through fire or theft and for any loss as a result of attempted fire or theft. Damage to property is also covered. There are also optional extras available such as windscreen breakage.'),(48,'Third party','2015-03-02','2016-02-02',2500.00,'This is the minimum cover required by law, but it does have restrictions and limits, leaving you open to substantial loss in the event of an accident. If you are at fault, then only your passengers and the driver and passengers of the other vehicle will be compensated. This type of insurance provides no cover for damage sustained in an accident to your car or if your car is stolen or goes on fire.An insurance company considers many things when calculating an insurance premium. Most premiums are based on basic third party cover with the cost of extras added on. The main thing that will determine the cost of your insurance is what you actually want to be covered for. The following are always taken into account:'),(49,'Licence','2015-04-02','2016-03-02',7500.00,'Whether you are driving on a full or provisional licence makes a huge difference to the cost of your motor insurance premium. You can expect to pay hundreds of euro extra, if you only have a provisional licence.'),(50,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.'),(51,'Profession and use','2015-05-02','2016-04-02',9500.00,'Some professions are considered to be more at risk than others and will have a loading put onto their premium. What the car will actually be used for is also taken into account. A standard policy covers the vehicle for social, domestic and pleasure purposes, but not for the carriage of goods. If the car is being used for business, then a loading will apply. If the car is being used commercially, then an even higher loading will be imposed.');
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-23  7:42:01
