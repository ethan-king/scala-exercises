package com.rockthejvm.numbers

import scala.annotation.tailrec

object NumberOps {
  implicit class RRichInt(n: Int) {
    def isPrime: Boolean = {
      @tailrec
      def primeTailRec(current: Int): Boolean = {
        if (current == 1) true
        else if (n % current == 0) false
        else primeTailRec(current -1)
      }
      primeTailRec(math.sqrt(n.toDouble).round.toInt)
    }
    def decompose: List[Int] = {
      assert(n >=0)
      @tailrec
      def decTailRec(div: Int, acc: List[Int]): List[Int] = {
        if (div > Math.sqrt(n)) acc
        else if (n % div == 0) decTailRec(div + 1, div :: (n / div) :: acc)
        else decTailRec(div + 1, acc)
      }
      decTailRec(1, List())
    }



  }
}

object NumberProblems extends App {

  import NumberOps._

  println(15.isPrime)
  println(3.isPrime)
  println(23.isPrime)
  println((35).isPrime)
  println((45).isPrime)

  println((24).decompose)
  println((54).decompose)

  def

}
