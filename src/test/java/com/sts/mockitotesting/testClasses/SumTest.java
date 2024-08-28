package com.sts.mockitotesting.testClasses;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

@RunWith(DataProviderRunner.class)
public class SumTest {

   @InjectMocks
   private Sum object= new Sum();
   
   @Test
   @UseDataProvider(value = "sum",location=TestDataProvider.class)
   public void sum(int num1,int num2, int expected) {
      int result=object.getSum(num1,num2);
      assertEquals(expected,result);
 }
}