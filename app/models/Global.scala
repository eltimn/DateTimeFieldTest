import play.api._
import play.api.mvc.RequestHeader
import play.api.mvc.Handler
import models.helpers.BackendMongoDatabase



object Global extends GlobalSettings {

   override def onStart(app: Application) {
		models.helpers.BackendMongoDatabase.connectToMongo()
		
		// com.mongodb.casbah.commons.conversions.scala.RegisterConversionHelpers()
		// com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers()
		
		super.onStart(app)
	}
}
