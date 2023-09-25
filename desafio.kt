enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Destimificando Kotlin ", 120)
    val conteudo2 = ConteudoEducacional("Explorando Padrões de Projetos com Kotlin", 180)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)

    val formacao1 = Formacao("Desenvolvimento de Software", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))

    val aluno1 = Usuario("João")
    val aluno2 = Usuario("Maria")

    formacao1.matricular(aluno1)
    formacao2.matricular(aluno2)


    println("${formacao1.inscritos.map { it.nome }}: inscreveu-se em ${formacao1.nome}\n Conteudo ${conteudo1.nome} ")
    println("${formacao2.inscritos.map { it.nome }}: inscreveu-se em ${formacao2.nome}\n Conteudo ${conteudo2.nome} ")
  
}