
# API - Posto de Combustível

Projeto simples desenvolvido para um desafio técnico visando apresentar habilidades de desenvolvedor java backend e tem como escopo o cadastro/manipulação de tipos e bombas de combustíveis, bem como o abastecimento de um veículo.



## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/isadorabello/posto-combustivel.git
```

Entre no diretório do projeto

```bash
  cd posto-combustivel
```

Rode o arquivo docker-compose

```bash
    mvn clean install
```

## Documentação da API

#### Cadastra Tipos de Combustíveis

```http
  POST /tipoCombustivel
```

| Body   | Tipo       | Descrição                                                           |
| :---------- | :--------- |:--------------------------------------------------------------------|
| `nome` | `string` | **Obrigatório**. Nome do Combustível                                |
| `precoPorLitro` | `BigDecimal` | **Obrigatório**. Valor do litro do combustível                      |

#### Retorna um Combustível por ID

```http
  GET /tipoCombustivel/${id}
```

| Parâmetro   | Tipo       | Descrição                                                 |
| :---------- | :--------- |:----------------------------------------------------------|
| `id`      | `string` | **Obrigatório**. O ID do combustível que você quer buscar |

#### Deleta um Combustível por ID

```http
  DELETE /tipoCombustivel/${id}
```

| Parâmetro   | Tipo       | Descrição                                                  |
| :---------- | :--------- |:-----------------------------------------------------------|
| `id`      | `string` | **Obrigatório**. O ID do combustível que você quer deletar |


#### Cadastra Bombas de Combustíveis

```http
  POST /bombaCombustivel
```

| Body   | Tipo              | Descrição                                                     |
| :---------- |:------------------|:--------------------------------------------------------------|
| `nome` | `string`          | **Obrigatório**. Nome da Bomba de Combustível                 |
| `tipoCombustivel` | `TipoCombustivel` | **Obrigatório**. Necessário apenas o ID do tipo de combstível |

#### Retorna uma Bomba de Combustível por ID

```http
  GET /bombaCombustivel/${id}
```

| Parâmetro   | Tipo       | Descrição                                                          |
| :---------- | :--------- |:-------------------------------------------------------------------|
| `id`      | `string` | **Obrigatório**. O ID da bomba de combustível que você quer buscar |

#### Deleta uma Bom de Combustível por ID

```http
  DELETE /bombaCombustivel/${id}
```

| Parâmetro   | Tipo       | Descrição                                                           |
| :---------- | :--------- |:--------------------------------------------------------------------|
| `id`      | `string` | **Obrigatório**. O ID da bomba de combustível que você quer deletar |

#### Cadastra Abastecimentos

```http
  POST /abastecimento
```

| Parâmetro         | Tipo              | Descrição                                         |
|:------------------|:------------------|:--------------------------------------------------|
| `quantidadeLitros`            | `Long`          | **Obrigatório**. ID da Bomba de Combustível       |
| `idBomba` | `Integer` | **Obrigatório**. Quantidade de litros abastecidos |

#### Retorna os Abastecimentos

```http
  GET /abastecimento
```
