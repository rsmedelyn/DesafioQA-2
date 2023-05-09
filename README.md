# Desafio QA  - Parte 2🐞

## **Pré-Requisitos**
✅ Java 8

✅ Maven

✅ Selenium WebDriver
- Chormedriver
- Geckdriver

✅ Eclipse IDE

---

##  🎉 **Desafio 2 - CORRIJA OS ERROS DO PROJETO**

⚠️ Passos:

1. Entrar no diretório `DesafioQA` via Terminal e fazer o clone desse projeto
2. Abrir o projeto clonado no Eclipse IDE
3. Executar o `Cenario: Tradução de texto no idioma Portugues para Espanhol` via Eclipse IDE
4. Analisar o erro contrado e corrigir
5. Executar o `Esquema do Cenario: Tradução de varios idiomas` via Eclipse IDE
6. Analisar os erros contrados e corrigi-los
7. Executar o projeto pela IDE, utilizando o Browser Chrome
   1. Por `@tag`
   2. Por `.feature`
8. Executar o projeto via Maven 
   1. Por pela tag `@espanhol` (exemplo:  mvn test -Dcucumber.filter.tags="@tag")
   2. Por pela tag `@idiomas`
   3. Por pela tag `@funcionais`
9. Todos os testes devem retornar **SUCESSO ✅**
10. Criar uma branch `feature/`  a partir da `develop`
11. Commitar a correção realizada na branch criada e subir para o repositório
12. Criar um PullRequest para a Branch `develop`
