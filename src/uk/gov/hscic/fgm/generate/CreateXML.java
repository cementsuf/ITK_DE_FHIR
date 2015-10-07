package uk.gov.hscic.fgm.generate;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu.resource.Profile;
import ca.uhn.fhir.model.dstu2.resource.BaseResource;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.rest.annotation.Metadata;

public class CreateXML {

	public static String createOrganization(){
		
		// Alternately, create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
		
		//set the data for the elements here
		Organization org = new Organization();
		org.setId("44789098");
		org.setName("Health and Social Care Information Centre");
		//BaseResource met;
		//ResourceMetadataMap theMap = new ResourceMetadataMap();
		//theMap.put(ResourceMetadataKeyEnum.UPDATED.put(IResource, TemporalPrecisionEnum.MILLI), new Profile());
		//met.setResourceMetadata(theMap);
		
		final Bundle bndl = new Bundle();
		final Entry entry = bndl.addEntry();
        entry.setResource(org);
		
		// We can now use a parser to encode this resource into a string.
		String encoded = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		
		return encoded;
		
	}
}
