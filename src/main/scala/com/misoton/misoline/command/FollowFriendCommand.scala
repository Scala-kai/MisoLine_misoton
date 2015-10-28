package com.misoton.misoline.command

import com.misoton.misoline.data.ApplicationData

case object FollowFriendCommand extends Command {
  private val ARG_SIZE = 2

  private val MODE_PHONE = "phone"
  private val MODE_EMAIL = "email"

  override def run(args: List[String]): CommandResult = {
    if (args.size < ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "Number of argument error.")
    }

    val you = ApplicationData.getCurrentUser
    val mode = args(1)
    val value = args(2)

    val friend = mode match {
      case MODE_PHONE => ApplicationData.getUserData.find(u => u.phoneNumber == value)
      case MODE_EMAIL => ApplicationData.getUserData.find(u => u.email == value)
      case _ => return CommandResult(CommandResult.ERR, "format: follow <MODE: phone, email> value.")
    }

    friend match {
      case Some(user) => if (!you.getFriends.contains(user)) {
        you.addFriend(user)
        user.addFriend(you)
        ApplicationData.newTalk(you, user)
        println("Followed * " + user.name + " * ")
        CommandResult(CommandResult.OK, "Follow " + user.id + ".")
      } else {
        CommandResult(CommandResult.ERR, "This user is already friend.")
      }

      case None => CommandResult(CommandResult.ERR, "Such user is not found.")
    }


  }
}
