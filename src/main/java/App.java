import static spark.Spark.*;
//import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/index.vtl");
      model.put("words", Word.all());
      model.put("word", Word.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/word-success.vtl");
      String name = request.queryParams("newWord");
      Word newWord = new Word(name);
      model.put("word", name);
      model.put("words", Word.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word.vtl");
      Word name = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", name);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/definition-success.vtl");
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
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/definition.vtl");
      Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
      model.put("definition", definition);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
