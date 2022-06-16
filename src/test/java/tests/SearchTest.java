package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @Test
    void gitTest(){
        Selenide.open("https://github.com/");

        $("[data-test-selector ='nav-search-input']").click();
        $("[data-test-selector ='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("ul.m-0.list-style-none li.wiki-more-pages-link").$("button").click();
        $$("ul.m-0.list-style-none").shouldHave(CollectionCondition.texts("SoftAssertions"));
        $$("ul.m-0.list-style-none li.wiki-more-pages").findBy(text("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").shouldHave(text("JUnit5 extend test class"));
    }
}
