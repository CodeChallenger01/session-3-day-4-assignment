import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SequenceClassTest extends AnyFlatSpec with Matchers {
  val sequenceOperation = new SequenceCrudOperation

  /*To testing with string type data only*/

  val mySequence: Seq[String] = Seq().empty
  "it " should "match with sequence is empty" in {
    val actualOutput = mySequence
    assert(actualOutput == List())
  }

  "it " should "not match with sequence is empty" in {
    val actualOutput = sequenceOperation.create("Manish", mySequence)
    assert(actualOutput != List())
  }

  "it " should "match with sequence has value when we insert" in {
    val actualOutput = sequenceOperation.create("Manish", mySequence)
    assert(actualOutput == List("Manish"))
  }

  "it " should "match with sequence has two value when we insert" in {
    val actualOutput = sequenceOperation.create("Manish", mySequence) ++ sequenceOperation.create("Ravi", mySequence)
    actualOutput shouldBe List("Manish", "Ravi")
  }

  "it " should "match with sequence value when we call read" in {
    val resultList = sequenceOperation.create("Manish", mySequence) ++ sequenceOperation.create("Ravi", mySequence)
    val actualOutput = sequenceOperation.read(resultList)
    actualOutput shouldBe List("Manish", "Ravi")
  }

  "it " should "not match with previous sequence when we update it" in {
    val resultList = sequenceOperation.create("Manish", mySequence) ++ sequenceOperation.create("Ravi", mySequence)
    val index = 1
    val newValue = "Mohan"
    val actualOutput = sequenceOperation.update(index, newValue, resultList)
    assert(actualOutput != List("Manish", "Ravi"))
  }

  "it " should "match with updated sequence when we update it" in {
    val resultList = sequenceOperation.create("Manish", mySequence) ++ sequenceOperation.create("Ravi", mySequence)
    val index = 1
    val newValue = "Mohan"
    val actualOutput = sequenceOperation.update(index, newValue, resultList)
    actualOutput shouldBe List("Mohan", "Ravi")
  }

  "it " should "match with updated sequence when we delete the item it" in {
    val resultList = sequenceOperation.create("Manish", mySequence) ++ sequenceOperation.create("Ravi", mySequence)
    val valueToDelete = "Ravi"
    val actualOutput = sequenceOperation.deleted(valueToDelete, resultList)
    actualOutput shouldBe List("Manish")
  }

  "it " should "match with empty sequence if element not found in sequence" in {
    val resultList = sequenceOperation.create("Manish", mySequence) ++ sequenceOperation.create("Ravi", mySequence)
    val valueToDelete = "Raju"
    val actualOutput = sequenceOperation.deleted(valueToDelete, resultList)
    assert(actualOutput == List())
  }


  /*To testing with integer type data only*/

  val intSequence: Seq[Int] = Seq().empty

  "it " should "match with integer sequence is empty" in {
    val actualOutput = mySequence
    assert(actualOutput == List())
  }

  "it " should "not match with integer sequence is empty" in {
    val actualOutput = sequenceOperation.create(10, intSequence)
    assert(actualOutput != List())
  }

  "it " should "match with integer sequence has value when we insert" in {
    val actualOutput = sequenceOperation.create(20, intSequence)
    assert(actualOutput == List(20))
  }

  "it " should "match with integer sequence has two value when we insert" in {
    val actualOutput = sequenceOperation.create(15, intSequence) ++ sequenceOperation.create(19, intSequence)
    actualOutput shouldBe List(15, 19)
  }

  "it " should "match with integer sequence value when we call read" in {
    val resultList = sequenceOperation.create(16, intSequence) ++ sequenceOperation.create(15, intSequence)
    val actualOutput = sequenceOperation.read(resultList)
    actualOutput shouldBe List(16, 15)
  }

}
