import MazePosition._

trait Maze

class RandomMaze(val height: Int, val width: Int, val locations: Set[Loc]) {
  def findNeighbors(current: Loc): Set[Loc] = {
    directions.map(current + _).filter(_.inBounds).intersect(locations)
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

  def openNorth(loc: Loc): Boolean = openInDirection(loc, North)
  def openWest(loc: Loc): Boolean = openInDirection(loc, West)
  def openEast(loc: Loc): Boolean = openInDirection(loc, East)
  def openSouth(loc: Loc): Boolean = openInDirection(loc, South)

  private def openInDirection(loc: Loc, dir: Direction): Boolean =
    locations.contains(loc + dir)

}
