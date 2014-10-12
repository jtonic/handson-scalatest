package samples

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Created by jtonic on 12.10.2014.
 */
@RunWith(classOf[JUnitRunner])
class So26312962Spec extends FeatureSpec with GivenWhenThen {

  import org.json4s.JsonAST.{JField, JInt, JObject}
  import org.json4s.JsonDSL._
  import org.json4s.native.JsonMethods._
  import org.json4s.native.JsonParser

  feature("stackoverflow - 26312962") {
    scenario("How to get list from nested Json using scala?") {

      Given("the the json")
      val json =
        """
          |{
          |"disks" : [
          |    {},
          |    {
          |        "name" : "disk1",
          |        "freeBytesPerDisk" : {
          |            "freeBytes" : 1295971778560,
          |            "sizeBytes" : 2988491931648,
          |            "usedBytes" : 1692520153088
          |        }
          |    },{
          |        "name" : "disk2",
          |        "freeBytesPerDisk" : {
          |            "freeBytes" : 1295971778560,
          |            "sizeBytes" : 2988491931648,
          |            "usedBytes" : 1692520153088
          |        }
          |    }
          |]
          |}
        """.stripMargin

      Then("Parse the json and compute the available space")

      // parse the json
      val root = JsonParser.parse(json)

      // getting the disks available space
      val freeBytesPerDisk = for {
        JObject(disk) <- root
        JField("freeBytesPerDisk", JObject(utilization)) <- disk
        JField("freeBytes", JInt(freeBytes)) <- utilization
      } yield freeBytes

      // create the json with available spaces
      val outcome2 = ("name" -> "Available") ~ ("data" -> freeBytesPerDisk)
      val outcomeJson2 = pretty(render(outcome2))
      println(outcomeJson2)

      // create the json with all available spaces
      val availableSpace = freeBytesPerDisk.sum
      val outcome1 = ("name" -> "Available") ~ ("data" -> availableSpace)
      // val outcomeJson1 = compact(render(outcome1)) for compact
      val outcomeJson1 = pretty(render(outcome1))
      println(outcomeJson1)
    }
  }

}
