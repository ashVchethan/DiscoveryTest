package com.discoverytest;

import com.utils.Pages;
import com.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DiscoveryTest extends TestBase {



    @Test(priority = 1)
    public void navigateToPopularShows(){
        Assert.assertTrue(Pages.discoveryShows().popularShows(),"Failed to reach popular shows carousal");
    }
    @Test(priority = 2)
    public void clickRightArrowTest(){
        Assert.assertTrue(Pages.discoveryShows().clickRightArrow(),"Failed to navigate Right Arrow");
    }

    @Test(priority = 3)
    public void clickExploretheShowTest(){
        Assert.assertTrue(Pages.discoveryShows().clickExploreTheShow(),"Failed to Click EXPLORE THE SHOWS button");
    }

    @Test(priority = 4)
    public void clickShowMore(){
        Assert.assertTrue(Pages.discoveryShows().showMore(),"Failed to Click SHOW MORE button");
    }

    @Test(priority = 5)
    public void getTitleAndDuration(){
        Assert.assertTrue(Pages.discoveryShows().showDetails(),"Failed to get title and duration details");
    }

    @Test(priority = 6)
    public void excel()  {
        Assert.assertTrue(Pages.discoveryShows().writeExcel(),"Failed print in excel sheet 'EpisodeDetails.xlsx'");
    }
}
