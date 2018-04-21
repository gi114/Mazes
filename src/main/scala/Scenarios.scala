import MazePosition._
import scala.util.Random

object Scenarios {
  val exitLoc = Loc(14,14)

  def buildMap: Maze = {
    val generator = new MazeGenerator
    generator.build()
  }
  def nextLocation(locations: Vector[Loc]): Loc = {
    val rnd = new Random
    locations(rnd.nextInt(locations.size))
  }

  def randomWalk(maze: Maze, currentLoc: Loc, direction: Option[Direction], path: List[Loc])(implicit rnd: Random): List[Loc] = {
    if (exitLoc == currentLoc) path
    else {
      val neighbors = maze.findNeighbors(currentLoc, direction).toVector
      val neighbor = neighbors.toList match {
        case _::_ => nextLocation(neighbors)
        /*going back*/
        case Nil => direction.map(dir => currentLoc.updateLocation(dir!)).get
      }
      val newDirection = currentLoc -- neighbor
      val updatePath = neighbor.updatePath(path)
      randomWalk(maze, neighbor, Some(newDirection), updatePath)(rnd)
    }

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

