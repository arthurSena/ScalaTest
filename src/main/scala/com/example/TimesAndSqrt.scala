package com.example

/**
 * Created by arthur on 13/03/15.
 */
class TimesAndSqrt extends Trait{
  override def binaryFunction(x: Int, y: Int): Int = x*y

  override def unaryFunction(x: Int): Int = Math.sqrt(x).toInt
}
