
object MazePosition {

  case class Direction(dx: Int, dy: Int)

  case class Loc(x: Int, y: Int) {
    def +(that: Direction): Loc = Loc(x + that.dx, y + that.dy)
    def inBounds: Boolean =
      this.x >= 0 && this.x < 15 && this.y >= 0 && this.y < 15

  }

  case class Wall(x: Int, y: Int)

  val North = Direction(0,-1)
  val South = Direction(0,1)
  val West = Direction(-1,0)
  val East = Direction(1,0)
  val directions = Set(North, South, West, East)

}






