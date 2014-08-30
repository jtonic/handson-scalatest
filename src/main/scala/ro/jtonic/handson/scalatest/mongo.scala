import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.{MongoClient, MongoCollection}

import scala.collection.mutable

/**
 * Created by jtonic on 30.08.2014.
 */
object MongoApp {
  def main(args: Array[String]) {

    val mongoClient = MongoClient("localhost", 27017)
    val db = mongoClient("test")

    val names: mutable.Set[String] = db.collectionNames()

    names.foreach {it =>
      println(f"collection name: $it")
    }

    val testColl = db("test")
    val all: MongoCollection#CursorType = testColl.find()
//    testColl.insert[Person](new Person("Antonel", "Pazargic"))
    testColl.insert(MongoDBObject("firstName" -> "Roxana", "lastName" -> "Pazargic"))
//    testColl.insert[Person](Person("Mitu", "Pazargic"), WriteConcern)
    all.foreach {
      it: DBObject => println(f"First name: ${it.get("firstName")}, last name: ${it.get("lastName")}")
    }

    val antoneis: MongoCollection#CursorType = testColl.find(MongoDBObject("firstName" -> "Antonel"))
//    antoneis.foreach(println(_))
    val persons = for(it <- antoneis) yield {
      it
    }
    println(f"persons no: ${persons.next()}")
    println(f"persons no: ${persons.next()}")

    val intGen = for(i <- Iterator.range(1, 10)) yield {
      println(f"producing i: $i")
      i
    }
    val one: Int = intGen.next()
    val two: Int = intGen.next()
    println(f"one: $one")
    println(f"two: $two")

  }

  case class Person(firstName: String, lastName: String)
}

