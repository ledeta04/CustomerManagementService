package com.craft.CustomerManagementService.Utility;


import java.io.Serializable;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomKeyGenerator implements IdentifierGenerator {

//	 /**
//	 * 
//	 */
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "CUST";
	private static final AtomicInteger counter = new AtomicInteger(123455);

	    @Override
	    public Serializable generate(SharedSessionContractImplementor session, Object object) {
	    	
	    	int value =  counter.incrementAndGet();
			String formattedValue = String.format("%06d", value);
	    	
	        return PREFIX + formattedValue;
	    }
}