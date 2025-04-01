# ANS Database Challenge

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