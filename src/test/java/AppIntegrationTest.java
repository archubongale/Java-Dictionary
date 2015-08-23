import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
//import java.util.concurrent.TimeUnit;
//import static java.util.concurrent.TimeUnit.SECONDS;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void wordIsAddedTest() {
    goTo("http://localhost:4567/");
    fill("#newWord").with("Technology");
    submit(".btn");
    assertThat(pageSource()).contains("Technology");
  }

  @Test
  public void definitionIsAddedTest() {
    goTo("http://localhost:4567/");
    fill("#newWord").with("the branch of knowledge dealing with engineering or applied sciences.");
    submit(".btn");
    assertThat(pageSource()).contains("the branch of knowledge dealing with engineering or applied sciences.");
  }

}
