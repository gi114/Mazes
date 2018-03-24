import MazePosition.{Loc, Wall}
import TemplateBuilder.Template

trait MazeGenerator {


  def partitionEither[A, B](s: Seq[Either[A, B]]): (Seq[A], Seq[B]) =
    s.foldRight(Seq.empty[A], Seq.empty[B]) {
      case (e, (as, bs)) => e.fold(a => (a+: as, bs), b => (as, b+: bs))
    }

  val height = TemplateBuilder.getTemplate.length
  val width = TemplateBuilder.getTemplate(height).length

  def explore[T](set: Set[T]): List[T] = set.toList

  def mapMaze(): List[(Seq[Loc], Seq[Wall])] = {
    (0 to height).toList.flatMap(y => mapRow(y))
  }


  def mapRow(y: Int): List[(Seq[Loc], Seq[Wall])] = {
    for (list <- (0 to width).toList.map(x => mapCell(y, x).toSeq)) yield
      partitionEither(list)
  }

  def mapCell(y: Int, x: Int): Either[Throwable, Either[Loc, Wall]] = {
    TemplateBuilder.getLocationValue(Loc(x,y)) match {
      case -1 => Right(Right(Wall(x,y)))
      case 0 => Right(Left(Loc(x,y)))
      case _ => Left(new Exception("example exception"))
    }
  }

  def build(template: Template): Maze

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
