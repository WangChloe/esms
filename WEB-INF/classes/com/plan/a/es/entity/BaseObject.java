package com.plan.a.es.entity;

import java.io.Serializable;

public abstract class BaseObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();
	
}
