import java.io.File

fun fullyContained(x1:Int, x2:Int, y1:Int, y2:Int):Boolean
{
    if((y1>=x1) and (y2<=x2)) {return true} // 2nd in 1st
    if((x1>=y1) and (x2<=y2)) {return true} // 1st in 2nd
    return false
}

fun partiallyOverlapped(x1:Int, x2:Int, y1:Int, y2:Int):Boolean{
    if((x2<y1) or (y2<x1)) 
    {
        return false
    }   //no overlap, everything else counts
    return true
}

fun main(){
    val fileName = "C:\\Dev\\Advent\\cleaning_data.txt"
    var item1:List<String>
    val intervals:ArrayList<Int> = ArrayList()
    var pairs:String
    var fullCount:Int = 0
    var partialCount:Int = 0
    File(fileName).forEachLine()
    {
        pairs = it.replace(',','-', true)
        item1 = pairs.split('-')
        for(item in item1){
            intervals.add(item.toInt())
        }
        if(fullyContained(intervals[0],intervals[1], intervals[2], intervals[3])){
            fullCount++
        }
        if(partiallyOverlapped(intervals[0],intervals[1], intervals[2], intervals[3])){
            partialCount++
        }
        intervals.clear()
    }
    println(fullCount)
    println(partialCount)
    readln()
 }