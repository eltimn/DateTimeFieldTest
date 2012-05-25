package controllers

import scala.annotation.implicitNotFound
import models._
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.data._
import play.api.data.Forms._
import org.bson.types.ObjectId
import scala.collection.mutable.{ Map => MMap }
import org.joda.time.DateTime
import play.api.Play.current
import org.joda.time.Duration
import org.joda.time.format.DateTimeFormat

import models.Foo



object FooController extends Controller {

	def createFoo = Action { implicit request =>
		Ok(Foo.createSomeFoo)
	}
	
	def listFoo = Action { implicit request =>
		Ok(Foo.listAllFoo)
	}
}
