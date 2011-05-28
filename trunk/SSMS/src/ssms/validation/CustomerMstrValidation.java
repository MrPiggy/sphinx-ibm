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
		CustomerMstr customer = (CustomerMstr) value;
        if(customer == null){
        	FacesMessage facesMessage = new FacesMessage("Invalid Input", "message");
            FacesContext.getCurrentInstance().addMessage("message", facesMessage);
        }
	}
}
