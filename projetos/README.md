<div align="center"><h1>Projeto Final - DEVinHouse - Grupo 03</h1></div>

## :clipboard: Diagrama

O diagrama elaborado, e visível abaixo, é uma representação sucinta das camadas que compõe a presente aplicação.

<details>
  <summary>
    <strong>Diagrama da aplicação</strong>
  </summary>
  <div align="center">
    <img width="400" height="400" src="https://user-images.githubusercontent.com/75398842/130335791-7e346753-b3f4-436d-af72-1f495c7e7b21.png">
  </div>
</details>

---
  
## :books: Documentação da API

A documentação da API foi realizada com OpenAPI (Swagger) e SpringFox. Ademais, também foi elaborada uma versão da mesma com ReDoc.
As imagens das documentações podem ser vistas abaixo.

* ### Observação: 

<div align="justify">
  A API conta com um sistema de segurança (protocolo OAuth). Portanto, para poder utilizar as funções de teste de 'endpoints' disponibilizadas pela documentação, faz-se     necessária a autenticação na mesma.
  <br/>
  Para tanto, seguem as informações a serem passadas na 'API Client' preferida.
  <br/>
  <br/>
</div>

<details>
  <summary>
    Imagem de exemplo no Insomnia
  </summary>
   <div align="center">
    <br/>
    <img width="944" alt="Dados para obter o token" src="https://user-images.githubusercontent.com/75398842/130609194-27e21ee6-97e5-4f64-a535-9bf8bffc0222.png">
   </div>
</details>

* #### Token URL: https://training.dev.delivery/auth/realms/Grupo02/protocol/openid-connect/token
* #### Dados a serem passados

<div align="center">
  <table>
    <tr>
      <th>Name</th>
      <th>Value</th>
      </tr>
      <tr>  
        <td>grant_type</td>
        <td>password</td>
      </tr>
      <tr> 
        <td>client_id</td>
        <td>devinhouse-spring-boot-keycloak</td>
      </tr>      
      <tr> 
        <td>client_secret</td>
        <td>5955c798-d5db-41f8-a772-de8c7c11242e</td>
      </tr>
      <tr> 
        <td>username</td>
        <td>alberto</td>
      </tr>
      <tr> 
        <td>password</td>
        <td>123</td>
      </tr>
  </table>
</div>

<details>
  <summary>
    <strong>Swagger UI</strong>
  </summary>
  <div>
    <br/>
    Esta é a imagem da documentação gerada pelo Swagger com a utilização do SpringFox.
    <br/>A mesma pode ser acessada, quando da execução da aplicação, em: 
      <strong>
        <a href="http://localhost:3001/swagger-ui/index.html#/" target="_blank" rel="noreferrer noopener">http://localhost:3001/swagger-ui/index.html#/</a>
      </strong>
      <br/>
      <br/>
    </div>
  <img alt="Swagger UI - API Documentation" src="https://user-images.githubusercontent.com/75398842/130336922-b0eee391-1cf5-4eed-b269-ce6479c940ba.png" />
</details>

<details>
  <summary>
    <strong>ReDoc</strong>
  </summary>
  <div>
    <br/>
    Esta é a imagem da documentação gerada pelo ReDoc com base na documentação gerada pelo Swagger.
    <br/>
    <br/>
  </div>
  <img alt="ReDoc - API Documentation" src="https://user-images.githubusercontent.com/75398842/130337571-1b091769-50c8-4b0e-8d6d-0de3d8030f73.png" />
</details>

---

## :gear: Como configurar e executar

```bash

    # Clonar o repositório
    $ git clone https://github.com/mausampaio/devinhouse-projeto-final-modulo-3.git

```

### :whale: Utilizando o Docker

Para rodar o projeto utilizando o Docker é necessário ter o mesmo instalado na máquina:

https://docs.docker.com/get-docker/

Para subir o Frontend:

```bash

    # Navegar para o diretório do frontend
    $ cd devinhouse-projeto-final-modulo-3/projetos/frontend

    # Para subir os containers
    $ docker-compose up -d

```

Para Subir o Backend:

Para rodar o backend foi criado um arquivo makefile para facilitar a geração do artefato do java e posteriormente executar o container. Para executar o Makefile é necessário possuir o make na máquina.

Caso seja Windows segue link:

https://community.chocolatey.org/packages/make

Caso seja Linux:

```bash

$ apt install make

```

```bash

    # Navegar para o diretório do backend
    $ cd devinhouse-projeto-final-modulo-3/projetos/backend

    # Executa o Makefile
    $ make run

    # Executa o Makefile como processo
    $ make run -- -d

    # Executa o Makefile sem verbose no maven
    $ make run quiet=-q

    # Os argumentos podem ser usados juntos
    $ make run quiet=-q -- -d

    # Para parar o container
    $ make down

    # Para gerar o artefato
    $ make package

```

### Sem o Docker

Para subir o backend:

```bash

    # Navegar para o diretório do backend
    $ cd devinhouse-projeto-final-modulo-3/projetos/backend

    # Faça o build do backend

    # Caso Linux ou MacOS
    $ ./mvnw package
    # Caso Windows
    $ ./mvnw.cmd package

    # Navegar para a pasta target
    $ cd /target

    # Execute o arquivo .jar
    $ java -jar backend-0.0.1-SNAPSHOT.jar

```

Para subir o frontend:

```bash

    # Navegar para o diretório do frontend
    $ cd devinhouse-projeto-final-modulo-3/projetos/frontend

    $ npm install
    # ou
    $ yarn

    # Para iniciar a aplicação
    $ npm start
    # ou
    $ yarn start

```

<br/>