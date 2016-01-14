package com.example.springboot.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MathUtilTest {

	@Test
	public void addTest() {
		Assert.assertEquals(50, MathUtil.addInteger(20, 30));
	}
}
