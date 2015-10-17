import org.scalacheck._, Prop._

object InPlaceStringShiftSpec extends Properties("In Place String Shift") {

  property("shifted") = forAll { (s: String, i: Int) =>
    // These are all the edge cases
    (s.length > 0 && i != 0 && i % s.length != 0 && i > 0) ==> {
      val str = s.toCharArray
      val j = i % s.length
      InPlaceStringShift.Shift(str, j)
      new String(str) ?= shift(s, i)
    }
  }

  def shift(s: String, shift: Int): String =
    s.splitAt(s.length - (shift % s.length)) match {
      case (a, b) => b ++ a
    }
}
