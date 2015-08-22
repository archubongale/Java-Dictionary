import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");
            
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/word", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");
      String name = request.queryParams("newWord");
      Word newWord = new Word(name);
      model.put("word", name); 
      model.put("words", Word.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word.vtl");
      Word name = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", name);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/definition", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/word.vtl");
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String information = request.queryParams("newDefinition");
      Definition newDefinition = new Definition(information);
      word.addDefinition(newDefinition);
      model.put("definition", information); 
      model.put("definitions", Definition.all());
      model.put("word", word);
      
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    get("/definition/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/definition.vtl");
      Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
      model.put("definition", definition);
      
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}