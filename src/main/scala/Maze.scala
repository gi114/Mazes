import MazePosition._


class Maze(val height: Int, val width: Int, val locations: Set[Loc], val visited: Set[Loc]) {

  def this(height: Int, width: Int, locations: Set[Loc]) {
    this(height, width, locations, Set.empty[Loc])
  }

  def findNeighbors(current: Loc, currDir: Option[Direction]): Set[Loc] = {
    val possibleDirections = currDir match {
      case Some(dir) => directions - (dir!)
      case None => directions
    }
    possibleDirections.map(current + _).filter(_.inBounds).intersect(locations)
  }

  def findNextAvailableDirection(current: Loc, currentDirection: Option[Direction]): Direction = {
    currentDirection match {
      case None => {
        val directions = findNeighbors(current, None).toList.map(loc => loc -- current)
        rightmost(directions).head
      }
      case Some(currDir) => {
        val dir = getRightMostDirections(currDir)
        if (openInDirection(current, dir)) dir
        else currDir
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

class DFSMaze(val height: Int, val width: Int, val locations: Set[Loc], val visited: Set[Loc]) {

  implicit val temp = TemplateBuilder.getTemplate

  def this(locations: Set[Loc], visited: Set[Loc]) {
    this(15, 15, locations, visited)
  }

  def markVisited(loc: Loc): DFSMaze = {
    new DFSMaze(height, width, locations, visited + loc)
  }

  /*def addWall(wall: Loc): Maze =
    new Maze(height, width, walls + wall, visited)*/

  def isVisited(loc: Loc): Boolean = {
    visited.contains(loc)
  }

  def findNeighbors(current: Loc): Set[Loc] = {
    directions.map(current + _).filter(_.inBounds) -- visited
  }

  def printMaze(): Unit = {
    (0 to height).toList.map(y => printRow(y))
  }

  def printRow(y: Int): Unit = {
    (0 to width).toList.map(x => printCell(y, x))
  }

  def printCell(y: Int, x: Int): Unit = {
    if (locations.contains(Loc(x, y))) print(' ')
    else print('*')
  }

}
