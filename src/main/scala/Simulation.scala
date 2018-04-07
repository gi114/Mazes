import MazePosition.Loc

import scala.util.Random

object Simulation extends MazeGenerator {

  def main(args: Array[String]): Unit = {

    val maze = Scenarios.buildMap
    println(Scenarios.randomWalk(maze, Loc(0,0), Set.empty[Loc])(Random))



    //println(shortestPath(maze, startLoc, exitLoc))
  }
}
