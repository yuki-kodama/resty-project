import com.github.takezoe.resty._

class DummyController {

  @Action(method = "GET", path = "/dummy")
  def dummy(): DummyMessage = {
    DummyMessage("dummy")
  }

}

case class DummyMessage(message: String)
