-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2020 at 07:51 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `token_number` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `doctor_name` varchar(50) NOT NULL,
  `hospital_name` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `payment_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`token_number`, `username`, `doctor_name`, `hospital_name`, `date`, `payment_type`) VALUES
(1, 'Shalitha', 'Dr. silva', 'Asiri', '2020-04-26', 'cash'),
(3, 'Gamage', 'Dr. Shashi', 'Suwasewana', '2020-05-02', 'online');

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `CardNumber` int(11) NOT NULL,
  `CVV` int(11) NOT NULL,
  `Credits` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`CardNumber`, `CVV`, `Credits`) VALUES
(12345, 123, '5000.00');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `DoctorID` varchar(10) NOT NULL,
  `HospitalName` varchar(50) NOT NULL,
  `DoctorName` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `Specialization` varchar(50) NOT NULL,
  `ArriveTime` time NOT NULL,
  `LeaveTime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`DoctorID`, `HospitalName`, `DoctorName`, `Age`, `Specialization`, `ArriveTime`, `LeaveTime`) VALUES
('D002', 'asiri', 'Jagath', 35, 'Kidney', '07:00:00', '09:00:00');

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
(4, 'moh1017', 'new mohotti', 'newmohotti@gmail.com', 'mr.kariyavasam', 'matara', '0413427557'),
(5, 'moh1017', 'new mohotti', 'newmohotti@gmail.com', 'mr.kariyavasam', 'matara', '0413427557');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `PatientID` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Age` int(11) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `PhoneNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`PatientID`, `Email`, `Username`, `Password`, `Age`, `Address`, `PhoneNo`) VALUES
(0, 'kalana123@gmail.com', 'kalanaej', 'kalana123', 24, 'Madampe', 911),
(1, 'admin@gmail.com', 'dilusha', 'dilusha', 25, 'Matara', 119);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`token_number`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`CardNumber`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`DoctorID`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hospitalID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`PatientID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `token_number` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hospitalID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
