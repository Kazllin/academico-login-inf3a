IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='finalizar_compras' AND xtype='U')

CREATE TABLE finalizar_compras (
  id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  carrinho_compras_id BIGINT NOT NULL,
  valor_total FLOAT NOT NULL,
  forma_pagamento VARCHAR(50) NOT NULL,
  data_finalizacao DATETIME NOT NULL DEFAULT GETDATE(),
  CONSTRAINT fk_finalizar_compras_carrinho_compras FOREIGN KEY (carrinho_compras_id) REFERENCES carrinho_compras (id)
);