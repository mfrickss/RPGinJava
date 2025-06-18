# RPG em Java

Um projeto de RPG de console desenvolvido em Java, utilizando princípios de orientação a objetos, padrões de projeto (Singleton, Factory, Observer, Strategy) e arquitetura MVC para organização e escalabilidade do código.

## 📋 Descrição

Este projeto simula um jogo de RPG em modo texto, onde o jogador explora uma masmorra, enfrenta monstros, gerencia inventário, compra itens em uma loja e pode salvar/carregar seu progresso. O código é modularizado, facilitando manutenção e expansão.

## 🛠️ Tecnologias e Conceitos Utilizados

- **Java 8+**
- **Orientação a Objetos**
- **Padrões de Projeto:** Singleton, Factory, Observer, Strategy
- **Arquitetura MVC**
- **Serialização de Objetos**
- **Coleções Java (ArrayList, HashMap, Set, etc.)**

## 📁 Estrutura do Projeto

```
RPG/
└── src/
    ├── model/        # Lógica de domínio (Player, Monstro, Itens, Inventário, Loja)
    ├── view/         # Exibição e interface com o usuário
    ├── controller/   # Fluxo principal do jogo
    └── observer/     # Interfaces do padrão Observer
```

## 🚀 Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repo.git
   ```
2. **Compile o projeto:**
   ```bash
   javac -d bin src/controller/Main.java
   ```
3. **Execute o jogo:**
   ```bash
   java -cp bin controller.Main
   ```

## 👨‍💻 Autores

- [Ricardo Augusto de Camargo](https://github.com/mfrickss)
- [João Carlos Pereira de Mello](https://github.com/joaocpmello)

## 📄 Licença

Este projeto é livre para fins acadêmicos e de estudo.
