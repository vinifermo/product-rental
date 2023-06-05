CREATE TABLE tb_product_order
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name     varchar(50) NOT NULL,
    product_type  varchar(50) NOT NULL,
    time_hour     int         NOT NULL,
    product_value BIGINT      NOT NULL,
    product_total BIGINT      NOT NULL,
    user_amount   BIGINT      NOT NULL
);