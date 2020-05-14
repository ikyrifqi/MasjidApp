-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Bulan Mei 2020 pada 19.22
-- Versi server: 10.4.8-MariaDB
-- Versi PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jamsholat`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `identitas_masjid`
--

CREATE TABLE `identitas_masjid` (
  `id_identitas` int(255) NOT NULL,
  `nama_masjid` varchar(255) NOT NULL,
  `alamat_masjid` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `identitas_masjid`
--

INSERT INTO `identitas_masjid` (`id_identitas`, `nama_masjid`, `alamat_masjid`) VALUES
(2, 'mrp', 'malang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_sholat`
--

CREATE TABLE `jadwal_sholat` (
  `id_jadwal` int(255) NOT NULL,
  `dhuha` varchar(255) NOT NULL,
  `shubuh` varchar(255) NOT NULL,
  `dhuhur` varchar(255) NOT NULL,
  `ashar` varchar(255) NOT NULL,
  `maghrib` varchar(255) NOT NULL,
  `isha` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL,
  `video` varchar(255) NOT NULL,
  `transisi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jadwal_sholat`
--

INSERT INTO `jadwal_sholat` (`id_jadwal`, `dhuha`, `shubuh`, `dhuhur`, `ashar`, `maghrib`, `isha`, `foto`, `video`, `transisi`) VALUES
(1, '09:32', '03:30', '11:32', '14:32', '17:32', '19:02', '1576633116122', '0', '1581490011193'),
(2, '10:00', '4:00', '13:00', '15:30', '18:30', '19:12', '12928137', '123124', '123143');

-- --------------------------------------------------------

--
-- Struktur dari tabel `marquee`
--

CREATE TABLE `marquee` (
  `id_marquee` int(255) NOT NULL,
  `isi_marquee` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `marquee`
--

INSERT INTO `marquee` (`id_marquee`, `isi_marquee`) VALUES
(1, '** Himbauan untuk seluruh Jamaah Masjid Ar Rohman agar berhati-hati dalam menempatkan kendaraan di tempat parkir. Pastikan kendaraan terkunci rapat. **');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengumuman_masjid`
--

CREATE TABLE `pengumuman_masjid` (
  `id_pengumuman` int(255) NOT NULL,
  `judul_pengumuman` varchar(255) NOT NULL,
  `isi_pengumuman` text NOT NULL,
  `aktif` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengumuman_masjid`
--

INSERT INTO `pengumuman_masjid` (`id_pengumuman`, `judul_pengumuman`, `isi_pengumuman`, `aktif`) VALUES
(13, 'hwjwj', '    Hadirilah pengajian akbar tahun 2019 di Masjid Ar Rohman, Sabtu 8 Januari 2020 di Pelataran Masjid Ar Rohman Dengan Pembicara Ustadz Budi dari Jakarta.\r\n\r\n<hr>\r\n\r\nProgram khitanan massal akan dilaksanakan pada tanggal 2 Pebruari 2020. Mohon diinformasikan kepada kerabat dan tetangga sekitar.\r\n        \r\n    ', 'no');

-- --------------------------------------------------------

--
-- Struktur dari tabel `slideshow`
--

CREATE TABLE `slideshow` (
  `id_slideshow` int(255) NOT NULL,
  `judul_slideshow` varchar(255) NOT NULL,
  `url_slideshow` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `slideshow`
--

INSERT INTO `slideshow` (`id_slideshow`, `judul_slideshow`, `url_slideshow`) VALUES
(19, 'foto', '1300x1000.jpg'),
(20, 'foto', 'CIMG1043JPG.jpg'),
(21, 'foto', 'CIMG1902JPG.jpg'),
(22, 'foto', 'CIMG1927JPG.jpg'),
(23, 'foto', 'CIMG1968JPG.jpg'),
(24, 'foto', 'efef.jpg'),
(26, 'foto', 'P90811-063819.jpg'),
(27, 'video', 'Animasi_Tata_Cara_Wudhu_Rasulullah_-_Belajar_Bareng_Baim_(2).mp4');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tagline`
--

CREATE TABLE `tagline` (
  `id_tagline` int(255) NOT NULL,
  `isi_tagline` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tagline`
--

INSERT INTO `tagline` (`id_tagline`, `isi_tagline`) VALUES
(2, 'Kajian Rutin dilaksanakan setiap hari Ahad bada Sholat Maghrib');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, 'abyan', '123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `identitas_masjid`
--
ALTER TABLE `identitas_masjid`
  ADD PRIMARY KEY (`id_identitas`);

--
-- Indeks untuk tabel `jadwal_sholat`
--
ALTER TABLE `jadwal_sholat`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indeks untuk tabel `marquee`
--
ALTER TABLE `marquee`
  ADD PRIMARY KEY (`id_marquee`);

--
-- Indeks untuk tabel `pengumuman_masjid`
--
ALTER TABLE `pengumuman_masjid`
  ADD PRIMARY KEY (`id_pengumuman`);

--
-- Indeks untuk tabel `slideshow`
--
ALTER TABLE `slideshow`
  ADD PRIMARY KEY (`id_slideshow`);

--
-- Indeks untuk tabel `tagline`
--
ALTER TABLE `tagline`
  ADD PRIMARY KEY (`id_tagline`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `identitas_masjid`
--
ALTER TABLE `identitas_masjid`
  MODIFY `id_identitas` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `jadwal_sholat`
--
ALTER TABLE `jadwal_sholat`
  MODIFY `id_jadwal` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `marquee`
--
ALTER TABLE `marquee`
  MODIFY `id_marquee` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pengumuman_masjid`
--
ALTER TABLE `pengumuman_masjid`
  MODIFY `id_pengumuman` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `slideshow`
--
ALTER TABLE `slideshow`
  MODIFY `id_slideshow` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT untuk tabel `tagline`
--
ALTER TABLE `tagline`
  MODIFY `id_tagline` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
