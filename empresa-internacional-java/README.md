
# Requisitos Funcionais

**Objetivo:** A partir de uma URL, obter o trecho de texto contido no nível mais profundo da estrutura HTML do seu conteúdo. Por exemplo:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>
        Este é o título.
    </title>
</head>
<body>
    Este é o corpo.
</body>
</html>
```

No exemplo acima, o trecho desejado como retorno é `Este é o título.` (sem as aspas), pois está em 3 níveis de profundidade (`html > head > title`), enquanto o trecho `Este é o corpo` está em 2 níveis (`html > body`). Se dois ou mais trechos estiverem no nível máximo de profundidade do documento, o primeiro deles deve ser retornado.

Para simplificar o escopo do problema, a solução deve seguir as seguintes premissas:

1. O código HTML está dividido em linhas;
2. Cada linha pode ser apenas de um dos seguintes tipos:
    - Tag de abertura (exemplo: `<div>`)
    - Tag de fechamento (exemplo: `</div>`)
    - Trecho de texto (exemplo: `Este é o corpo.`)
3. Uma mesma linha não pode conter dois tipos de conteúdo;
4. Apenas elementos HTML com pares de tags de abertura e fechamento são utilizados (exemplo: `<div>` e `</div>`, mas não `<br/>`);
5. Tags de abertura não possuem atributos (contra-exemplo: `<a href="link.html">`).

Cada linha pode ou não ter espaços iniciais, utilizados apenas para indentação, que devem ser ignorados. Linhas em branco também devem ser ignoradas.

**Opcional:** Pontos bônus serão concedidos caso a solução seja capaz de identificar estruturas HTML malformadas, retornando nesse caso a mensagem `"malformed HTML"` (sem as aspas).

# Requisitos Técnicos
1. A solução deve ser desenvolvida como um programa Java a ser compilado e executado pela linha de comando, utilizando o JDK 17.
2. Não é permitido o uso de quaisquer bibliotecas ou frameworks externos ao JDK. Também não é permitido o uso de packages e classes nativos do JDK relacionados à manipulação de HTML, XML ou DOM (como `javax.xml` ou quaisquer outros).
3. Para a compilação do programa, deve ser suficiente executar o seguinte comando a partir do diretório que contém o(s) arquivo(s) de código, sem quaisquer alterações:
   ```sh
   javac HtmlAnalyzer.java
   ```
4. Para a execução do programa, deve ser suficiente executar o seguinte comando, a partir do diretório onde foi feita a compilação (item anterior), alterando apenas o argumento para a URL a ser analisada:
   ```sh
   java HtmlAnalyzer inserir-url-aqui
   ```