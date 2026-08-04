-- ===========================================
-- MiniWinThor
-- Script de criação do banco de dados
-- ===========================================

CREATE DATABASE IF NOT EXISTS miniwinthor;

USE miniwinthor;

CREATE TABLE produtos (

    codigo INT PRIMARY KEY,

    descricao VARCHAR(100) NOT NULL,

    preco_compra DECIMAL(10,2) NOT NULL,

    preco_venda DECIMAL(10,2) NOT NULL,

    status VARCHAR(20) NOT NULL

);
