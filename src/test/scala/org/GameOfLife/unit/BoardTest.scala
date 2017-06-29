package org.GameOfLife.unit

/**
  * Created by KingOfBeasts on 25-06-2017.
  */
import org.scalatest.FunSuite
class BoardTest extends FunSuite {
  val s = new Board(3,null)

  test("setCell/getPopulation/display"){
    s.setCell(2,2,true)
    assertResult(1)(s.getPopulation(2,1))
    assertResult(1)(s.getPopulation(1,2))
    assertResult(1)(s.getPopulation(1,1))
    assertResult(0)(s.getPopulation(0,0))
    assertResult(0)(s.getPopulation(15,15))
    assertResult(0)(s.getPopulation(-1,-1))
    s.display
  }
}
