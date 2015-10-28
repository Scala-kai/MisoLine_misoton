package com.misoton.misoline.controller

import com.misoton.misoline.command.CommandManager
import com.misoton.misoline.data.ApplicationData

import scala.util.control.Breaks

object Main {
  val b = new Breaks

  def main(args: Array[String]): Unit = {
    b.breakable {
      actionLoop()
    }
  }

  def actionLoop(): Unit = {
    Iterator.continually({
      print("[ " + ApplicationData.getCurrentUser.name + " ]" + "> ")
      scala.io.StdIn.readLine()
    }).takeWhile(_ != null).foreach {
      line =>
        val finish = CommandManager.runCommand(line)
        if (finish) {
          b.break()
        }
    }
  }
}
