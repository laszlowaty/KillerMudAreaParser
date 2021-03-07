package file

import java.io.File
import scala.io.Source

object AreaReader {
  def readAreas(path: String, fileEncoding: String = "ISO-8859-2"): List[String] = getListOfAreas(path).map(readArea(_, fileEncoding))

  def getListOfAreas(path: String): List[File] = new File(path).listFiles().filter(_.isFile).toList

  def readArea(areaFile: File, fileEncoding: String): String = {
    val openedAreaFile = Source.fromFile(areaFile, enc = fileEncoding)
    val area =  openedAreaFile.getLines().mkString
    openedAreaFile.close()
    area
  }
}
