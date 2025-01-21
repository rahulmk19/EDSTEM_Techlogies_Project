package com.edstem.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyErrorHandler {

	private String msg;
	private String desc;
	private LocalDateTime timeStamp;

}
