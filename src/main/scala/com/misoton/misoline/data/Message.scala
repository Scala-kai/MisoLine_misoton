package com.misoton.misoline.data

case class Message(body: String, from: User, to: User) {
  private var checked: Boolean = false

  def check(): Unit = {
    checked = true
  }

  def isChecked: Boolean = {
    checked
  }
}
