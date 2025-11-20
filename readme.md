# 🚀 API de CRUD de Documentos com Relacionamento e Swagger

Este projeto é uma **API REST completa** desenvolvida em **Spring Boot**, implementando operações de CRUD para **Documentos e Categorias**, incluindo relacionamento entre as entidades e documentação automática com **Swagger (Springdoc)**.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|-----------|-----------|
| Java 21 | Linguagem utilizada no projeto |
| Spring Boot 3 | Framework principal da aplicação |
| Maven | Gerenciador de dependências e build |
| Spring Data JPA (Hibernate) | Persistência e ORM |
| Lombok | Redução de boilerplate no código |
| H2 Database | Banco de dados em memória |
| Springdoc / Swagger | Documentação interativa da API |

---

## ▶️ Como Executar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/igorgustavo31/CRUD-com-relacionamento-Swagger.git
cd CRUD-com-relacionamento-Swagger
````

### 2️⃣ Compilar com Maven

```bash
mvn clean install
```

### 3️⃣ Executar a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 📚 Documentação da API (Swagger)

Após iniciar a aplicação, acesse:

➡️ [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Aqui você poderá:

* visualizar todos os endpoints
* testar requisições direto no navegador
* ver payloads, códigos de resposta, exemplos, etc.

---

# 🗺️ Endpoints da API

A API possui dois recursos principais:

---

# 📁 Categorias

**Base URL:**

```
http://localhost:8080/api/categorias
```

### 1️⃣ Criar Categoria

**Método:** POST
**URL:** `/api/categorias`
**Body (JSON):**

```json
{
  "nome": "Financeiro"
}
```

### 2️⃣ Listar Todas as Categorias

**Método:** GET
**URL:** `/api/categorias`

### 3️⃣ Buscar Categoria por ID

**Método:** GET
**URL:** `/api/categorias/{id}`

### 4️⃣ Atualizar Categoria

**Método:** PUT
**URL:** `/api/categorias/{id}`
**Body (JSON):**

```json
{
  "nome": "Relatórios Financeiros"
}
```

### 5️⃣ Deletar Categoria

**Método:** DELETE
**URL:** `/api/categorias/{id}`

---

# 📄 Documentos

**Base URL:**

```
http://localhost:8080/api/documentos
```

### 1️⃣ Criar Documento

⚠️ A categoria referenciada deve existir.

**Método:** POST
**URL:** `/api/documentos`
**Body (JSON):**

```json
{
  "titulo": "Relatório 2025",
  "conteudo": "Balanço financeiro do ano.",
  "categoria": {
    "id": 1
  }
}
```

### 2️⃣ Listar Todos os Documentos

**Método:** GET
**URL:** `/api/documentos`

### 3️⃣ Buscar Documento por ID

**Método:** GET
**URL:** `/api/documentos/{id}`

### 4️⃣ Atualizar Documento

**Método:** PUT
**URL:** `/api/documentos/{id}`
**Body (JSON):**

```json
{
  "titulo": "Relatório 2025 (Revisado)",
  "conteudo": "Conteúdo atualizado.",
  "categoria": {
    "id": 1
  }
}
```

### 5️⃣ Deletar Documento

**Método:** DELETE
**URL:** `/api/documentos/{id}`

---

# 🤝 Contribuição

Contribuições são bem-vindas!

