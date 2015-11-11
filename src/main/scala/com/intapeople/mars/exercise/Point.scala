package com.intapeople.mars.exercise

/*
* 
* To represent a Point (x,y)
* @author rambabu.posa
*/
class Point(var location: Int) {
  def step(direction: Int, step: Int, max: Int): Int = (max + location + step * direction) % max
  override def equals(that: Any): Boolean = this.hashCode() == that.hashCode()
  override def hashCode = location.hashCode
}