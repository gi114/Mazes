import scala.reflect.ClassTag
import java.util.NoSuchElementException

sealed trait NotificationErrors extends NoSuchElementException {
  val message = getClass.getSimpleName
}

case class NoSuchTemplateElementException(msg: String) extends NoSuchElementException


class ExceptionCatcher[E <: Exception] {
  def apply[A](input: => A)(implicit m: ClassTag[E]) = {
    try { Some(input) } catch { case x if m.runtimeClass.isInstance(x) => None}
  }
}

object ExceptionCatcher { def apply[E <: Exception] = new ExceptionCatcher[E] }