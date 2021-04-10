-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2021 at 05:07 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_transaksi`
--

CREATE TABLE `tb_detail_transaksi` (
  `id` varchar(11) NOT NULL,
  `id_transaksi` varchar(11) NOT NULL,
  `id_paket` varchar(11) NOT NULL,
  `qty` double NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_transaksi`
--

INSERT INTO `tb_detail_transaksi` (`id`, `id_transaksi`, `id_paket`, `qty`, `keterangan`) VALUES
('1001', 'KTR001', 'KPA001', 2, 'paket milik Annisa 2kg telah diambil'),
('1002', 'KTR001', 'KPA002', 2, 'Paket kania sudah bayar belum diambil'),
('1003', 'KTR003', 'KPA003', 1, 'paket dyah sudah diambil'),
('1004', 'KTR004', 'KPA004', 3, 'Paket Bu Nining, sudah selesai belum diambil dan dibayar');

-- --------------------------------------------------------

--
-- Table structure for table `tb_member`
--

CREATE TABLE `tb_member` (
  `id_member` varchar(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `jenis_kelamin` enum('L','P') NOT NULL,
  `tlp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_member`
--

INSERT INTO `tb_member` (`id_member`, `nama`, `alamat`, `jenis_kelamin`, `tlp`) VALUES
('KME001', 'Annisa', 'Kp. Banusari', 'P', '0873786937985'),
('KME002', 'kania', 'Cigorowong', 'P', '08971625436'),
('KME003', 'Dyah Nurul', 'Citunjung', 'P', '08976543214'),
('KME004', 'Nining', 'Perum Pesona Bintang', 'P', '0897651432'),
('KME005', 'Pak Wawan', 'Kp. Babakansari Rt.07/Rw.18', 'L', '089566432178'),
('KME006', 'Amir', 'Kp.Sukamanah Rt.02/Rw.06 Ds.Pangauban', 'L', '089765413226'),
('KME007', 'maranda', 'kp.Galanggang', 'P', '08976541245');

-- --------------------------------------------------------

--
-- Table structure for table `tb_outlet`
--

CREATE TABLE `tb_outlet` (
  `id_outlet` varchar(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `tlp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_outlet`
--

INSERT INTO `tb_outlet` (`id_outlet`, `nama`, `alamat`, `tlp`) VALUES
('KOUT001', 'HomeyLaundry', 'Jl. Batujajar Barat', '085380979642'),
('KOUT002', 'HomeyLaundry', 'JL. Cihanjuang  ', '089675423175'),
('KOUT003', 'HomeyLaundry', 'Jl.Ciraden', '0897654231');

-- --------------------------------------------------------

--
-- Table structure for table `tb_paket`
--

CREATE TABLE `tb_paket` (
  `id_paket` varchar(11) NOT NULL,
  `id_outlet` varchar(11) NOT NULL,
  `jenis` enum('Cuci Kering','Cuci Basah','Cuci Setrika','lain') NOT NULL,
  `nama_paket` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_paket`
--

INSERT INTO `tb_paket` (`id_paket`, `id_outlet`, `jenis`, `nama_paket`, `harga`) VALUES
('KPA001', 'KOUT001', 'Cuci Setrika', 'kiloan annisa', 12000),
('KPA002', 'KOUT001', 'Cuci Kering', 'paket kania', 5000),
('KPA003', 'KOUT001', 'Cuci Basah', 'kaos Dyah', 8000),
('KPA004', 'KOUT001', 'Cuci Setrika', 'kiloan nining', 12000),
('KPA005', 'KOUT001', 'Cuci Basah', 'Jas Pak Wawan', 8000),
('KPA006', 'KOUT001', 'Cuci Kering', 'paket maranda', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `id_outlet` varchar(11) NOT NULL,
  `kode_invoice` varchar(100) NOT NULL,
  `id_member` varchar(11) NOT NULL,
  `tgl` datetime NOT NULL,
  `batas_waktu` datetime NOT NULL,
  `tgl_bayar` datetime NOT NULL,
  `biaya_tambahan` int(11) NOT NULL,
  `diskon` double NOT NULL,
  `pajak` int(11) NOT NULL,
  `status` enum('Baru','Proses','Selesai','Diambil') NOT NULL,
  `dibayar` enum('Dibayar','Belum Dibayar') NOT NULL,
  `id_user` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`id_transaksi`, `id_outlet`, `kode_invoice`, `id_member`, `tgl`, `batas_waktu`, `tgl_bayar`, `biaya_tambahan`, `diskon`, `pajak`, `status`, `dibayar`, `id_user`) VALUES
('KTR001', 'KOUT001', 'KINV001', 'KME001', '2021-01-01 00:00:00', '2021-04-02 00:00:00', '2021-04-02 00:00:00', 5000, 1, 2000, 'Proses', 'Belum Dibayar', 'KUS001'),
('KTR003', 'KOUT001', 'KINV002', 'KME003', '2021-04-01 00:00:00', '2021-04-04 00:00:00', '2021-04-01 00:00:00', 0, 1, 500, 'Diambil', 'Dibayar', 'KUS002'),
('KTR004', 'KOUT001', 'KINV003', 'KME004', '2021-04-06 00:00:00', '2021-04-09 00:00:00', '2021-04-09 00:00:00', 0, 3, 1500, 'Selesai', 'Belum Dibayar', 'KUS002'),
('KTR005', 'KOUT001', 'KINV005', 'KME005', '2021-04-09 00:00:00', '2021-04-11 00:00:00', '2021-04-09 00:00:00', 0, 0, 500, 'Baru', 'Dibayar', 'KUS002'),
('KTR006', 'KOUT001', 'KINV006', 'KME006', '2021-04-09 00:00:00', '2021-04-11 00:00:00', '2021-04-09 00:00:00', 0, 2, 1000, 'Baru', 'Dibayar', 'KUS002'),
('KTR007', 'KOUT001', 'KINV007', 'KME007', '2021-04-09 00:00:00', '2021-04-11 00:00:00', '2021-04-09 00:00:00', 0, 2, 1000, 'Baru', 'Dibayar', 'KUS002');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` varchar(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` text NOT NULL,
  `id_outlet` varchar(11) NOT NULL,
  `role` enum('Admin','Kasir','Owner') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `nama`, `username`, `password`, `id_outlet`, `role`) VALUES
('KUS001', 'NADIA', 'admin', 'admin123', 'KOUT001', 'Admin'),
('KUS002', 'KANIA', 'kasir', 'kasir123', 'KOUT001', 'Kasir'),
('KUS003', 'YANI', 'owner', 'owner123', 'KOUT001', 'Owner');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_detail_transaksi`
--
ALTER TABLE `tb_detail_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `tb_member`
--
ALTER TABLE `tb_member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indexes for table `tb_outlet`
--
ALTER TABLE `tb_outlet`
  ADD PRIMARY KEY (`id_outlet`);

--
-- Indexes for table `tb_paket`
--
ALTER TABLE `tb_paket`
  ADD PRIMARY KEY (`id_paket`),
  ADD KEY `id_outlet` (`id_outlet`);

--
-- Indexes for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_outlet` (`id_outlet`),
  ADD KEY `id_member` (`id_member`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_outlet` (`id_outlet`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_detail_transaksi`
--
ALTER TABLE `tb_detail_transaksi`
  ADD CONSTRAINT `tb_detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `tb_transaksi` (`id_transaksi`),
  ADD CONSTRAINT `tb_detail_transaksi_ibfk_2` FOREIGN KEY (`id_paket`) REFERENCES `tb_paket` (`id_paket`);

--
-- Constraints for table `tb_paket`
--
ALTER TABLE `tb_paket`
  ADD CONSTRAINT `tb_paket_ibfk_1` FOREIGN KEY (`id_outlet`) REFERENCES `tb_outlet` (`id_outlet`);

--
-- Constraints for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD CONSTRAINT `tb_transaksi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`),
  ADD CONSTRAINT `tb_transaksi_ibfk_2` FOREIGN KEY (`id_member`) REFERENCES `tb_member` (`id_member`),
  ADD CONSTRAINT `tb_transaksi_ibfk_3` FOREIGN KEY (`id_outlet`) REFERENCES `tb_outlet` (`id_outlet`);

--
-- Constraints for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`id_outlet`) REFERENCES `tb_outlet` (`id_outlet`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
