package com.mercadolibre.exam.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface IRound {

	default Double round(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
