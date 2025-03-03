INSERT INTO dbo.produto (nome, dat_hora_entrada, dat_hora_saida, descricao,categoria_produto , preco_compra, preco_medio, preco_venda, validade_lote_data, qtd_lote, dat_insercao, dat_hora_ult_modif_reg, usuario_ult_modif)
VALUES
('Produto A', TIMESTAMPADD(DAY, -1, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 30, CURRENT_TIMESTAMP), 'Descricao do Produto A',1, 10.5, 12.0, 15.0, DATEADD(DAY, 90, CURRENT_DATE), 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto B', TIMESTAMPADD(DAY, -2, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 40, CURRENT_TIMESTAMP), 'Descricao do Produto B',3, 20.0, 22.5, 28.0, DATEADD(DAY, 80, CURRENT_DATE), 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto C', TIMESTAMPADD(DAY, -3, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 35, CURRENT_TIMESTAMP), 'Descricao do Produto C',2, 30.0, 35.0, 40.0, DATEADD(DAY, 70, CURRENT_DATE), 150, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto D', TIMESTAMPADD(DAY, -1, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 20, CURRENT_TIMESTAMP), 'Descricao do Produto D',2, 15.0, 16.5, 20.0, DATEADD(DAY, 100, CURRENT_DATE), 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto E', TIMESTAMPADD(DAY, -4, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 50, CURRENT_TIMESTAMP), 'Descricao do Produto E',3, 25.0, 30.0, 35.0, DATEADD(DAY, 85, CURRENT_DATE), 300, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto F', TIMESTAMPADD(DAY, -5, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 45, CURRENT_TIMESTAMP), 'Descricao do Produto F',1, 5.5, 6.5, 10.0, DATEADD(DAY, 120, CURRENT_DATE), 80, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto G', TIMESTAMPADD(DAY, -6, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 60, CURRENT_TIMESTAMP), 'Descricao do Produto G',2, 50.0, 55.0, 60.0, DATEADD(DAY, 150, CURRENT_DATE), 250, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto H', TIMESTAMPADD(DAY, -7, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 70, CURRENT_TIMESTAMP), 'Descricao do Produto H',2, 40.0, 45.0, 50.0, DATEADD(DAY, 180, CURRENT_DATE), 400, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto I', TIMESTAMPADD(DAY, -8, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 15, CURRENT_TIMESTAMP), 'Descricao do Produto I',1, 12.0, 13.5, 18.0, DATEADD(DAY, 130, CURRENT_DATE), 120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system'),
('Produto J', TIMESTAMPADD(DAY, -9, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, 90, CURRENT_TIMESTAMP), 'Descricao do Produto J',3, 35.0, 40.0, 45.0, DATEADD(DAY, 200, CURRENT_DATE), 180, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system');
