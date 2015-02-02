import spark.ModelAndView

import static spark.Spark.*
import spark.template.freemarker.FreeMarkerEngine
 
class WebServer {
 
  static void main(String[] args) {
      staticFileLocation '/public'
      def systemPort = System.getenv("PORT")
      if(systemPort) {
          port Integer.valueOf(systemPort)
      }

      get "/", {req, res ->
          res.redirect "/hello/world"
      }

      get "/hello/:name", { request, response ->
          return new ModelAndView([greeted: request.params('name')], "hello.ftl")
      }, new FreeMarkerEngine()
  }
}