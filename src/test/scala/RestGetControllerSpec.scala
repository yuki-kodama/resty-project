import com.typesafe.scalalogging.LazyLogging

import org.specs2.mutable.Specification

class RestGetControllerSpec extends Specification with LazyLogging {

  "RestGetControllerSpec" should {
    "test case" in {
      val restGetController = new RestGetController()
      val actionResult = restGetController.getHello()

      actionResult.status must_== 200
      actionResult.body.Result must_== Map("message" -> "HelloWorld.")
    }
  }
}
