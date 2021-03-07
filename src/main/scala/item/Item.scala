package item

case class Item(name: String, itemType: String) {
  override def toString: String = s"name: ${name} - type: ${itemType}"
}
