package com.intapeople.mars.exercise

/*
* 
* To represent a Robotic Rover
* @author rambabu.posa
*/
class RoboticRover(val coordinates: Coordinates, var direction: Char, val planet: Planet) {

  val compass = Seq('N', 'E', 'S', 'W')

  /*
   * To Perform robotic Rover commands 
   * 1) M stands for Move forward
   * 2) L stands for Move Left
   * 3) R stands for Move Right
   */
  def sendCommands(commands: String): String = {
    def sendCommands(commands: List[Char], performed: String): String = {
      commands.head match {
        case 'M' => if(!move(1)) return performed
        case 'L' => turn(-1)
        case 'R' => turn(1)
      }
      if (commands.tail == Nil) performed + commands.head.toString
      else sendCommands(commands.tail, performed + commands.head.toString)
    }
    val performed = sendCommands(commands.toList, "")
    (if (performed == commands) "OK" else "NOK") + ": " + performed
  }

  private def move(stepDirection: Int): Boolean = {
    val newCoordinates = coordinates.step(stepDirection, direction, planet.coordinates)
    if (planet.hasObstacle(newCoordinates)) false
    else { coordinates.update(newCoordinates); true }
  }

  private def turn(turnDirection: Int) {
    direction = compass((4 + compass.indexOf(direction) + turnDirection) % 4)
  }

}

object RoboticRover {
  def apply(initialX: Int, initialY: Int, direction: Char, planet: Planet = Planet()) = {
    new RoboticRover(Coordinates(initialX, initialY), direction, planet)
  }
}