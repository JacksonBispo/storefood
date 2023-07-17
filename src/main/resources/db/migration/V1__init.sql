CREATE TABLE IF NOT EXISTS `tb_categoria` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `tb_produtos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `price` DECIMAL(38,2) NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  `categoria_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK555mlvcyvwis1o07pywhrr83p`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `tb_categoria` (`id`));


CREATE TABLE IF NOT EXISTS `tb_ingredients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `price` DECIMAL(38,2) NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `product_ingredient` (
  `product_id` BIGINT NOT NULL,
  `ingredient_id` BIGINT NOT NULL,
  CONSTRAINT `FKaft3nqkkbyo3h2gl7f14d1mih`
    FOREIGN KEY (`product_id`)
    REFERENCES `tb_produtos` (`id`),
  CONSTRAINT `FKn2ojjyx71g19piwb0trwqwtvr`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `tb_ingredients` (`id`));


CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `pass` VARCHAR(255) NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `tb_cargo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `tb_person` (
  `person_type` VARCHAR(31) NOT NULL,
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cel_phone` VARCHAR(255) NULL DEFAULT NULL,
  `cpf` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `birth_date` DATE NULL DEFAULT NULL,
  `admission_date` DATE NULL DEFAULT NULL,
  `user_id` BIGINT NULL DEFAULT NULL,
  `cargo_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKc4adphkrhxj5mxmvwo4jxkbt0`
    FOREIGN KEY (`user_id`)
    REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKloqi73i53s8wncb1d32587syi`
    FOREIGN KEY (`cargo_id`)
    REFERENCES `tb_cargo` (`id`));


CREATE TABLE IF NOT EXISTS `profiles` (
  `person_id` BIGINT NOT NULL,
  `profiles` INT NULL DEFAULT NULL,
  CONSTRAINT `FKdvct6x1ebnx9n8u557yolccgg`
    FOREIGN KEY (`person_id`)
    REFERENCES `tb_person` (`id`));


CREATE TABLE IF NOT EXISTS `tb_address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bairro` VARCHAR(255) NULL DEFAULT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `number` VARCHAR(255) NULL DEFAULT NULL,
  `postal_code` VARCHAR(255) NULL DEFAULT NULL,
  `uf` VARCHAR(255) NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  `person_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKtrocr0nyv92c11b6gvu9p5rcr`
    FOREIGN KEY (`person_id`)
    REFERENCES `tb_person` (`id`));


CREATE TABLE IF NOT EXISTS `tb_orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `amount_change` DECIMAL(38,2) NULL DEFAULT NULL,
  `amount_order` DECIMAL(38,2) NULL DEFAULT NULL,
  `order_data` DATE NULL DEFAULT NULL,
  `uuid` VARCHAR(255) NULL DEFAULT NULL,
  `person_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKfu2t9c2626lfts3tfd9v1bsgf`
    FOREIGN KEY (`person_id`)
    REFERENCES `tb_person` (`id`));


CREATE TABLE IF NOT EXISTS `usuario_roles` (
  `usuario_id` BIGINT NOT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  CONSTRAINT `FK156s3ye7ajlyyalbyfj1k2tyu`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `tb_usuario` (`id`));
