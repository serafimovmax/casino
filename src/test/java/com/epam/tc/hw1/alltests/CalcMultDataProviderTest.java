package com.epam.tc.hw1.alltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcMultDataProviderTest extends CalcBaseTest {

    @DataProvider
    public Object[][] multDataProvider() {
        return new Object[][] {
            {7, 5, 35},
            {350, 45, 15750},
            {125, 125, 15625}
        };
    }

    @Test(dataProvider = "multDataProvider", groups = "multDiv")
    public void calcMultTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
