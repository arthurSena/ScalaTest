package com.example

import scala.collection.mutable.ArrayBuffer

/**
 * Created by arthur on 10/03/15.
 */
class User (name:String){

  var myName = name
  var phones = new ArrayBuffer[Int]()

  override def equals(that: Any): Boolean =
    that match {
      case that:User => that.myName == myName
      case _ => false
    }

  def addNumber(phone:Int){
       val p = phones.find(p => p == phone)
       p match {
         case None =>  phones += phone
         case _ => throw new IllegalArgumentException("requirement failed: Cannot add repeated number to a contact")
       }
  }
}
