# web-comprar-passagens-aereas
web-comprar-passagens-aereas

## ![Windows Logo](https://raw.githubusercontent.com/gabrielrtakeda/app-comprar-passagens-aereas/master/binary/images/icons/windows-16.png "Windows Logo") Subir projeto no Windows
 - Instalar GlassFish 4.1.1
 - Instalar Maven
 - Insira o diretório principal do Maven no PATH da máquina

 - Ter MySQL instalado
 - Rodar o Script `database.sql`

 - Abra o Prompt de Comando (Win + R -> cmd -> Enter)
 - Entre na pasta do projeto `cd caminho/do/projeto`
 - Execute `mvn clean package` para gerar o arquivo `.war`

 - Instale o GlassFish no `C:\` da máquina
 - Para subir o servidor GlassFish execute no Prompt de Comando `C:\glassfish4\glassfish\bin\asadmin.bat start-domain`
 - Irá ficar esperando a execução do servidor
 - No browser acesse `localhost:4848`
 - Aguarde e logo em seguida será exibido que o servidor está disponível

 - No Prompt de Comando execute `C:\glassfish4\glassfish\bin\asadmin.bat deploy --force=true caminho\do\projeto\target\web-comprar-passagens-aereas.war`

 - Acesse `http://localhost:8080/web-comprar-passagem-aerea/` para visualizar o projeto
 - Acesse o sistema com um dos seguintes usuários:
    - `gabrieltakeda`, `123`
    - `wesleyalmeida`, `123`
    - `karinapinna`, `123`

 - Enjoy! (:

## ![ST Logo](https://raw.githubusercontent.com/gabrielrtakeda/app-comprar-passagens-aereas/master/binary/images/icons/sublime-24.png "ST Logo") Subir projeto no OS X com sublime
 - Abra o projeto `web-comprar-passagem-aerea.sublime-project` no sublime
 - Para efetuar deploy do projeto ⌘ + B para compilar

 - Acesse `http://localhost:8080/web-comprar-passagem-aerea/` para visualizar o projeto
 - Acesse o sistema com um dos seguintes usuários:
    - `gabrieltakeda`, `123`
    - `wesleyalmeida`, `123`
    - `karinapinna`, `123`
