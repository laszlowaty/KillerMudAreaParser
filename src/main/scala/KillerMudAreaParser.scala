import finders.item.ItemFinder
import item.ItemType

object KillerMudAreaParser extends App {
  val areasDirectory = "C:\\Users\\laszlo\\IdeaProjects\\KillerMudAreaParser\\areas"
  println(ItemFinder.findAllItems(file.AreaReader.readAreas(areasDirectory), ItemType.spellbook))

}
