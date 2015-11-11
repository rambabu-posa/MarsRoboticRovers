package com.intapeople.mars.exercise

/*
* 
* To represent x and y coordinates
* @author rambabu.posa
*/
class Coordinates(val x: Point, val y: Point) {

  /*
   * To move robot in all direcations : North, South, East and West
   * 1) Any move from point (X,Y) and the rover facing towards North will increment	++Y 
   * 2) Any move from point (X,Y) and the rover facing towards South will decrement --Y
   * 3) Any move from point (X,Y) and the rover facing towards East will increment  ++X
   * 4) Any move from point (X,Y) and the rover facing towards West will decrement --X
   */
  def step(stepDirection: Int, direction: Char, planetCoordinates: Coordinates): Coordinates = {
    var stepX, stepY = 0
    direction match {
      case 'N' => stepY = 1
      case 'S' => stepY = -1
      case 'E' => stepX = 1
      case 'W' => stepX = -1
    }
    Coordinates(x.step(stepDirection, stepX, planetCoordinates.x.location),
      y.step(stepDirection, stepY, planetCoordinates.y.location))
  }
   /*
   * To update x and y coordinates values
   */
  def update(coordinates: Coordinates) {
    x.location = coordinates.x.location
    y.location = coordinates.y.location
  }
}

object Coordinates {
  def apply(x: Int, y: Int) = new Coordinates(new Point(x), new Point(y))
}
