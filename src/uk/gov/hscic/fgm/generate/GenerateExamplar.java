package uk.gov.hscic.fgm.generate;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;

public class GenerateExamplar {

	public static void main(String[] args) {

		// create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
		
		Bundle bndl = CreateXML.createBundle();
		Organization orgn = CreateXML.createOrganization();
		MessageHeader mh = CreateXML.createMessageHeader();
		
				
		final Entry entryh = bndl.addEntry();
		final Entry entry = bndl.addEntry();
		entry.setResource(orgn);
		entryh.setResource(mh);
		
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		
		System.out.println(output);
		
	}

}
