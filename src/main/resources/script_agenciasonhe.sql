use `agenciasonhe`;

INSERT INTO contato VALUES 
(default, 'email@email.com', 'exemplo de mensagem', 'Maria'),
(default, 'email@email.com', 'exemplo de mensagem', 'José'),
(default, 'email@email.com', 'exemplo de mensagem', 'Clara'),
(default, 'email@email.com', 'exemplo de mensagem', 'Antonio');

select * from contato;

INSERT INTO destino (id, nome_destino, origem, data_ida, data_volta) VALUES 
(default, 'São Paulo', 'Maceio', '2023-11-11', '2023-11-11'),
(default, 'Rio de Janeiro', 'Maceio', '2023-03-19', '2023-12-08'),
(default, 'Salvador', 'Maceio', '2023-02-04', '2023-12-16'),
(default, 'Recife', 'Maceio', '2023-05-22', '2023-12-26');

select * from destino;

INSERT INTO usuario VALUES 
(default, 'ana@email.com', 'ana', '99 99999-0000'),
(default, 'joao@email.com', 'joao', '99 99999-0000'),
(default, 'luis@email.com', 'luis', '99 99999-0000'),
(default, 'maria@email.com', 'maria', '99 99999-0000');

select * from usuario;