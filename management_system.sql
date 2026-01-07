-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2025 at 12:31 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `management system`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `Surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `age`, `Surname`) VALUES
(1, 'Benedict', 30, NULL),
(2, 'Ben', 30, NULL),
(3, 'Ben', 30, NULL),
(4, 'Ben', 30, NULL),
(5, 'Ben', 30, NULL),
(6, 'Ben', 30, NULL),
(7, 'Ben', 30, NULL),
(8, 'Ben', 30, NULL),
(9, 'Seilane', 30, NULL),
(10, 'Benedict', 30, NULL),
(11, 'Ben', 30, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `policies`
--

CREATE TABLE `policies` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `policy_type` varchar(100) DEFAULT NULL,
  `coverage_amount` decimal(10,2) DEFAULT NULL,
  `premium_amount` decimal(10,2) DEFAULT NULL,
  `customer_i` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `policies`
--

INSERT INTO `policies` (`id`, `customer_id`, `policy_type`, `coverage_amount`, `premium_amount`, `customer_i`) VALUES
(1, 1, 'Life', 2300.00, 2400.00, NULL),
(2, 2, 'Life', 100.00, 200.00, NULL),
(3, 3, 'Life', 22.00, 33.00, NULL),
(4, 4, 'Life', 444.00, 555.00, NULL),
(5, 5, 'Life', 22.00, 23.00, NULL),
(6, 6, 'Life', 222.00, 3333.00, NULL),
(7, 7, 'Life', 20202020.00, 2202.00, NULL),
(8, 8, 'Life', 2400.00, 2500.00, NULL),
(9, 9, 'Life', 2300.00, 2400.00, NULL),
(10, 10, 'Life', 23459.00, 45.00, NULL),
(11, 11, 'Health', 111.00, 112.00, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `policies`
--
ALTER TABLE `policies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_i` (`customer_i`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `policies`
--
ALTER TABLE `policies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `policies`
--
ALTER TABLE `policies`
  ADD CONSTRAINT `policies_ibfk_1` FOREIGN KEY (`customer_i`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
