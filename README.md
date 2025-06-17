# 💰 Sistema de Controle Financeiro

Projeto Java simples para controle de contas mensais via terminal, utilizando Spring Boot, JPA e banco de dados MySQL. Ideal para fins educativos e para praticar CRUD completo com uma estrutura profissional.

---

## 📋 Funcionalidades

- ✅ Listar contas cadastradas
- ➕ Adicionar nova conta
- ✏️ Editar conta existente
- ❌ Excluir conta
- 💾 Persistência em banco de dados MySQL

---

## 🧰 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL (Docker)
- Hibernate
- Maven
- Docker (para MySQL e phpMyAdmin)

---

## 🗂️ Estrutura do Projeto

src/
- ├── main/
- │ ├── java/
- │ │ └── br/com/controlefinanceiro/
- │ │ ├── Main.java
- │ │ ├── model/
- │ │ ├── repository/
- │ │ └── service/
- │ └── resources/
- │ ├── application.properties

---

## ⚙️ Como Executar

### 1. Clone o repositório
bash
git clone https://github.com/seu-usuario/controle-financeiro.git
cd controle-financeiro

### 2 ➡️ Suba o MySQL via Docker (se ainda não tiver)
bash
docker run --name cursosql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=cursosql -e MYSQL_USER=leo -e MYSQL_PASSWORD=1234 -p 3306:3306 -d mysql:8.0
(opcional) Acesse o banco com phpMyAdmin:

bash
docker run --name pma_cursosql --link cursosql:db -p 8088:80 -d phpmyadmin

### 3 ➡️ Configure o application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/cursosql
spring.datasource.username=leo
spring.datasource.password=###
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

### 4 ➡️ Execute o projeto
Você pode rodar diretamente pela IDE (IntelliJ, Eclipse) ou via terminal:

bash
mvn spring-boot:run

---

# 🧪 Exemplo de Uso
Bem vindo ao Sistema de Controle Financeiro!

Escolha uma opção:
1 - Verificar dados da tabela
2 - Adicionar nova conta
3 - Alterar conta existente
4 - Excluir conta
5 - Sair

---

# 👤 Autor
Leonardo Possan

---

### 🔧 Dicas finais

- Substitua os campos do autor com seus dados reais.
- Crie um arquivo `LICENSE` se quiser adicionar uma licença (MIT, Apache, etc.).
- Pode adicionar um print do terminal usando `![screenshot](caminho)` se quiser ilustrar visualmente.
