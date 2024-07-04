## Requisitos
Este projeto tem como objetivo implementar um sistema simplificado de transferencia, focando no fluxo de transferência de dinheiro entre dois tipos de usuários: comuns (COMMON) e lojistas(MERCHANT).

### Cadastro de Usuários
- Nome Completo, CPF, e-mail e Senha são obrigatórios para ambos os tipos de usuários.
- CPF/CNPJ e e-mails devem ser únicos no sistema.
- Permite apenas um cadastro por CPF ou endereço de e-mail.

### Transferência de Dinheiro
- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.
- Lojistas só recebem transferências, não enviam dinheiro para ninguém.
- Validação de saldo do usuário antes da transferência.

## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot)
```http request
http://localhost:8082/
```
- [Swagger](https://swagger.io/)
```http request
http://localhost:8082/swagger-ui/index.html#
```
- [H2 Database](https://www.h2database.com/html/main.html)
```http request
http://localhost:8082/h2-console
```

Chave SSH para o clone do projeto: git@github.com:lucashmad/PicPay-Transaction.git
