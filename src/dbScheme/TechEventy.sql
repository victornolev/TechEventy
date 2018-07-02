-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: techeventdb
-- ------------------------------------------------------
-- Server version	5.5.5-10.2.13-MariaDB

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (22,'Competition'),(1,'Conference'),(21,'Еntrepreneurship');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `location` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entrance_fee` decimal(6,0) DEFAULT NULL,
  `url_of_event` varchar(600) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_path` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'The Crypto CONF 2018','NEW TECHNOLOGY IS NOT THE NEW TREND. JOIN US TO LEARN WHY. Main topics are: BLOCKCHAIN TECHNOLOGY, CRYPTOCURRENCIES, ICOs, P2P, DECENTRALIZED ECONOMY, INVESTMENTS & SPECULATIONS, THE FUTURE OF MONEY AND WEALTH','2018-05-11 09:00:00','Sofia, Bulgaria | Inter Expo Center, Boulevard \"Tsarigradsko shose\" 147, 1784 7-mi 11-ti kilometar, Sofia',NULL,'http://cryptocurrency.business-storm.com/','cryptoConf2018.jpg'),(211,'Astea Conference: Revolutions','Бъдещето на езиците за програмиране, Програмиране за графични ускорители, За функционалното програмиране и конкурентния свят, Доволен тестер - здрав проект, Documentation-Driven Development, Fun with SVG, Civic Hacking, ','2018-05-12 10:00:00','Sofia, Bulgaria | Intere Expo Center',0,'http://conference.astea.solutions','asteaConf.jpg'),(212,'Наука на Борда: Невронни Мрежи и Блокчейн Технологии','Какво обединява алгоритъма за разпознаване на лицата на приятелите ни в социалните мрежи и идентифицирането на човешки глас от мобилния ни телефон? Как Google „знае“ какво търсим преди да сме формулирали въпроса си докрай? А как „знае“ къде се намираме с по-голяма точност от нас самите? Нашият гост, Звездин, ще ни разкаже на достъпен език за технологията, която стои зад тези чудеса на съвремието, а именно един интересен вариант на изкуствения интелект: НЕВРОННИТЕ МРЕЖИ. Те са вдъхновени от човешкия мозък и също като него са способни да се САМООБУЧАВАТ. Ще разберем повече и за така нашумелите КРИПТОВАЛУТИ и как с помощта на невронни мрежи могат да се правят прогнози за стойността им на базата на общодостъпна информация. „Оказа се, че като се анализира тази публична информация (…с подхода, фокус на научния проект на Звездин…), се постигат около 5 пъти по-малко грешки при прогнози спрямо по-стандартния подход – анализ на пазара“, казва младият учен. Звездин Бесарабов е лауреат на националния конкурс Млади таланти, носител на специална награда от международния панаир на науката и иновациите Intel ISEF, наскоро отличен и с Harvard Prize Book Award 2018, а също и най-младият предподавател в SoftUni. Заповядайте на борда за глътка наука в лятната понеделнишка вечер на 2 юли, от 18:30ч. Очакваме ви!','2018-07-02 10:00:00','Sofia, Bulgaria | bar Abordage 22 ulitsa \"Veslets\"',0,'https://www.eventbrite.com/e/47141617848?aff=ebdssbdestsearch','scienceBoard.jpg'),(213,'ClimateLaunchpad Bulgaria National Finals - 4th Edition!','Cleantech Bulgaria има удоволствието да Ви покани да станете част от Националния финал на най-мащабния международен конкурс за стартиращи \"зелени\" бизнес идеи ClimateLaunchpad!','2018-07-05 14:00:00','Sofia, Bulgaria | 111B Tsarigradsko Shose Blvd., Sofia Tech Park, building Business Incubator, Ground floor',0,'https://www.eventbrite.com/e/climatelaunchpad-bulgaria-national-finals-4th-edition-tickets-47420207116?aff=ebdssbdestsearch','climateLaunch.jpg'),(216,'Startup From The Bottom','На 07.07.2018 Иноватор ще бъде домакин на еднодневна конференция под надслов Startup from The Bottom, ориентирана към бизнес средите, стартъп общността и хората, които желаят да стартират свой собствен бизнес или да станат част от иновативен проект. Място на събитието ще бъде залата за събития на Иноватор във Варна. Основната цел на изданието е да насърчи предприемаческото и новаторско мислене, представяйки успешни бизнес модели, споделяне на опит и ноу-хау.  ','2018-07-07 09:30:00','Varna, Bulgaria | Sofia 1 street',15,'https://innovator.bg/event/startup-from-the-bottom-2018/','startupBottom.jpg'),(220,'Hackathon for Machine Learning – The First Online DATAthon','През февруари ще се състои първият в света онлайн Data Science Hackathon – #Datathon2018! Всички с познания в областта Data Science ще могат да изберат Machine Learning казус за свое предизвикателство и ще се състезават на международно ниво online или offline в Софийски университет “Св. Климент Охридски”. В рамките на 48 часа участниците ще експериментират с данни, достъпни само вътрешно във водещи компаниите, допитвайки се до световно признати ментори от Австрия, Индия, България, Германия, Хърватска и Катар.  ','2018-02-10 17:30:00','Sofia University and online',NULL,'https://www.datasciencesociety.net/datathon/?utm_source=IT%20Events&utm_medium=Website&utm_campaign=Dev.bg#registration','datathon.jpg'),(221,'Paysafe хакатон 2018','Paysafe България ще проведе първия си хакатон на 31 март и 1 април. Хакатонът е отворен за всички ИТ инженери със страст към технологиите и програмирането. Участието е безплатно и изисква предварителна регистрация тук.\nХакатонът ще се проведе в Capital Fort, една от най-модерните бизнес сгради в София. Участниците ще трябва да се справят с три основни предизвикателства с фокус върху: kови начини за извършване на транзакции през мобилни устройства. fблачни инфраструктура и инструменти. ,азплащания в социални мрежи през приложения за комуникация, инструменти за сътрудничество иливидеоигри. До 20 отбора ще могат да се включат в събитието. Всеки от тях ще се състои от най-много четирима души, които трябва да се регистрират заедно. Ще се допуска и индивидуално участие, при което съответният човек ще бъде сам в отбор. Всички участници ще работят на собствени лаптопи. На края на втория ден от хакатона всеки екип ще представи работата си пред жури. Наградите са 5 000 евро за победителите, 3 000 евро за второ място и 1 500 евро за трето място. Всеки участник ще получи подарък от Paysafe.\n','2018-03-31 08:30:00','Sofia, Bulgaria | Capital Fort',0,'https://www.paysafe.com/hackathonsofia/','paySafeHack.jpg'),(222,'AngelHack Sofia Hackathon 2018','\nAngelHack Challenge: Challenge yourself and your entrepreneurial spirit. Make something innovative without limits, something that brings positive change to the world, even something that solves a small problem. It’s that simple. Code For A Cause Impact Award Challenge: Build technology that solves a social or environmental problem and positively impacts your local community. Code For A Cause Impact Award Prize: One Impact Award will be given out at each event. At the end of the Global Hackathon Series, the top Impact Award projects will be chosen by an expert judging panel including; Chan Zuckerberg, Chan Zuckerberg Initiative; and more. These top five teams will receive an official invite into the HACKcelerator. Challenge: Get ready for Call for Code with this preliminary challenge to improve logistics based on traffic and weather activity. Create an application that helps build resilient communities, and safeguards the health and well-being of individuals and institutions. Use the IBM Code Patterns http://ibm.biz/AHIBMC4C for inspiration to kickstart your solutions or build your idea and services provided by the IBM Cloud. All ages, genders, and skill levels are welcome. Come solo or in a team of up to five, and spend the weekend learning new skills, meeting your local tech community and tech sponsors, enjoying free food, and more.\nOur attendees typically consist of developers looking to improve their skills or expand their horizons, students, designers of all skill-sets, and serious entrepreneurs that can add value to teams. Bring your ideas and let’s go!\nWant to get involved in another way? We’re always open to chat with potential sponsors, mentors, and judges! Just email info (at) angelhack.com to get connected\n','2018-07-21 09:00:00','Sofia, Bulgaria | Puzl CowOrKing Cherni Vrah 47A',0,'https://www.eventbrite.com/e/angelhack-sofia-hackathon-2018-tickets-45922856500?aff=erelexpmlt','angelHack.jpg');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_categories`
--

DROP TABLE IF EXISTS `events_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_categories` (
  `category_id` int(11) unsigned NOT NULL,
  `event_id` int(11) unsigned NOT NULL,
  KEY `fk_events_idx` (`event_id`),
  KEY `fk_category_idx` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_event` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_categories`
--

LOCK TABLES `events_categories` WRITE;
/*!40000 ALTER TABLE `events_categories` DISABLE KEYS */;
INSERT INTO `events_categories` VALUES (1,1),(1,211),(1,212),(21,213),(21,216),(22,220),(22,221),(22,222);
/*!40000 ALTER TABLE `events_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_organisers`
--

DROP TABLE IF EXISTS `events_organisers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_organisers` (
  `events_id` int(11) unsigned NOT NULL,
  `organisers_id` int(11) unsigned NOT NULL,
  KEY `fk_events_id_idx` (`events_id`),
  KEY `fk_organisators_id_idx` (`organisers_id`),
  CONSTRAINT `fk_events` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_organisers` FOREIGN KEY (`organisers_id`) REFERENCES `organisers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_organisers`
--

LOCK TABLES `events_organisers` WRITE;
/*!40000 ALTER TABLE `events_organisers` DISABLE KEYS */;
INSERT INTO `events_organisers` VALUES (1,1),(211,22),(212,23),(212,24),(213,25),(216,28),(220,29),(221,30),(222,31);
/*!40000 ALTER TABLE `events_organisers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organisers`
--

DROP TABLE IF EXISTS `organisers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organisers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) CHARACTER SET utf8 NOT NULL,
  `description` text CHARACTER SET utf8 DEFAULT NULL,
  `site_link` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `image_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organisers`
--

LOCK TABLES `organisers` WRITE;
/*!40000 ALTER TABLE `organisers` DISABLE KEYS */;
INSERT INTO `organisers` VALUES (1,'The Business Storm Global','The Business Storm is a new-millennium, boutique business network that aims to disrupt the Business World by combining three flammable ingredients: The Tomorrow’s Business Knowledge, Unique Emotional Experiences and Disruptive Business Ideas. ','http://www.business-storm.com/','businessStorm.jpg'),(22,'Astea Solutions','Astea Solutions AD was formed to leverage its founders’ strong relationship with Sofia University’s Faculty for Mathematics and Informatics (FMI) with access to exceptionally trained and talented software developers working with the most advanced technologies. Bulgaria is today globally recognized as a premiere source of highly qualified technical talent.','https://asteasolutions.com/','asteaSolutions.jpg'),(23,'Българска Наука','След стартирането на списание \"Българска Наука\" през зимата на 2005/2006 г., то успя да спечели читатели и ентусиасти, които да изпращат свои материали и да предлагат различни идеи за подобряването на самото издание. Целта, с която стартира и продължи да се развива, е то да се разпространява безплатно в интернет, да осигури възможно най-добрата, интересна и подробна информация относно науката, като достъпно я предоставя за възможно най-много потребители на интернет.','https://nauka.bg/','bgScience.jpg'),(24,'Клуб Млади Таланти','Клуб Млади Таланти (КМТ) е неправителствена организация, създадена през 2005 година от приятели и ентусиасти, които искат да подкрепят, подпомагат и развиват научните интереси и талантите на младите хора.','http://www.cys.bg/','cys.jpg'),(25,'Cleantech Bulgaria','Cleantech Bulgaria is a business network, which focuses on clean technologies and sustainable growth. We bring together SMEs and large enterprises, experts, NGOs, entrepreneurs, governmental and international institutions.','http://cleantech.bg/','cleanTech.jpg'),(28,'Innovator','COWORKING SPACE – MAKERSPACE – EVENT HALL – TRAINING CENTER – COFFICE – MANY MORE. Innovator is the best place in Varna for peer-to-peer learning and knowledge sharing. We are part of the Global Maker Movement and aim to form a constructive, modern environment that will stimulate the entrepreneurial and creative thinking.','https://innovator.bg/','innovator.jpg'),(29,'Data Science Society','Организатор: Data Science Society е доброволческа общност от експерти в обработкатa, моделирането и анализа на данни, които за последните 3 години популяризират сферата Data Science. Целта на общността е да насърчи иновацията и предприемачеството във всички сфери на работата с данни чрез множество инициативи. Сред тях са Workshop-и, дългосрочни проекти с практическа насоченост към разработването на Machine Learning модели и участия в международни конференции. През 2017 година Data Science Society е инициатор на първото по рода си състезание за Централна и Източна Европа – Datathon, практическо образователно предизвикателство, свързано с обработка и анализ на данни.','https://www.datasciencesociety.net','dataScience.jpg'),(30,'Paysafe','Основната цел на компанията е да позволи на бизнесът и потребителите да се свързват и осъществяват транзакции безпроблемно като използват техните водещи за индустрията възможности в обработването на разплащания, дигитални портфейли и онлайн парични решения. През 2016 в Пейсейф България са се провели около 3000 вътрешни и външни обучения. Офисът в София най-големият за компанията майка, която има центрове и във Виена, Лондон, Монреал, Калифорния и др.','https://www.paysafe.com/en/','paysafe.jpg'),(31,'AngelHack','AngelHack, a female-owned, female-majority company, is the world’s largest and most diverse global hacker community, helping to drive open innovation of tech products, platforms and brands with extraordinary smarts, scale and speed.','https://angelhack.com','angelHackLogo.jpg');
/*!40000 ALTER TABLE `organisers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET latin1 NOT NULL,
  `password` varchar(61) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (9,NULL,NULL,NULL,'jajaja','$2a$10$CKo4t0PXdEX34AtS0A5NZOGky6c28LENzxKlgEmMjM0tKVBwHRcU.'),(16,'Zhoro','Zhorov','zhorkata@gmail.com','zhorkata','$2a$10$Qemautt5.ZeUfPWZyYVEguHpZBlyp0gnXpi9c6DjwGCBnc/X9MVS6');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-02 19:04:29
