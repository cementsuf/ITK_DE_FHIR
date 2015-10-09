package uk.gov.hscic.fgm.generate;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Destination;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Source;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters.Parameter;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.primitive.InstantDt;

public class CreateXML {

	public static Bundle createBundle(){
		
		final Bundle bndl = new Bundle();
		
		//Base Resource attributes
		bndl.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-Bundle-QueryParameters");
		bndl.setResourceMetadata(meta);
		
		return bndl;
		
	}
	
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
		msgH.setId("14daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
//		ResourceMetadataMap meta = new ResourceMetadataMap();
//		meta.put(ResourceMetadataKeyEnum.UPDATED, "2015-06-22T14:04:44+00:00");
//		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-MessageHeader-QueryParameters");
//		msgH.setResourceMetadata(meta);
		
//		msgH.setIdentifier("13daadee-26e1-4d6a-9e6a-7f4af9b58977");
		
//		InstantDt dt = new InstantDt();
//		dt.setValueAsString("2015-07-04T09:10:14+00:00");
//		msgH.setTimestamp(dt);
		
//		CodingDt event = new CodingDt();
//		event.setSystem("urn:fhir.nhs.uk:vs/MessageEvent");
//		event.setCode("urn:nhs:names:services:fgmquery/FGMQuery_1_0");
//		msgH.setEvent(event);
		
//		Source src = new Source();
//		src.setName("FooBar NHS Trust");
//		src.setSoftware("FooBar Patient Manager");
//		src.setEndpoint("urn:system:asid/047192794544");
//		ContactPointDt cp = new ContactPointDt();
//		cp.setSystem(ContactPointSystemEnum.PHONE);
//		cp.setValue("0207 444777");
//		cp.setUse(ContactPointUseEnum.MOBILE);
//		src.setContact(cp);
//		
//		Destination dest = new Destination();
//		dest.setName("SPINE 2 MHS");
//		dest.setEndpoint("urn:spinecore:asid/990101234567");
//		msgH.addDestination(dest);
		
//		ResourceReferenceDt rr = new ResourceReferenceDt();
//		rr.setReference("Practitioner/41fe704c-18e5-11e5-b60b-1697f925ec7b");
//		rr.setDisplay("Dr Town Wood");
//		msgH.setAuthor(rr);
//		
//		List<ResourceReferenceDt> rr2 = new ArrayList<ResourceReferenceDt>();
//		rr2.add(rr);
//		msgH.setData(rr2);
		return msgH;
		
	}
	
	
	public static Parameter createParameters(){
		
		//set the data for the elements here
		Parameter msgH = new Parameter();
	
		return msgH;
		
	}
	
	public static Practitioner createPractitioner(){
		
		//set the data for the elements here
		Practitioner msgH = new Practitioner();
		msgH.setId("999");
	
		return msgH;
		
	}
		
}
