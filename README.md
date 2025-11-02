# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


# 📘 Projeto de Desenvolvimento e Aplicação de Conteúdo Técnico Online

## 🧠 Descrição
Projeto voltado para o **desenvolvimento de conteúdo educacional** para **desenvolvedores web**, com foco em níveis de aprendizado progressivos — do básico ao avançado.  

Permite **matricular usuários**, adicionar **notas de cursos**, calcular **média** e gerar **avaliações textuais**, além de **modificar níveis de usuário**.

---

# Níveis do aluno

## 🏁 Nível Básico
Conteúdo destinado a iniciantes nas tecnologias web.  
Tópicos abordados:

- Introdução a **HTML**, **CSS** e **JavaScript**  
- Fundamentos de **lógica de programação**  
- Conceitos sobre **internet e protocolos** (HTTP, TCP/IP)

---

## ⚙️ Nível Intermediário
Voltado para quem já possui base em desenvolvimento web.  
Conteúdos incluem:

- **Frameworks** e **ferramentas de design** (Figma, Tailwind, Next.js)  
- Fundamentos de **front-end** e **back-end**  
- Conceitos de **negócios** e **qualidade de software (QA)**

---

## 🚀 Nível Avançado
Focado em profissionais que desejam aprofundar conhecimentos técnicos.  
Abrange:

- Papel do **analista de sistemas**  
- **Arquitetura de software**, QA avançado e banco de dados  
- **Design Thinking** e **metodologias de empreendedorismo**

---

## 🧩 Nível Expert
Voltado para dominar todo o processo de implementação de projetos web.  
Inclui:

- Planejamento e **arquitetura de soluções web em larga escala**  
- **Gerenciamento de equipes** e versionamento de código (Git, GitHub, Git Flow)  
- **Boas práticas de DevOps**, CI/CD e automação de deploy  
- Estratégias de **segurança, escalabilidade e performance**  
- Estudos de caso sobre projetos reais e **metodologias ágeis** (Scrum, Kanban)

---

# Conteúdo Educacional

Cada curso possui:

- `id`: Identificador único  
- `nome` e `descricao`: Informações do curso  
- `duracao`: Duração em minutos  

### Métodos principais:

- `modificarNomeDescricaoCurso(novoNome, novaDescricao)`: Alterar nome e descrição do curso

---

## Notas de Avaliação

| Nota | Valor | Descrição     |
|------|-------|--------------|
| UM   | 1     | Ruim         |
| DOIS | 2     | Regular      |
| TRES | 3     | Bom          |
| QUATRO | 4   | Muito bom    |
| CINCO | 5    | Excelente    |

### Funções relacionadas:

- `adicionarNotaCurso(novaNota)`: Adiciona nota a um curso da formação  
- `calcularMediaCurso()`: Calcula média das notas  
- `imprimirAvaliacaoCurso()`: Mostra avaliação textual baseada na média

---

# Usuários

Cada usuário possui:

- `id`: Identificador único  
- `nome`: Nome do usuário  
- `idade`: Idade  
- `nivel`: Nível (`BASICO`, `INTERMEDIARIO`, `AVANCADO`, `EXPERT`)  

### Funções disponíveis:

- `imprimirPerfilUsuario()`: Imprime dados do usuário  
- `modificarDadosUsuario(novoNomeUsuario, novaIdade, novoNivel)`: Alterar dados do usuário  

---

# Formação

Cada formação contém:

- `nome`: Nome da formação  
- `conteudos`: Lista de cursos (`ConteudoEducacional`)  
- `notas`: Lista de notas (`NotaCurso`)  
- `media`: Média calculada  
- `inscritos`: Lista de usuários matriculados  

### Funções principais:

- `matricular(usuario)`: Adiciona um usuário à formação  
- `modificarNivelUsuario(id, novoNivel)`: Modifica o nível de um usuário específico  

---

## Cenário de Teste

```kotlin
fun main() {
    val usuario1 = Usuario(1, "Alice", 25, Nivel.BASICO)
    val usuario2 = Usuario(2, "Bob", 30, Nivel.INTERMEDIARIO)

    val curso1 = ConteudoEducacional(1, "Kotlin Básico", "Aprenda o básico de Kotlin")
    val curso2 = ConteudoEducacional(2, "Kotlin Avançado", "Técnicas avançadas em Kotlin")

    val formacao = Formacao("Formação Kotlin Developer", listOf(curso1, curso2))

    println("- Matricula do aluno -")
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("- Adiciona notas aos cursos -")
    formacao.adicionarNotaCurso(NotaCurso.TRES)
    formacao.adicionarNotaCurso(NotaCurso.QUATRO)

    println("- Calcula e imprime a média/avaliação do curso -")
    formacao.calcularMediaCurso()
    formacao.imprimirAvaliacaoCurso()

    println("- Modifica o nível do usuário -")
    formacao.modificarNivelUsuario(1, Nivel.AVANCADO)

    println("- Imprime os dados do usuário -")
    usuario1.imprimirPerfilUsuario()
    usuario2.imprimirPerfilUsuario()
}
