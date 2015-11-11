package com.intapeople.mars.exercise

/*
* 
* To represent Plateau  Planet on Mars
* @author rambabu.posa
*/
class Planet(val coordinates: Coordinates = Coordinates(100, 100), obstacles: List[Coordinates] = List()) {
  def hasObstacle(location: Coordinates): Boolean = {
    for (coordinates <- obstacles) {
      if (coordinates.x == location.x && coordinates.y == location.y) {
        return true
      }
    }
    false
  }
}
object Planet {
  def apply(maxX: Int = 100, maxY: Int = 100, obstacles: List[Coordinates] = List()) = {
    new Planet(Coordinates(maxX, maxY), obstacles)
  }
}