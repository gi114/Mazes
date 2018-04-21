import MazePosition.{Loc, Trajectory}

import scala.util.Random

object Simulation extends MazeGenerator {

  def main(args: Array[String]): Unit = {

    val maze = Scenarios.buildMap
    (1 to 10) foreach (_ => println(travel(maze, Loc(14,12))))

  }


  def travel(maze: Maze, start: Loc): Trajectory = {

    val path = Scenarios.randomWalk(maze, start, None, List.empty[Loc])(Random)

    val trajectory = path.foldLeft(Trajectory(List.empty[Int], List.empty[Int])){
      case (Trajectory(x,y), loc) => Trajectory(x.::(loc.x), y.::(loc.y))
    }
    trajectory
  }
}
