fun main() {
    println("Bem vindo ao Bytebank")

    //instancia da classe
    //nao conseguiremos imprimir dessa forma por isso teremos que a colocar dentro de uma variavel
    val contaAlex = Conta("Alex", 1000)
    //poderiamos indicar os parametros por labels, e elas nao precisam seguir a ordem do construtor:
    /* val contaAlex = Conta( numero = 1000, titular = "Alex") */
    /* contaAlex.titular = "Alex"
    contaAlex.numero = 1000 */
    contaAlex.deposita(200.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    val contaFran = Conta("Fran", 1001)
    /* contaFran.titular = "Fran"
    contaFran.numero = 1001 */
    contaFran.deposita(300.0)
    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("Depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("Depositando na conta da Fran")
    contaFran.deposita(60.0)
    println(contaFran.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(20.0)
    println(contaAlex.saldo)

    println("Sacando na conta da Fran")
    contaFran.saca(20.0)
    println(contaFran.saldo)

    println("Transferencia da conta da Fran para a conta do Alex")
    if(contaFran.transfere(100.0, contaAlex)){
        println("Transferencia sucedida")
    }else {
        println("Falha na transferencia")
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)
}

//temos que criar a classe no mesmo nivel de arquivo
//esses parametros sao do construtor, pois utilizamos ele ja na classe inicial
class Conta(var titular: String, val numero: Int) {
    //var titular = ""
    //var numero = 0
    var saldo = 0.0
        //caso queremos que somente nos modificamos tal atributo colocamos o set como private
        private set

    //construtor padrao usamos somente quando queremos modificar algo
   /* constructor(titular: String, numero: Int){
        this.titular = titular
        this.numero = numero
    } */


    fun deposita(valor: Double){
        if(valor > 0) {
            saldo += valor
        }
    }

    fun saca(valor: Double){
        if(saldo >= valor){
            saldo -= valor
        }
    }

    //para indicar que queremos um retorno, por padrao ele nos retorna um Unit, mas como queremos um boolean indicamos ele
    fun transfere(valor: Double, destino: Conta): Boolean {
        if(saldo >= valor){
            saldo -= valor
            destino.deposita(valor)
            return true
        }
            return false
        }

    //get e set nao sao interessantes para o kotlin
    /*fun getSaldo(): Double{
        return saldo
    }

    fun setSaldo(valor: Double) {
        if (valor > 0) {
            saldo = valor
        }
    } */
}




fun testaCopiaEReferencias(){
    //quando informamos que uma variavel recebe outra, estamos realizando uma copia dela
    val numeroX = 10
    var numeroY = numeroX
    numeroY++
    println(numeroX)
    println(numeroY)

    //quando fazemos isso com uma classe ele nao cria uma copia e sim instancia ela e por isso o valor sera alterado nas duas
    val contaJoao = Conta("Joao", 1002)
    /* contaJoao.titular = "Joao" */
    var contaMaria = Conta("Maria", 1003)
    /* contaMaria.titular = "Maria" */
    println(contaJoao.titular)
    println(contaMaria.titular)

}

fun testaLacos(){
    var i = 0
    while(i < 5) {
        val titular = "Alex $i"
        val numeroConta = 1000 + i
        var saldo = i + 10.0

        println("Titular $titular")
        println("Numero da conta $numeroConta")
        println("Saldo da conta $saldo")
        println()
        i++
    }

    /*
      for (i in 1..3) {

         //val variavel que nao permite modificar o valor
         //var varival que permite modificar o valor
         //deve sempre inicializar a variavel
         val titular = "Alex $i"
         val numeroConta = 1000 + i
         var saldo = i + 10.0


         //podemos utilizar a string templete que eh chamar a variavel dentro da string
         println("Titular $titular")
         println("Numero da conta $numeroConta")
         println("Saldo da conta $saldo")
         println()
        */
    // testaCondicoes(saldo)

    //for in soh permite quando o primeiro numero eh menor do que o ultimo da condicao
    //quando queremos diminuir temos que usar o downTo
    /*
    for(i in 5 downTo 1 step 1){
        println(i)
        //se quisermos parar a operacao utilizamos o if com o break
        if(i == 4){
            break
        }
    }
    */
}

fun testaCondicoes(saldo: Double) {

    if (saldo > 0.0) {
        println("conta eh positiva")
    } else if (saldo == 0.0) {
        println("conta eh neutra")
    } else {
        println("conta eh negativa")
    }

    //Substitui o if pelo when para que fique menor
    when {
        saldo > 0.0 -> {
            println("conta eh positiva")
        }
        saldo == 0.0 -> {
            println("conta eh neutra")
        }
        else -> {
            println("conta eh negativa")
        }
    }

    //e ainda conseguimos diminuir mais tirando as chaves e colocando na mesma clinha
    when {
        saldo > 0.0 -> println("conta eh positiva")
        saldo == 0.0 -> println("conta eh neutra")
        else -> println("conta eh negativa")
    }

}