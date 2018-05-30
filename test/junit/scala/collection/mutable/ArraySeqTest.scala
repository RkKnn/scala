package scala.collection.mutable

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import scala.reflect.ClassTag

@RunWith(classOf[JUnit4])
class ArraySeqTest {
  @Test
  def t10851(): Unit = {
    val s1 = ArraySeq.untagged(1,2,3)
    assertTrue(s1.array.getClass == classOf[Array[AnyRef]])
    val s2 = ArraySeq.make(Array(1))
    assertTrue(s2.array.getClass == classOf[Array[Int]])
    val s3 = ArraySeq.make(Array(1): Array[Any]).asInstanceOf[ArraySeq[Int]]
    assertTrue(s3.array.getClass == classOf[Array[AnyRef]])
  }
}

/*
scala> import scala.collection.mutable.WrappedArray
import scala.collection.mutable.WrappedArray

scala> val a = WrappedArray.make(Array(1))
a: scala.collection.mutable.WrappedArray[Int] = WrappedArray(1)

scala> a.array.getClass
res0: Class[_ <: Array[Int]] = class [I

scala> val a = WrappedArray.make(Array(1): Array[Any]).asInstanceOf[WrappedArray[Int]]
a: scala.collection.mutable.WrappedArray[Int] = WrappedArray(1)

scala> a.array.getClass
res1: Class[_ <: Array[Int]] = class [Ljava.lang.Object;
 */