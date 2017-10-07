import com.github.takezoe.resty._

class DummyController {

  @Action(method = "GET", path = "/dummy")
  def dummuy(): DummyMessage = {
    DummyMessage("dummy")
  }

}

case class DummyMessage(message: String)
