package com.example.exception;

import javax.persistence.EntityNotFoundException;

public class Productnotfoundexception extends EntityNotFoundException {
public Productnotfoundexception() {
	super();
}
public Productnotfoundexception(String msg) {
	super(msg);
}
}