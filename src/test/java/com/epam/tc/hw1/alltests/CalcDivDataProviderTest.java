package com.epam.tc.hw1.alltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcDivDataProviderTest extends CalcBaseTest {

    @DataProvider
    public Object[][] divDataProvider() {
        return new Object[][] {
            {500, 5, 100},
            {350, 5, 70},
            {125, 125, 1}
        };
    }

    @Test(dataProvider = "divDataProvider", groups = "multDiv")
    public void calcDivTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
