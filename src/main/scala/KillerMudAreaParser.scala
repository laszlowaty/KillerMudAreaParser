import finders.item.{ItemFinder, SpellbookFinder, WeaponFinder}
import item.ItemType

object KillerMudAreaParser extends App {
  val areasDirectory = "C:\\Users\\laszlo\\IdeaProjects\\KillerMudAreaParser\\areas"

  val finders = Map(
    ItemType.weapon -> WeaponFinder.findItem _,
    ItemType.spellbook -> SpellbookFinder.findItem _,
  )

  println(ItemFinder.findAllItems(file.AreaReader.readAreas(areasDirectory), finders(ItemType.spellbook)))

}
