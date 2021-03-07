package finders.item

import item.Item

import java.util.Optional

trait Finder {

  def findItem(item: String): Optional[Item]

}
