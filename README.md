# storefood

API de Gerenciamento de Produtos com Ingredientes
Bem-vindo(a) à documentação da API de Gerenciamento de Produtos com Ingredientes. Esta API permite o gerenciamento de produtos, incluindo a criação, recuperação, atualização e exclusão de produtos, juntamente com informações sobre seus ingredientes.

Visão Geral
A API de Gerenciamento de Produtos com Ingredientes fornece endpoints para realizar as seguintes operações:

Criação de um novo produto com seus ingredientes correspondentes.
Recuperação de informações de um produto específico, incluindo seus ingredientes.
Atualização das informações de um produto, incluindo a lista de ingredientes.
Exclusão de um produto existente.
Autenticação
A API utiliza autenticação baseada em tokens para garantir a segurança dos dados. Todos os endpoints, exceto o de autenticação, exigem a inclusão de um token válido no cabeçalho da requisição.

Endpoints
A seguir, estão listados os endpoints disponíveis nesta API:

1. Autenticação
POST /login: Autentica um usuário e retorna um token de acesso válido.
2. Produtos
GET  /api/v1/product/list: Retorna a lista de todos os produtos cadastrados.
POST  /api/v1/product/save: Cria um novo produto com seus ingredientes correspondentes.
PUT  /api/v1/product/{id}: Atualiza as informações de um produto existente. 
DELETE /products/{id}: Exclui um produto específico. 
3. Ingredientes
GET /api/v1/product/{id}/ingredients: Retorna a lista de ingredientes de um produto específico.
POST /api/v1/product/product/{id}/ingredients: Adiciona um novo ingrediente à lista de ingredientes de um produto.
PUT /api/v1/product/{id}/ingredients/{ingredientId}: Atualiza as informações de um ingrediente de um produto.
DELETE /api/v1/product/{id}/ingredients/{ingredientId}: Remove um ingrediente da lista de ingredientes de um produto.
Formato de Dados
A API utiliza o formato de dados JSON para as requisições e respostas. A seguir, estão os exemplos dos principais objetos utilizados:

Produto

<img width="673" alt="Captura de Tela 2023-07-12 às 11 34 55" src="https://github.com/JacksonBispo/storefood/assets/9170784/9755c16f-bcca-4082-982b-a7e8413cde30">


json
Erros Comuns
A API retorna códigos de status HTTP adequados e mensagens de erro descritivas em caso de falhas nas requisições. Alguns dos erros comuns são:

400 Bad Request: Requisição inválida, geralmente devido a dados ausentes ou inválidos.
401 Unauthorized: Falha na autenticação ou token inválido.
404 Not Found: Recurso não encontrado.
500 Internal Server Error: Erro interno do servidor.
Considerações Finais
Esta é uma visão geral da API de Gerenciamento de Produtos com Ingredientes. Certifique-se de utilizar a autenticação correta ao fazer chamadas aos endpoints e fornecer os dados no formato adequado.

A ideia é implemtar toda a gestao de produtos e pedidos de um restaurante, futuramente com a parte de pagamento e entregas

Agradecemos por utilizar nossa API e esperamos que seja útil para o gerenciamento eficiente dos produtos e seus ingredientes!
