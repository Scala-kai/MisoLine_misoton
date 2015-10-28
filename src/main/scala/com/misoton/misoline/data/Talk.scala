package com.misoton.misoline.data

case class Talk(usera: User, userb: User, var messageData: List[Message] = List()) {

  def addMessage(message: Message): Unit = {
    messageData = message +: messageData
  }
}
