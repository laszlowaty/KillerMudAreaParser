package item

class Item(name: String, itemType: String) {
  override def toString: String = "name: " + name + "-type:" + itemType
}
