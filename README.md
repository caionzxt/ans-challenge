# ANS Database Challenge

Repositório para o desafio técnico de banco de dados da ANS (Agência Nacional de Saúde Suplementar).

## Objetivo

Implementar soluções para:
- Download de dados abertos da ANS
- Processamento e armazenamento em banco de dados MySQL
- Consultas analíticas sobre operadoras de saúde

## Pré-requisitos

- MySQL 8.0+
- Java JDK 11+
- WSL2 (para ambiente Windows)
- Git

## Configuração

1. Clone o repositório:
```bash
git clone https://github.com/caionzxt/ans-challenge.git

Fluxo de Trabalho Completo
Download dos dados:

bash
Copy
java -cp bin Downloader
Processamento:

bash
Copy
java -cp bin DataProcessor
Análise:

bash
Copy
mysql -u root -p ans_analysis < sql/02_analytic_queries.sql