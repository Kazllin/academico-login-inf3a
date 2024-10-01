IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='carrinho_compras' AND xtype='U')


CREATE TABLE carrinho_compras (
  id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  usuario_id BIGINT NOT NULL,
  valor_total FLOAT NOT NULL,
  data_criacao DATETIME NOT NULL DEFAULT GETDATE(),
  CONSTRAINT fk_carrinho_compras_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);