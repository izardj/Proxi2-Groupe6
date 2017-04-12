-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 12 Avril 2017 à 06:37
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanqueafij`
--

--
-- Vider la table avant d'insérer `client`
--

TRUNCATE TABLE `client`;
--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`, `telephone`, `entreprise`, `nom_entreprise`, `email`, `id_conseiller`) VALUES
(3, 'Smith', 'John', 'route du chemin', '78852', 'Lille', '014458712', 1, 'Ford', 'john.smith@test.com', 1),
(4, 'Doe', 'Jane', 'chemin du pré', '38000', 'Grenoble', '0145789632', 0, NULL, 'jdoe@example.fr', 1),
(5, 'Sinatra', 'Frank', 'hollywood boulevard', '14587', 'Los Angeles', '555-4548', 0, NULL, 'fsinatra@star.com', 1),
(6, 'Izard', 'Jerome', 'route de Grenoble', '38420', 'Domène', '0145859654', 0, NULL, 'monemail@email.com', 1),
(7, 'Ayraud', 'Florent', 'gabriel péri', '69100', 'Villerubane', '98754121', 0, NULL, 'fayraud@email.com', 1),
(8, 'William', 'David', 'chemin de la vie', '12000', 'Paris', '01458796', 0, NULL, 'wd@test.com', 2);

--
-- Vider la table avant d'insérer `compte`
--

TRUNCATE TABLE `compte`;
--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `num_compte`, `solde`, `date_ouverture`, `remuneration`, `decouvert`, `type_compte`, `id_client`) VALUES
(1, 14598563, 524689.56, '2012-12-01', NULL, 10000, 'CompteCourant', 3),
(2, 85749852, 75000, '2013-04-12', NULL, NULL, 'CompteEpargne', 3),
(5, 87895244, 2587.23, '2010-05-06', NULL, 1000, 'CompteCourant', 4),
(6, 98765421, 25045.23, '', 0.03, NULL, 'CompteEpargne', 5),
(7, 48521547, 9658.23, '2017-05-14', 0.03, NULL, 'CompteEpargne', 6),
(8, 1254785, 568.12, '2016-05-23', NULL, 1000, 'CompteCourant', 6),
(9, 1254879, 50.01, '2009-05-23', NULL, 1000, 'CompteCourant', 7),
(10, 968574, 45000, '2008-08-02', NULL, 1000, 'CompteCourant', 8),
(11, 254563, 458792.25, '2003-07-01', 0.03, NULL, 'CompteEpargne', 8);

--
-- Vider la table avant d'insérer `conseiller`
--

TRUNCATE TABLE `conseiller`;
--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`id_conseiller`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`, `telephone`, `login`, `pwd`) VALUES
(1, 'Robichet', 'Robert', '24 rue du Chène', '38420', 'Le Versoud', '0478458596', 'demo1', 'demo1'),
(2, 'Patoulatchi', 'Marcel', '5 avenue du Chateau', '45789', 'Ville sur marne', '0745859632', 'demo2', 'demo2');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
