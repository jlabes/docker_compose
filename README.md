# Exemplo: Docker Compose

Este projeto demonstra:

- Aplicação Java empacotada como fat JAR
- Banco de dados MySQL com volume persistente
- Comunicação entre containers via Docker Compose

---

## Environment variables

Define the following environment variables in the .env file:

### Mandatory

- MYSQL_ROOT_PASSWORD
- MYSQL_DATABASE
- MYSQL_USER
- MYSQL_PASSWORD

---

## Como usar

### 1. Build da imagem

```bash
docker compose up --build
```