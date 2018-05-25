import MazePosition.{Loc, Trajectory}

import scala.util.Random

object Simulation extends MazeGenerator {

  def main(args: Array[String]): Unit = {

    //CSVWriter.clearFile
    val maze = Scenarios.buildMap
    (1 to 10) foreach (i => {
      val trajectory = travel(maze, Loc(14,12), Loc(14,14))
      //CSVWriter.write(i, trajectory)
    })

  }


  def travel(maze: Maze, start: Loc, exits: Loc): Trajectory = {

    val path = Scenarios.rightHand(maze, start, None, List.empty[Loc], List(exits))
    //handling empty path
    println(path)

    val trajectory = path.foldLeft(Trajectory(List.empty[Int], List.empty[Int])){
      case (Trajectory(x,y), loc) => Trajectory(x.::(loc.x), y.::(loc.y))
    }

    trajectory
  }


}
