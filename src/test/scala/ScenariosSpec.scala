import MazePosition.Loc
import org.scalatest.mockito.MockitoSugar

import scala.util.Random

class ScenariosSpec extends UnitSpec with MockitoSugar {

  "randomWalk" should "exit with either (12,14) or (14,14)" in {
    val maze = mock[Maze]
    val rnd = mock[Random]
    val exists = List(Loc(12,14), Loc(14,14))
    val end = Scenarios.randomWalk(maze, Loc(14,12), None, List.empty[Loc])(rnd)

    exists contains end.reverse.head

  }
}
