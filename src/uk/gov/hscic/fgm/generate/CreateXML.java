package uk.gov.hscic.fgm.generate;

import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;

public class CreateXML {

	public static Organization createOrganization(){
		
		//set the data for the elements here
		Organization org = new Organization();
		org.setId("447890980071");
		org.setName("Health and Social Care Information Centre");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-Organization");
		
		org.setResourceMetadata(meta);
		
		return org;
		
	}
	
	public static MessageHeader createMessageHeader(){
		
		//set the data for the elements here
		MessageHeader msgH = new MessageHeader();
		msgH.setId("999");
	
		return msgH;
		
	}
	
		
}
