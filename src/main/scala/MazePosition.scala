
object MazePosition {

  case class Direction(dx: Int, dy: Int) {

    implicit val mask: (Int, Int) = (-1, -1)
    def ! = Direction(this.dx * mask._1, this.dy * mask._2)

  }

  case class Loc(x: Int, y: Int) {

    def +(that: Direction): Loc = Loc(x + that.dx, y + that.dy)
    def --(loc: Loc): Direction = {
      Direction(loc.x - this.x, loc.y - this.y)
    }

    def inBounds: Boolean =
      this.x >= 0 && this.x < 15 && this.y >= 0 && this.y < 15

    def validLocation: Option[Loc] = {
      if (this.inBounds) Some(this)
      else None
    }

    def updatePath(path: List[Loc]): List[Loc] = {
      path.::(this)
    }

    def updateLocation(dir: Direction): Loc = {
      this + dir
    }

    def isExit2(exitA: Loc, exitB: Loc): Boolean = {
      if (this == exitA) true
      else if (this == exitB) true
      else false
    }

  }

  case class Wall(x: Int, y: Int)

  val North = Direction(0,-1)
  val South = Direction(0,1)
  val West = Direction(-1,0)
  val East = Direction(1,0)
  val directions = Set(North, East, South, West)

  def getRightMostDirections(currentDir: Direction): Direction = {
    currentDir match {
      case West => North
      case South => West
      case East => South
      case North => East
    }
  }

  case class Trajectory(x: List[Int], y: List[Int])

}









