//This is an abstract class for CRUD OPERATIONS
abstract class CrudOperations {
  //All these method are polymorphic method of abstract type
  def create[T](value: T, list: Seq[T]): Seq[T]

  def read[T](list: Seq[T]): Seq[T]

  def update[T](index: Int, value: T, list: Seq[T]): Seq[T]

  def deleted[T](value: T, list: Seq[T]): Seq[T]
}

/*
  Others Class has been defined separately in different scala file by the Name:
  1. ListClass
  2. SequenceClass
  These class extends this abstract type class
*/


object Main extends App {

}
