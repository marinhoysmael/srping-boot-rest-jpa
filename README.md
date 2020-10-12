# srping-boot-rest-jpa

Este projeto, faz parte dos estudos do curso da Alura, onde desenvolvi uma API REST com srping boot;

Ele usa um banco de dados em memoria para implementar exemplos com JPA


Executar em modo de produção:
java -jar -DFORUM_DATABASE_URL=jdbc:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=123456 -Dspring.profiles.active=prod forum.jar
