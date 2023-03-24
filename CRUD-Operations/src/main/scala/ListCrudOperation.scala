/*
In the parameter list of methods  I had taken sequence type list and inside that method
I changed it in list and Performed the operation on LIST.
*/
/*
   Here I am extending the abstract class CrudOperation
   To perform the
   1. Create
   2. Read
   3. Update
   4. Delete
   Operation on LIST
 */
class ListCrudOperation extends CrudOperations {
  /*
   This method is for creating list and we define all method as Polymorphic Method
   It can take any type of Data such as Int, String, Long
   */
  override def create[T](value: T, myList: Seq[T]): List[T] = {
    val newList: List[T] = myList.toList
    if (newList.isEmpty) {
      newList :+ value
    }
    else {
      newList :+ value
    }
  }

  //This method is used to read the value from the list
  override def read[T](myList: Seq[T]): List[T] = {
    val newList: List[T] = myList.toList
    try {
      if (newList.isEmpty) {
        throw new NullPointerException("List is Empty can't able to read")
      }
      else {
        newList.map(element => element)
      }
    }
    catch {
      case ex: NullPointerException => Nil
    }
  }

  //This method is used to update the value of the existing list with new value
  override def update[T](index: Int, newValue: T, myList: Seq[T]): List[T] = {
    val newList: List[T] = myList.toList
    try {
      if (newList.isEmpty) {
        throw new NullPointerException("List is Empty ")
      }
      else if (index > newList.size || index < 0) {
        throw new IndexOutOfBoundsException("You have entered Wrong position")
      }
      else {
        val newUpdatedList = newList.updated(index - 1, newValue)
        newUpdatedList
      }
    }
    catch {
      case ex: NullPointerException => Nil
      case ex: IndexOutOfBoundsException => Nil
    }
  }

  //This method is used to delete the value from the existing list
  override def deleted[T](value: T, myList: Seq[T]): List[T] = {
    val newList: List[T] = myList.toList
    try {
      if (newList.isEmpty) {
        throw new NullPointerException("List is Empty")
      }
      else if (newList.contains(value)) {
        val updatedList = newList.filter(element => element != value)
        updatedList
      }
      else {
        throw new RuntimeException("Value not Found")
      }
    }
    catch {
      case ex: NullPointerException => Nil
      case ex: RuntimeException => Nil
    }
  }
}