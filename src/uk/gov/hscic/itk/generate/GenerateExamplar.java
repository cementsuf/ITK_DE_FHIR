package uk.gov.hscic.itk.generate;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;

public class GenerateExamplar {

	public static void main(String[] args) {

		// create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
		
		Bundle bndl = CreateXML.createBundle();
		MessageHeader mh = CreateXML.createMessageHeader();
		
		final Entry entryMh = bndl.addEntry();
		
		entryMh.setResource(mh);
		
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		
		System.out.println(output);
		
	}

}
