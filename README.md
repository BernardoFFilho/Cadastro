# Projeto Cadastro

Este projeto é uma aplicação Android (APK) desenvolvida em Kotlin. A aplicação tem como objetivo gerenciar cadastros de usuários, com funcionalidades simples de CRUD (criação, leitura, atualização e exclusão).

---

## 🛠 Tecnologias utilizadas

- Kotlin (Android)
- Gradle (Kotlin DSL)
- Docker (para automação do build)

---

## 🚀 Como executar via Docker

### 1. Build da imagem Docker

Execute o seguinte comando no terminal, **estando na pasta raiz do projeto** (onde está o `Dockerfile`):

```bash
docker build -t cadastro .