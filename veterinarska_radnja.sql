-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2024 at 10:06 PM
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
-- Database: `veterinarska_radnja`
--

-- --------------------------------------------------------

--
-- Table structure for table `pacijent`
--

CREATE TABLE `pacijent` (
  `PacijentID` bigint(20) NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Vrsta` varchar(255) NOT NULL,
  `Rasa` varchar(255) DEFAULT NULL,
  `GodinaRodjenja` date DEFAULT NULL,
  `ImeVlasnika` varchar(255) DEFAULT NULL,
  `KontaktVlasnika` varchar(255) DEFAULT NULL,
  `VeterinarID` bigint(20) DEFAULT NULL,
  `godina_rodjenja` datetime DEFAULT NULL,
  `ime_vlasnika` varchar(255) DEFAULT NULL,
  `kontakt_vlasnika` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `pacijent`
--

INSERT INTO `pacijent` (`PacijentID`, `Ime`, `Vrsta`, `Rasa`, `GodinaRodjenja`, `ImeVlasnika`, `KontaktVlasnika`, `VeterinarID`, `godina_rodjenja`, `ime_vlasnika`, `kontakt_vlasnika`) VALUES
(2, 'Rexx', 'Pass', 'Labradorr', NULL, NULL, NULL, NULL, '1970-01-01 01:00:02', 'Marko Markoviic', '+3816000001000');

-- --------------------------------------------------------

--
-- Table structure for table `poseta`
--

CREATE TABLE `poseta` (
  `id` bigint(20) NOT NULL,
  `datum` date NOT NULL,
  `veterinar_id` bigint(20) DEFAULT NULL,
  `pacijent_id` bigint(20) DEFAULT NULL,
  `usluge_pružene` text DEFAULT NULL,
  `beleške` text DEFAULT NULL,
  `usluge_pruzene` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Table structure for table `tretman`
--

CREATE TABLE `tretman` (
  `id` bigint(20) NOT NULL,
  `opis` text NOT NULL,
  `cena` decimal(10,2) DEFAULT NULL,
  `trajanje` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Table structure for table `veterinar`
--

CREATE TABLE `veterinar` (
  `id` int(20) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `specijalizacija` varchar(255) DEFAULT NULL,
  `kontakt_informacije` varchar(255) DEFAULT NULL,
  `kontakt` varchar(255) DEFAULT NULL,
  `veterinarid` bigint(20) DEFAULT NULL,
  `specijalnost` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `veterinar`
--

INSERT INTO `veterinar` (`id`, `ime`, `prezime`, `specijalizacija`, `kontakt_informacije`, `kontakt`, `veterinarid`, `specijalnost`) VALUES
(1, 'Markooo', 'Markovicc', NULL, NULL, NULL, NULL, 'Hirurgija');

-- --------------------------------------------------------

--
-- Table structure for table `zakazivanje`
--

CREATE TABLE `zakazivanje` (
  `id` bigint(20) NOT NULL,
  `datum` date NOT NULL,
  `vreme` varchar(20) NOT NULL,
  `vrsta_tretmana` varchar(50) DEFAULT NULL,
  `beleške` text DEFAULT NULL,
  `pacijent_id` bigint(20) DEFAULT NULL,
  `veterinar_id` bigint(20) DEFAULT NULL,
  `pacijent_ime` varchar(255) DEFAULT NULL,
  `veterinar_ime` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pacijent`
--
ALTER TABLE `pacijent`
  ADD PRIMARY KEY (`PacijentID`),
  ADD KEY `VeterinarID` (`VeterinarID`);

--
-- Indexes for table `poseta`
--
ALTER TABLE `poseta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `veterinar_id` (`veterinar_id`),
  ADD KEY `pacijent_id` (`pacijent_id`);

--
-- Indexes for table `tretman`
--
ALTER TABLE `tretman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `veterinar`
--
ALTER TABLE `veterinar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zakazivanje`
--
ALTER TABLE `zakazivanje`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pacijent`
--
ALTER TABLE `pacijent`
  MODIFY `PacijentID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `poseta`
--
ALTER TABLE `poseta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tretman`
--
ALTER TABLE `tretman`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `veterinar`
--
ALTER TABLE `veterinar`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `zakazivanje`
--
ALTER TABLE `zakazivanje`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `poseta`
--
ALTER TABLE `poseta`
  ADD CONSTRAINT `poseta_ibfk_2` FOREIGN KEY (`pacijent_id`) REFERENCES `pacijent` (`PacijentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
