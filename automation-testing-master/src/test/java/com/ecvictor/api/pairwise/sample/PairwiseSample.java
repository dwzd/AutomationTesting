package com.ecvictor.api.pairwise.sample;


import com.ecvictor.api.pairwise.IInventory;
import com.ecvictor.api.pairwise.PairwiseInventoryFactory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by caoc on 3/25/2017.
 */
public class PairwiseSample {
    @Test
    public void buildTestSets() {
        String NAV_SCENARIO =
                "Browser: Chrome, Firefox, InternetExplorer, Safari"
                        + "\nPage: Home, Category, Search, New Products"
                        + "\nProduct: Phone, Movie, Computer, Blender, Microwave, Book, Sweater"
                        + "\nClick: Link, Image, Description"
                ;

        //First, generate the list of vectors we *want*
        IInventory inventory = PairwiseInventoryFactory.generateParameterInventory(NAV_SCENARIO);
        List<Map<String, String>> rawDataSet = inventory.getTestDataSet().getTestSets();

        //Now, go through the vectors in the database to figure out what we already *have*
        // If we don't have it already, create it
        int index = 0;
        for (Map<String, String> rawTestCase: rawDataSet) {
            System.out.println(String.format("Test Case %03d: [%s] [%s] [%s] [%s]", index++, rawTestCase.get("Browser"), rawTestCase.get("Page"), rawTestCase.get("Product"), rawTestCase.get("Click")));
        }
    }
}
