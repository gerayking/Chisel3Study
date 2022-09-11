import chiseltest.{ChiselScalatestTester, testableData}
import org.scalatest.flatspec.AnyFlatSpec
import chisel3._
import chisel3.tester.testableClock

class ALUTest extends AnyFlatSpec with ChiselScalatestTester{
  "ALU" should "pass" in{
    test(new ALU){
      c =>
        val InputSeq = Seq(9,8)
        val AnswerSeq = Seq(17,1,72,1,8)
        for(i <- 0 until 5){
          c.io.a.poke(InputSeq(0).U)
          c.io.b.poke(InputSeq(1).U)
          c.io.op.poke(i.U)
          c.clock.step()
          println(s"op = ${i} the input1 = ${c.io.a.peek().toString()} the input2 = ${c.io.b.peek().toString()} the ans = ${c.io.out.peek().toString()}")
          c.io.out.expect(AnswerSeq(i).U)
        }
    }
  }
}
