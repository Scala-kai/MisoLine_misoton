package com.misoton.misoline.data

case class User(id: String, name: String, phoneNumber: String, email: String) {
  private var friends: List[User] = List()

  def getFriends = friends

  def addFriend(newFriend: User): Unit = {
    friends = newFriend +: friends
  }

  override def equals(a: Any): Boolean = {
    val o: User = a.asInstanceOf[User]

    o.id == this.id
  }
}

object User{
  val NoUser = User("_", "NoUser", "_", "_")
}
