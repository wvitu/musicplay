# 🎵 MusicPlay

Projeto desenvolvido como parte do desafio do curso **"Java: persistência de dados e consultas com Spring Data JPA"** da [Alura](https://www.alura.com.br/), com diversas melhorias e integrações adicionais implementadas por mim.

## 📌 Funcionalidades

- 🔎 Buscar informações de um artista via API pública (Last.fm)
- 🎶 Listar músicas por artista
- ➕ Cadastrar novos artistas e músicas no banco de dados
- 💾 Persistência dos dados com PostgreSQL
- 🧠 Exibição de informações detalhadas como nome, país, estilo musical e biografia (em português)

## 🚀 Melhorias implementadas por mim

- Integração com a **API do Last.fm** (substituindo o ChatGPT anterior)
- Retorno de informações em **português** quando possível
- Sanitização dos dados para evitar erros de acentuação e espaços
- Organização do código com boas práticas (injeção de dependências, serviços separados)
- Tratamento de exceções e mensagens amigáveis ao usuário
- Refatoração do sistema de menu com melhorias na usabilidade

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Last.fm API
- Maven
- IntelliJ IDEA

## 📚 Como executar o projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/wvitu/musicplay.git
   cd musicplay
   ```

2. **Configure o banco de dados PostgreSQL:**

   Crie um banco com o nome `musicplay`.

   ```sql
   CREATE DATABASE musicplay;
   ```

3. **Atualize o arquivo `application.properties`:**

   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/musicplay
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Execute a aplicação:**

   ```bash
   ./mvnw spring-boot:run
   ```

5. **Navegue pelo menu no terminal:**

   O sistema exibirá um menu com as opções disponíveis para interação.

## 🌐 Sobre a API utilizada

A aplicação consome a API pública do [Last.fm](https://www.last.fm/api), utilizando sua chave criada gratuitamente:

A busca é feita com base no nome do artista e retorna dados como:

- Nome
- Gênero musical
- Biografia (em português quando disponível)

## 📸 Exemplo de uso no terminal

```
===== MusicPlay =====
1 - Pesquisar dados do artista
2 - Buscar músicas por artista
3 - Listar músicas
4 - Cadastrar músicas
5 - Cadastrar artistas
0 - Sair
Escolha uma opção: 1
Pesquisar informações sobre qual artista?
VMZ
Nome: VMZ
País: Brasil
Gênero: Rap
Bio: VMZ é um artista conhecido por...
```

## 👨‍💻 Autor

Projeto desenvolvido e melhorado por [Vitor](https://github.com/wvitu), com foco em aprendizado prático, boas práticas de desenvolvimento e integração com serviços externos.

---

```
