// [Template no Kotlin Playground](https://pl.kotl.in/eL-vaRmty)

enum class Nivel(val descricao: String) { BASICO("Básico"), INTERMEDIARIO("Intermediário"), AVANCADO("Avançado"), EXPERT("Esperto") }
enum class NotaCurso(val valor: Int, val descricao: String) {
    UM(1, "Ruim"),
    DOIS(2, "Regular"),
    TRES(3, "Bom"),
    QUATRO(4, "Muito bom"),
    CINCO(5, "Excelente")
}

class Usuario(val id: Int, var nome: String, var idade: Int, var nivel: Nivel) {
    // Função para imprimir os dados do usuário
    fun imprimirPerfilUsuario() {
        println("-------------------------------------------")
        println("-- $nome --")
        println("ID: $id")
        println("Idade: $idade anos, Nível: $nivel.descricao")
        println("-------------------------------------------")
    }
    
    // Função para modificar o tempo de conclusão do usuário
    fun modificarDadosUsuario(id: Int, novoNomeUsuario: String?, novaIdade: Int?, novoNivel: Nivel?) {
       if (novoNomeUsuario != null) {
           this.nome = novoNomeUsuario
           println("Nome do usuário alterado com sucesso!")
       }
       if (novaIdade != null) {
           this.idade = novaIdade
           println("Idade do usuário alterado com sucesso!")
       }
       if (novoNivel != null) {
           this.nivel = novoNivel
           println("Nível do usuário alterado com sucesso!")
       }
    }
}

data class ConteudoEducacional(
    val id: Int, 
    var nome: String, 
    var descricao: String, 
    val duracao: Int = 60
) {    
    // Modifica o nome e a descrição
    fun modificarNomeDescricaoCurso(novoNome: String?, novaDescricao: String?) {
        if (novoNome != null) {
            this.nome = novoNome
        	println("Nome do curso alterado com sucesso!")
        }
        if (novaDescricao != null) {
            this.descricao = novaDescricao
        	println("Descrição do curso alterado com sucesso!")
        }
    }
}

data class Formacao(
    val nome: String, 
    var conteudos: List<ConteudoEducacional>,
    var notas: MutableList<NotaCurso> = mutableListOf<NotaCurso>(), 
    var media: Double = 0.0,
) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário(a) ${usuario.nome} inscrito(a)!")
    }
    // Vai modificar a nota do curso
    fun adicionarNotaCurso(novaNota: NotaCurso) {
        this.notas.add(novaNota)
        println("Nota do curso - $nome - adicionada(o) com sucesso!")
    }
    
    // Calcula a média do curso
    fun calcularMediaCurso(imprimir: Boolean = false): Double {
        if (this.notas.size > 0) {
            var soma: Double = 0.0
            for (i in 0 until this.notas.size) {
                soma += this.notas[i].valor
            }
            val mediaCalculada: Double = soma / this.notas.size - 1
            this.media = mediaCalculada
            
            if (!imprimir) {
             	println("Média do curso $nome: $media")   
            }
            
            return mediaCalculada
        } else {
            if (!imprimir) {
            	println("O curso ainda não foi avaliado.")   
            }
            
            return 0.0
        }
    }
    
    // Imprime a avaliação da média do curso
    fun imprimirAvaliacaoCurso() {
        val mediaAtualizada = calcularMediaCurso(true)

        if (mediaAtualizada > 0.0) {
            var descricaoMedia = ""
            
            when (this.media) {
                in 0.0..0.9 -> println("Avaliação: Muito Ruim")
                in 1.0..1.9 -> println("Avaliação: Ruim")
                in 2.0..2.9 -> println("Avaliação: Regular")
                in 3.0..3.9 -> println("Avaliação: Bom")
                in 4.0..4.9 -> println("Avaliação: Muito bom")
                5.0 -> println("Avaliação: Excelente")
                else -> println("Média fora do intervalo esperado")
            }
        } else {
            println("O curso ainda não foi avaliado.")
        }
    }
    
    // Função para modificar o nivel do usuário
    fun modificarNivelUsuario(id: Int, novoNivel: Nivel) {
       for ( usuario in inscritos) {
           if (usuario.id == id) {
               usuario.nivel = novoNivel
               println("Usuário(a) ${usuario.nome} com nível alterado para ${novoNivel.descricao}")
               break
           }
       }
    }
}

fun main() {
    val usuario1 = Usuario(1, "Alice", 25, Nivel.BASICO)
    val usuario2 = Usuario(2, "Bob", 30, Nivel.INTERMEDIARIO)

    val curso1 = ConteudoEducacional(1, "Kotlin Básico", "Aprenda o básico de Kotlin")
    val curso2 = ConteudoEducacional(2, "Kotlin Avançado", "Técnicas avançadas em Kotlin")

    val formacao = Formacao("Formação Kotlin Developer", listOf(curso1, curso2))

    println("- Matricula do aluno -")
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println()
    println("- Adiciona notas aos cursos -")
    formacao.adicionarNotaCurso(NotaCurso.TRES)
    formacao.adicionarNotaCurso(NotaCurso.QUATRO)

    println()
    println("- Calcula e imprime a média/avaliação do curso -")
    formacao.calcularMediaCurso()
    formacao.imprimirAvaliacaoCurso()

    println()
    println("- Modifica o nível do usuário aqui -")
    formacao.modificarNivelUsuario(1, Nivel.AVANCADO)

    println()
    println("- Imprime os dados do usuário -")
    usuario1.imprimirPerfilUsuario()
    usuario2.imprimirPerfilUsuario()
}