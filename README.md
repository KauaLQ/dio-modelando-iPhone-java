<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=E76F00&height=120&section=header"/>

# dio-modelando-iPhone-java <img width='50' heigth='50' src="https://static-00.iconduck.com/assets.00/java-icon-1511x2048-6ikx8301.png" />
#### Olá, _Javeiros_. Este repositório é resultado de um desafio de código do curso de Java Básico da Digital Inovation One (DIO), focado no aprimoramento de habilidades com a Linguagem de Modelagem Unificada (UML). O objetivo foi criar diagramas que representassem os papéis do iPhone como Reprodutor Musical, Aparelho Telefônico e Navegador na Internet. Além disso, desenvolvi um _software_ básico para simular essas funções, utilizando a biblioteca _Swing_ para a interface gráfica, com a qual tenho mais afinidade. Estou muito satisfeito com o resultado, e este foi, até agora, o projeto Java em que mais me dediquei. Espero que vocês gostem também! :)
#### Abaixo, você encontrará o diagrama UML do projeto.
---
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

    style Usuario fill:#4E7896,color:#000000
    style Telefone fill:#4E7896,color:#000000
    style Internet fill:#4E7896,color:#000000
    style Musica fill:#4E7896,color:#000000

    Usuario --> Telefone
    Usuario --> Internet
    Usuario --> Musica
```
---

### _Gostou do meu perfil? Você pode saber mais sobre mim em:_ &nbsp;&nbsp;[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kaualimaq/)
### _Ou me contatar através do:_ &nbsp;&nbsp;[![Gmail](https://img.shields.io/badge/Gmail-333333?style=for-the-badge&logo=gmail&logoColor=red)](mailto:limakaua610@gmail.com)
### _Referências:_
<https://felipe-aguiar.gitbook.io/dio-java>

<https://mermaid-js.github.io/mermaid/#/>
