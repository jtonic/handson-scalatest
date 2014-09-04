import org.junit.runner._
import org.scalacheck.Gen
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, GivenWhenThen}
import org.scalatest.Matchers

/**
 * Created by jtonic on 31.08.2014.
 */

@RunWith(classOf[JUnitRunner])
class SimpleMathTest extends FunSpec with Matchers with GivenWhenThen with GeneratorDrivenPropertyChecks {

  describe("We can use test data from Scala check") {
    it("runs the same but with different constructs") {
      forAll((Gen.choose(1, 10), "a"), (Gen.choose(-10, 0), "b")) {
        (a: Int, b: Int) => {
          (a + b) should (be(b + a) and not be <(0))
        }
      }
    }
  }

  describe("Full names") {
    it("can contains middle names") {
      var idx = 0
      forAll("fName", "middleName", "lastName") {
        (fName: String, mName: Option[String], lName: String) => {
          idx += 1
          println(f"idx: $idx\n\tfName: $fName\n\tmName: $mName\n\tName: $lName\n")

          mName match {
            case Some(x) =>
              val artist  = new Artist(fName, mName, lName)
              artist.fullName should equal (fName + " " + x + " " + lName)
            case _ =>
              val artist  = new Artist(fName, mName, lName)
              artist.fullName should equal (fName + " " + lName)
          }
        }
      }
    }
  }

  class Artist(fName: String, mName: Option[String], lName: String) {
    def fullName = s"$fName${if (mName.isEmpty) " " else " " + mName.get + " "}$lName"
  }

}
