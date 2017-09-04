import com.github.takezoe.resty.{Action, ActionResult, Controller, Param}
import com.typesafe.scalalogging.LazyLogging

@Controller(name = "resty-project", description = "Rest APIs")
class RestGetController extends LazyLogging {

  @Action(method = "GET", path = "/hello.json")
  def getHello(): ActionResult[ResultRestGet] = {
    val result = Map("message" -> "HelloWorld.")
    ActionResult(200, ResultRestGet(result))
  }

  @Action(method = "GET", path = "/test_url/{name}")
  def getTestUrlName(name: String): ActionResult[ResultRestGet] = {
    logger.info(s"name:${name}")
    val result = Map("name" -> name, "message" -> "HelloWorld.")
    ActionResult(200, ResultRestGet(result), Map("header_test" -> "this is header."))
  }

  @Action(method = "GET", path = "/test_url/{name}/test.json")
  def getTestUrl(
                  name: String,
                  @Param(name = "param_query", from = "query") paramQuery: String,
                  @Param(name = "param_header", from = "header") paramHeader: String): ActionResult[ResultRestGet] = {
    logger.info(s"name: ${name}")
    logger.info(s"paramQuery: ${paramQuery}")
    logger.info(s"paramHeader: ${paramHeader}")

    val result = Map("name" -> name, "paramQuery" -> paramQuery, "paramHeader" -> paramHeader, "message" -> "HelloWorld.")
    ActionResult(200, ResultRestGet(result), Map("header_test" -> "this is header."))
  }
}


case class ResultRestGet(Result: AnyRef)