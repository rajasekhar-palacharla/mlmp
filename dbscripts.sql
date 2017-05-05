CREATE TABLE `webuser` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_EMAIL_ID` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_CONTACT_NO` bigint(20) NOT NULL,
  `USER_ROLE` varchar(20) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

insertion query
--------------
# USER_ID, USER_EMAIL_ID, USER_PASSWORD, USER_CONTACT_NO, USER_ROLE
'3', 'john@gmail.com', 'am9objEyMzQ=', '9012346745', 'Admin'
