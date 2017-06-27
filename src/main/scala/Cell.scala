package org.GameOfLife.unit

/**
  * Created by KingOfBeasts on 25-06-2017.
  */
class Cell (lifeStatus:Boolean){
  private var life:Boolean = lifeStatus
  def isLive:Boolean = life
  def toggleLife:Boolean = {
    life = if (isLive) false else true
    isLive
  }
  override def toString: String = "|"+ {if (isLive==true) "X" else " "} +"|"
}
