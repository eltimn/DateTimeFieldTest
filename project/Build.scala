import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "DateTimeFieldTest"
    val appVersion      = "1.0-SNAPSHOT"

	val rogue = "com.foursquare" %% "rogue" % "1.1.8" intransitive()
	val liftMongoRecord = "net.liftweb" %% "lift-mongodb-record" % "2.4"


    val appDependencies = Seq(
		rogue,
		liftMongoRecord
    )

    val main = PlayProject(appName, appVersion, appDependencies).settings()

}
