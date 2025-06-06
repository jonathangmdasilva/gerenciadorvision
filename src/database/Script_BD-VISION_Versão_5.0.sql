CREATE DATABASE IF NOT EXISTS BD_VISION;

USE BD_VISION;

/*MODULO ADMINISTRATIVO*/
CREATE TABLE IF NOT EXISTS TB_EMPRESA(
	Id_Empresa			INT				AUTO_INCREMENT PRIMARY KEY,
	Razao_Empresa		VARCHAR(255)	NOT NULL,
	Cnpj_Empresa		VARCHAR(50)		NOT NULL,
    Incri_Esta_Empresa	VARCHAR(50)		NOT NULL
);


CREATE TABLE TB_CONFIGURACAO_SISTEMA(
	Id_Configuracao		INT				AUTO_INCREMENT PRIMARY KEY,
	Id_Empresa			INT				REFERENCES TB_EMPRESA(Id_Empresa),
	Admin_Config		INT				NOT NULL,
    Estoque_Config		INT				NOT NULL,
    Financeiro_Config	INT				NOT NULL,
    Lembretes_Config	INT				NOT NULL,
    Vendas_Config		INT				NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_USUARIO(
	Id_Usuario			INT				AUTO_INCREMENT PRIMARY KEY,
	Login_Usuario		VARCHAR(25)		NOT NULL,
	Senha_Usuario		VARCHAR(50)		NOT NULL,
	Nivel_Usuario		VARCHAR(50)		NOT NULL,
	Status_Usuario		INT				NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_FUNCIONARIO(
	Id_Func				INT				AUTO_INCREMENT PRIMARY KEY,
	Nome_Func			VARCHAR(255)	NOT NULL,
	Cargo_Func			VARCHAR(50)		NOT NULL,
	Id_Usuario			INT				REFERENCES TB_USUARIO(Id_Usuario)
);

CREATE TABLE IF NOT EXISTS TB_CLIENTE(
	Id_Cliente			INT				AUTO_INCREMENT PRIMARY KEY,
	Nome_Cliente		VARCHAR(150)	NOT NULL,
	Tipo_Cliente		VARCHAR(50)		NOT NULL,
	Cpf_CLiente			VARCHAR(150)	NULL,
	Cnpj_Cliente		VARCHAR(150)	NULL,
	Status_Cliente		INT				NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_CONTATO(
	Id_Contato			INT				AUTO_INCREMENT PRIMARY KEY, 
	Email_Contato		VARCHAR(150)	NULL,
	Tel_Um_Contato		VARCHAR(150)	NULL,
	Tel_Dois_Contato	VARCHAR(150)	NULL,    
    Id_Cliente			INT				REFERENCES TB_USUARIO(Id_Usuario),
    Id_Fornecedor		INT				REFERENCES TB_FORNECEDOR(Id_Fornecedor),
	Id_Empresa			INT				REFERENCES TB_EMPRESA(Id_Empresa)
);

CREATE TABLE IF NOT EXISTS TB_ENDERECO(
	Id_End				INT				AUTO_INCREMENT PRIMARY KEY,
	Logradouro_End		VARCHAR(150)	NOT NULL,
	Num_End				INT				NOT NULL,
	Bairro_End			VARCHAR(150)	NOT NULL,
	Cidade_End			VARCHAR(150)	NOT NULL,
	Id_Estado			INT				REFERENCES TB_ESTADO(Id_Estado),
	Id_Cliente			INT				REFERENCES TB_USUARIO(Id_Usuario),
    Id_Fornecedor		INT				REFERENCES TB_FORNECEDOR(Id_Fornecedor),
	Id_Empresa  		INT				REFERENCES TB_EMPRESA(Id_Empresa)
);

CREATE TABLE IF NOT EXISTS TB_ESTADO(
	Id_Estado			INT				AUTO_INCREMENT PRIMARY KEY,
	Nome_Estado			VARCHAR(100)	NOT NULL
);

/*MÓDULO FINANCEIRO*/
CREATE TABLE IF NOT EXISTS TB_CONTAS(
	Id_Contas			INT				AUTO_INCREMENT PRIMARY KEY,
	Numero_conta		VARCHAR(150)	NOT NULL,
	Valor_Conta			DECIMAL(10,2)	NOT NULL,
	Emissao_Conta		DATE			NOT NULL,
	Venc_Conta			DATE			NOT NULL,
	Status_Conta		VARCHAR(30)		NOT NULL,
    Tipo_Conta			VARCHAR(250)	NOT NULL,
    Ativa_Conta			INT				NOT NULL,	
	Obser_Conta			VARCHAR(250)	NOT NULL
);


CREATE TABLE IF NOT EXISTS TB_CONTA_PAGAR(
	Id_Cont_Pag			INT				AUTO_INCREMENT PRIMARY KEY,
	Cedente_Cont_Pag	VARCHAR(200)	NOT NULL,
	Id_Contas			INT 			NOT NULL	REFERENCES TB_CONTAS(Id_Contas)
);

CREATE TABLE IF NOT EXISTS TB_CONTA_RECEBER(
	Id_Cont_Rec			INT				AUTO_INCREMENT PRIMARY KEY,
	Sacado_Cont_Rec		VARCHAR(200)	NOT NULL,
	Id_Contas			INT				NOT NULL	REFERENCES TB_CONTA(Id_Contas)
);

CREATE TABLE IF NOT EXISTS TB_LEMBRETES(
	Id_Lembrete			INT				AUTO_INCREMENT PRIMARY KEY,
	Data_Lembrete		DATETIME		NOT NULL,
	Descricao_Lembrete	VARCHAR(200)	NOT NULL,
	Status_Lembrete		INT				NOT NULL
);

/*MÓDULO DE ESTOQUE*/
CREATE TABLE IF NOT EXISTS TB_FORNECEDOR(
	Id_Fornecedor		INT				AUTO_INCREMENT PRIMARY KEY,
	Razao_Social_Forn	VARCHAR(250)	NOT NULL,
	Cnpj_Forn			VARCHAR(250)	NOT NULL,
	Status_Forn			INT				NOT NULL	
);

CREATE TABLE IF NOT EXISTS TB_CATEGORIA_PRODUTO(
	Id_Cat_Prod			INT				AUTO_INCREMENT PRIMARY KEY,
	Descricao_Cat_Prod	VARCHAR(200)	NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_PRODUTO(
	Id_Produto			INT				AUTO_INCREMENT PRIMARY KEY,
	Descricao_Produto	VARCHAR(255)	NOT NULL,
	Sku_Produto			VARCHAR(255)	NOT NULL,
	Min_Produto			INT				NOT NULL,
	Max_Produto			INT				NOT NULL,
	Status_Produto		INT				NOT NULL,
	Id_Cat_Produto		INT				REFERENCES TB_CATEGORIA_PRODUTO(Id_Cat_Prod),
    Id_Lucro			INT				REFERENCES TB_LUCRO_PRODUTO(Id_Lucro),
    Id_Fornecedor		INT				REFERENCES TB_FORNECEDOR(Id_Fornecedor)
);

CREATE TABLE IF NOT EXISTS TB_LUCRO_PRODUTO(
	Id_Lucro 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Valor_Compra 		REAL 			NOT NULL,
	Valor_Venda 		REAL 			NOT NULL,
	Lucro_Produto		REAL 			NOT NULL,
    Margem_Lucro		REAL			NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_ESTOQUE_ENTRADA(
	Id_Entrada 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Id_Produto 			INT UNSIGNED 	NOT NULL,
	Qtd_Entrada 		REAL 			NOT NULL,
	DH_Entrada 			DATETIME 		NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_ESTOQUE_SAIDA(
	Id_Saida 			INT UNSIGNED    AUTO_INCREMENT PRIMARY KEY,
	Id_Produto 			INT UNSIGNED 	NOT NULL,
	Qtd_Saida 			REAL 			NOT NULL,
	DH_Saida 			DATETIME 		NOT NULL
);


CREATE TABLE IF NOT EXISTS TB_ESTOQUE_SALDO(
	Id_Saldo 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Id_Produto 			INT UNSIGNED 	NOT NULL,
	Saldo_Produto 		REAL 			NOT NULL,
    Atualizacao_Saldo   DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_INVENTARIO(
	Id_Invent			INT				AUTO_INCREMENT PRIMARY KEY,
	Data_Invent			DATETIME		NOT NULL,
	Quantidade_Tot		DECIMAL(10,2)	NOT NULL,
	Valor_Tot			DECIMAL(10,2)	NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_ASSOC_ITENS_INVENTARIO(
	Id_Invent			INT				REFERENCES TB_INVENTARIO(Id_Invent),
	Id_Produto			INT				REFERENCES TB_PRODUTO(Id_Produto),
	Qtd_Item			DECIMAL(10,2)	NOT NULL,
	Valor_Item			DECIMAL(10,2)	NOT NULL
);

/*MÓDULO DE VENDAS*/
CREATE TABLE IF NOT EXISTS TB_FORMA_PAGAMENTO(
	Id_Forma_Pagamento			INT				AUTO_INCREMENT PRIMARY KEY,
    Descricao_Forma_Pagamento 	VARCHAR(255)	NOT NULL,
    Taxa_Desc 					REAL 			NOT NULL,
    Ativo_Pagamento				INT				NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_PEDIDO(
	Id_Pedido			INT				AUTO_INCREMENT PRIMARY KEY,
	Id_Func				INT				REFERENCES TB_FUNCIONARIO(Id_Func),
	Id_Cliente			INT				REFERENCES TB_CLIENTE(Id_Cliente),
	Data_Hora_Pedido	DATETIME		NOT NULL,
    Sub_Total_Pedido	DECIMAL(10,2)	NOT NULL,
	Total_Pedido		DECIMAL(10,2)	NOT NULL,
	Status_Pedido		VARCHAR(255)	NOT NULL,
	Desconto_Pedido		DECIMAL(7,2)	NOT NULL,
	Id_Forma_Pagamento	INT				REFERENCES TB_FORMA_PAGAMENTO(Id_Forma_Pagamento),
	Obs_Pedido			VARCHAR(255)	NULL,
    Id_Cotacao			INT(255)		NULL REFERENCES TB_COTACAO(Id_Cotacao)
);

CREATE TABLE IF NOT EXISTS TB_ASSOC_ITEM_PEDIDO(
	Id_Pedido			INT				REFERENCES TB_PEDIDO(Id_Pedido),
	Id_Produto			INT				REFERENCES TB_PRODUTO(Id_Produto),
	Qtd_Item_Pedido		DECIMAL(10,2)	NOT NULL,
	Preco_Item_Pedido	DECIMAL(10,2)	NOT NULL,
	Total_Item_Pedido	DECIMAL(10,2)	NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_COTACAO(
	Id_Cotacao			INT				AUTO_INCREMENT PRIMARY KEY,
	Id_Func				INT				REFERENCES TB_FUNCIONARIO(Id_Func),
	Id_Cliente			INT				REFERENCES TB_CLIENTE(Id_Cliente),
	Data_Hora_Cotacao	DATETIME		NOT NULL,
	Total_Cotacao		DECIMAL(10,2)	NOT NULL,
	Status_Cotacao		VARCHAR(255)	NOT NULL,
	Desconto_Cotacao	DECIMAL(7,2)	NOT NULL,
	Id_Forma_Pagamento	INT				REFERENCES TB_FORMA_PAGAMENTO(Id_Forma_Pagamento),
	Periodo_Val_Cotacao INT 			NOT NULL,
	Obs_Cotacao			VARCHAR(255)	NULL
);

CREATE TABLE IF NOT EXISTS TB_ASSOC_ITEM_COTACAO(
	Id_Cotacao			INT				REFERENCES TB_COTACAO(Id_Cotacao),
	Id_Produto			INT				REFERENCES TB_PRODUTO(Id_Produto),
	Qtd_Item_Cotacao	DECIMAL(10,2)	NOT NULL,
	Preco_Item_Cotacao	DECIMAL(10,2)	NOT NULL,
	Total_Item_Cotacao	DECIMAL(10,2)	NOT NULL
);


/*INSERTS BÁSICOS ADM*/
INSERT INTO TB_USUARIO (Login_Usuario,Senha_Usuario,Nivel_Usuario,Status_Usuario)VALUES('ROOT','ROOT','ADMINISTRADOR',1);
INSERT INTO TB_FUNCIONARIO VALUES(1,'YODA','ADMINISTRADOR',1);

SELECT *FROM TB_CATEGORIA_PRODUTO;

INSERT INTO TB_CATEGORIA_PRODUTO VALUES (1,'ACESSÓRIO'),(2,'FERRAMENTA AUTOMÁTICA'),(3,'FERRAMENTA MANUAL'),(4,'HIDRÁULICA'),(5,'MAQUINA'),(6,'OUTROS');

INSERT INTO TB_ESTADO (Nome_Estado) VALUES('Acre'),
										  ('Alagoas'),
										  ('Amapá'),
										  ('Amazonas'),
										  ('Bahia'),
										  ('Ceará'),
										  ('Espírito Santo'),
										  ('Goiás'),
										  ('Maranhão'),
										  ('Mato Grosso'),
										  ('Mato Grosso do Sul'),
										  ('Minas Gerais'),
										  ('Pará'),
										  ('Paraíba'),
										  ('Paraná'),
										  ('Pernambuco'),
										  ('Piauí'),
										  ('Rio de Janeiro'),
										  ('Rio Grande do Norte'),
										  ('Rio Grande do Sul'),
										  ('Rondônia'),
										  ('Roraima'),
										  ('Santa Catarina'),
										  ('São Paulo'),
										  ('Sergipe'),
										  ('Tocantins');



SELECT * FROM TB_LEMBRETES WHERE Data_Lembrete = NOW();
SELECT * FROM TB_LEMBRETES WHERE DATE_FORMAT(Data_Lembrete,'%Y/%m/%d') = CURDATE() AND Status_Lembrete =1;

/*
*CAMINHO DO ARQUIVO My.ini
C:\ProgramData\MySQL\MySQL Server 8.0\my.ini
show variables like 'secure-file-priv﻿'; -- 
*/

SELECT SUM(Total_Pedido),EXTRACT(YEAR FROM CURDATE()) AS Ano FROM TB_PEDIDO WHERE DATE_FORMAT(Data_Hora_Pedido,'%Y/%m/%d') = CURDATE(); /*WHERE DATA_HORA_PEDIDO
*/
SELECT YEAR FROM CURRENT_DATE();

SELECT EXTRACT(DAY FROM CURDATE()) AS DIA, EXTRACT(MONTH FROM CURDATE()) AS MES, EXTRACT(YEAR FROM CURDATE()) AS ANO;

SELECT *FROM TB_PEDIDO;

SELECT YEAR(Data_Hora_Pedido) as Ano , MONTH(Data_Hora_Pedido) as Mês, SUM(Total_Pedido) as Total FROM TB_PEDIDO group by year(Data_Hora_Pedido) order by 3 desc;


SELECT YEAR(Data_Hora_Pedido) as Ano , SUM(Total_Pedido) as Total FROM TB_PEDIDO group by year(Data_Hora_Pedido);
