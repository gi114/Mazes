import MazePosition.Loc

object TemplateBuilder {

    type Template = Array[Array[Int]]
    def getTemplate: Template = Array(
      Array( 0, 0, 0,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array( 0,-1, 0,-1, 0,-1, 0,-1,-1,-1,-1,-1, 0,-1, 0),
      Array( 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array( 0,-1,-1,-1, 0,-1, 0,-1, 0,-1, 0,-1, 0,-1,-1),
      Array( 0,-1, 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0, 0, 0),
      Array( 0,-1, 0,-1, 0,-1, 0,-1, 0,-1, 0,-1,-1,-1, 0),
      Array( 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0),
      Array( 0,-1,-1,-1, 0,-1, 0,-1, 0,-1, 0,-1, 0,-1, 0),
      Array( 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0),
      Array( 0,-1, 0,-1,-1,-1,-1,-1, 0,-1,-1,-1, 0,-1, 0),
      Array( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1, 0),
      Array(-1,-1, 0,-1, 0,-1, 0,-1,-1,-1, 0,-1, 0,-1, 0),
      Array( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1, 0, 0, 0),
      Array( 0,-1, 0,-1, 0,-1, 0,-1, 0,-1, 0,-1,-1,-1,-1),
      Array( 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0))

    def getLocationValue(loc: Loc): Int = getTemplate(loc.x)(loc.y)

    def setLocationValue(loc: Loc, value: Int): Unit = {
      getTemplate(loc.x)(loc.y) = value
    }

}
