package gameoflife


object Game {
  def tick(grid: Array[Array[Int]]) :Array[Array[Int]] = {
    grid.zipWithIndex.map{ case (row: Array[Int], rowIndex: Int) =>
      row.zipWithIndex.map{case (cell: Int, colIndex: Int) =>
        evaluateCell(grid, rowIndex, colIndex)}}
  }

  def evaluateCell(grid: Array[Array[Int]], row: Int, col: Int) :Int = {
    var liveCellCount = 0
    val rowAbove = grid(if(row > 0) row - 1 else grid.length - 1)
    val currentRow = grid(row)
    val rowBelow = grid((row + 1) % grid.length)
    val reverseWrappedColNumber = if(col > 0) col - 1 else grid(row).length -1
    val forwardWrappedColNumber: Int = (col + 1) % grid(row).length

    liveCellCount += rowAbove (reverseWrappedColNumber)
    liveCellCount += rowAbove (col)
    liveCellCount += rowAbove (forwardWrappedColNumber)
    liveCellCount += currentRow (reverseWrappedColNumber)
    liveCellCount += currentRow(forwardWrappedColNumber)
    liveCellCount += rowBelow (reverseWrappedColNumber)
    liveCellCount += rowBelow (col)
    liveCellCount += rowBelow (forwardWrappedColNumber)
    if (liveCellCount < 2 || liveCellCount > 3) 0 else if (liveCellCount == 2) grid(row)(col) else 1
  }

}
