package com.example

import scala.collection.mutable.ArrayBuffer

/**
 * Created by arthur on 10/03/15.
 */
class PhoneBook(var owner:User){

  //Checking constructor arguments
  if (owner==null){
    throw new IllegalArgumentException("requirement failed: Phonebook owner cannot be null")
  }

  //Class attributes

  var contacts = new ArrayBuffer[User]()

  //This method takes a user object as parameter and add it to the list of contact if it does not exist yet
  def addContact(user:User){
    if(user == null){
      throw new IllegalArgumentException("requirement failed: Contact cannot be null")
    }

    else{
      val c = contacts.find(p => p.myName == user.myName)
      if (c != None){
        throw new IllegalArgumentException("requirement failed: Cannot add repeated contacts")
      }
      else{
        contacts += user
      }
    }

  }

  //This methods takes two arguments as parameters, name and phonem and is going to add the phone number to the contact
  def addPhoneNumber(name:String, phone:Int): Unit ={

    (contacts.find(p => p.myName == name)) match {
      case None => throw new IllegalArgumentException("There is no user named " + name)
      case _ =>
        (contacts.find(p => p.myName == name)).get.addNumber(phone)
    }


  }

  //This method finds a contact by using the name taken as parameter

  def findContact(name:String):List[User] ={
    name match {
      case null => throw new IllegalArgumentException("requirement failed: Cannot search for a null user")
      case _ =>
        var listUsers = List[User]()
        for (c <- contacts if c.myName.startsWith(name.toLowerCase())){
          listUsers = c :: listUsers
        }
        return listUsers.sortBy(_.myName)
    }
  }

}

