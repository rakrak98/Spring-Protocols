//package it.simplewebapp
//
//import com.intuit.karate.gatling.PreDef._
//import io.gatling.core.Predef._
//import scala.concurrent.duration._
//
//class SimpleRestAppTestRunner extends Simulation {
//
//  val tps = Integer.getInteger("tps", 1).toDouble
//  val duration = Integer.getInteger("duration", 1).toInt
//
//  val protocol = karateProtocol(
//    "/transform" -> Nil
//  )
//
//  val transform = scenario("transform").exec(karateFeature("classpath:it/simplewebapp/simplewebapp.feature"))
//
//  setUp(
//    transform.inject(constantUsersPerSec(tps) during (duration.seconds)).protocols(protocol)
//  )
//
//}
