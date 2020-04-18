-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2020 at 05:18 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hospitalID` int(11) NOT NULL,
  `mohCode` varchar(30) NOT NULL,
  `hospitalName` varchar(50) NOT NULL,
  `emailAddress` varchar(40) NOT NULL,
  `managerName` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `telephoneNo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hospitalID`, `mohCode`, `hospitalName`, `emailAddress`, `managerName`, `address`, `telephoneNo`) VALUES
(1, 'moh1010', 'asiri', 'asiri123@gmail.com', 'mr.fernando', 'colombo15,asiri road, colombo', '0112223334'),
(2, 'moh1011', 'heladiwaHoapital', 'heladiwa321@gmail.com', 'mr.suriyaarachchi', 'akuressa,matara', '0412249776'),
(4, 'moh1017', 'new mohotti', 'newmohotti@gmail.com', 'mr.kariyavasam', 'matara', '0413427557');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hospitalID`),
  ADD UNIQUE KEY `mohCode` (`mohCode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hospitalID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
