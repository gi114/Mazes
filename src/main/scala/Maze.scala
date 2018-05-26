import MazePosition._


class Maze(val height: Int, val width: Int, val locations: Set[Loc], val visited: Set[Loc]) {

  def this(height: Int, width: Int, locations: Set[Loc]) {
    this(height, width, locations, Set.empty[Loc])
  }

  def findNeighbors(current: Loc, currDir: Option[Direction]): Set[Loc] = {
    val possibleDirections = currDir match {
      case Some(dir) => directions.toSet - (dir!)
      case None => directions
    }
    possibleDirections.map(current + _).filter(_.inBounds).toSet.intersect(locations)
  }

  def findDirection(current: Loc, currDir: Direction): Direction = {
    val dir = currDir.nextRight
    if (openInDirection(current, dir)) dir
    else findDirection(current, currDir.nextLeft)
  }

  def findNextAvailableDirection(current: Loc, currentDirection: Option[Direction]): Direction = {
    currentDirection match {
      case None => {
        val directions = findNeighbors(current, None).toList.map(loc => loc -- current)
        rightmost(directions).head
      }
      case Some(currDir) => {
       findDirection(current, currDir)
      }
    }
  }

  def openNorth(loc: Loc): Boolean = openInDirection(loc, North)
  def openWest(loc: Loc): Boolean = openInDirection(loc, West)
  def openEast(loc: Loc): Boolean = openInDirection(loc, East)
  def openSouth(loc: Loc): Boolean = openInDirection(loc, South)

  private def openInDirection(loc: Loc, dir: Direction): Boolean =
    locations.contains(loc + dir)

  private def rightmost(list: List[Direction]) = {
    val orderedDirections = List(West, North, East, South)
    orderedDirections.filter(dir => list contains dir)
  }

}




