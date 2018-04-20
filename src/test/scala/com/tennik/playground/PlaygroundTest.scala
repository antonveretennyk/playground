package com.tennik.playground

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class PlaygroundTest extends Specification {

  trait Context extends Scope

  "The 'Hello world' string" should {
    "contain 11 characters" in new Context  {
      "Hello world" must have size 11
    }
    "start with 'Hello'" in new Context  {
      "Hello world" must startWith("Hello")
    }
    "end with 'world'" in new Context  {
      "Hello world" must endWith("world")
    }
  }
}