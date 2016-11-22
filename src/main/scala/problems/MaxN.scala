// See LICENSE.txt for license details.
package problems

import chisel3._

class MaxN(val n: Int, val w: Int) extends Module {

  private def Max2(x: UInt, y: UInt) = Mux(x > y, x, y)

  val io = IO(new Bundle {
    val ins = Input(Vec(n, UInt(w.W)))
    val out = Output(UInt(w.W))
  })

  io.out := io.ins.reduceLeft(Max2)
}
