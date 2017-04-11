package com.dataprovider;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by November on 28.03.2017.
 */

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> getDataFromCsvFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/new4.csv")
        ));
        List<Object[]> data = new ArrayList<>();
        String line = in.readLine();
        while (line != null) {
            data.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return data.iterator();
    }
}
