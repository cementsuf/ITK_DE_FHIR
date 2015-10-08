package uk.gov.hscic.fgm.generate;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;

public class GenerateExamplar {

	public static void main(String[] args) {

		// create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
		
		Organization orgn = CreateXML.createOrganization();
		MessageHeader mh = CreateXML.createMessageHeader();
		
		final Bundle bndl = new Bundle();
		
		//Base Resource attributes
		bndl.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-Bundle-QueryParameters");
		bndl.setResourceMetadata(meta);
		
		
		final Entry entryh = bndl.addEntry();
		final Entry entry = bndl.addEntry();
		entry.setResource(orgn);
		entryh.setResource(mh);
		
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		
		System.out.println(output);
		
	}

}
