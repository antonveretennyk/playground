package com.tennik.playground

object TreeTraversal extends App {
  case class TreeNode(v: Int, l: Option[TreeNode] = None, r: Option[TreeNode] = None) {
    def hasLeft: Boolean = l.nonEmpty
    def hasRight: Boolean = r.nonEmpty
    def empty: Boolean = !(hasLeft || hasRight)
    def hasBoth: Boolean = hasLeft && hasRight
  }

  def preOrderTraverse(root: TreeNode): List[Int] = ifRootNotNull(root) {
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

  private def ifRootNotNull(root: TreeNode)(body: => List[Int]): List[Int] =
    if (root == null) List.empty[Int]
    else body
}
