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
    val seq = (0 until width).toList.map(x => mapCell(x, y))
    partitionEither(seq)._1
  }

  def mapCell(x: Int, y: Int): Either[Loc, Wall] = {
    TemplateBuilder.getLocationValue(Loc(x,y)).toSeq.head match {
      case -1 => Right(Wall(x,y))
      case 0 => Left(Loc(x,y))
    }
  }

  def build(): Maze = {
    val loc = mapMaze().toSet
    new Maze(height, width, locations = loc)
  }


}

