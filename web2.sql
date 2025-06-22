-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/06/2025 às 19:54
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `web2`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `herois`
--

CREATE TABLE `herois` (
  `id` int(11) NOT NULL,
  `altura` float NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nome_heroi` varchar(255) DEFAULT NULL,
  `peso` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `herois`
--

INSERT INTO `herois` (`id`, `altura`, `data_nascimento`, `nome`, `nome_heroi`, `peso`) VALUES
(9, 1.85, '2003-03-12', 'Arthur XXXX', 'Capitão Xereca', 92.2),
(10, 121, '2025-05-28', 'dasdad', 'sadas', 1212),
(11, 2.87, '2025-06-22', 'Fds', 'Super FSds', 200),
(12, 1.85, '2003-03-12', 'Arthur', 'Capitão WWWW', 92.2),
(13, 344, '2025-06-21', 'zzz', 'zzz', 344),
(15, 1.85, '2003-03-12', 'XXXXXXXXX', 'pinto', 92.2),
(16, 1.85, '2003-06-18', 'Biel', 'Capitão Costinha', 110.09),
(17, 1.9, '1978-06-18', 'Clark Kent', 'Superman', 100);

-- --------------------------------------------------------

--
-- Estrutura para tabela `herois_superpoderes`
--

CREATE TABLE `herois_superpoderes` (
  `heroi_id` int(11) NOT NULL,
  `superpoder_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `herois_superpoderes`
--

INSERT INTO `herois_superpoderes` (`heroi_id`, `superpoder_id`) VALUES
(9, 2),
(12, 2),
(15, 1),
(15, 2),
(16, 1),
(17, 1),
(17, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `superpoderes`
--

CREATE TABLE `superpoderes` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `superpoder` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `superpoderes`
--

INSERT INTO `superpoderes` (`id`, `descricao`, `superpoder`) VALUES
(1, 'Ver através de objetos sólidos', ' Visão de Raio-X'),
(2, 'Capacidade de voar', 'Voo');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `herois`
--
ALTER TABLE `herois`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK4l0nqhjas0oqta9s3gtmkc49k` (`nome_heroi`);

--
-- Índices de tabela `herois_superpoderes`
--
ALTER TABLE `herois_superpoderes`
  ADD KEY `FKbhvs8yet3i2eoxmej7lsq34ym` (`superpoder_id`),
  ADD KEY `FK9k3si02xf3fi3kw5r0vr2suit` (`heroi_id`);

--
-- Índices de tabela `superpoderes`
--
ALTER TABLE `superpoderes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `herois`
--
ALTER TABLE `herois`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `superpoderes`
--
ALTER TABLE `superpoderes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `herois_superpoderes`
--
ALTER TABLE `herois_superpoderes`
  ADD CONSTRAINT `FK9k3si02xf3fi3kw5r0vr2suit` FOREIGN KEY (`heroi_id`) REFERENCES `herois` (`id`),
  ADD CONSTRAINT `FKbhvs8yet3i2eoxmej7lsq34ym` FOREIGN KEY (`superpoder_id`) REFERENCES `superpoderes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
