# Compilar Java
javac -d bin src/*.java

# Executar download
java -cp bin Downloader

# Processar dados
java -cp bin DataProcessor

# Executar queries e salvar resultados
mysql -u root -p ans_analysis < sql/02_analytic_queries.sql > results/analysis_results.txt