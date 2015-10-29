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
voo_id INT(11) NOT NULL,
passageiro_responsavel_id INT(11) NOT NULL,
passageiro_id INT(11) NOT NULL,
bilhete VARCHAR(10), -- MD5 gerado pelo Backend
valor DOUBLE NOT NULL -- Valor do Vôo c/ taxas e ajustes embutidos
)ENGINE = InnoDB;

INSERT INTO PASSAGEM (
	voo_id,
    passageiro_responsavel_id,
    passageiro_id,
    bilhete,
    valor
) VALUES (1, 1, 1, '', 300.90);

SELECT
	p.id,
    por.forma_tratamento,
    por.nome,
    por.sobrenome,
    por.data_nascimento,
    po.forma_tratamento,
    po.nome,
    po.sobrenome,
    po.data_nascimento,
    p.bilhete,
    p.valor as valor_passagem,
    v.codigo,
    oa.nome,
    da.nome,
    v.escalas,
    v.datahora,
    v.assentos_disponiveis,
    v.situacao
FROM Projeto.PASSAGEM as p
LEFT JOIN Projeto.VOO as v ON p.voo_id = v.id
LEFT JOIN Projeto.PASSAGEIRO as por ON p.passageiro_responsavel_id = por.id
LEFT JOIN Projeto.PASSAGEIRO as po ON p.passageiro_id = po.id
LEFT JOIN Projeto.AEROPORTO as oa ON v.origem_aeroporto_id = oa.id
LEFT JOIN Projeto.AEROPORTO as da ON v.destino_aeroporto_id = da.id;

SELECT
	pm.id,
	pm.bilhete,
    oa.nome as origem_aeroporto_nome,
    da.nome as destino_aeroporto_nome,
    por.forma_tratamento,
    por.nome,
    por.sobrenome,
    po.tipo,
    po.forma_tratamento,
    po.nome,
    po.sobrenome,
    v.datahora,
    v.assentos_disponiveis,
    v.situacao,
    pm.valor
FROM
	Projeto.PASSAGEM as pm
LEFT JOIN Projeto.VOO as v ON pm.voo_id = v.id
LEFT JOIN Projeto.AEROPORTO as oa ON v.origem_aeroporto_id = oa.id
LEFT JOIN Projeto.AEROPORTO as da ON v.destino_aeroporto_id = da.id
LEFT JOIN Projeto.PASSAGEIRO as por ON pm.passageiro_responsavel_id = por.id
LEFT JOIN Projeto.PASSAGEIRO as po ON pm.passageiro_id = po.id
WHERE
	pm.bilhete = '9aa65385a';

SELECT * FROM Projeto.PASSAGEM;



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
assento VARCHAR(20) NOT NULL, -- Letra da Fileira + Número do Assento (Ex: B10),
date_create DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
)ENGINE = InnoDB;

SELECT * FROM Projeto.CHECKIN;



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

SELECT
	v.id as voo_id,
    ae.nome as voo_nome,
    v.codigo,
    oa.nome as origem_aeroporto_nome,
    da.nome as destino_aeroporto_nome,
    v.escalas,
    v.datahora,
    v.assentos_disponiveis,
    v.situacao,
    v.valor
FROM VOO as v
LEFT JOIN Projeto.AERONAVE as ae ON v.aeronave_id = ae.id
LEFT JOIN Projeto.AEROPORTO as oa ON v.origem_aeroporto_id = oa.id
LEFT JOIN Projeto.AEROPORTO as da ON v.destino_aeroporto_id = da.id
WHERE
		v.origem_aeroporto_id = 1
	AND v.destino_aeroporto_id = 2
	AND v.situacao = 'Confirmado'
    AND v.id != 1;

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



-- TABELA CARTAO DE DEBITO **********************************
DROP TABLE IF EXISTS Projeto.CARTAO_DEBITO;
CREATE TABLE Projeto.CARTAO_DEBITO(
id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
banco VARCHAR(50) NOT NULL,
agencia VARCHAR(10) NOT NULL,
conta_corrente VARCHAR(15) NOT NULL,
nome_titular VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
ddd VARCHAR(3) NOT NULL,
telefone VARCHAR(10) NOT NULL
)ENGINE = InnoDB;

INSERT INTO Projeto.CARTAO_DEBITO (
    banco,
    agencia,
    conta_corrente,
    nome_titular,
    cpf,
    ddd,
    telefone
) VALUES
('Itaú', '9999', '99999-9', 'Gabriel Ramos Takeda', '123.456.879-09', '011', '9999-99999');

SELECT * FROM Projeto.CARTAO_DEBITO;



-- TABELA CARTO DE CREDITO *********************************
DROP TABLE IF EXISTS Projeto.CARTAO_CREDITO;
CREATE TABLE Projeto.CARTAO_CREDITO(
id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
nome_titular VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
numero_cartao VARCHAR(19) NOT NULL,
data_vencimento_mes VARCHAR(2) NOT NULL,
data_vencimento_ano VARCHAR(4) NOT NULL,
codigo_seguranca VARCHAR(3) NOT NULL
)ENGINE = InnoDB;

INSERT INTO Projeto.CARTAO_CREDITO (
    nome_titular,
    cpf,
    numero_cartao,
    data_vencimento_mes,
    data_vencimento_ano,
    codigo_seguranca
) VALUES
('Gabriel Ramos Takeda', '123.456.789-09', '9999 9999 9999 9999', '01', '2022', '123');

SELECT * FROM Projeto.CARTAO_CREDITO;



-- TABELA CARTO DE REEMBOLSO *********************************
DROP TABLE IF EXISTS Projeto.REEMBOLSO;
CREATE TABLE Projeto.REEMBOLSO(
id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
voo_id INT(11) NOT NULL,
valor DOUBLE NOT NULL,
banco VARCHAR(10) NOT NULL,
agencia VARCHAR(10) NOT NULL,
conta_corrente VARCHAR(15) NOT NULL,
nome_titular VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
date_create DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
) ENGINE = InnoDB;

INSERT INTO Projeto.REEMBOLSO (
	voo_id,
	valor,
    banco,
	agencia,
	conta_corrente,
	nome_titular,
	cpf
) VALUES (1, 300.90, 'itau', '8493', '32050-4', 'Gabriel Ramos Takeda', '419-148-618-76');

SELECT * FROM Projeto.REEMBOLSO;



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

