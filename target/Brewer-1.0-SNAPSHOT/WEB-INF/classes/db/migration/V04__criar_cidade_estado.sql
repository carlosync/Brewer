CREATE TABLE estado (
    codigo BIGINT(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sigla VARCHAR(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    codigo_estado BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_estado) REFERENCES estado(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estado (codigo, nome, sigla) VALUES (1,'Acre', 'AC');
INSERT INTO estado (codigo, nome, sigla) VALUES (2, 'Alagoas', 'AL');
INSERT INTO estado (codigo, nome, sigla) VALUES (3, 'Amazonas', 'AM');
INSERT INTO estado (codigo, nome, sigla) VALUES (4, 'Amapá', 'AP');
INSERT INTO estado (codigo, nome, sigla) VALUES (5, 'Bahia', 'BA');
INSERT INTO estado (codigo, nome, sigla) VALUES (6, 'Ceará', 'CE');
INSERT INTO estado (codigo, nome, sigla) VALUES (7, 'Distrito Federal', 'DF');
INSERT INTO estado (codigo, nome, sigla) VALUES (8, 'Espírito Santo', 'ES');
INSERT INTO estado (codigo, nome, sigla) VALUES (9, 'Goiás', 'GO');
INSERT INTO estado (codigo, nome, sigla) VALUES (10, 'Maranhão', 'MA');
INSERT INTO estado (codigo, nome, sigla) VALUES (11, 'Minas Gerais', 'MG');
INSERT INTO estado (codigo, nome, sigla) VALUES (12, 'Mato Grosso do Sul', 'MS');
INSERT INTO estado (codigo, nome, sigla) VALUES (13, 'Mato Grosso', 'MT');
INSERT INTO estado (codigo, nome, sigla) VALUES (14, 'Pará', 'PA');
INSERT INTO estado (codigo, nome, sigla) VALUES (15, 'Paraíba', 'PB');
INSERT INTO estado (codigo, nome, sigla) VALUES (16, 'Pernambuco', 'PE');
INSERT INTO estado (codigo, nome, sigla) VALUES (17, 'Piauí', 'PI');
INSERT INTO estado (codigo, nome, sigla) VALUES (18, 'Paraná', 'PR');
INSERT INTO estado (codigo, nome, sigla) VALUES (19, 'Rio de Janeiro', 'RJ');
INSERT INTO estado (codigo, nome, sigla) VALUES (20, 'Rio Grande do Norte', 'RN');
INSERT INTO estado (codigo, nome, sigla) VALUES (21, 'Rondônia', 'RO');
INSERT INTO estado (codigo, nome, sigla) VALUES (22, 'Roraima', 'RR');
INSERT INTO estado (codigo, nome, sigla) VALUES (23, 'Rio Grande do Sul', 'RS');
INSERT INTO estado (codigo, nome, sigla) VALUES (24, 'Santa Catarina', 'SC');
INSERT INTO estado (codigo, nome, sigla) VALUES (25, 'Sergipe', 'SE');
INSERT INTO estado (codigo, nome, sigla) VALUES (26, 'São Paulo', 'SP');
INSERT INTO estado (codigo, nome, sigla) VALUES (27, 'Tocantins', 'TO');

INSERT INTO cidade (nome, codigo_estado) VALUES ('Rio Branco', 1);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Cruzeiro do Sul', 1);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Salvador', 4);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Manaus', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Codajás', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Iranduba', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Manacapuru', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Boa Vista', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Alto Alegre', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Bonfim', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Caracaraí', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Pacaraima', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Mucajaí', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Porto Seguro', 2);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santana', 2);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Goiânia', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Itumbiara', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Novo Brasil', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Belo Horizonte', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Uberlândia', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Montes Claros', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Florianópolis', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Criciúma', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Camboriú', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Lages', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('São Paulo', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ribeirão Preto', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Campinas', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santos', 26);