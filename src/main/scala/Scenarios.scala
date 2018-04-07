import MazePosition._
import scala.util.Random

object Scenarios {
  val exitLoc = Loc(2,2)

  def buildMap: RandomMaze = {
    val generator = new MazeGenerator
    generator.build()
  }
  def nextLocation(locations: Vector[Loc]): Loc = {
    val rnd = new Random
    locations(rnd.nextInt(locations.size))
  }



  def randomWalk(maze: RandomMaze, currentLoc: Loc, path: Set[Loc])(implicit rnd: Random): Set[Loc] = {
    if (currentLoc == exitLoc ) {
      println(path)
      path
    }
    else {
      val neighbors = maze.findNeighbors(currentLoc).toVector
      val neighbor = nextLocation(neighbors)
      val updatePath = neighbor.updatePath(path)
      randomWalk(maze, neighbor, updatePath)(rnd)
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
}

