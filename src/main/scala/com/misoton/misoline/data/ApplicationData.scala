package com.misoton.misoline.data

object ApplicationData {
  private var messageData: List[Message] = List()
  private var talkData: List[Talk] = List()
  private var userData: List[User] = List()

  private var currentUserId: String = ""

  def getMessageData = messageData

  def getTalkData = talkData

  def getUserData = userData

  def getCurrentUser = userData.find(u => u.id == currentUserId) match {
    case Some(user) => user
    case None => User.NoUser
  }

  def getTalkDataWithFriend(user: User, friend: User): Option[Talk] = {
    talkData.find(t => (t.usera == user && t.userb == friend) || (t.userb == user && t.usera == friend))
  }

  def addMessage(message: Message): Unit = {
    messageData = message +: messageData
  }

  def addTalk(talk: Talk): Unit = {
    talkData = talk +: talkData
  }

  def addUser(user: User): Boolean = {
    if (!user.isRightUser || userData.exists(_.equals(user))) return false

    userData = user +: userData
    true

  }

  def checkoutUser(user: User): Boolean = {
    if (userData.exists(u => u.id == user.id)) {
      currentUserId = user.id
      return true
    }

    false
  }

  def newTalk(user: User, friend: User): Unit = {
    talkData = Talk(user, friend) +: talkData
  }
}
