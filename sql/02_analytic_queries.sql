-- Query 1: Top 10 operadoras com maiores despesas no último trimestre
SELECT 
    o.razao_social,
    o.nome_fantasia,
    SUM(d.valor) AS total_despesas
FROM 
    demonstracoes d
JOIN 
    operadoras o ON d.registro_ans = o.registro_ans
WHERE 
    d.conta LIKE '%EVENTOS/%SINISTROS%'
    AND d.data >= DATE_SUB(CURDATE(), INTERVAL 3 MONTH)
GROUP BY 
    o.razao_social, o.nome_fantasia
ORDER BY 
    total_despesas DESC
LIMIT 10;

-- Query 2: Top 10 operadoras com maiores despesas no último ano
SELECT 
    o.razao_social,
    o.nome_fantasia,
    SUM(d.valor) AS total_despesas
FROM 
    demonstracoes d
JOIN 
    operadoras o ON d.registro_ans = o.registro_ans
WHERE 
    d.conta LIKE '%EVENTOS/%SINISTROS%'
    AND d.data >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
GROUP BY 
    o.razao_social, o.nome_fantasia
ORDER BY 
    total_despesas DESC
LIMIT 10;