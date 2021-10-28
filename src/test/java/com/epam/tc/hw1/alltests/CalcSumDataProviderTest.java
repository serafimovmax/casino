package com.epam.tc.hw1.alltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcSumDataProviderTest extends CalcBaseTest {

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][] {
            {7, 5, 12},
            {350, 45, 395},
            {1250, 1250, 2500}
        };
    }

    @Test(dataProvider = "sumDataProvider", groups = "sumSub")
    public void calcSumTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
