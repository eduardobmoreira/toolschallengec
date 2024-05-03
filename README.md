# toolschallengec
API de pagamentos para o Tools Challenge C.

:::: Tecnologias Utilizadas:
- Spring Boot: 3.2.5
- Java JDK: 17
- Maven: 4.0
- MySql: 8.0.31


Implementar uma API de Pagamentos.
As operações serão as seguintes:
Pagamento:
- Solicitação e resposta conforme JSON abaixo
Estorno:
- consulta: por ID
- retorno: conforme JSON de retorno de estorno
Consulta:
- consulta: todos e por ID
- retorno: conforme JSON de retorno do pagamento

A API deve utilizar conceitos REST, JSON e protocolo padrão HTTP de retorno.
O servidor da aplicação pode ser Tomcat, JBoss ou pode ser utilizado SpringBoot.
Requisitos dastransações:
- Transacao > id: Deve ser único
- Transacao > Status: “AUTORIZADO”, “NEGADO”
- formaPagamento > Tipo: “AVISTA”, “PARCELADO LOJA”, “PARCELADO EMISSOR”
