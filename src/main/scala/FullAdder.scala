// fulladder.scala
import chisel3._

class FullAdder extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val out = Output(UInt(8.W))
  })
  io.out := io.a + io.b
}

class Register extends  Module{
  val io = IO(new Bundle() {
    val in = Input(UInt(8.W))
    val out = Output(UInt(8.W))
  })
  val reg = RegInit(0.U(8.W))
  io.out := reg
  reg := io.in
}

class Counter10 extends Module{
  val io = IO(new Bundle() {
    val out = Output(UInt(4.W))
  })
  val add = Module(new FullAdder)
  val reg = Module(new Register)
  val count = reg.io.out
  add.io.a := 1.U
  add.io.b := count
  val res = add.io.out
  val next = Mux(res === 10.U,0.U,add.io.out)
  reg.io.in := next
  io.out :=next
}