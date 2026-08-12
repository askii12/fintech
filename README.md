# Fintech Wallet API

Backend-система для переводов между кошельками с double-entry ledger, идемпотентностью и аудит-трейлом.

## Стек
Java 17, Spring Boot, PostgreSQL, Liquibase, Docker

## Статус
🚧 В разработке — сейчас: схема данных (users, accounts, transactions, ledger_entries)

## Запуск
1. `docker compose up -d`
2. `./mvnw spring-boot:run`
