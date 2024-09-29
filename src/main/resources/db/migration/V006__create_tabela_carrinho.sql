IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='carrinhos' AND xtype='U')

CREATE TABLE carrinhos (
    id BIGINT PRIMARY KEY,
    valor_total DECIMAL(10, 2),
    forma_pagamento VARCHAR(255),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES usuarios(id)
);