import chisel3.{Bundle, Module}
import chisel3._
import chisel3.util._
class ALU extends Module{
  val io = IO(new Bundle() {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val op = Input(UInt(3.W))
    val out = Output(UInt(32.W))
  })
  io.out := 0.U // default value
  switch(io.op){
    is(0.U){io.out := io.a + io.b}
    is(1.U){io.out := io.a - io.b}
    is(2.U){io.out := io.a * io.b}
    is(3.U){io.out := io.a / io.b}
    is(4.U){io.out := io.a & io.b}
    is(5.U){io.out := io.a ^ io.b}
  }
}
