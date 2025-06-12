# RPG em Java

Um jogo de RPG desenvolvido em Java com sistema de combate, inventário, conquistas e salvamento de progresso.

## Como usar

### 1. Compilar o projeto
```bash
.\compile.bat
```
Este comando compila todos os arquivos `.java` e gera os arquivos `.class` na pasta `build/`.

### 2. Executar o jogo
```bash
.\run.bat
```
Este comando executa o jogo usando os arquivos compilados da pasta `build/`.

### 3. Limpar arquivos compilados
```bash
.\clean.bat
```
Este comando remove todos os arquivos `.class` e a pasta `build/`.

## Estrutura do Projeto

```
RPG/
├── src/                    # Código fonte
│   ├── Main.java          # Classe principal
│   └── Personagens/       # Classes dos personagens
├── build/                 # Arquivos compilados (.class)
├── compile.bat           # Script de compilação
├── run.bat              # Script de execução
├── clean.bat            # Script de limpeza
└── README.md            # Este arquivo
```

## Funcionalidades

- Sistema de combate por turnos
- Inventário com diferentes tipos de itens
- Sistema de conquistas com padrão Observer
- Salvamento e carregamento de progresso
- Diferentes tipos de monstros com níveis
- Interface de usuário interativa

## Padrões de Projeto Implementados

- **Singleton**: Para gerenciar recursos compartilhados
- **Observer**: Para sistema de conquistas
- **Factory**: Para criação de monstros

## Tecnologias

- Java 8+
- Programação Orientada a Objetos
- Serialização para persistência de dados 