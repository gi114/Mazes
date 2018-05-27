import MazePosition.{Direction, Loc}
import org.scalamock.scalatest.MockFactory


class MazePositionSpec extends UnitSpec with MockFactory {
  "MazePosition Direction" should "allow turning left or right to the current direction" in {
    val location = mock[Loc]
    val direction = mock[Direction]

    val directions = direction.getDirections
    val reversedDirections = directions.reverse


    val north = directions.head
    val west = directions.tail.head
    val east = reversedDirections.head
    val south = reversedDirections.tail.head


    /* Given
    directions is List(north, west, south, east)
    and reversedDirections is List(east, south, west, north)
     */

    north.nextLeft shouldBe west
    north.nextRight shouldBe east

    west.nextLeft shouldBe south
    west.nextRight shouldBe north

    south.nextLeft shouldBe east
    south.nextRight shouldBe west

    east.nextLeft shouldBe north
    east.nextRight shouldBe south

  }


}
