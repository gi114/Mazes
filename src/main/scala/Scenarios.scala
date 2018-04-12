import MazePosition._
import scala.util.Random

object Scenarios {
  val exitLoc = Loc(2,2)

  def buildMap: Maze = {
    val generator = new MazeGenerator
    generator.build()
  }
  def nextLocation(locations: Vector[Loc]): Loc = {
    val rnd = new Random
    locations(rnd.nextInt(locations.size))
  }

  def randomWalk(maze: Maze, currentLoc: Loc, direction: Option[Direction], path: Set[Loc])(implicit rnd: Random): Set[Loc] = {
    if (currentLoc == exitLoc ) path
    else {
      val neighbors = maze.findNeighbors(currentLoc, direction).toVector
      println(neighbors)
      val neighbor = neighbors.toList match {
        case _::_ => nextLocation(neighbors)
        /*going back*/
        case Nil => direction.map(dir => currentLoc.updateLocation(dir!))
      }
      println(neighbor)
      //val newDirection = currentLoc -- neighbor
      //println(neighbors)
      //val updatePath = neighbor.updatePath(path)
      //println(neighbors)
      path
      //randomWalk(maze, neighbor, newDirection, updatePath)(rnd)
    }


    /*if (currentLoc == exitLoc) 0
    else if (currentLoc.isOutBound) 1000000000
    else {
      MazeBuilder.setLocationValue(currentLoc, -2)// maze(x)(y) = -2
      val answer = (shortestPath(maze, currentLoc + East, exitLoc) min
        shortestPath(maze, currentLoc + West, exitLoc) min
        shortestPath(maze, currentLoc + North, exitLoc) min
        shortestPath(maze, currentLoc + South, exitLoc)) +1
      MazeBuilder.setLocationValue(currentLoc, 0)// maze(x)(y) = -2
      answer
    }*/

  }

  def rightHand(maze: Maze, currentLoc: Loc, direction: Direction, path: Set[Loc]): Set[Loc] = {
    if (currentLoc == exitLoc ) path
    else {
      val newDirection = maze.findNextAvailableDirection(currentLoc, direction)
      val updateLoc = currentLoc.updateLocation(newDirection)
      rightHand(maze, updateLoc, newDirection, path)
    }
  }
}

