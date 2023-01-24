package data.provider;

import org.testng.annotations.DataProvider;

public class SearchingTestData {

    @DataProvider(name = "remoteDataProvider")
    public Object[][] queriesTestData() {
        Object[][] testDataArray = {
                {"little"},
                {"about"},
                {"red"}};
        return testDataArray;
    }
}
