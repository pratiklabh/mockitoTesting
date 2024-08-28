package com.sts.mockitotesting.testClasses;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class TestDataProvider {
   @DataProvider
   public static Object[][] sum() {
      
       return new Object[][] {
          {-3,3,0},
          {5,0,5},
          {5,6,11}
      };
       
  }
}
