package org.GameOfLife.unit

/**
  * Created by KingOfBeasts on 25-06-2017.
  */

import org.scalatest.FunSuite
class CellTest extends FunSuite{
  val f = new Cell(false)
  val t = new Cell(true)
  test("isLive"){
    assertResult(true)(t.isLive)
    assertResult(false)(f.isLive)
  }
  test("toggleLife"){
    assertResult(false)(t.toggleLife)
    assertResult(true)(t.toggleLife)
    assertResult(true)(f.toggleLife)
    assertResult(false)(f.toggleLife)
  }
  test("toString"){
    assertResult("| |")(f.toString)
    assertResult("|X|")(t.toString)
  }
}
