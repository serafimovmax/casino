package com.epam.tc.hw1.alltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcSubDataProviderTest extends CalcBaseTest {
    @DataProvider
    public Object[][] subDataProvider() {
        return new Object[][] {
            {7, 5, 2},
            {350.8, 45.4, 305.40000000000003},
            {2250, 1250, 1000}
        };
    }

    @Test(dataProvider = "subDataProvider", groups = "sumSub")
    public void calcSubTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
