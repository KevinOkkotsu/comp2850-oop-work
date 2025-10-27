import kotlin.math.hypot

class Point(var x:Double, var y: Double) {
    fun distanceToOrigin():Double {
        return hypot(x,y)
    } 
    fun distanceFrom():Double {
        return hypot(x-4.5, y-7.0)
    } 
}

fun main(){
    val p = Point(5.0,7.4)
    
    println(p.x)
    println(p.y)
    println(p.distanceFrom())
    println(p.distanceToOrigin())
}