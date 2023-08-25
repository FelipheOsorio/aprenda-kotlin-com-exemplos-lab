enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val name: String, val cpf: String)

data class ConteudoEducacional(val nome: String, var nivel: Nivel, var duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val _inscritos = mutableMapOf<String, String>()

    private val inscritos: Map<String, String> = _inscritos

    fun matricularAlunos(vararg listaUsuario: Usuario) {

        for (usuario in listaUsuario) {
            if (_inscritos.containsKey(usuario.cpf)) {
                println("O/A Aluno(a): ${usuario.name} ja possui matricula nesta formação")
            } else {
                _inscritos[usuario.cpf] = usuario.name
                println("Matricula Feita !!!!!")
            }
        }
    }

    fun mostrarAlunosMatriculados() {
        when (inscritos.isNotEmpty()) {
            true -> {
                println("Alunos Matriculados: ${inscritos.values}")
            }

            false -> println("Nenhum Aluno Matriculado")
        }
    }
}


fun main() {

    val timeDuration = { nivel: Nivel ->
        when (nivel.name) {
            "BASICO" -> 60
            "INTERMEDIARIO" -> 120
            else -> 180
        }
    }

    val formacao = Formacao(
        "Android Developer",
        listOf(
            ConteudoEducacional(
                "Linguagem de Programação Kotlin",
                Nivel.BASICO,
                timeDuration(Nivel.BASICO)
            ),
            ConteudoEducacional(
                "Fundamentos de Desenvolvimento Mobile Nativo Para Android",
                Nivel.BASICO,
                timeDuration(Nivel.BASICO)
            ),
            ConteudoEducacional(
                "Noções Básicas do Android com Kotlin",
                Nivel.INTERMEDIARIO,
                timeDuration(Nivel.INTERMEDIARIO)
            ),
            ConteudoEducacional(
                "Dominando o Android Jetpack",
                Nivel.AVANCADO,
                timeDuration(Nivel.AVANCADO)
            )
        )
    )

    formacao.mostrarAlunosMatriculados()
    println("/////////////////")

    formacao.matricularAlunos(
        Usuario(
            "Felipe",
            "111.111.111.11"
        ),
        Usuario(
            "Ana",
            "222.222.222.22"
        ),
        Usuario(
            "Carlos",
            "222.222.222.22"
        ),
        Usuario(
            "Roberto",
            "444.444.444.44"
        ),
        Usuario(
            "Juliana",
            "555.555.555.55"
        ),
        Usuario(
            "Nilton",
            "111.111.111.11"
        )
    )
    println("/////////////////")

    formacao.mostrarAlunosMatriculados()
}
