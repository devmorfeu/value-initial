# WEBSERVICES PARA O CASE CYRELA | WEBSERVICES EM RESTFUL
Realizado tarefa - WEBSERVICES PARA O CASE CYRELA | WEBSERVICES EM RESTFUL

Tecnologias utilizadas:
  > JAVA 11 |
  > SPRING FRAMEWORK |
  > MODEL MAPPER |
  > SLF4J |
  > H2 DATABASE 

## ENDPOINT (GET) /pagamentos/v1/pagamentos/valores_imoveis ##
  
  Descrição: Rota responsavel pelo calculo DMI (dados do mercado imobiliário)
  
  Parametros de entrada :  
    valor_metro : "Valor base do metro² na região"
    metro_quadrado : "Tamanho do metro² a ser vendido"
    
  Body de saída : 
    valor_dmi : "Valor calculado"
  
