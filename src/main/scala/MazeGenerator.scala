import MazePosition.Loc

object MazeGenerator {

  def explore[T](set: Set[T]): List[T] = set.toList

  /*def buildImpl(current: Loc, maze: Maze, template: Template): Maze = {
    var newmaze = maze.markVisited(current)
    explore(maze.findNeighbors(current)).foreach {
      n => if(!newmaze.isVisited(n)) {
        newmaze = buildImpl(n, maze, template)
      }
    }
    newmaze
  }*/

  /*def build(width: Int, height: Int): Maze = {
    val exit = Loc(width-1, height-1)
    val template = MazeBuilder.getTemplate
    buildImpl(exit, new Maze(height, width, Set(), Set()), template)
  }*/

}
