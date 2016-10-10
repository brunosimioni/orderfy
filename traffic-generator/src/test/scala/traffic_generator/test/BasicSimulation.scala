package traffic_generator.test;

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import search.controllers.protobuf.SuggReq

class BasicSimulation extends Simulation {

  object Catalog {

    val random = new util.Random
    val feeder = Iterator.continually(Map("id" -> random.nextInt()))

    val catalog = feed(feeder).exec(http("Catalog")
      .get("/catalog-service/catalog/${id}"))

  }

  object Customers {

    val random = new util.Random
    val feeder = Iterator.continually(Map("id" -> random.nextInt()))

    val customers = feed(feeder).exec(http("Customers")
      .get("/customers-service/customers/${id}"))
  }

  object Search {

    val random = new util.Random

    val search = exec(http("Search")
        .post("/search-service/search/suggestions")
        .header("Content-Type", "application/x-protobuf")
        .header("Accept", "application/x-protobuf")
        .body(ByteArrayBody(SuggReq.SuggReqMsg.newBuilder().setUserId(random.nextString(10)).setTerm(random.nextString(10)).build().toByteArray()))
      )
  }

  object Checkout {

    val random = new util.Random
    val feeder = Iterator.continually(Map(
        "idCustomer" -> random.nextInt(),
        "idProduct1" -> random.nextInt(),
        "idProduct2" -> random.nextInt(),
        "idProduct3" -> random.nextInt()
    ))

    val checkout = feed(feeder).exec(http("PlaceOrder")
        .post("/checkout-service/checkout/placeorder")
        .body(StringBody(
          """{ "idsProducts":[ "${idProduct1}", "${idProduct2}", "${idProduct3}" ],"idCustomer":"${idCustomer}" }"""
        )).asJSON
    )
  }
    
  val httpConf = http
    .baseURL("http://localhost:8000")
    .acceptHeader("text/html,application/xhtml+xml,application/xml,application/json;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val frontend = scenario("Frontend").exec(Catalog.catalog, Customers.customers, Checkout.checkout)
  val searchers = scenario("Searches").exec(Search.search)
  
  setUp(
    frontend.inject(
      atOnceUsers(1),
      constantUsersPerSec(20) during(100 seconds) randomized
//      heavisideUsers(3000) over(20 seconds),
//      nothingFor(30 seconds),
//      constantUsersPerSec(20) during(300 seconds) randomized
    ),
    searchers.inject(
      atOnceUsers(1),
      constantUsersPerSec(50) during(100 seconds) randomized
//      heavisideUsers(6000) over(20 seconds),
//      nothingFor(30 seconds),
//      constantUsersPerSec(50) during(300 seconds) randomized
    )
  ).protocols(httpConf)

}