import java.io.File

// warehouse array[9] of crates
/*

[P]     [C]         [M]
[D]     [P] [B]     [V] [S]
[Q] [V] [R] [V]     [G] [B]
[R] [W] [G] [J]     [T] [M]     [V]
[V] [Q] [Q] [F] [C] [N] [V]     [W]
[B] [Z] [Z] [H] [L] [P] [L] [J] [N]
[H] [D] [L] [D] [W] [R] [R] [P] [C]
[F] [L] [H] [R] [Z] [J] [J] [D] [D]
 1   2   3   4   5   6   7   8   9
 */
const val fileName = "C:\\Dev\\Advent\\crane_data.txt"
var warehouse = arrayOf(
    arrayListOf("F","H","B","V","R","Q","D","P"),
    arrayListOf("L","D","Z","Q","W","V"),
    arrayListOf("H","L","Z","Q","G","R","P","C"),
    arrayListOf("R","D","H","F","J","V","B"),
    arrayListOf("Z","W","L","C"),
    arrayListOf("J","R","P","N","T","G","V","M"),
    arrayListOf("J","R","L","V","M","B","S"),
    arrayListOf("D","P","J"),
    arrayListOf("D","C","N","W","V")
)
fun getToDoLine(line:String):List<Int>{
    val pattern ="[^a-z]+".toRegex()
    val todoLine = arrayListOf<String>()
    val todo:ArrayList<Int> = ArrayList()
    val match = pattern.findAll(line)

    match.forEach{f -> val m = f.value
        todoLine.add(m.trim())
    }
    for(t in todoLine)
    {
        todo.add(t.toInt())
    }
    todo[1]-=1
    todo[2]-=1
    todoLine.clear()
    return todo
}
fun printMove(todo: List<Int>){
    println(String.format( "Move %d boxes from stack %d, to %d", todo[0], todo[1], todo[2]))
}
fun printWarehouse(){
    for(x in warehouse)
    {
        println(x)
    }
}
fun printTopCrates(){
    var topCrates:String=""
    for(x in warehouse)
    {
        topCrates+=x.last()
    }
    println(topCrates)
}

fun boxesMove(todo: List<Int>, useReverseOrder:Boolean){
    // 0 - qty, 1-from, 2-to
    printMove(todo)
    var sourceStackSize: Int = warehouse[todo[1]].count()
    var rmStart:Int = sourceStackSize-todo[0]
    if(useReverseOrder) {
        warehouse[todo[2]].addAll(warehouse[todo[1]].takeLast(todo[0]).reversed())
    }else{
        warehouse[todo[2]].addAll(warehouse[todo[1]].takeLast(todo[0]))
    }
    warehouse[todo[1]].subList(rmStart,sourceStackSize).clear()
    println(warehouse[todo[1]])
    println(warehouse[todo[2]])
    println("moved")
}
fun part1(){
    // x - qty, y-from, z-to
    printWarehouse()
    File(fileName).forEachLine()
    {
        boxesMove(getToDoLine(it),true)
    }
    printWarehouse()
    printTopCrates()
}
fun part2(){
    printWarehouse()
    File(fileName).forEachLine()
    {
        boxesMove(getToDoLine(it),false)
    }
    printWarehouse()
    printTopCrates()
}

fun main(){
    //part1()
    part2()
    readln()
}