package org.http4s

import cats.Id

class HttpRoutesSpec extends Http4sSpec {
  "HttpRoutes.strict" should {
    "work for type without defer" in {
      val route = HttpRoutes.strict[Id] {
        case _ => Response[Id](Status.Ok)
      }
      val req = Request[Id](Method.GET)
      route.run(req).map(_.status).value must_=== Some(Status.Ok)
    }
  }
}
