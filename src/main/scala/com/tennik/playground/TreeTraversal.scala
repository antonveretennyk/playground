package com.tennik.playground

object TreeTraversal extends App {
  case class TreeNode(v: Int, l: Option[TreeNode] = None, r: Option[TreeNode] = None) {
    def hasLeft = l.nonEmpty
    def hasRight = r.nonEmpty
    def empty = !(hasLeft || hasRight)
    def hasBoth = hasLeft && hasRight
  }

  def preOrderTraverse(root: TreeNode): List[Int] = {
    var result = List.empty[Int]
    var stack = List.empty[TreeNode]
    var n = root
    var exit = false

    do {

      n match {
        case x if x.empty =>
          result = result :+ n.v
          if (stack.nonEmpty) {
            n = stack.head
            stack = stack.tail
          } else {
            exit = true
          }
        case x if x.hasBoth =>
          result = result :+ n.v
          stack = n.r.get :: stack
          n = n.l.get
        case x if x.hasLeft =>
          result = result :+ n.v
          n = n.l.get
        case _ =>
          result = result :+ n.v
          n = n.r.get
      }

    } while (!exit)

    result
  }
}
