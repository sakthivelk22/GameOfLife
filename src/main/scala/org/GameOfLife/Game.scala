package org.GameOfLife

/**
  * Created by KingOfBeasts on 25-06-2017.
  */

import org.GameOfLife.unit.Board

class Game(boardSize:Int){
  val gameBoard = new Board(boardSize,null)

  private def processNexGen(reps:Int,board:Board):Board=
    if(reps>1) processNexGen(reps-1,new Board(boardSize,board))  else new Board(boardSize,board)

  def setGameBoard(row:Int,col:Int,state:Boolean):Boolean=gameBoard.setCell(row,col,state)

  def GenX(reps:Int):Unit = {
    println("Generation ZERO .. ")
    gameBoard.display
    processNexGen(reps,gameBoard)
  }
}

object Game{
  val a = new Game(20)
  a.setGameBoard(1,3,true)
  a.setGameBoard(2,3,true)
  a.setGameBoard(3,3,true)
  a.setGameBoard(3,2,true)
  a.setGameBoard(2,1,true)
  a.setGameBoard(2,18,true)
  a.setGameBoard(2,19,true)
  a.setGameBoard(2,20,true)
  a.GenX(72)
}
