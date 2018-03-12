-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2018 at 06:51 PM
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
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `ADDRESS_ID` bigint(20) NOT NULL,
  `STATE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `COUNTRY` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CITY` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `AREA` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PINCODE` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`ADDRESS_ID`, `STATE`, `COUNTRY`, `CITY`, `AREA`, `PINCODE`) VALUES
(2, 'ss', NULL, 'ss', 'ss', 33);

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
(1, '8416', NULL, NULL),
(2, '392610', NULL, NULL),
(3, '5806', NULL, NULL);

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
(1, 'ITMZ00001', ' liquid fue', NULL, 67, 0.00, 1),
(2, 'ITMZ00002', 'A3Size Sheet Protector', NULL, 0, 0.00, 2),
(3, 'ITMZ00003', 'Battery', NULL, 56, 0.00, 3);

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
(1),
(2),
(3);

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
(1, 2, 1, 68, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(3, 2, 3, 59, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(4, 2, 2, 100, NULL, '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `USER_ID` bigint(20) NOT NULL,
  `COMPANY_NAME` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `OWNERSHIP_TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `PHONE_LAND` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHONE_MOBILE` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GSTIN_NO` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LICENCE_NO` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CIN_NO` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `EMAIL` varchar(80) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`USER_ID`, `COMPANY_NAME`, `first_name`, `last_name`, `TYPE`, `OWNERSHIP_TYPE`, `PHONE_LAND`, `PHONE_MOBILE`, `GSTIN_NO`, `LICENCE_NO`, `CIN_NO`, `STATUS`, `EMAIL`) VALUES
(2, 'ss', 'ss', 'ss', 'Dealer', 'HUF', '333', '333', 'ss', 'ss', 'kp', 'ACTIVE', 'ss');

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
(2, 'kp', 'SDYL0001');

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
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ADDRESS_ID`);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `items_table`
--
ALTER TABLE `items_table`
  MODIFY `items_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `item_seq`
--
ALTER TABLE `item_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user_dealer_items_mapper`
--
ALTER TABLE `user_dealer_items_mapper`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `FK_USER_ADDRESS` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `user_details` (`USER_ID`) ON DELETE CASCADE;

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
