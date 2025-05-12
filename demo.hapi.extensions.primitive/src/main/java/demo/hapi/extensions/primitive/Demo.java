package demo.hapi.extensions.primitive;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.context.FhirContext;
import lombok.extern.slf4j.XSlf4j;

@XSlf4j
public class Demo {

	public static void main(String[] args) {
		final var context = FhirContext.forR4();
		renderAndLog(context, "Address with dynamic extension", buildAddressUsingDynamicExtensions());
		renderAndLog(context, "Address with extended StringType", buildAddressUsingExtendedStringType());
	}

	private static Address buildAddressUsingDynamicExtensions() {
		final var address = new Address();
		final var lineElement = address.addLineElement();
		lineElement.setValue("Slippery Ice Road 12b");
		lineElement
			.addExtension("http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetName",
					new StringType("Slippery Ice Road"));
		lineElement
			.addExtension("http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-houseNumber", new StringType("12b"));
		address.setCity("Very Cold Town");
		address.setPostalCode("12345");
		address.setCountry("ATA");
		return address;
	}

	private static Address buildAddressUsingExtendedStringType() {
		final var address = new AddressWithExtendedPrimitive();
		final var line = new AddressWithExtendedPrimitive.ExtendedLine();
		line.setValue("Slippery Ice Road 12b");
		line.setStreetName("Slippery Ice Road");
		line.setHouseNumber("12b");
		address.getLine().add(line);
		address.setCity("Very Cold Town");
		address.setPostalCode("12345");
		address.setCountry("ATA");
		return address;
	}

	private static void renderAndLog(final FhirContext context, final String description, final Address address) {
		final var loc = new Location().setName(description).setAddress(address);
		final var renderedJSON = context.newJsonParser().setPrettyPrint(true).encodeResourceToString(loc);
		log.info("{} rendered as JSON:\n{}", description, renderedJSON);
	}

}
