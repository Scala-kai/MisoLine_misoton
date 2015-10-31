package com.misoton.misoline.command

import com.misoton.misoline.data.{ApplicationData, User}

case object FollowFriendCommand extends Command {
  private val ARG_SIZE = 1

  override def run(args: List[String]): CommandResult = {
    if (args.size < ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "follow [phone or email] : Follow user by phone number or email address.")
    }

    val you = ApplicationData.getCurrentUser
    val value = args(1)

    val friend =
      if (User.isRightPhoneNumber(value)) {
        ApplicationData.getUserData.find(u => u.phoneNumber == value)
      } else if (User.isRightEmailAddress(value)) {
        ApplicationData.getUserData.find(u => u.email == value)
      } else {
        return CommandResult(CommandResult.ERR, "follow [phone or email] : Follow user by phone number or email address.")
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
