-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2022 at 07:22 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db-smart-marriage`
--

-- --------------------------------------------------------

--
-- Table structure for table `m_data`
--

CREATE TABLE `m_data` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `birth` varchar(30) NOT NULL,
  `adress` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `mstatus` varchar(30) NOT NULL,
  `nid` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_data`
--

INSERT INTO `m_data` (`id`, `name`, `birth`, `adress`, `email`, `mstatus`, `nid`) VALUES
(1, 'Alexa', '1995-09-02', 'Rangpur', 'alexta@gmail.com', 'Xaina', '1937289374893'),
(2, 'kamal', '2010-10-12', 'Dhaka', 'abdo@gmail.dz', 'monica', '1839027382944'),
(3, 'Sakib', '2022-03-10', 'rangpur', 'sakib@gmail.com', 'jorina', '183902738293423'),
(4, 'Kazi Maruf', '1990-03-01', 'Dinajpur', 'kazimaruf@gmail.com', 'Purnima ', '1839027382974'),
(5, 'Nishad', 'eE', 'HJHJ', 'mlkmakl', 'malkjia', 'amlarekra'),
(6, 'S N', '1990/12/12', 'Dhaka', 'abc@yahoo.com', 'alice', '38483920394857');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `username`, `email`, `password`) VALUES
(1, 'Shohanur Nishad', 'nishad@gmail.com', '123456'),
(2, 'ABC', 'abc@gmail.com', '123456'),
(3, 'ABC', 'abc123@gmail.com', '123456'),
(4, 'Kazi Maruf', 'kazimaruf@gmail.com', '123456'),
(5, 'Afiah Farzana', 'afiah@gmail.com', '123456'),
(6, 'Afiah Farjana', 'afiah12@gmail.com', '123456'),
(7, 'Sarmin Akter', 'sm@gmail.com', '123456'),
(8, 'afiah farzana', 'afia123@gmail.com', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `m_data`
--
ALTER TABLE `m_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `id_2` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `m_data`
--
ALTER TABLE `m_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
