-- ============================================
-- Loan Application System - Stage 1 Schema
-- ============================================

CREATE DATABASE IF NOT EXISTS loan_app_db;
USE loan_app_db;

CREATE TABLE IF NOT EXISTS users (
    user_id           INT AUTO_INCREMENT PRIMARY KEY,
    fname             VARCHAR(50)  NOT NULL,
    lname             VARCHAR(50)  NOT NULL,
    mobile            VARCHAR(10)  NOT NULL,
    email             VARCHAR(100) NOT NULL UNIQUE,
    location           VARCHAR(100),
    username          VARCHAR(50)  NOT NULL UNIQUE,
    password          VARCHAR(255) NOT NULL,
    status            VARCHAR(10)  NOT NULL DEFAULT 'active',   -- active / inactive
    failed_attempts   INT          NOT NULL DEFAULT 0,
    lastmodifieddate  DATETIME     NOT NULL,
    created_date      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
);
