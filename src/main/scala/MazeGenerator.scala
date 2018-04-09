import MazePosition.{Loc, Wall}

class MazeGenerator {

  def partitionEither[A, B](s: Seq[Either[A, B]]): (Seq[A], Seq[B]) =
    s.foldRight(Seq.empty[A], Seq.empty[B]) {
      case (e, (as, bs)) => e.fold(a => (a+: as, bs), b => (as, b+: bs))
    }

  val height = TemplateBuilder.getTemplate.length
  val width = TemplateBuilder.getTemplate(0).length

  def explore[T](set: Set[T]): List[T] = set.toList

  def mapMaze(): Seq[Loc] = {
    (0 until height).flatMap(y => mapRow(y))
  }

  def mapRow(y: Int): Seq[Loc] = {
    val seq = (0 until height).toList.map(x => mapCell(y, x))
    partitionEither(seq)._1
  }

  def mapCell(y: Int, x: Int): Either[Loc, Wall] = {
    TemplateBuilder.getLocationValue(Loc(x,y)).toSeq.head match {
      case -1 => Right(Wall(x,y))
      case 0 => Left(Loc(x,y))
    }
  }

  def build(): Maze = {
    val loc = mapMaze().toSet
    new Maze(height, width, locations = loc)
  }

  /*def buildImpl(current: Loc, maze: Maze, template: Template): Maze = {
    var newmaze = maze.markVisited(current)
    explore(maze.findNeighbors(current)).foreach {
      n => if(!newmaze.isVisited(n)) {
        newmaze = buildImpl(n, maze, template)
      }
    }
    newmaze
  }*/

  /*def build(width: Int, height: Int): Maze = {
    val exit = Loc(width-1, height-1)
    val template = MazeBuilder.getTemplate
    buildImpl(exit, new Maze(height, width, Set(), Set()), template)
  }*/

}

