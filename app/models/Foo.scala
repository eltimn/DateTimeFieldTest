package models

import models.helpers.BackendMongoDatabase
import play.api.Play.current
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.MongoId
import net.liftweb.mongodb._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field.{ DateTimeField, StringField, IntField, EnumNameField, EnumField }
import net.liftweb.record._
import net.liftweb.mongodb.record.field.MongoMapField
import com.foursquare.rogue.HasMongoForeignObjectId
import com.foursquare.rogue.Rogue._
import com.foursquare.rogue.Rogue.Iter._
import org.bson.types.ObjectId
import org.joda.time.{ DateTime, DateTimeZone }
import com.mongodb.WriteConcern



class Foo extends MongoRecord[Foo] with MongoId[Foo] {
	def meta = Foo
	
	object dateA extends DateTimeField(this)
	object dateB extends DateField(this)
	
	def printFoo: Unit = {
		println("   id: " + this._id.value)
		println("dateA: " + this.dateA.value)
		println("dateB: " + this.dateB.value)
	}
}


object Foo extends Foo with MongoMetaRecord[Foo] {
	override def collectionName = "foo"
	override def mongoIdentifier = BackendMongoDatabase
	
	def createSomeFoo(): String = {
		val date = new DateTime(2012, 4, 1, 12, 0)
		val foo = Foo.createRecord.dateA(date.toGregorianCalendar).dateB(date.toDate).save
		foo.toString
	}
	
	def listAllFoo(): String = {
		Foo.fetch().map{_.toString}.foldLeft("")((m: String, n: String) => m ++ "\n" ++ n)
	}
}
