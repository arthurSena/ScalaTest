package com.example

import scala.collection.mutable.ArrayBuffer
import collection.mutable.HashMap


/**
 * Created by arthur on 12/03/15.
 */
object Lab {

  def main(args: Array[String]): Unit = {
    var l1 = List[Integer](1,2,3,4,5,6,7,8,9)
    var l2 = List[Integer](1,2,3,4,5,6,7,8,9)

    println("//------------------------High Order Functions----------------------------------")
    println("lista1: " + l1)
    println("lista2: " + l2)
    println("Both lists were merged using a for command and the function was taken: "+juntaListas(l1,l2,mult).toString())
    println("Both lists were merged using a for command and anonym function: "+juntaListas(l1,l2,(x:Integer,y:Integer) => x*y).toString())
    println("Both lists were merged without a for command and the function was taken: "+juntaListasSemFor(l1,l2,mult).toString())
    println("Both lists were merged without a for command and using anonym function: "+juntaListasSemFor(l1,l2,(x:Integer,y:Integer) => x*y).toString())

    println("//-----------------------Collections------------------------------")

    println("List: " + List(1,2,3).toString())
    println("Adding a element to the beginning of a list: "+ (4 :: List(1,2,3)).toString()) //Adding a element to the beginning of a list

    println("Adding a element to the final of a list: "+ (List(1,2,3) :+ 4).toString()) //Adding a element to the final of a list

    println("It removes the first element of the list "+(List(1,2,3).drop(1)).toString())//It removes the first element of the list

    println("It replaces the first element by 10: "+(List(1,2,3).updated(0,10)).toString()) //It replaces the first element by 10

    var multableList = new ArrayBuffer[Integer]()

    multableList.+=(1)
    multableList.+=(2)
    println("mutableList: " + multableList.toString())

    println("Adding a element to the end of a mutable list: " + (multableList.+=(3)).toString)//Adding a element to the end of a mutable list

    println("Adding a element to the beginning of a mutable list: "+ (multableList.+=:(4)).toString)//Adding a element to the beginning of a mutable list

    println("It removes the first element of the list: " + (multableList.remove(0)).toString)//It removes the first element of the list


    multableList.update(0,10)
    println("It updates the first element of the list: "+multableList.toString())//It updates the first element of the list

    println("//-----------------------Hash Maps------------------------------")
    var imuhasMap = new HashMap[Int,String]()
    imuhasMap += (1 -> "b", 2 -> "a", 3 -> "c")

    println("HashMap: " + imuhasMap.toString())

    println("Adding a new (key,value): "+(imuhasMap += (4 -> "d")).toString())// Adding a new (key,value)

    println("Removing a key and its value: "+(imuhasMap.-=(4)).toString) //Removing a key and its value

    println("It gets the value for the key two: "+imuhasMap.get(2).toString) //It gets the value for the key two

    println("//-----------------------Tuple------------------------------")
    var t = (1,2,3)
    println("Tuple: " + t.toString)
    var temp = t.copy(4) //It copies the original tuple and modifies the copy by replacing its the first element storing into the X variable
    println("It copies the original tuple and modifies the copy by replacing its the first element by 4: "+temp.toString)
    println("//-----------------------Range------------------------------")
    var lista100 = (0 to 100).toList
    println("See the code")
    println("//-----------------------Map--------------------------------")

    var lista50 = (0 to 50).toList
    println("Before Map: "+lista50.toString())
    lista50  = lista50.map(x => x*x)
    println("After Map: "+lista50.toString())

    println("//-----------------------Filter--------------------------------")

    var lista10 = (0 to 10).toList
    println("lista: "+lista10.toString)

    println("Using an anonym function: "+(lista10.filter(p => p%2==0)).toString()) //Using an anonym function
    println("In this case, the function was taken: "+lista10.filter(p => isEven(p) ).toString()) //In this case, the function was taken
    println("Using an underline: "+ (lista10.filter(_%2==0)).toString()) //Using an underline

    def isEven(x:Integer) = x%2==0

    println("//-----------------------Find--------------------------------")
    var lista1to10 = (1 to 10).toList
    println("lista: "+lista1to10.toString)
    println("It gets the 5 element using an anonym function: "+(lista1to10.find(p => p - 5 == 0).get).toString) //It gets the 5 element using an anonym function

    println("In this case, the function was taken: "+(lista1to10.find(p => is5(p)).get).toString)//In this case, the function was taken

      println("Using an underline: "+(lista1to10.find(_-5==0).get).toString)//Using an underline

    def is5(x:Integer) = x- 5 == 0
    println("//----------------------Reduce--------------------------------")
    var lista = (1 to 10).toList
    println("Before Reduce: " + lista)
    println("After Reduce: " + lista.reduce((x:Int, y:Int) =>x+y).toString)




  }

  //------------------------Question 1 ----------------------------------
  def juntaListas(lista1 : List[Integer], lista2 : List[Integer], mult:(Integer, Integer) => Integer) = {
    var listaToReturn = List[Integer]()

    for (i <- 0 to (lista1.length - 1)){
      listaToReturn = mult(lista1(i), lista2(i)) :: listaToReturn
    }

    listaToReturn.reverse
  }


  //The function below does the same thing that the above function does without using for commmand
  def juntaListasSemFor(lista1 : List[Integer], lista2 : List[Integer], mult:(Integer, Integer) => Integer) = {
    lista1.zip(lista2).map({a:(Integer, Integer) => mult(a._1,a._2)})
  }


  def mult(x:Integer, y :Integer) = x*y

  //-----------------------------------------------------------------------
}


