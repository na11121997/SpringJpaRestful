package com.cg.payroll.services;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exception.*;

public interface PayrollServices {
	Associate acceptAssociateDetails(Associate associate);
	int calculateNetSalary(int associateId) throws AssociateDetailNotfoundException;
	Associate getAssociateDetails(int associateId)throws AssociateDetailNotfoundException;
	List<Associate> getAllAssociatesDetails();
	boolean removeAssociateDetails(int associateId)throws AssociateDetailNotfoundException;
}
