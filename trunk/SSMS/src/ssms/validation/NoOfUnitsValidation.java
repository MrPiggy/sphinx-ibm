package ssms.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class NoOfUnitsValidation implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

			Integer NOUnits = (Integer) value;
	        if(NOUnits <= 0){
	        	throw new ValidatorException(
						new FacesMessage("No. of units must be greater than ZERO."),null);
	        }
	}
}
