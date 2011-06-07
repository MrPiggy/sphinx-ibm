package ssms.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ShipmentValidation implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

			String shipment = (String) value;
	        if(shipment.isEmpty()){
	        	throw new ValidatorException(
						new FacesMessage("Shipment ID is required."),null);
	        }
	        else if(shipment.length() < 3 || shipment.length() > 10)
	        {
	        	throw new ValidatorException(
						new FacesMessage("Shipment ID is invalid (maximum length is 3)."),null);
	        }
	}
}
