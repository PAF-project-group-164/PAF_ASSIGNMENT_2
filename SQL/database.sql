-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2022 at 08:26 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pafprojecteletricity`
--

-- --------------------------------------------------------

--
--
-- --------------------------------------------------------

--
-- Table structure for table `paymentapi`
--

CREATE TABLE IF NOT EXISTS `paymentapi` (
  `Payment_id` int(6) NOT NULL AUTO_INCREMENT,
  `Payment_customer_id` varchar(200) NOT NULL,
  `Payment_customer_name` varchar(200) NOT NULL,
  `Payment_date` varchar(200) NOT NULL,
  `Payment_amount` varchar(200) NOT NULL,
  `Payment_description` varchar(200) NOT NULL,
  PRIMARY KEY (`Payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
