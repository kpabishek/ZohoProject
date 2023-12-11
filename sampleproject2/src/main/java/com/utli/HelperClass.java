package com.utli;

import org.openqa.selenium.WebDriver;


  
public class HelperClass {
      
    private static HelperClass helperClass;
      
    private static WebDriver driver;
    public final static int TIMEOUT = 10;
      
     private HelperClass() {
                   
         }    
              
    public static void openPage(String url) {
        driver.get(url);
    }
  
      
    public static WebDriver getDriver() {
        return driver;              
    }
      
    public static void setUpDriver() {
          
        if (helperClass==null) {
              
            helperClass = new HelperClass();
        }
    }
      
     public static void tearDown() {
           
    
    	 if(driver!=null) {
             driver.close();
             driver.quit();
         }
           
         helperClass = null;
     } 
      
}