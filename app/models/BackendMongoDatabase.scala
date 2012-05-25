package models.helpers

import play.api.Play.current
import play.Logger
import java.net.URI
import net.liftweb.mongodb._
import com.mongodb.{Mongo, MongoURI}



object BackendMongoDatabase extends MongoIdentifier {
	override def jndiName = "ua"

	private var mongo: Option[Mongo] = None

	def connectToMongo() = {
		val envName = "MONGODB_URI"
		val uriString = scala.util.Properties.envOrElse(envName, "mongodb://localhost:27017/")
		println("Connecting to MongoDB at " + uriString + " -- set environment variable " + envName + " to change.")
		val uri = new MongoURI(uriString)
		mongo = Some(new Mongo(uri))
		MongoDB.defineDb(BackendMongoDatabase, mongo.get, "datetimetest")
	}

	def disconnectFromMongo = {
		mongo.foreach(_.close)
		MongoDB.close
		mongo = None
	}
}
