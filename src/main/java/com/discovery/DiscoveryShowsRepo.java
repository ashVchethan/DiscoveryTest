package com.discovery;

import com.utils.ObjectsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiscoveryShowsRepo extends ObjectsBase {

    public DiscoveryShowsRepo(WebDriver driver){super(driver);}

    @FindBy(xpath = "//h2[@class='popularShowsCarousel__header']")
    protected static WebElement popularShowsTitle;

    @FindBy(xpath = "//div[contains(@class,'popularShowsCarousel')]//i[@class='icon-arrow-right']")
    protected static WebElement rightArrowBtn;

    @FindBy(xpath = "//h4[@class='popularShowTile__name']//div[contains(text(),'Moonshiners')]")
    protected static WebElement moonshiners;

    @FindBy(xpath = "//button[@class='episodeList__showMoreButton']")
    protected static WebElement showMoreBtn;

    @FindBy(xpath = "//button[@class='episodeList__showMoreButton']")
    protected static WebElement fullEpisode;

    @FindBy(xpath = "//p[@class='episodeTitle']")
    protected static List<WebElement> episodeTitles;

    @FindBy(xpath = "//p[@class=\"minutes\"]")
    protected static List<WebElement> episodeDuration;

}
