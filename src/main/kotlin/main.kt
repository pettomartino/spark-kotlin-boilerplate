import spark.kotlin.*

fun getAssignedPort(): Int = ProcessBuilder()
  .environment()
  .getOrDefault("PORT", "4567")
  .toInt()

fun main(args: Array<String>) {
    val http: Http = ignite()

    http.port(getAssignedPort())

    http.get("/hello") {
        "Hello Spark Kotlin!"
    }

    http.get("/testing") {
      "this is amazing"
    }
}