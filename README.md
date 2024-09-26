# dio-modelando-iPhone-java
Diagramação das classes e interfaces com a proposta de representar os papéis do iPhone de: Reprodutor Musical, Aparelho Telefônico e Navegador na Internet



```mermaid
---
title: Modelando iPhone#1
---
classDiagram
    class Usuario
    Usuario : +main(args ~String~)

    class Telefone {
    +ligar()
    +atender()
    +verificarCorreioVoz()
    }

    class Internet {
    +exibir(url ~String~)
    +atualizar()
    +novaGuia()
    }

    class Musica {
    +progressBar
    +isPaused ~boolean~
    +tocar(musica ~String~)
    +pausarMusica()
    +resumirMusica()
    +pararMusica()
    }

    Usuario --> Telefone
    Usuario --> Internet
    Usuario --> Musica
```


https://mermaid-js.github.io/mermaid/#/
