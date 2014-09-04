object FrogJump {
  def count(start: Int, end: Int, distance: Int) = {
    val toTravel = end - start
    if (toTravel % distance > 0) {
      1 + toTravel / distance
    }
    else {
      toTravel / distance
    }
  }

}
