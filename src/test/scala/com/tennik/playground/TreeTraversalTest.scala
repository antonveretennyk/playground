package com.tennik.playground

import com.tennik.playground.TreeTraversal.TreeNode
import com.tennik.playground.TreeTraversal.preOrderTraverse
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class TreeTraversalTest extends Specification {

  "preOrderTraverse should return value of root is root has no leaf" in new ctx {
    preOrderTraverse(TreeNode(42)) must be_==(List(42))
  }

  "preOrderTraverse should return empty list if root == null" in new ctx {
    preOrderTraverse(null) must beEmpty
  }

  "preOrderTraverse should return valid output for right corner case" in new ctx {
    private val root = TreeNode(1, None, Some(TreeNode(2, None, Some(TreeNode(3, None, None)))))

    preOrderTraverse(root) must be_==(List(1, 2, 3))
  }

  "preOrderTraverse should return valid output for left corner case" in new ctx {
    private val root = TreeNode(1, Some(TreeNode(2, Some(TreeNode(3)))))

    preOrderTraverse(root) must be_==(List(1, 2, 3))
  }

  "preOrderTraverse should return valid output" in new ctx {
    preOrderTraverse(inputTree) must be_==(output)
  }

  trait ctx extends Scope {
    val inputTree = TreeNode(
      v = 1,
      l = Some(TreeNode(
        v = 2,
        l = Some(TreeNode(
          v = 4,
          l = Some(TreeNode(v = 5))
        )),
        r = Some(TreeNode(v = 3))
      )),
      r = Some(TreeNode(
        v = 6,
        r = Some(TreeNode(
          v = 7,
          l = Some(TreeNode(v = 8))
        ))
      ))
    )

    val output: List[Int] = 1 :: 2 :: 4 :: 5 :: 3 :: 6 :: 7 :: 8 :: Nil

  }
}