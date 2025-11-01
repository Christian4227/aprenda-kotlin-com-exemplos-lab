// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO, EXPERT }

class Usuario(val id: Int, var nome: String, var idade: Int, var nivel: Nivel) {
    // Função para imprimir os dados do usuário
    fun imprimirPerfilUsuario() {
        println("Nome: $nome - ID: $id")
        println("Idade: $idade anos, Nível: $nivel")
    }
    
    // Função para modificar o tempo de conclusão do usuário
    fun modificarDadosUsuario(id: Int, novoNomeUsuario: String?, novaIdade: Int?, novoNivel: Nivel?) {
       if (novoNomeUsuario != null) {
           this.nome = novoNomeUsuario
       }
       if (novaIdade != null) {
           this.idade = novaIdade
       }
       if (novoNivel != null) {
           this.nivel = novoNivel
       }     
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    // Função para modificar o nivel do usuário
    fun modificarNivelUsuario(id: Int, novoNivel: Nivel) {
       for ( usuario in inscritos) {
           if (usuario.id == id) {
               usuario.nivel = novoNivel
               break
           }
       }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}