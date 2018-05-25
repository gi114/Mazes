import MazePosition.{Loc, _}

import scala.util.Random

object Scenarios {

  def buildMap: Maze = {
    val generator = new MazeGenerator
    generator.build()
  }
  def nextLocation(locations: Vector[Loc]): Loc = {
    val rnd = new Random
    locations(rnd.nextInt(locations.size))
  }


  def randomWalk(maze: Maze, currentLoc: Loc, direction: Option[Direction], path: List[Loc], exits: List[Loc] = List(Loc(14,14), Loc(14,12)))(implicit rnd: Random): List[Loc] = {
    exits.find(exit => exit == currentLoc) match {
      case Some(_) => currentLoc.updatePath(path)
      case None =>
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


  def rightHand(maze: Maze, currentLoc: Loc, direction: Option[Direction], path: List[Loc], exits: List[Loc] = List(Loc(14,14), Loc(14,12))): List[Loc] = {
    exits.find(exit => exit == currentLoc) match {
      case Some(_) => currentLoc.updatePath(path)
      case None =>
        val newDirection = maze.findNextAvailableDirection(currentLoc, direction)  //test this
        val updateLoc = currentLoc.updateLocation(newDirection)
        val updateP = updateLoc.updatePath(path)
        rightHand(maze, updateLoc, Some(newDirection), updateP)
    }
  }
}

