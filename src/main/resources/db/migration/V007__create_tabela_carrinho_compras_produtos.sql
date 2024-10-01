IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='carrinho_compras_produtos' AND xtype='U')


CREATE TABLE carrinho_compras_produtos (
  carrinho_compras_id BIGINT NOT NULL,
  produto_id BIGINT NOT NULL,
  PRIMARY KEY (carrinho_compras_id, produto_id),
  FOREIGN KEY (carrinho_compras_id) REFERENCES carrinho_compras (id),
  FOREIGN KEY (produto_id) REFERENCES produtos (id)
);