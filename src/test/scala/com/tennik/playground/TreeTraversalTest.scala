package com.tennik.playground

import com.tennik.playground.TreeTraversal.TreeNode
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class TreeTraversalTest extends Specification {

  "preOrderTraverse should return valid output" in new ctx {
    TreeTraversal.preOrderTraverse(inputTree) must be_==(output)
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