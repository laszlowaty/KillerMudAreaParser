package finders.item

import item.Item

import java.util.Optional

object SpellbookFinder extends Finder {

  override def findItem(item: String): Optional[Item] = {
    val itemNameFinder = raw"Short [\w\s żźńąśłóę]+".r
    val itemTypeFinder = raw"Type spellbook".r
    val itemName = itemNameFinder.findFirstMatchIn(item)
    val itemType = itemTypeFinder.findFirstMatchIn(item)
    if (itemType.isDefined && itemName.isDefined) {
      return Optional.of(Item(itemName.get.toString, itemType.get.toString))
    }
    Optional.empty()
  }
}
