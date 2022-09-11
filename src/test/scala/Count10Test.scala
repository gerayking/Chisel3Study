import chiseltest.{ChiselScalatestTester, testableClock, testableData}
import org.scalatest.flatspec.AnyFlatSpec

class Count10Test extends AnyFlatSpec with ChiselScalatestTester{
  "count" should "pass" in{
    test(new Counter10){
      c =>
        for(i <- 0 until 11){
          c.clock.step()
          println("now count : " + c.io.out.peek().toString())
        }
    }
  }
}
