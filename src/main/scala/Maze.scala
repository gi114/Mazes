import MazePosition._

class Maze(val height: Int, val width: Int, val walls: Set[Loc], val visited: Set[Loc]) {

  implicit val temp = TemplateBuilder.getTemplate

  def this(walls: Set[Loc], visited: Set[Loc]) {
    this(15, 15, walls, visited)
  }

  def markVisited(loc: Loc): Maze = {
    new Maze(height, width, walls, visited + loc)
  }

  def addWall(wall: Loc): Maze =
    new Maze(height, width, walls + wall, visited)

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
    if (walls.contains(Loc(x, y))) print('*')
    else print(' ')
  }

  def openNorth(loc: Loc): Boolean = openInDirection(loc, North)
  def openWest(loc: Loc): Boolean = openInDirection(loc, West)
  def openEast(loc: Loc): Boolean = openInDirection(loc, East)
  def openSouth(loc: Loc): Boolean = openInDirection(loc, South)

  private def openInDirection(loc: Loc, dir: Direction): Boolean =
    !walls.contains(loc + dir)


}
