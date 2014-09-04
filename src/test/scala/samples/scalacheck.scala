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
      forAll ((Gen.choose(1, 10), "a"), (Gen.choose(-10, 0), "b")) {
        (a: Int, b: Int) => {
          (a + b) should (be (b + a) and not be < (0))
        }
      }
    }
  }

}
