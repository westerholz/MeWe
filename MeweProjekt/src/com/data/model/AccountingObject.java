/**
 * 
 */
package com.data.model;

/**
 * An accounting object is used to classify postings. It can be considered being somoehow an equivalent to a GL account
 * in financial accounting.
 * @author D049283
 *
 */
public interface AccountingObject {

	public String getName();
	public void setName(String sName);

}