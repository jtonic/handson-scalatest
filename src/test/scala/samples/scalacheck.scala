import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

/**
 * Created by jtonic on 31.08.2014.
 */

@RunWith(classOf[JUnitRunner])
class ScalaTestWithScalaCheck extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  describe("We can use test data from Scala check") {
    it("runs the same but with different constructs") {
      forAll("a", "b") {
        (a: Int, b: Int) =>
          whenever(a > 0 && b < 10) {
            (a + b) should equal (b + a)
            // uncomment the following to get
            // Read further about the gave up problem
            // https://github.com/rickynils/scalacheck/wiki/User-Guide (search for 'Gave up after only')
            // (a + b) should (equal(b + a) and be > a)
          }
      }
    }
  }
}