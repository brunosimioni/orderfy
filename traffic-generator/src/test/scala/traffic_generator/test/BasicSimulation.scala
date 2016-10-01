package traffic_generator.test;

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BasicSimulation extends Simulation {

  
  object Catalog {

    val catalog = exec(http("Catalog")
      .get("/catalog-service/catalog"))
  }

  object Customers {

    val customers = exec(http("Customers")
      .get("/customers-service/customers"))

  }

  object Checkout {

    val checkout = exec(http("PlaceOrder")
        .post("/checkout-service/checkout/placeorder"))
  }

  val httpConf = http
    .baseURL("http://localhost:8000")
    .acceptHeader("text/html,application/xhtml+xml,application/xml,application/json;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Orderfy").exec(Catalog.catalog, Customers.customers, Checkout.checkout)

  setUp(
    scn.inject(
      atOnceUsers(1),
      constantUsersPerSec(80) during(10 seconds) randomized,
      nothingFor(4 seconds),
      rampUsersPerSec(50) to(100) during(5) randomized
    ).protocols(httpConf)
  )
}
