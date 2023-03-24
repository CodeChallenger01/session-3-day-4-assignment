import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ListClassTest extends AnyFlatSpec with Matchers {
  val listOperation = new ListCrudOperation

  /*To testing with string type data only*/

  val list: List[String] = List().empty

  "it " should "match with list is empty" in {
    val actualOutput = list
    assert(actualOutput == List())
  }

  "it " should "not match with list is empty" in {
    val actualOutput = listOperation.create("Manish", list)
    assert(actualOutput != List())
  }

  "it " should "match with list has value when we insert" in {
    val actualOutput = listOperation.create("Manish", list)
    assert(actualOutput == List("Manish"))
  }

  "it " should "match with list has two value when we insert" in {
    val actualOutput = listOperation.create("Manish", list) ++ listOperation.create("Ravi", list)
    actualOutput shouldBe List("Manish", "Ravi")
  }

  "it " should "match with list value when we call read" in {
    val resultList = listOperation.create("Manish", list) ++ listOperation.create("Ravi", list)
    val actualOutput = listOperation.read(resultList)
    actualOutput shouldBe List("Manish", "Ravi")
  }

  "it " should "not match with previous list when we update it" in {
    val resultList = listOperation.create("Manish", list) ++ listOperation.create("Ravi", list)
    val index = 1
    val newValue = "Mohan"
    val actualOutput = listOperation.update(index, newValue, resultList)
    assert(actualOutput != List("Manish", "Ravi"))
  }

  "it " should "match with updated list when we update it" in {
    val resultList = listOperation.create("Manish", list) ++ listOperation.create("Ravi", list)
    val index = 1
    val newValue = "Mohan"
    val actualOutput = listOperation.update(index, newValue, resultList)
    actualOutput shouldBe List("Mohan", "Ravi")
  }

  "it " should "match with updated list when we delete the item it" in {
    val resultList = listOperation.create("Manish", list) ++ listOperation.create("Ravi", list)
    val valueToDelete = "Ravi"
    val actualOutput = listOperation.deleted(valueToDelete, resultList)
    actualOutput shouldBe List("Manish")
  }

  "it " should "match with empty list if element not found in list" in {
    val resultList = listOperation.create("Manish", list) ++ listOperation.create("Ravi", list)
    val valueToDelete = "Raju"
    val actualOutput = listOperation.deleted(valueToDelete, resultList)
    assert(actualOutput == List())
  }


  /*To testing with integer type data only*/

  val intList: List[Int] = List().empty

  "it " should "match with integer list is empty" in {
    val actualOutput = list
    assert(actualOutput == List())
  }

  "it " should "not match with integer list is empty" in {
    val actualOutput = listOperation.create(10, list)
    assert(actualOutput != List())
  }

  "it " should "match with integer list has value when we insert" in {
    val actualOutput = listOperation.create(20, list)
    assert(actualOutput == List(20))
  }

  "it " should "match with integer list has two value when we insert" in {
    val actualOutput = listOperation.create(30, list) ++ listOperation.create(20, list)
    actualOutput shouldBe List(30, 20)
  }

  "it " should "match with integer list value when we call read" in {
    val resultList = listOperation.create(10, list) ++ listOperation.create(30, list)
    val actualOutput = listOperation.read(resultList)
    actualOutput shouldBe List(10, 30)
  }

}
