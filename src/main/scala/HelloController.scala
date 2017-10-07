import com.github.takezoe.resty._
import org.slf4j.LoggerFactory

class HelloController {

  private val logger = LoggerFactory.getLogger(classOf[HelloController])

  @Action(method = "GET", path = "/hello/{name}")
  def hello(name: String): HelloMessage = {
    logger.debug(name)
    HelloMessage(name)
  }

}

case class HelloMessage(message: String)
