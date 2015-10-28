package com.misoton.misoline.log

import java.io.{OutputStreamWriter, FileOutputStream}
import java.util.{Locale, Date}

import com.misoton.misoline.data.ApplicationData

object Log {
  var time: Option[String] = None

  val TYPE_INFORMATION = "INFORMATION"
  val TYPE_DEBUG = "DEBUG"

  def i = Log.writeLog(TYPE_INFORMATION) _

  def d = Log.writeLog(TYPE_DEBUG) _

  private def makeWithTemplate(logType: String, tag: String, message: String): String = {
    nowTimeString + " [" + logType + "] " + tag + " " + message +  " by " + ApplicationData.getCurrentUser.id + "\n"
  }

  private def writeLog(logType: String)(tag: String, message: String): Unit ={
    val logMessage = makeWithTemplate(logType, tag, message)

    val fileName = "log" + timeString + ".log"
    val encode = "UTF-8"
    val append = true

    val fileOutPutStream = new FileOutputStream(fileName, append)
    val writer = new OutputStreamWriter( fileOutPutStream, encode )

    writer.write(logMessage)
    writer.close()
  }

  private def nowTimeString: String = "%tF_%<tT" formatLocal (Locale.JAPAN, new Date)

  private def timeString: String = time match {
    case Some(message) =>
      message

    case None =>
      val newTime = nowTimeString
      time = Some(newTime)
      newTime
  }
}
