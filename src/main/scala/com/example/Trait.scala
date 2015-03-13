package com.example

/**
 * Created by arthur on 13/03/15.
 */
trait Trait {

    def binaryFunction(x:Int, y:Int) : Int
    def unaryFunction(x:Int):Int

    def calculation(x:Int, y:Int) = unaryFunction(binaryFunction(x,y))

}
