sealed trait NotificationErrors {
  val message = getClass.getSimpleName
}

case class NoSuchTemplateElementException(msg: String) extends  NotificationErrors

