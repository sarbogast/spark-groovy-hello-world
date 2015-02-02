import static spark.Spark.*
 
class WebServer {
 
  static void main(String[] args) {
      get "/hello/:name", { request, response ->
          return "Hello " + request.params('name') + "\n"
      }
  }
}