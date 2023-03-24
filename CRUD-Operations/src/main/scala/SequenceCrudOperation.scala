/*
   Here I am extending the abstract class CrudOperation
   To perform the
   1. Create
   2. Read
   3. Update
   4. Delete
   Operation on SEQUENCE
 */
class SequenceCrudOperation extends CrudOperations {
  /*
     This method is for creating sequence and we define all method as Polymorphic Method
     It can take any type of Data such as Int, String, Long
     */
  override def create[T](value: T, mySequence: Seq[T]): Seq[T] = {
    if (mySequence.isEmpty) {
      mySequence :+ value
    }
    else {
      mySequence :+ value
    }
  }

  //This method is used to read the value from the sequence
  override def read[T](mySequence: Seq[T]): Seq[T] = {
    try {
      if (mySequence.isEmpty) {
        throw new NullPointerException("Sequence is Empty can't able to read it")
      }
      else {
        mySequence.map(element => element)
      }
    }
    catch {
      case ex: NullPointerException => Nil
    }
  }

  //This method is used to update the value of the existing sequence with new value
  override def update[T](index: Int, newValue: T, mySequence: Seq[T]): Seq[T] = {
    try {
      if (mySequence.isEmpty) {
        throw new NullPointerException("Sequence is Empty")
      }
      else if (index > mySequence.size || index < 0) {
        throw new IndexOutOfBoundsException("You have entered Wrong position")
      }
      else {
        val newSequence = mySequence.updated(index - 1, newValue)
        newSequence
      }
    }
    catch {
      case ex: NullPointerException => Nil
      case ex: IndexOutOfBoundsException => Nil
    }
  }

  //This method is used to delete the value from the existing list
  override def deleted[T](value: T, mySequence: Seq[T]): Seq[T] = {
    try {
      if (mySequence.isEmpty) {
        throw new RuntimeException("List is Empty")
      }
      else if (mySequence.contains(value)) {
        val newSequence = mySequence.filter(element => element != value)
        newSequence
      }
      else {
        throw new RuntimeException("Value Not Found")
      }
    }
    catch {
      case ex: NullPointerException => Nil
      case ex: RuntimeException => Nil
    }
  }
}