package com.intapeople.mars.exercise

import org.scalatest.{Matchers, FlatSpec}

class MarsRoboticRoverAppTest extends FlatSpec with Matchers {

  "Planet" can "define its size" in {
    val mars = Planet(5, 5)
    mars.coordinates.x.location should be (5)
    mars.coordinates.y.location should be (5)
  }

  "RoboticRover" should "accept it's starting point (X,Y) and it's direction (N,S,E,W)" in {
    val rover = RoboticRover(1, 2, 'N')
    rover.coordinates.x.location should be (1)
    rover.coordinates.y.location should be (2)
    rover.direction should be ('N')
  }
  
  "RoboticRover" should "be able to move left (L) and forward(M)" in {
    val rover = RoboticRover(1, 2, 'N')
	rover.sendCommands("LMLMLMLMM")
    rover.coordinates.x.location should be (1)
    rover.coordinates.y.location should be (3)
	rover.direction should be ('N')
  }
  
  "RoboticRover" should "be able to move right(R) and forward(M)" in {
    val rover = RoboticRover(3, 3, 'E')
	rover.sendCommands("MMRMMRMRRM")
    rover.coordinates.x.location should be (5)
    rover.coordinates.y.location should be (1)
	rover.direction should be ('E')
  }
  
}
