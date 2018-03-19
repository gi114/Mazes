import MazePosition.Loc
import RecursiveMaze.shortestPath

object Mazes {
  def main(args: Array[String]): Unit = {

    val maze = MazeBuilder.getMaze
    val startLoc = Loc(0,0)
    val exitLoc = Loc(9,5)

    println(shortestPath(maze, startLoc, exitLoc))
  }
}
