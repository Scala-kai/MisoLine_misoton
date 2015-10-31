package com.misoton.misoline.data

case class User(id: String, name: String, phoneNumber: String, email: String) {
  private var friends: List[User] = List()

  def getFriends = friends

  def addFriend(newFriend: User): Unit = {
    friends = newFriend +: friends
  }

  def isRightUser: Boolean = User.isRightPhoneNumber(phoneNumber) && User.isRightEmailAddress(email)

  override def equals(a: Any): Boolean = {
    val o: User = a.asInstanceOf[User]

    o.id == this.id
  }
}

object User {
  val NoUser = User("_", "NoUser", "_", "_")

  def isRightPhoneNumber(phoneNumber: String) : Boolean = phoneNumber.filter(x => !(x.isDigit || x.equals('-'))).length == 0

  def isRightEmailAddress(email: String) : Boolean = email != null && email.count(_.equals('@')) == 1
}
