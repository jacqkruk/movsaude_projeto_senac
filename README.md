# 🧠 MovSaúde

**MovSaúde** é um sistema desktop desenvolvido como parte do curso **Técnico em Desenvolvimento de Sistemas** do **Senac EAD**. O projeto simula o funcionamento de um sistema de gestão para uma clínica de psicologia, permitindo o cadastro, listagem, busca, edição e exclusão de pacientes e funcionários.

---

## 📋 Funcionalidades

- Cadastro de pacientes e funcionários
- Listagem de registros com filtros por nome
- Edição e exclusão de cadastros (com base na permissão do usuário)
- Controle de acesso por tipo de usuário

---

## 🛠️ Tecnologias utilizadas

- **Java** (linguagem principal)
- **Maven** (gerenciador de dependências e build)
- **MySQL** (banco de dados relacional)
- **Swing** (interface gráfica)

---

## 🚀 Como executar o projeto localmente

> ⚠️ Este projeto ainda não possui um instalador automático. Para rodá-lo localmente, é necessário configurar o ambiente manualmente.

### Pré-requisitos

- Java JDK 11 ou superior
- Apache Maven
- MySQL Server
- IDE como IntelliJ IDEA, Eclipse ou NetBeans

### Passos

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/movsaude.git
   cd movsaude

2. **Configure o banco de dados:**

   - Crie um banco de dados no mySQL (ex: movsaude_db)
   - Importe o script SQL com as tabelas e dados iniciais
   - Atualize o arquivo persistence.xml com as credenciais corretas do seu banco

3. **Compile o projeto com Maven:**

   mvn clean install

4. **Execute o projeto:**
   - Via IDE: execute a classe principal com o método main
   - Ou via terminal

---

## 👨‍🏫 Sobre o projeto
 Este projeto foi desenvolvido como parte das atividades práticas do curso **Técnico em Desenvolvimento de Sistemas** do **Senac EAD**, com o objetivo de aplicar conceitos de programação orientada a objetos, persistência de dados e interfaces gráficas. 

---

 ## 📌 Autor
 - Nome: Jake Kruk
 - GitHub: @jacqkruk

 ## 📎 Atribuições
 - Ícones de funcionário e pessoa criados por mattbadal - Flaticon
 - ìcone de grupo de funcionários criado por apien - Flaticon
 - Ícone de grupo de pessoas criado por Freepik - Flaticon
