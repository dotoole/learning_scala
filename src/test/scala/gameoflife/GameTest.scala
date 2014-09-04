package gameoflife

import org.scalatest.{Matchers, FlatSpec}

class GameTest extends FlatSpec with Matchers {


  "middle cell" should "die when fewer than two live neighbours" in {
    val grid = Array(
      Array(0,0,0),
      Array(0,1,0),
      Array(0,0,0)
    )

    Game.evaluateCell(grid, 1, 1) should be (0)
  }

  "middle cell" should "live on with two live neighbours" in {
    val grid = Array(
      Array(0,1,0),
      Array(1,1,0),
      Array(0,0,0)
    )

    Game.evaluateCell(grid, 1, 1) should be (1)
  }

  "middle cell" should "live on with three live neighbours" in {
    val grid = Array(
      Array(0,1,0),
      Array(1,1,1),
      Array(0,0,0)
    )

    Game.evaluateCell(grid, 1, 1) should be (1)
  }

  "middle cell" should "die with four live neighbours" in {
    val grid = Array(
      Array(0,1,0),
      Array(1,1,1),
      Array(1,0,0)
    )

    Game.evaluateCell(grid, 1, 1) should be (0)
  }

  "middle cell" should "come to life with three live neighbours" in {
    val grid = Array(
      Array(0,1,0),
      Array(1,0,1),
      Array(0,0,0)
    )

    Game.evaluateCell(grid, 1, 1) should be (1)
  }

  "middle cell" should "stay dead with two live neighbours" in {
    val grid = Array(
      Array(0,0,0),
      Array(1,0,1),
      Array(0,0,0)
    )

    Game.evaluateCell(grid, 1, 1) should be (0)
  }

  "bottom right cell" should "come to life with three wrapped live neighbours" in {
    val grid = Array(
      Array(1,0,0,1),
      Array(0,0,0,0),
      Array(0,0,0,0),
      Array(1,0,0,0)
    )

    Game.evaluateCell(grid, 3, 3) should be (1)
  }

  "top left cell" should "come to life with three wrapped live neighbours" in {
    val grid = Array(
      Array(0,0,0,1),
      Array(0,0,0,0),
      Array(0,0,0,0),
      Array(1,0,0,1)
    )

    Game.evaluateCell(grid, 0, 0) should be (1)
  }

  "generation with block" should "stay in next generation" in {
    val grid = Array(
      Array(0,0,0,0),
      Array(0,1,1,0),
      Array(0,1,1,0),
      Array(0,0,0,0)
    )

    Game.tick(grid) should equal (grid)
  }

  "generation with blinker" should "blink" in {
    val grid = Array(
      Array(0,0,0,0),
      Array(1,1,1,0),
      Array(0,0,0,0),
      Array(0,0,0,0)
    )
    val expectedGrid = Array(
      Array(0,1,0,0),
      Array(0,1,0,0),
      Array(0,1,0,0),
      Array(0,0,0,0)
    )

    Game.tick(grid) should equal (expectedGrid)
  }
}
