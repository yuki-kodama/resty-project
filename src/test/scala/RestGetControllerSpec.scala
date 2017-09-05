import com.typesafe.scalalogging.LazyLogging

import org.specs2.mutable.Specification

class RestGetControllerSpec extends Specification with LazyLogging {

  "RestGetControllerSpec" should {
    "test case" in {
      val restGetController = new RestGetController()
      val actionResult = restGetController.getHello()

      logger.info(s"{}", actionResult.body.Result)
      actionResult.status must_== 200
    }
  }
}
