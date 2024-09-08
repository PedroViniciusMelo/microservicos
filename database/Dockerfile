# Usando a imagem oficial do PostgreSQL
FROM postgres:latest

# Definindo variáveis de ambiente para o usuário e a senha do banco de dados
ENV POSTGRES_USER=docker
ENV POSTGRES_PASSWORD=docker

# Copia um script SQL que será executado na inicialização do container
COPY init.sql /docker-entrypoint-initdb.d/

# Expõe a porta padrão do PostgreSQL
EXPOSE 5432
