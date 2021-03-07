package finders.item

import item.{Item, ItemType}

object ItemFinder {
  def findAllItems(areas: List[String], itemType: ItemType.Value): List[Item] = {
    areas.flatMap(findAllItemsInArea(_, itemType))
  }

  private def findAllItemsInArea(area: String, itemType: ItemType.Value): List[Item] = {
    val finders = Map(
      ItemType.weapon -> WeaponFinder.findItem _,
      ItemType.spellbook -> SpellbookFinder.findItem _,
    )

    val itemSectionFinder = raw"#OBJECTS([\w\W]+)#ROOMS".r
    val unparsedItems = itemSectionFinder.findFirstMatchIn(area).toString.split("#Vnum").toList
    unparsedItems.map(finders(itemType)).filter(_.isPresent).map(_.get())
  }

}
