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
    val stack = new Stack[TreeNode]
    var n = root
    var exit = false

    do {
      result = result :+ n.v
      n match {
        case x if x.empty =>
          if (stack.nonEmpty) {
            n = stack.pop
          } else {
            exit = true
          }
        case x if x.hasBoth =>
          stack.push(x.r.get)
          n = x.l.get
        case x if x.hasLeft =>
          n = x.l.get
        case _ =>
          n = n.r.get
      }

    } while (!exit)

    result
  }

  private class Stack[T] {
    private var xs = List.empty[T]
    def pop: T = {
      val x = xs.head
      xs = xs.tail
      x
    }

    def push(x: T): Unit = xs = x :: xs

    def nonEmpty: Boolean = xs.nonEmpty
  }

  private def ifRootNotNull(root: TreeNode)(body: => List[Int]): List[Int] =
    if (root == null) List.empty[Int]
    else body
}
