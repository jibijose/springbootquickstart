package com.example.springboot.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.springboot.util.Calculator;
import com.example.springboot.util.MathUtil;

import org.powermock.api.mockito.PowerMockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MathUtil.class)
public class CalculatorTest {

	private Calculator calc;

	@Before
	public void setUp() {
		calc = new Calculator();

		PowerMockito.mockStatic(MathUtil.class);
		PowerMockito.when(MathUtil.addInteger(1, 1)).thenReturn(0);
		PowerMockito.when(MathUtil.addInteger(2, 2)).thenReturn(1);
	}

	@Test
	public void shouldCalculateInAStrangeWay() {
		assertEquals(0, calc.add(1, 1));
		assertEquals(1, calc.add(2, 2));
	}

}
