package org.GameOfLife.unit

/**
  * Created by KingOfBeasts on 25-06-2017.
  */
class Cell (lifeStatus:Boolean){
  private var life:Boolean = lifeStatus
  def isLive:Boolean = life
  def toggleLife:Boolean = {
    life = !life
    isLive
  }
  override def toString: String = "|"+ {if (isLive==true) "X" else " "} +"|"
}
