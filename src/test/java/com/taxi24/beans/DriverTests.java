package com.taxi24.beans;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import com.taxi24.models.Driver;

public class DriverTests {
	@Test
    public void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(Driver.class, hasValidGettersAndSetters());
    }
}
