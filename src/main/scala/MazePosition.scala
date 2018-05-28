
object MazePosition {


  case class Direction(dx: Int, dy: Int) {

    implicit val getDirections: List[Direction] = directions
    implicit val mask: (Int, Int) = (-1, -1)
    def ! = Direction(this.dx * mask._1, this.dy * mask._2)

    def nextLeft: Direction = {
/*      this match {
        case West => South
        case South => East
        case East => North
        case North => West
      }
      */
      val turnLeft = directions.toIterator.dropWhile(_ != this).toList
      if (turnLeft.head == directions.last) directions.head
      else turnLeft.tail.head
    }

    def nextRight: Direction = {
      val reversedDirections = directions.reverse
      val turnLeft = reversedDirections.toIterator.dropWhile(_ != this).toList
      if (turnLeft.head == reversedDirections.last) reversedDirections.head
      else turnLeft.tail.head

    }


  }

  /*case class Coordinate(int: Int) {
    implicit def coordinateToInt(coordinate: Coordinate): Int = coordinate.int
  }

  case object Coordinate {
    def apply(int: Int): PartialFunction[Int, Coordinate] = {
      case x if x >= 0 && x < 15 => new Coordinate(x)
    }
  }*/


  case class Loc(x: Int, y: Int) {

/*    def apply(x: Int, y: Int): Option[Loc] = {
      val newLocation = Loc(x,y)
      if (newLocation.inBounds) Some(newLocation)
      else None
    }*/

    def inBounds: Boolean = this.x >= 0 && this.x < 15 && this.y >= 0 && this.y < 15

    def +(that: Direction): Loc = Loc(x + that.dx, y + that.dy)
    def --(loc: Loc): Direction = {
      Direction(loc.x - this.x, loc.y - this.y)
    }

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

  }

  case class Wall(x: Int, y: Int)

  val North = Direction(0,-1)
  val South = Direction(0,1)
  val West = Direction(-1,0)
  val East = Direction(1,0)
  val directions = List(North, West, South, East)

  case class Trajectory(x: List[Int], y: List[Int])

}









