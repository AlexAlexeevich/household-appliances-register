CREATE SEQUENCE model_sequence_name;

CREATE TABLE IF NOT EXISTS tv (
    id                      BIGINT           NOT NULL  DEFAULT  nextval('model_sequence_name'),
    household_appliance_id  BIGINT           NOT NULL,
    name                    VARCHAR(200)     NOT NULL,
    serial_number           VARCHAR(20)      NOT NULL,
    color                   VARCHAR(20)      NOT NULL,
    size                    VARCHAR(20)      NOT NULL,
    price                   NUMERIC(10, 2)   NOT NULL,
    is_available            BOOLEAN          NOT NULL,
    category                VARCHAR(20),
    technology              VARCHAR(20),

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS hoover (
    id                        BIGINT           NOT NULL  DEFAULT  nextval('model_sequence_name'),
    household_appliance_id    BIGINT           NOT NULL,
    name                      VARCHAR(200)     NOT NULL,
    serial_number             VARCHAR(20)      NOT NULL,
    color                     VARCHAR(20)      NOT NULL,
    size                      VARCHAR(20)      NOT NULL,
    price                     NUMERIC(10, 2)   NOT NULL,
    is_available              BOOLEAN          NOT NULL,
    dust_collector_volume     VARCHAR(20),
    mode_quantity             VARCHAR(20),

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS fridge (
    id                        BIGINT           NOT NULL  DEFAULT  nextval('model_sequence_name'),
    household_appliance_id    BIGINT           NOT NULL,
    name                      VARCHAR(200)     NOT NULL,
    serial_number             VARCHAR(20)      NOT NULL,
    color                     VARCHAR(20)      NOT NULL,
    size                      VARCHAR(20)      NOT NULL,
    price                     NUMERIC(10, 2)   NOT NULL,
    is_available              BOOLEAN          NOT NULL,
    door_fridge_quantity      VARCHAR(20),
    compressor_type           VARCHAR(50),

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS smartphone (
    id                        BIGINT           NOT NULL  DEFAULT  nextval('model_sequence_name'),
    household_appliance_id    BIGINT           NOT NULL,
    name                      VARCHAR(200)     NOT NULL,
    serial_number             VARCHAR(20)      NOT NULL,
    color                     VARCHAR(20)      NOT NULL,
    size                      VARCHAR(20)      NOT NULL,
    price                     NUMERIC(10, 2)   NOT NULL,
    is_available              BOOLEAN          NOT NULL,
    memory                    VARCHAR(20),
    camera_quantity           VARCHAR(20),

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS computer (
    id                        BIGINT           NOT NULL  DEFAULT  nextval('model_sequence_name'),
    household_appliance_id    BIGINT           NOT NULL,
    name                      VARCHAR(200)     NOT NULL,
    serial_number             VARCHAR(20)      NOT NULL,
    color                     VARCHAR(20)      NOT NULL,
    size                      VARCHAR(20)      NOT NULL,
    price                     NUMERIC(10, 2)   NOT NULL,
    is_available              BOOLEAN          NOT NULL,
    category                  VARCHAR(20),
    processor_type            VARCHAR(20),

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS household_appliance (
    id                        BIGINT           NOT NULL  DEFAULT  nextval('model_sequence_name'),
    product_name              VARCHAR(20)      NOT NULL,
    country                   VARCHAR(20)      NOT NULL,
    company                   VARCHAR(30)      NOT NULL,
    is_order_online           BOOLEAN          NOT NULL,
    is_possible_installments  BOOLEAN          NOT NULL,

    PRIMARY KEY(id),
--     CONSTRAINT pk_bank_branch PRIMARY KEY (id),
    CONSTRAINT ch_household_appliance_product_name CHECK ( product_name in ('TV', 'FRIDGE', 'HOOVER', 'SMARTPHONE', 'COMPUTER'))
);

ALTER TABLE tv ADD FOREIGN KEY (household_appliance_id) REFERENCES household_appliance(id);
ALTER TABLE hoover ADD FOREIGN KEY (household_appliance_id) REFERENCES household_appliance(id);
ALTER TABLE fridge ADD FOREIGN KEY (household_appliance_id) REFERENCES household_appliance(id);
ALTER TABLE computer ADD FOREIGN KEY (household_appliance_id) REFERENCES household_appliance(id);
ALTER TABLE smartphone ADD FOREIGN KEY (household_appliance_id) REFERENCES household_appliance(id);