package com.example

import sun.swing.plaf.windows.ClassicSortArrowIcon

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

    println("//----------------------Trait--------------------------------")
    val sumAndSqr = new SumAndSqr
    val timesAndSqrt = new TimesAndSqrt


    for (i <- (1 to 10)){
      println("sumAndSqr.calculation("+i+"," +(i+1)+"): " + sumAndSqr.calculation(i, (i+1)))
      println(("timesAndSqrt.calculation("+i+"," +(i+1)+"): " + timesAndSqrt.calculation(i, (i+1))))
    }


    println("//----------------------Pattern Matching--------------------------------")
    val listaObj = List[Any]()
    new Car :: listaObj
    new MotorCycle :: listaObj
    new Bike :: listaObj
    println("See the code")

    println("//----------------------Options--------------------------------")
    var listaOpt = List[Person]()

    var p1 = new Person
    p1.auto = Some(new Carro)

    var p2 = new Person
    p2.auto = Some(new Bicleta)

    var p3 = new Person
    p3.auto = Some(new Helicoptero)

    var p4 = new Person
    p4.auto = Some(new Moto)

    var p5 = new Person
    var p6 = new Person
    var p7 = new Person

    listaOpt = p1 :: p2 :: p3 :: p4 :: p5 :: p6 :: p7 :: listaOpt

    println("Tuple with the persons " +getPerson(listaOpt).toString())

    println("//----------------------Métodos e objetos implicitos--------------------------------")
    var pb = new phonebook().addName("Arthur")
    println("Both lists were merged using a for command and a implicit function: "+juntaListasImplicit(l1,l2).toString())





  }
  implicit def soma(x:Integer, y :Integer) = x+y
  implicit def a(s:String) = new User(s)

  def getPerson(lista:List[Person]) = {
    var t = List[(Any,Any)]()
    lista.map(p => p.auto match {
      case Some(c) => if (c.name != "" && c.brand != "") t = (c.name,c.brand) :: t
                      else if (c.name != ""  && c.brand == "") t = (c.name,"no brand") :: t
                      else if (c.name == "" && c.brand == "") t = ("no name","no brand") :: t
                      else t = ("no name" , c.brand) :: t
      case None =>
    })
    t
  }

//  implicit def implicitAddName(user: User) =

  def carMotorBike(obj : Any) = obj match {
    case c :Car => println("Car")
    case m:MotorCycle => println("Motorcycle")
    case b:Bike => println("Bike")
  }

  //------------------------Question 1 ----------------------------------
  def juntaListas(lista1 : List[Integer], lista2 : List[Integer], mult:(Integer, Integer) => Integer) = {
    var listaToReturn = List[Integer]()

    for (i <- 0 to (lista1.length - 1)){
      listaToReturn = mult(lista1(i), lista2(i)) :: listaToReturn
    }

    listaToReturn.reverse
  }

  def juntaListasImplicit(lista1 : List[Integer], lista2 : List[Integer]) (implicit soma:(Integer, Integer) => Int) = {
    var listaToReturn = List[Integer]()

    for (i <- 0 to (lista1.length - 1)){
      listaToReturn = soma(lista1(i), lista2(i)) :: listaToReturn
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


