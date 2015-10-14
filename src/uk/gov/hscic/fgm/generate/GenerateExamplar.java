package uk.gov.hscic.fgm.generate;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;

public class GenerateExamplar {

	public static void main(String[] args) {

		// create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
		
		Bundle bndl = CreateXML.createBundle();
		Organization orgn = CreateXML.createOrganization();
		MessageHeader mh = CreateXML.createMessageHeader();
		Parameters pm = CreateXML.createParameters();
		Practitioner prac = CreateXML.createPractitioner();
		
		final Entry entryBundle = bndl.addEntry();		
		final Entry entryMh = bndl.addEntry();
		final Entry entryParam = bndl.addEntry();
		final Entry entryPrac = bndl.addEntry();
		
		entryBundle.setResource(orgn);
		entryMh.setResource(mh);
		entryParam.setResource(pm);
		entryPrac.setResource(prac);
		
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		
		System.out.println(output);
		
	}

}
