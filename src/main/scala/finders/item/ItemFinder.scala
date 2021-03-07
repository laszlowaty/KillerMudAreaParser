package finders.item

import item.{Item, ItemType}

import java.util.Optional

object ItemFinder {

  def findAllItems(areas: List[String], finder: String => Optional[Item]): List[Item] = {
    areas.flatMap(findAllItemsInArea(_, finder))
  }

  private def findAllItemsInArea(area: String, finder: String => Optional[Item]): List[Item] = {
    val itemSectionFinder = raw"#OBJECTS([\w\W]+)#ROOMS".r
    val unparsedItems = itemSectionFinder.findFirstMatchIn(area).toString.split("#Vnum").toList
    unparsedItems.map(finder).filter(_.isPresent).map(_.get())
  }

}
