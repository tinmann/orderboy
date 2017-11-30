-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2017 at 06:29 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `orderboy`
--

-- --------------------------------------------------------

--
-- Table structure for table `hsn_table`
--

CREATE TABLE `hsn_table` (
  `id` bigint(20) NOT NULL,
  `hsn_number` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `hsn_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hsn_table`
--

INSERT INTO `hsn_table` (`id`, `hsn_number`, `hsn_name`, `Description`) VALUES
(2, '8416', NULL, NULL),
(3, '392610', NULL, NULL),
(4, '5806', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `items_table`
--

CREATE TABLE `items_table` (
  `items_id` bigint(20) NOT NULL,
  `Item_auto_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` float(8,2) DEFAULT NULL,
  `hsn_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `items_table`
--

INSERT INTO `items_table` (`items_id`, `Item_auto_id`, `name`, `Description`, `quantity`, `price`, `hsn_id`) VALUES
(1, 'ITMZ00002', ' liquid fue', NULL, 2, 0.00, 2),
(2, 'ITMZ00003', 'A3Size Sheet Protector', NULL, 300, 0.00, 3),
(3, 'ITMZ00004', 'Battery', NULL, 6, 0.00, 4);

--
-- Triggers `items_table`
--
DELIMITER $$
CREATE TRIGGER `item_trigger` BEFORE INSERT ON `items_table` FOR EACH ROW BEGIN
  INSERT INTO item_seq() VALUES();
  SET NEW.Item_auto_id = CONCAT('ITMZ', LPAD(LAST_INSERT_ID(), 5,'0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `item_seq`
--

CREATE TABLE `item_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `item_seq`
--

INSERT INTO `item_seq` (`id`) VALUES
(2),
(3),
(4);

-- --------------------------------------------------------

--
-- Table structure for table `user_dealer_items_mapper`
--

CREATE TABLE `user_dealer_items_mapper` (
  `ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `uom` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rate` decimal(7,2) DEFAULT NULL,
  `TOTAL_VALUE` decimal(7,2) DEFAULT NULL,
  `TOTAL_TAXABLE_VALUE` decimal(7,2) DEFAULT NULL,
  `TOTAL_GST` decimal(7,2) DEFAULT NULL,
  `TOTAL_CGST` decimal(7,2) DEFAULT NULL,
  `TOTAL_SGST` decimal(7,2) DEFAULT NULL,
  `TOTAL_IGST` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_dealer_items_mapper`
--

INSERT INTO `user_dealer_items_mapper` (`ID`, `USER_ID`, `items_id`, `quantity`, `uom`, `rate`, `TOTAL_VALUE`, `TOTAL_TAXABLE_VALUE`, `TOTAL_GST`, `TOTAL_CGST`, `TOTAL_SGST`, `TOTAL_IGST`) VALUES
(2, 1, 2, 200, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(4, 1, 1, 1, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(5, 1, 3, 3, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(6, 2, 1, 1, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(7, 2, 2, 100, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(8, 2, 3, 3, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `USER_ID` bigint(20) NOT NULL,
  `first_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `STATUS` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`USER_ID`, `first_name`, `last_name`, `TYPE`, `STATUS`) VALUES
(1, 'sarigam', 'kp', 'Dealer', 'ACTIVE'),
(2, 'newUser', 'kp', 'Dealer', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `user_log`
--

CREATE TABLE `user_log` (
  `USER_ID` bigint(20) NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `login_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_log`
--

INSERT INTO `user_log` (`USER_ID`, `password`, `login_id`) VALUES
(1, 'kp', 'SDYL0001'),
(2, 'kp', 'SDYL0002');

--
-- Triggers `user_log`
--
DELIMITER $$
CREATE TRIGGER `user_trigger` BEFORE INSERT ON `user_log` FOR EACH ROW BEGIN
  INSERT INTO user_seq() VALUES();
  SET NEW.login_id = CONCAT('SDYL', LPAD(LAST_INSERT_ID(), 4,'0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user_retailer_items_mapper`
--

CREATE TABLE `user_retailer_items_mapper` (
  `ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `uom` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rate` decimal(7,2) DEFAULT NULL,
  `TOTAL_VALUE` decimal(7,2) DEFAULT NULL,
  `TOTAL_TAXABLE_VALUE` decimal(7,2) DEFAULT NULL,
  `TOTAL_GST` decimal(7,2) DEFAULT NULL,
  `TOTAL_CGST` decimal(7,2) DEFAULT NULL,
  `TOTAL_SGST` decimal(7,2) DEFAULT NULL,
  `TOTAL_IGST` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_seq`
--

CREATE TABLE `user_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_seq`
--

INSERT INTO `user_seq` (`id`) VALUES
(1),
(2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hsn_table`
--
ALTER TABLE `hsn_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `items_table`
--
ALTER TABLE `items_table`
  ADD PRIMARY KEY (`items_id`),
  ADD UNIQUE KEY `Item_auto_id` (`Item_auto_id`),
  ADD KEY `FK_item_hsn` (`hsn_id`);

--
-- Indexes for table `item_seq`
--
ALTER TABLE `item_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_dealer_items_mapper`
--
ALTER TABLE `user_dealer_items_mapper`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_User` (`USER_ID`),
  ADD KEY `FK_Item` (`items_id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`USER_ID`);

--
-- Indexes for table `user_log`
--
ALTER TABLE `user_log`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `login_id` (`login_id`);

--
-- Indexes for table `user_retailer_items_mapper`
--
ALTER TABLE `user_retailer_items_mapper`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_User_1` (`USER_ID`),
  ADD KEY `FK_Item_1` (`items_id`);

--
-- Indexes for table `user_seq`
--
ALTER TABLE `user_seq`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hsn_table`
--
ALTER TABLE `hsn_table`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `items_table`
--
ALTER TABLE `items_table`
  MODIFY `items_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `item_seq`
--
ALTER TABLE `item_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user_dealer_items_mapper`
--
ALTER TABLE `user_dealer_items_mapper`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_retailer_items_mapper`
--
ALTER TABLE `user_retailer_items_mapper`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_seq`
--
ALTER TABLE `user_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `items_table`
--
ALTER TABLE `items_table`
  ADD CONSTRAINT `FK_item_hsn` FOREIGN KEY (`hsn_id`) REFERENCES `hsn_table` (`id`);

--
-- Constraints for table `user_dealer_items_mapper`
--
ALTER TABLE `user_dealer_items_mapper`
  ADD CONSTRAINT `FK_Item` FOREIGN KEY (`items_id`) REFERENCES `items_table` (`items_id`),
  ADD CONSTRAINT `FK_User` FOREIGN KEY (`USER_ID`) REFERENCES `user_details` (`USER_ID`);

--
-- Constraints for table `user_log`
--
ALTER TABLE `user_log`
  ADD CONSTRAINT `user_log_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_details` (`USER_ID`) ON DELETE CASCADE;

--
-- Constraints for table `user_retailer_items_mapper`
--
ALTER TABLE `user_retailer_items_mapper`
  ADD CONSTRAINT `FK_Item_1` FOREIGN KEY (`items_id`) REFERENCES `items_table` (`items_id`),
  ADD CONSTRAINT `FK_User_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_details` (`USER_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
