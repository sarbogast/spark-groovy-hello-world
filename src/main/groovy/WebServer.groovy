import static spark.Spark.*
 
class WebServer {
 
  static void main(String[] args) {
      port Integer.valueOf(System.getenv("PORT")) ?: 4567

      get "/hello/:name", { request, response ->
          return "Hello " + request.params('name') + "\n"
      }
  }
}