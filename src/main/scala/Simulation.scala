import MazePosition.{Direction, Loc}

import scala.util.Random

object Simulation extends MazeGenerator {

  def main(args: Array[String]): Unit = {

    val maze = Scenarios.buildMap

    Scenarios.randomWalk(maze, Loc(0,0), None, Set.empty[Loc])(Random)

    //Scenarios.rightHand(maze, Loc(0,0), startDirection, Set.empty[Loc])

  }
}
