import MazeBuilder.Maze
import MazePosition._

object RecursiveMaze {

  def shortestPath(maze: Maze, currentLoc: Loc, exitLoc: Loc): Int = {
    if (currentLoc == exitLoc) 0
    else if (currentLoc.isOutBound) 1000000000
    else {
      MazeBuilder.setLocationValue(currentLoc, -2)// maze(x)(y) = -2
      val answer = (shortestPath(maze, currentLoc + East, exitLoc) min
        shortestPath(maze, currentLoc + West, exitLoc) min
        shortestPath(maze, currentLoc + North, exitLoc) min
        shortestPath(maze, currentLoc + South, exitLoc)) +1
      MazeBuilder.setLocationValue(currentLoc, 0)// maze(x)(y) = -2
      answer
    }
  }
}

