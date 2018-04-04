import MazePosition.{Loc, Wall}
import Simulation._
import org.mockito.Mockito
import org.mockito.Matchers.{any, eq => mockEq}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfterEach, FreeSpec, Matchers}


class MazeGeneratorSpec extends UnitSpec with MockitoSugar {

  "Map Cell" should "successfully map 0 or -1 to corresponding Maze location type" in {
    mapCell(0,0) shouldBe Left(Loc(0,0))
    mapCell(1,1) shouldBe Right(Wall(1,1))
  }

  "Map Maze" should "successfully map Template to corresponding sequence of Wall locations" in {
    mapMaze() shouldBe Seq(
      Wall(11,0),
      Wall(1,1), Wall(3,1), Wall(4,1), Wall(5,1), Wall(7,1), Wall(8,1), Wall(9,1), Wall(11,1), Wall(13, 1),
      Wall(3,2), Wall(7,2),
      Wall(0,3), Wall(1,3), Wall(3,3), Wall(5,3), Wall(7,3), Wall(9,3), Wall(11,3), Wall(13,3),
      Wall(9,4),
      Wall(1,5), Wall(2,5), Wall(3,5), Wall(5,5), Wall(6,5), Wall(7,5), Wall(9,5), Wall(11,5), Wall(13,5), Wall(14,5),
      Wall(9,6),
      Wall(1,7), Wall(3,7), Wall(4,7), Wall(5,7), Wall(7,7), Wall(9,7), Wall(11,7), Wall(13,7),
      Wall(1,8), Wall(11,8),
      Wall(1,9), Wall(3,9), Wall(5,9), Wall(7,9), Wall(8,9), Wall(9,9), Wall(11,9), Wall(13,9),
      Wall(1,10), Wall(9,10),
      Wall(1,11), Wall(3,11), Wall(5,11), Wall(7,11), Wall(9,11), Wall(11,11), Wall(12,11), Wall(13,11),
      Wall(5,12), Wall(13,12),
      Wall(1,13), Wall(3,13), Wall(5,13), Wall(6,13), Wall(7,13), Wall(9,13), Wall(10,13), Wall(11,13), Wall(13,13),
      Wall(3,13), Wall(13,14)
    )
  }


}
