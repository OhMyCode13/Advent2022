import java.io.File

fun getLtrPriority(letter: Char ): Int {
    val ltrPriority = mapOf('a' to 1, 'b' to 2, 'c' to 3, 'd' to 4, 'e' to 5, 'f' to 6, 'g' to 7, 'h' to 8,
        'i' to 9, 'j' to 10, 'k' to 11, 'l' to 12, 'm' to 13, 'n' to 14, 'o' to 15, 'p' to 16,  'q' to 17,
        'r' to 18,  's' to 19,  't' to 20,  'u' to 21, 'v' to 22, 'w' to 23, 'x' to 24, 'y' to 25, 'z' to 26)
    var chrPriority:Int = 0
    chrPriority = ltrPriority.getValue(Character.toLowerCase(letter))
    if(letter.isUpperCase()){
        chrPriority += 26
    }
    return chrPriority
}

fun main() {
    val fileName:String = "C:\\Dev\\Advent\\rucksack_data.txt"
    var item1:String
    var item2:String
    var u1:List<Char>
    var u2:List<Char>
    var totalPriorities:Int=0
    /*  // Part 1
    File(fileName).forEachLine()
    {
        item1= it.subSequence(0, it.length/2).toString()
        u1 = item1.toCharArray().distinct()
        item2= it.subSequence(it.length/2, it.length).toString()
        u2 = item2.toCharArray().distinct()
        var sect = u1.intersect(u2.toSet())
        totalPriorities += getLtrPriority(sect.first().toChar())
    }*/

    var lineCtr: Int =0
    var elfCtr: Int =0
    var elfBadges= ArrayList<List<Char>>()
    var elfGroupBadgePriority:Int=0
    var elfGroupBadge = setOf(' ')
    // Part 2
    File(fileName).forEachLine()
    {
        elfBadges.add(it.toCharArray().distinct())
        lineCtr++
        elfCtr++
        if(elfCtr %3 == 0){
            elfGroupBadge = elfBadges[0].intersect(elfBadges[1].toSet().intersect(elfBadges[2].toSet()))
            elfGroupBadgePriority = getLtrPriority(elfGroupBadge.first().toChar())
            totalPriorities += elfGroupBadgePriority
            elfBadges.clear()
            lineCtr=0
        }
    }
    println(totalPriorities)
    readln()

}