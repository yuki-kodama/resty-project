import com.github.takezoe.resty.{Action, ActionResult, Controller, Param}
import com.typesafe.scalalogging.{LazyLogging, Seq}

@Controller(name = "resty-project", description = "Rest APIs")
class RestPostController extends LazyLogging {

  @Action(method = "POST", path = "/test.json")
  def postTest(): ActionResult[ResultRestPost] = {
    val map = Map("test" -> "test")
    ActionResult(200, ResultRestPost(map))
  }


  @Action(method = "POST", path = "/request/test.json")
  def postTest(requestBodyJson: AnyRef): ActionResult[ResultRestPost] = {
    val map = Map("test" -> "test")

    ActionResult(200, ResultRestPost(map))
  }


  @Action(method = "POST", path = "/test/{name}")
  def postTest(name: String, requestBody: RequestBody): ActionResult[ResultRestPost] = {
    // {
    // "message": "message",
    // "seq": [1],
    // "service": {"name": "hoge", "id": "123"}
    // }
    logger.debug(s"name:${name}")
    val map = Map("name" -> name, "message" -> requestBody.message)
    ActionResult(200, ResultRestPost(map), Map("Test" -> "hoge"))
  }

  @Action(method = "POST", path = "/errortest.json")
  def postErrorTest(): ActionResult[ResultRestPost] = {
    val map = Map("message" -> "there are invalid parameter.")
    ActionResult(400, ResultRestPost(map), Map("detail" -> "xxx error."))
  }
}

case class ResultRestPost(Result: AnyRef)

case class RequestBody(message: Option[String], seq: Seq[String], service: Service){
  assert(message.get.length < 20, "message must be less than 20 charactors.")
}

case class Service(name: Option[String], id: Option[String])
