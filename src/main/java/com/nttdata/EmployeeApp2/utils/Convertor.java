package com.nttdata.EmployeeApp2.utils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Convertor {
	
	public static <T> List<T> toList(Optional<T> opt) {
	    return opt
	            .map(Collections::singletonList)
	            .orElseGet(Collections::emptyList);
	}

}
