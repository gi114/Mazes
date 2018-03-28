import MazePosition.{Loc, Wall}
import Simulation.mapCell
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


}
