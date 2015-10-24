CREATE DATABASE Projeto;
use Projeto;


-- TABELA AERONAVE *****************************************
DROP TABLE IF EXISTS Projeto.AERONAVE;
CREATE TABLE Projeto.AERONAVE(
id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
codigo VARCHAR(255) NOT NULL,
nome VARCHAR(255) NOT NULL,
quantidade_fileiras INT(11) NOT NULL,
quantidade_assentos_fileira INT(11) NOT NULL
);

INSERT INTO Projeto.AERONAVE(
    codigo,
    nome,
    quantidade_fileiras,
    quantidade_assentos_fileira
) VALUES
('ER89', 'AMX', 6, 25),
('EMB', 'EMB 120', 4, 15),
('EMB', 'EMB 145 AGS', 4, 20);

SELECT * FROM AERONAVE;


-- TABELA LOGIN *****************************************
DROP TABLE IF EXISTS Projeto.LOGIN;
CREATE TABLE Projeto.LOGIN (
ID SERIAL NOT NULL,
USUARIO VARCHAR(200) NOT NULL,
SENHA  VARCHAR(200) NOT NULL,
PERFIL INT NOT NULL
);

INSERT INTO LOGIN(usuario,senha,perfil) VALUES
('gabrieltakeda', '123', 1),
('wesleyalmeida', '123', 1),
('karinapinna', '123', 1);



-- TABELA PASSAGEM *****************************************
DROP TABLE IF EXISTS Projeto.PASSAGEM;
CREATE TABLE Projeto.PASSAGEM(
id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
passageiro_responsavel_id INT(11) NOT NULL,
passageiro_id INT(11) NOT NULL,
bilhete VARCHAR(20) NOT NULL, -- MD5 gerado pelo Backend
valor DOUBLE NOT NULL -- Valor do Vôo c/ taxas e ajustes embutidos
)ENGINE = InnoDB;



-- TABELA PASSAGEIRO ***************************************
DROP TABLE IF EXISTS Projeto.PASSAGEIRO;
CREATE TABLE Projeto.PASSAGEIRO(
id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
tipo ENUM('Bebê', 'Criança', 'Adulto') NOT NULL,
forma_tratamento ENUM('Sr.', 'Sra.', 'Srta.') NOT NULL,
nome VARCHAR(60) NOT NULL,
sobrenome VARCHAR(60) NOT NULL,
data_nascimento DATE NOT NULL,
email VARCHAR(100),
ddd VARCHAR(3),
telefone_celular VARCHAR(10)
)ENGINE = InnoDB;

INSERT INTO Projeto.PASSAGEIRO (
    tipo,
    forma_tratamento,
    nome,
    sobrenome,
    data_nascimento,
    email,
    ddd,
    telefone_celular
) VALUES
('Adulto', 'Srta.', 'Daenerys', 'Targaryen', '1990-10-12', 'daenerys@targaryen.com', '11', '9777-77777'),
('Adulto', 'Sr.', 'Tyrion', 'Lannister', '1990-12-10', 'tyrion@lannister.com', '21', '9888-88888'),
('Criança', 'Sr.', 'Bran', 'Stark', '1998-01-02', 'bran@stark.com', '11', '9555-55555');

SELECT * FROM Projeto.PASSAGEIRO;



-- TABELA CHECKIN ***************************************
DROP TABLE IF EXISTS Projeto.CHECKIN;
CREATE TABLE Projeto.CHECKIN(
id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
passagem_id INT(11) NOT NULL,
ticket_malas VARCHAR(20) NOT NULL, -- MD5 gerado pelo Backend
assento VARCHAR(5) NOT NULL -- Letra da Fileira + Número do Assento (Ex: B10)
)ENGINE = InnoDB;



-- TABELA VOO **********************************************
DROP TABLE IF EXISTS Projeto.VOO;
CREATE TABLE Projeto.VOO(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
aeronave_id INT(11) NOT NULL,
codigo VARCHAR(100) NOT NULL,
origem_aeroporto_id INT(11) NOT NULL,
destino_aeroporto_id INT(11) NOT NULL,
escalas VARCHAR(50) NOT NULL,
datahora DATETIME NOT NULL,
assentos_disponiveis INT(4) NOT NULL,
situacao ENUM('Em espera', 'Confirmado', 'Encerrado') NOT NULL,
valor DOUBLE NOT NULL
)ENGINE = InnoDB;

INSERT INTO Projeto.VOO VALUES
(1, 1, 'ER7-10', 1, 6, 1, '2016-01-01 11:13:00', 110, 'Em espera', 289.90),
(2, 3, 'AS7-06', 8, 9, 1, '2016-02-01 16:54:00', 180, 'Confirmado', 169.90),
(3, 9, 'SJ7-49', 5, 3, 1, '2016-05-21 20:23:00', 220, 'Encerrado', 549.90),
(4, 1, 'JK89-49', 1, 2, 1, '2015-10-23 00:00:00', 220, 'Confirmado', 300.90),
(5, 1, 'ST28-49', 1, 2, 1, '2015-10-23 00:00:00', 220, 'Confirmado', 179.90);

SELECT * FROM VOO;

-- Seleciona Vôo disponível por:
--  + Quantidade de assentos disponíveis
--  + Aeroporto de Origem
--  + Aeroporto de Destino
--  + Status Confirmado
SELECT
    v.id,
    v.aeronave_id,
    v.codigo,
    v.origem_aeroporto_id,
    v.destino_aeroporto_id,
    v.escalas,
    v.datahora,
    v.assentos_disponiveis,
    v.situacao,
    v.valor,
    apo.nome as 'origem_aeroporto_nome',
    apd.nome as 'destino_aeroporto_nome'
FROM Projeto.VOO as v
LEFT JOIN Projeto.AERONAVE as an ON v.aeronave_id = an.id
LEFT JOIN Projeto.AEROPORTO as apd ON v.destino_aeroporto_id = apd.id
LEFT JOIN Projeto.AEROPORTO as apo ON v.origem_aeroporto_id = apo.id
WHERE
        v.assentos_disponiveis >= 3
    AND v.origem_aeroporto_id = 1
    AND v.destino_aeroporto_id = 2
    AND v.datahora = '2015-10-23 00:00:00'
    AND v.situacao = 'Confirmado';

-- TABELA AEROPORTOS *****************************************
DROP TABLE IF EXISTS Projeto.AEROPORTO;
CREATE TABLE Projeto.AEROPORTO(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`nome` VARCHAR(255) NOT NULL,
`status` ENUM('Disponível', 'Fechado', 'Em manutenção') NOT NULL
)ENGINE = InnoDB;

INSERT INTO Projeto.AEROPORTO (`nome`, `status`) VALUES
('Curitiba - Afonso Pena', 'Disponível'),
('Natal - Augusto Severo', 'Disponível'),
('Maceió - Campo dos Palmares', 'Disponível'),
('Foz do Iguaçu-PR - Catarata', 'Disponível'),
('Belo Horizonte - Confins', 'Disponível'),
('São Paulo - Congonhas', 'Disponível'),
('São Paulo - Cumbica', 'Disponível'),
('Acre - Cruzeiro do Sul', 'Disponível'),
('Salvador - Dep. Luis Eduardo Magalhães', 'Disponível'),
('Manaus - Eduardo Gomes', 'Disponível'),
('Rio de Janeiro - Galeão / Tom Jobim', 'Disponível'),
('Recife - Guararapes', 'Disponível'),
('Florianópolis - Hercílio Luz', 'Disponível'),
('Brasília - Juscelino Kubitschek', 'Disponível'),
('Cuiabá - Marechal Rondon', 'Disponível'),
('Belo Horizonte - Pampulha', 'Disponível'),
('Fortaleza - Pinto Martins', 'Disponível'),
('João Pessoa - Presidente Castro Pinto', 'Disponível'),
('Rio Branco - Presidente Médici', 'Disponível'),
('Juazeiro do Norte-CE - Regional do Cariri', 'Disponível'),
('Porto Alegre - Salgado Filho', 'Disponível'),
('Goiânia - Santa Genoveva', 'Disponível'),
('Aracaju - Santa Maria', 'Disponível'),
('Rio de Janeiro - Santos Dumont', 'Disponível'),
('Belém - Vai-de-Cans', 'Disponível'),
('Campinas-SP - Viracopos', 'Disponível');

SELECT * FROM Projeto.AEROPORTO;

-- TABELA PAGAMENTO ****************************************
CREATE TABLE Projeto.PAGAMENTO(
cod_passageiro SMALLINT UNSIGNED NOT NULL,
cod_classe_voo VARCHAR(60) NOT NULL,
forma_de_pagamento VARCHAR(60) NOT NULL,
aeroporto_de_destino VARCHAR(60) NOT NULL,
data_da_partida VARCHAR(30) NOT NULL,
hora_da_partida VARCHAR(30) NOT NULL,
quantidade_passageiros_adultos INT(3),
quantidade_passageiros_criancas INT(3),
PRIMARY KEY (cod_passageiro)
)ENGINE = InnoDB;

-- TABELA CARTAO DE DEBTO **********************************
CREATE TABLE Projeto.CARTAODEBTO(
cpf VARCHAR(90) NOT NULL,
banco VARCHAR(10)  NOT NULL,
agencia VARCHAR(46) NOT NULL,
conta VARCHAR(90) NOT NULL,
nome_do_titular VARCHAR(234) NOT NULL,
telefone VARCHAR(30),
PRIMARY KEY (cpf)
)ENGINE = InnoDB;

-- TABELA CARTO DE CREDITO *********************************
CREATE TABLE Projeto.CARTAOCREDITO(

nome_do_titular VARCHAR(30) NOT NULL,
tipo_de_cartao VARCHAR(30) NOT NULL,
numero_do_cartao VARCHAR(200) NOT NULL,
data_validade VARCHAR(30) NOT NULL,
cod_seguranca INT(30) NOT NULL,
PRIMARY KEY (nome_do_titular)
)ENGINE = InnoDB;

CREATE TABLE Projeto.TICKET(
cod_passagem INT (50) NOT NULL,
cod_ticket INT (50) NOT NULL,
PRIMARY KEY (usuario)
)ENGINE = InnoDB;

CREATE TABLE Projeto.REEMBOLSO(
valor VARCHAR(50) NOT NULL,
agencia VARCHAR (10) NOT NULL,
conta VARCHAR (30) NOT NULL,
nome VARCHAR (80) NOT NULL,
cpf VARCHAR (30) NOT NULL,
PRIMARY KEY (cpf)
) ENGINE = InnoDB;



-- // SELECT // --
select * from PASSAGEM;
select * from PASSAGEIRO;
select * from VOO;
select * from AERONAVE;
select * from PAGAMENTO;
select * from CARTAODEBTO;
select * from CARTAOCREDITO;
select * from USUARIO;

SELECT *
    FROM Passageiro INNER JOIN Cartaodebto ;


SELECT * FROM PASSAGEM INNER JOIN PASSAGEIRO INNER JOIN CARTAOCREDITO where cpf;

select * from Passagem INNER JOIN PASSAGEIRO INNER JOIN CARTAODEBTO  INNER JOIN VOO WHERE cpf;

