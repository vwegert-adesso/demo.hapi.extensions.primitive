package demo.hapi.extensions.primitive;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Configuration;
import org.hl7.fhir.r4.model.Property;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.util.ElementUtil;

@DatatypeDef(name = "AddressWithExtendedPrimitive")
public class AddressWithExtendedPrimitive extends Address {

	@Block
	public static class ExtendedLine extends StringType {
		@Child(name = "streetName")
		@Extension(url = "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetName")
		@Description(value = "Street Name", shortDefinition = "Street Name")
		private StringType streetName;

		@Child(name = "houseNumber")
		@Extension(url = "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-houseNumber")
		@Description(value = "House Number", shortDefinition = "House Number")
		private StringType houseNumber;

		public String getStreetName() {
			return this.streetName == null || this.streetName.isEmpty() ? null : this.streetName.getValue();
		}

		public StringType getStreetNameElement() throws FHIRException {
			if (this.streetName == null) {
				if (Configuration.errorOnAutoCreate()) {
					throw new FHIRException("Unable to auto-create element Address.line.extension:StreetName");
				} else if (Configuration.doAutoCreate()) {
					this.streetName = new StringType();
				}
			}
			return this.streetName;
		}

		public boolean hasStreetName() {
			return this.streetName != null && !this.streetName.isEmpty();
		}

		public boolean hasStreetNameElement() {
			return this.streetName != null && !this.streetName.isEmpty();
		}

		public ExtendedLine setStreetNameElement(StringType value) {
			this.streetName = value;
			return this;
		}

		public ExtendedLine setStreetName(String value) {
			if (this.streetName == null) {
				this.streetName = new StringType();
			}
			this.streetName.setValue(value);
			return this;
		}

		public String getHouseNumber() {
			return this.houseNumber == null || this.houseNumber.isEmpty() ? null : this.houseNumber.getValue();
		}

		public StringType getHouseNumberElement() throws FHIRException {
			if (this.houseNumber == null) {
				if (Configuration.errorOnAutoCreate()) {
					throw new FHIRException("Unable to auto-create element Address.line.extension:HouseNumber");
				} else if (Configuration.doAutoCreate()) {
					this.houseNumber = new StringType();
				}
			}
			return this.houseNumber;
		}

		public boolean hasHouseNumber() {
			return this.houseNumber != null && !this.houseNumber.isEmpty();
		}

		public boolean hasHouseNumberElement() {
			return this.houseNumber != null && !this.houseNumber.isEmpty();
		}

		public ExtendedLine setHouseNumberElement(StringType value) {
			this.houseNumber = value;
			return this;
		}

		public ExtendedLine setHouseNumber(String value) {
			if (this.houseNumber == null) {
				this.houseNumber = new StringType();
			}
			this.houseNumber.setValue(value);
			return this;
		}

		/**
		 * @see Base#addChild(String)
		 */
		@Override
		public Base addChild(String name) throws FHIRException {
			if (name.equals("StreetName")) {
				throw new FHIRException("Cannot call addChild on singleton property Address.line.extension:StreetName");
			}
			if (name.equals("HouseNumber")) {
				throw new FHIRException(
						"Cannot call addChild on singleton property Address.line.extension:HouseNumber");
			}
			return super.addChild(name);
		}

		/**
		 * @see StringType#copy()
		 */
		@Override
		public ExtendedLine copy() {
			final var dst = new ExtendedLine();
			copyValues(dst);
			return dst;
		}

		/**
		 * @see StringType#copyValues(StringType)
		 */
		public void copyValues(ExtendedLine dst) {
			super.copyValues(dst);
			dst.streetName = this.streetName == null ? null : this.streetName.copy();
			dst.houseNumber = this.houseNumber == null ? null : this.houseNumber.copy();
		}

		@Override
		public boolean equalsDeep(Base other) {
			if (!super.equalsDeep(other)) {
				return false;
			}
			if (!(other instanceof final ExtendedLine castOther)) {
				return false;
			}
			if (!compareDeep(this.streetName, castOther.streetName, true)) {
				return false;
			}
			if (!compareDeep(this.houseNumber, castOther.houseNumber, true)) {
				return false;
			}
			return true;
		}

		@Override
		public boolean equalsShallow(Base other) {
			if (!super.equalsShallow(other)) {
				return false;
			}
			if (!(other instanceof final ExtendedLine castOther)) {
				return false;
			}
			if (!compareValues(this.streetName, castOther.streetName, true)) {
				return false;
			}
			if (!compareValues(this.houseNumber, castOther.houseNumber, true)) {
				return false;
			}
			return true;
		}

		@Override
		public boolean isEmpty() {
			return super.isEmpty() && ElementUtil.isEmpty(this.streetName, this.houseNumber);
		}

		@Override
		public Property getNamedProperty(int hash, String name, boolean checkValid) {
			switch (hash) {
				case 919494990:
					// StreetName
					return new Property("StreetName", "string", "StreetName", 0, 1, this.streetName);
				case -1540661655:
					// HouseNumber
					return new Property("HouseNumber", "string", "HouseNumber", 0, 1, this.houseNumber);
				default:
					return super.getNamedProperty(hash, name, checkValid);
			}
		}

		@Override
		public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
			switch (hash) {
				case 919494990:
					// StreetName
					return this.streetName == null ? new Base[0]
							: new Base[] {
									this.streetName };
				case -1540661655:
					// HouseNumber
					return this.houseNumber == null ? new Base[0]
							: new Base[] {
									this.houseNumber };
				default:
					return super.getProperty(hash, name, checkValid);
			}
		}

		@Override
		public String[] getTypesForProperty(int hash, String name) throws FHIRException {
			switch (hash) {
				case 919494990:
					// StreetName
					return new String[] {
							"string" };
				case -1540661655:
					// HouseNumber
					return new String[] {
							"string" };
				default:
					return super.getTypesForProperty(hash, name);
			}
		}

		@Override
		protected void listChildren(List<Property> children) {
			super.listChildren(children);
			children.add(new Property("StreetName", "string", "StreetName", 0, 1, this.streetName));
			children.add(new Property("HouseNumber", "string", "HouseNumber", 0, 1, this.houseNumber));
		}

		@Override
		public Base makeProperty(int hash, String name) throws FHIRException {
			switch (hash) {
				case 919494990:
					// StreetName
					return getStreetNameElement();
				case -1540661655:
					// HouseNumber
					return getHouseNumberElement();
				default:
					return super.makeProperty(hash, name);
			}
		}

		@Override
		public void removeChild(String name, Base value) throws FHIRException {
			switch (name) {
				case "StreetName":
					this.streetName = null;
					break;
				case "HouseNumber":
					this.houseNumber = null;
					break;
				default:
					super.removeChild(name, value);
			}
		}

		/**
		 * @see Base#setProperty(int, String, Base)
		 */
		@Override
		public Base setProperty(int hash, String name, Base value) throws FHIRException {
			switch (hash) {
				case 919494990:
					// StreetName
					this.streetName = castToString(value);
					return value;
				case -1540661655:
					// HouseNumber
					this.houseNumber = castToString(value);
					return value;
				default:
					return super.setProperty(name, value);
			}
		}

		/**
		 * @see Base#setProperty(int, String, Base)
		 */
		@Override
		public Base setProperty(String name, Base value) throws FHIRException {
			switch (name) {
				case "StreetName":
					this.streetName = castToString(value);
					return value;
				case "HouseNumber":
					this.houseNumber = castToString(value);
					return value;
				default:
					return super.setProperty(name, value);
			}
		}

	}

}
