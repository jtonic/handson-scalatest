import org.scalacheck.{Prop, Properties}
import org.scalacheck.Prop._

/**
 * Created by jtonic on 31.08.2014.
 */

object SimpleMathTest extends Properties("Simple math") {
  property("Simple add check") = Prop.forAll { (a: Int, b: Int) =>
    (a < a + b) :| "a < a + b" &&
    (b < a + b) :| "b < a + b"
  }
}