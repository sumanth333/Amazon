package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderSearchBooks {

    @DataProvider(name = "Books")
    public Object[][] getData()
    {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[3][1];

        // 1st row
        data[0][0] ="Selenium With JAVA";


        // 2nd row
        data[1][0] ="The intelligent investor";

        // 3rd row
        data[2][0] ="The three musketeers";


        return data;
    }

}
