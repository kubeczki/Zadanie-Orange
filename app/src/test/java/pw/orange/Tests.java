package pw.orange;

import io.appium.java_client.MobileElement;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests extends TestBase{

    /*  All tests are run in order, if a test fails, every subsequent test also fails   */

    // First test - test if Warsaw has been chosen
    @Test
    public void testA(){
        // Wait for the starting page to load fully
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Find and click the browse cities button
        MobileElement browseCitiesButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout"));
        browseCitiesButton.click();

        // Search for Warszawa
        MobileElement citiesSearchBar = driver.findElement(By.id("com.citynav.jakdojade.pl.android:id/et_search_city"));
        citiesSearchBar.sendKeys("Warszawa");

        // Find the result, test and click
        MobileElement citiesSearchResult = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        String chosenCity = citiesSearchResult.getText();
        System.out.println("\nChosen city is: " + chosenCity);
        assertEquals("check that the chosen city is Warsaw", "Warszawa", chosenCity);
        citiesSearchResult.click();
    }

    // Second test - test if line 501 has been chosen
    @Test
    public void testB(){
        // Find and click the continue button
        MobileElement continueButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout"));
        continueButton.click();

        // Wait for the terms page to load fully
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Find and click the terms button
        MobileElement acceptTermsButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.Button[2]"));
        acceptTermsButton.click();
        // Find and click the "Later" button
        MobileElement ignoreNavRequestButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout"));
        ignoreNavRequestButton.click();

        // Find and click the timetables button
        MobileElement timetablesButton = driver.findElement(By.id("com.citynav.jakdojade.pl.android:id/timetables"));
        timetablesButton.click();

        // Search for line 501
        MobileElement linesSearchBar = driver.findElement(By.id("com.citynav.jakdojade.pl.android:id/act_wl_search_input"));
        linesSearchBar.sendKeys("501");
        linesSearchBar.click();
        // Find the result, test and click
        MobileElement busResultButton = driver.findElement(By.id("com.citynav.jakdojade.pl.android:id/act_lsearch_line_name"));
        String chosenLine = busResultButton.getText();
        System.out.println("\nChosen line is: " + chosenLine);
        assertEquals("check that the chosen line is 501", "501", chosenLine);
        busResultButton.click();
    }

    // Final test - test if Stegny is the first stop
    @Test
    public void testC(){
        // Find the first stop and test
        MobileElement firstStopText = driver.findElement(By.id("com.citynav.jakdojade.pl.android:id/act_l_stops_from_txt"));
        String chosenStop = firstStopText.getText();
        System.out.println("\nChosen stop is: " + chosenStop);
        assertEquals("check that the first stop is STEGNY", "STEGNY", chosenStop);
    }
}
