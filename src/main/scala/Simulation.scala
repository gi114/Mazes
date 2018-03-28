import MazePosition.Loc

object Simulation extends MazeGenerator {

  def main(args: Array[String]): Unit = {
    println(mapCell(0,0), mapCell(1,1), width)



    //println(shortestPath(maze, startLoc, exitLoc))
  }
}
