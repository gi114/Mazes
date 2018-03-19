import MazePosition.Loc

object MazePosition {

  case class Direction(dx: Int, dy: Int)

  case class Loc(x: Int, y: Int) {
    def +(that: Direction): Loc = Loc(x + that.dx, y + that.dy)
    def isOutBound: Boolean = {
      if (this.y <= -1 || this.y >= 11 || this.x <= -1 || this.x >= 10) true
      else false
    }
  }
  //val outOfBound = List(Loc(_,-1), Loc(-1,_), Loc(_, 11), Loc(10, _))

  val North = Direction(0,-1)
  val South = Direction(0,1)
  val West = Direction(-1,0)
  val East = Direction(1,0)
  val directions = Set(North, South, West, East)



}

object MazeBuilder {
  type Maze = Array[Array[Int]]
  val getMaze: Maze = Array(
    Array( 0,-1, 0, 0,-1, 0, 0, 0, 0, 0),
    Array( 0, 0,-1,-1,-1, 0, 0,-1, 0, 0),
    Array( 0, 0, 0, 0, 0, 0, 0,-1, 0,-1),
    Array(-1, 0,-1,-1, 0,-1,-1,-1, 0, 0),
    Array(-1, 0, 0,-1, 0,-1, 0, 0, 0,-1),
    Array( 0, 0, 0,-1,-1,-1,-1, 0, 0, 0),
    Array(-1, 0, 0, 0, 0, 0, 0, 0, 0,-1),
    Array(-1, 0,-1,-1,-1,-1, 0,-1, 0,-1),
    Array(-1, 0, 0,-1, 0,-1, 0, 0, 0,-1),
    Array(-1, 0, 0, 0, 0, 0, 0, 0, 0,-1),
    Array(-1, 0,-1,-1, 0, 0, 0,-1, 0, 0))

  def getLocationValue(loc: Loc): Int = getMaze(loc.x)(loc.y)

  def setLocationValue(loc: Loc, value: Int): Unit = {
    getMaze(loc.x)(loc.y) = value
  }


}




