# Aerodromes Map

Sistema construído usando **Java 17**, **Spring Boot** e Banco de dados **PostgreSQL** no _backend_ e **TypeScript**, **React.js** e **Material-UI 5** no _frontend_. Nele é possível se cadastrar, com um _nome_, _e-mail_ e _password_, e inserir Aerodromes usando um sistema de upload de arquivos _.json_. Após o upload do arquivo esses Aerodromes são renderizados em um mapa.

As especificações completas estão [aqui](https://drive.google.com/file/d/17muCC160IKbDQItXWvShypi08rwVJsXk/view?usp=sharing), embora o sistema desenvolvido as supere. Os detalhes desses recursos serão detalhados neste documento.

Outros documentos:

- Arquivo _.json_ para [download](https://drive.google.com/file/d/1UCNVPNEEkXWyGA_pQ-KDYtX04NT9yE59/view?usp=sharing);
- Documentos de modelagem do Bando de Dados para [download](https://docs.google.com/document/d/1L2GnNVsrPFozc6OrCDVdmDe39kM7PfwTZWNi4c7475g/edit?usp=sharing);
- Configuração do projeto para VSCode para [download](https://drive.google.com/drive/folders/1derS_dKNcHaTqkB8_usD6cNRrE8vwhAN?usp=sharing) (poderá ser útil, caso haja problemas com a configuração do Eslint).

## Backend

Foi construído usando os princípios de _Clean Code_, _Clean Architecture_ e _SOLID_ na forma de API _REST_. Essa camada foi criada na pasta **backend** do projeto. Para fazer a validação dos repositórios e operações SQL, usamos **JPA** e **Hibernates**. A segurança do sistema foi feita usando _JWT_.

As funções extras desenvolvidas (que não estão no documento de requisitos) são:

- Criação de usuários funcional;
- Autenticação funcional;
- Sistema de autorização (permissões) funcional;
- Tratamento global de exceções;
- Diversos endpoints funcionais para fins de testes (usando Postman, por exemplo).

Algumas features ficaram faltando e não foram desenvolvidas ainda por falta de tempo:

- Endpoint para _logout_;
- Endpoint para recuperar dados do usuário logado através do _token_ (atualmente o sistema recupera dados do usuário para fins de autorização de uma forma insegura).

### Como Executar

Existe uma infinidade de maneira de executar o projeto dependendo da _IDE_ utilizada durante o desenvolvimento. Alguns recursos foram desenvolvidos para facilitar a execução e para fins didáticos.

#### 1) Conexão com o Banco de Dados

Para facilitar a execução do backend, foi criado o script _backend/scrips/\_start_postgres_local_container.sh_, que baixa a imagem **Docker** do **PostgreSQL**, configura a conexão e começa a executar (é necessário ter o **Docker** instalado).

Foi configurado (arquivo _backend/xmobotscase/src/main/resources/application.properties_) para que o **Hibernates** recrie as tabelas toda vez que o servidor for iniciado. Para alterar isso, basta mudar a opção na linha:

```java
spring.jpa.hibernate.ddl-auto=create
```

#### 2) Deploy do Backend em Container

O projeto também pode ser executado em container **Docker**. Para isso foi criado o arquivo com informações da criação da _imagem_ (_backend/docker/Dockerfile_) e os arquivos: _backend/\_build_java_server.sh_ e _backend/\_start_java_server.sh_. O primeiro cria uma imagem **Docker** com o projeto e o segundo inicializa o container.

Caso queira executar dessa forma, lembre-se de alterar as configurações em _backend/xmobotscase/src/main/resources/application.properties_ e _backend/docker/Dockerfile_ de acordo com as configurações do seu sistema local.

## Frontend

No frontend, além das já mencionadas, foram usadas diversas bibliotecas que facilitaram o desenvolvimento. As principais são:

- [eslint](https://www.npmjs.com/package/eslint), para manter a qualidade do código;
- [react-hook-form](https://www.npmjs.com/package/react-hook-form), que facilita o gerenciamento de formulários;
- [yup](https://www.npmjs.com/package/yup), para validação de formulários;
- [leaflet](https://www.npmjs.com/package/leaflet) e [react-leaflet](https://www.npmjs.com/package/react-leaflet), para o gerenciamento do mapa e outros recursos;
- [react-dropzone](https://www.npmjs.com/package/react-dropzone), para upload de arquivos de forma moderna e amigável.

Assim como no backend, alguns recursos a mais também foram desenvolvidos:

- Tratamento de autenticação e autorização do lado do cliente;
- Recurso que centraliza o mapa de acordo com a posição do usuário (é necessário autorizar esse recurso no browser e as vezes a posição não é exata);
- Ao clicar na marcação de um Aerodrome, as informações dele são exibidas em um _modal_.

Notas sobre o frontend:

- Na página principal estados locais seriam suficientes para o desenvolvimento de todas as _features_. A API de Contexto foi utilizada somente para fins didáticos;
- Por questões de versatilidade, arquitetura e reuso de código, todos os componentes na pasta _frontend/src/components_ requerem atributos passados explicitamente como variáveis. Esses componentes não utilizam dados de contextos, embora estejam dentro deles.

Ficou faltando desenvolver no frontend alguns recursos que seriam úteis:

- Uma legenda para as marcações no mapa;
- Mover o botão de upload de arquivo para outro local (dependendo do local, será necessário criar um contexto global que controla a abertura do _modal_).

### Como Executar

Para executar o frontend localmente, basta instalar os pacotes e executar o servidor. Os dados para a configuração da comunicação com a API, entre outras, está em _frontend/.env_.

#### 1) Instalação de Pacotes

Entrar na pasta _client_ e instalar os pacotes usando _npm_ ou _yarn_:

    yarn install

#### 2) Executar o Servidor

    yarn start

O frontend deve estar rodando em http://localhost:3000.

### Deploy do Frontend em Container

Assim como no backend, o modulo de _deploy_ utilizando container **Docker** também foi desenvolvido para o frontend.

No arquivo _frontend/docker/Dockerfile_ estão os dados para a criação da imagem **Docker** contendo o servidor do frontend. Foram criados também arquivos de geração da imagem e execução do container: _frontend/\_build_react_server.sh_ e _frontend/\_start_react_server.sh_.

Caso queira usar essa opção, lembrar de alterar os arquivos de acordo com a configuração do seu sistema local!

## Dúvidas?

Qualquer dúvida: entrar em contato através do e-mail _juniorbocelli.com_ ou WhatsApp (16) 99123-9505.
