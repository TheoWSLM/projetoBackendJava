<h3>API de controle de contatos</h3>
 <p>
Essa é uma api de controle de contatos onde é possível cadastrar, atualizar, deletar e buscar de várias formas pessoas e contatos, sendo contatos uma entidade dependente, experimente os 11 end-points disponíveis para utilização em varias aplicações!
</p>

<p>
<img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>
  
### :hammer: Construído com

 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="70"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="60"/>


 # 🎇 Como funciona

## CRUD de Pessoas:

### Criar Pessoa

    POST /api/pessoas: Crie uma nova Pessoa.

### Obter Pessoa por ID

    GET /api/pessoas/{id}: Obtenha os detalhes de uma Pessoa específica com base em seu ID.

### Obter Pessoa por ID para mala direta

    GET /api/pessoas/maladireta/{id}: Obtenha informações de uma Pessoa com o objetivo de preparar uma mala direta simplificada.

### Listar todas as Pessoas

    GET /api/pessoas: Liste todas as Pessoas cadastradas no sistema.

### Atualizar Pessoa por ID

    PUT /api/pessoas/{id}: Atualize as informações de uma Pessoa existente com base em seu ID.

### Deletar Pessoa por ID

    DELETE /api/pessoas/{id}: Remova uma Pessoa do sistema com base em seu ID.

## CRUD de Contatos:

### Adicionar um novo Contato a uma Pessoa

    POST /api/pessoas/{id}/contatos: Adicione um novo meio de Contato a uma Pessoa existente, especificando o tipo de contato e os detalhes do mesmo (por exemplo, telefone ou celular).

### Obter Contato por ID

    GET /api/contatos/{id}: Obtenha informações detalhadas sobre um Contato com base em seu ID.

### Listar todos os Contatos de uma Pessoa

    GET /api/pessoas/{idPessoa}/contatos: Liste todos os meios de Contato associados a uma Pessoa específica.

### Atualizar Contato por ID

    PUT /api/contatos/{id}: Atualize as informações de um Contato existente com base em seu ID.

### Deletar Contato por ID

    DELETE /api/contatos/{id}: Remova um meio de Contato do sistema com base em seu ID.




# ⏬ Instalação

1. Clone o repositorio, abra na IDE de sua preferencia
2. Se certifique de sincronizar todas as dependencias antes de executar o projeto
3. Configure o ambiente do mySql com a conexão e esquema com o nome "treinamento", se certifique de inserir no arquivo application.properties seu usuario e senha do banco de dados usado
4. Execute o projeto



# 📧 Contato

Theo Weber - theoweber1@gmail.com

# ❤️ Agradecimentos

* Instrutor Eduardo Henrique
