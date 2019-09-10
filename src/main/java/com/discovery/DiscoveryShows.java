package com.discovery;

import com.utils.Base;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DiscoveryShows extends Base {
    private static DiscoveryShowsRepo dsr;
    public DiscoveryShows(){dsr = new DiscoveryShowsRepo(driver);}

    public boolean popularShows(){
    scrollToElement(dsr.popularShowsTitle);
    if(isElementVisible(dsr.popularShowsTitle)==true)
        return true;
    else
        return false;
    }

    public static int count;
    public boolean clickRightArrow(){
        while(isElementVisible(dsr.rightArrowBtn)==true){
            dsr.rightArrowBtn.click();
            count++;
        }
       // System.out.print("count value "+count);
      return true;
    }


    public boolean clickExploreTheShow(){
        moonShires();
        count= count+1;
     driver.findElement(By.xpath("(//button[contains(text(),'Explore the Show')])["+count+"]")).click();
        return true;
    }

    public boolean moonShires(){
        return isElementVisible(dsr.moonshiners);
    }


    public boolean showMore(){
       waitUntilElementIsVisible(dsr.fullEpisode);
        Actions actions = new Actions(driver);
        actions.moveToElement(dsr.showMoreBtn).click().perform();
        System.out.println("clicked  show More button once");
        actions.moveToElement(dsr.showMoreBtn).click().perform();
        System.out.println("clicked  show More button twice");
    return true;
        }

        static LinkedHashMap<String, String> EpisodeMap = new LinkedHashMap<String, String>();
    public boolean showDetails(){

        System.out.println("episode title size "+dsr.episodeTitles.size());
        System.out.println("episode duration size "+dsr.episodeDuration.size());
        for(int i=0;i<dsr.episodeTitles.size();i++){
            scrollToElement(dsr.episodeTitles.get(i));
            String title =dsr.episodeTitles.get(i).getText();
            String duration =dsr.episodeDuration.get(i).getText();
            EpisodeMap.put(title, duration);
//            System.out.println("episode title "+title);
////            System.out.println("episode duration "+duration);


        }
        for(Map.Entry map : EpisodeMap.entrySet()) {
            System.out.println(map.getKey()+ "  "+ map.getValue());
        }

            return true;
    }



    public boolean writeExcel() throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("EpisodeDetail");
        Row row1 = sheet.createRow(0);
        Cell cell = row1.createCell(0);
        cell.setCellType(cell.CELL_TYPE_STRING);
        cell.setCellValue("Episode Title");

        Cell cell2 = row1.createCell(1);
        cell.setCellType(cell2.CELL_TYPE_STRING);
        cell2.setCellValue("Episode Duration");

        int rowCount = 0;
        Iterator episodeItr = EpisodeMap.keySet().iterator();

        while (episodeItr.hasNext()) {
            Row row = sheet.createRow(++rowCount);
            writeBook((String) episodeItr.next(), row);
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("./src/main/resources/EpisodeDetails.xlsx");
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    //to write in excel sheet
    private void writeBook(String key, Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue(key);

        cell = row.createCell(1);
        cell.setCellValue(EpisodeMap.get(key));
    }


}
