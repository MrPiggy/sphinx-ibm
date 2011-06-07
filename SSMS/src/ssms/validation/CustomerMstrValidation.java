package ssms.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import ssms.entities.CustomerMstr;

public class CustomerMstrValidation implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

			String customer = (String) value;
	        if(customer.isEmpty()){
	        	throw new ValidatorException(
						new FacesMessage("Customer ID is required."),null);
	        }
	        else if(customer.length() > 3)
	        {
	        	throw new ValidatorException(
						new FacesMessage("Customer ID is invalid (maximum length is 3)."),null);
	        }
	}
}
