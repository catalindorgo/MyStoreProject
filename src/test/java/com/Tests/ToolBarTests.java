package com.Tests;

import com.Steps.ToolBarSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/15/2017.
 */

@RunWith(SerenityRunner.class)
public class ToolBarTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;
    @Steps
    ToolBarSteps toolBarSteps;

    @Test
    public void checkBottomToolbarElementsPrsence(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        toolBarSteps.checkBottomToolbarElementsPrsence();
    }
}
