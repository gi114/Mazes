import MazePosition.{Loc, Wall}
import Simulation.{mapCell, _}
import org.mockito.Mockito
import org.mockito.Matchers.{any, eq => mockEq}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfterEach, FreeSpec, Matchers}


class MazeGeneratorSpec extends UnitSpec with MockitoSugar {

  "Map Cell" should "successfully map 0 or -1 to corresponding Maze location type" in {
    mapCell(0,0) shouldBe Left(Loc(0,0))
    mapCell(1,1) shouldBe Right(Wall(1,1))

    val thrown = intercept[NoSuchElementException] {
      mapCell(15,8)
    }
    //thrown.msg shouldBe "not a valid location"
  }

  "Map Maze" should "successfully map Template to corresponding sequence of available locations Loc" in {
    val wallsLoc = Seq(
      Loc(11,0),
      Loc(1,1), Loc(3,1), Loc(4,1), Loc(5,1), Loc(7,1), Loc(8,1), Loc(9,1), Loc(11,1), Loc(13, 1),
      Loc(3,2), Loc(7,2),
      Loc(0,3), Loc(1,3), Loc(3,3), Loc(5,3), Loc(7,3), Loc(9,3), Loc(11,3), Loc(13,3),
      Loc(9,4),
      Loc(1,5), Loc(2,5), Loc(3,5), Loc(5,5), Loc(6,5), Loc(7,5), Loc(9,5), Loc(11,5), Loc(13,5), Loc(14,5),
      Loc(9,6),
      Loc(1,7), Loc(3,7), Loc(4,7), Loc(5,7), Loc(7,7), Loc(9,7), Loc(11,7), Loc(13,7),
      Loc(1,8), Loc(11,8),
      Loc(1,9), Loc(3,9), Loc(5,9), Loc(7,9), Loc(8,9), Loc(9,9), Loc(11,9), Loc(13,9),
      Loc(1,10), Loc(9,10),
      Loc(1,11), Loc(3,11), Loc(5,11), Loc(7,11), Loc(9,11), Loc(11,11), Loc(12,11), Loc(13,11),
      Loc(5,12), Loc(13,12),
      Loc(1,13), Loc(3,13), Loc(5,13), Loc(7,13), Loc(9,13), Loc(11,13), Loc(12,13), Loc(13,13),
      Loc(14,13), Loc(5,14)
    )

    !(wallsLoc forall (mapMaze contains))
  }


}

