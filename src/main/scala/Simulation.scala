import MazePosition.Loc

object Simulation extends MazeGenerator {

  def main(args: Array[String]): Unit = {

    val r = mapMaze()
    println(r)



    //println(shortestPath(maze, startLoc, exitLoc))
  }
}
