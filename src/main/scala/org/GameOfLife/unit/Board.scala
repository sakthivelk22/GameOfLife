package org.GameOfLife.unit

/**
  * Created by KingOfBeasts on 25-06-2017.
  */

class Board(boardSize:Int,parent:Board){

  private def getBoard:List[List[Cell]]={
    def getConsolidate[T](f:Int=>T,size:Int,acc:List[T]):List[T] =
      if (size>0) getConsolidate(f,size-1,List(f(size)):::acc) else acc
    def getCell(row:Int)(col:Int):Cell =  new Cell(if (parent==null) false else parent.getNexGen(row-1,col-1))
    def getRow(row:Int):List[Cell] = getConsolidate[Cell](getCell(row),boardSize,List[Cell]())
    getConsolidate[List[Cell]](getRow,boardSize,List[List[Cell]]())
  }

  private def getNexGen(row:Int,col:Int):Boolean =
    getPopulation(row+1,col+1) match { case 3 => true case 2 => board(row)(col).isLive  case _ => false }

  def display:Unit={
    board.foreach(x=>{x.foreach(y=>print(y.toString));println()})
    println()
  }

  def setCell(row:Int,col:Int,state:Boolean):Boolean =
    if(board(row-1)(col-1).isLive!=state) board(row-1)(col-1).toggleLife else state

  def getPopulation(row:Int,col:Int):Int={
    def getCol(xrow: Int, acc: Int):Int = (if(xrow!=row-1 && board(xrow)(col-1).isLive) 1 else 0) +
        (if (col>1&&col<=boardSize && board(xrow)(col-2).isLive) 1 else 0) +
        (if (col>=1&&col<boardSize && board(xrow)(col).isLive) 1 else 0)
    getCol(row-1,0) + (if (row>1&&row<=boardSize) getCol(row-2,0) else 0) +
      (if (row>=1&&row<boardSize) getCol(row,0) else 0)
  }

  val board:List[List[Cell]] = getBoard
  display
}