package uk.gov.hscic.fgm.generate.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import uk.gov.hscic.fgm.generate.CreateXML;


public class MyTests {

	@Test
	public void checkCreateBundleAddsTheAttributes(){
		
		Bundle checkBundle = CreateXML.createBundle();
		
		assertEquals(checkBundle.getId().toString(), "13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		assertEquals(checkBundle.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES), "urn:fhir.nhs.uk:profile/NHS-FGM-Bundle-QueryParameters");
	} 
	
	@Test
	public void checkCreateOrganisationAddsTheAttributes(){
		
		Organization checkOrg = CreateXML.createOrganization();
		
		assertEquals(checkOrg.getName(), "Health and Social Care Information Cerntre");
		assertEquals(checkOrg.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES), "urn:fhir.nhs.uk:profile/NHS-FGM-Organization");
	} 
	
	@Test
	public void checkCreateMessageHeaderAddsTheAttributes() {
		
		MessageHeader checkMh = CreateXML.createMessageHeader();
		assertEquals("14daadee-26e1-4d6a-9e6a-7f4af9b58877", checkMh.getId().toString());
		assertEquals("urn:fhir.nhs.uk:profile/NHS-FGM-MessageHeader-QueryParameters", checkMh.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES));
//		assertEquals("2015-07-04T09:10:14+00:00", checkMh.getTimestamp());
		assertEquals("13daadee-26e1-4d6a-9e6a-7f4af9b58977", checkMh.getIdentifier());
		
		assertEquals("urn:fhir.nhs.uk:vs/MessageEvent", checkMh.getEvent().getSystem());
		assertEquals("urn:nhs:names:services:fgmquery/FGMQuery_1_0", checkMh.getEvent().getCode());
		
		assertEquals("FooBar NHS Trust", checkMh.getSource().getName());
		assertEquals("FooBar Patient Manager", checkMh.getSource().getSoftware());
		assertEquals("urn:system:asid/047192794544", checkMh.getSource().getEndpoint());
		assertEquals("phone", checkMh.getSource().getContact().getSystem());
		assertEquals("0207 444777", checkMh.getSource().getContact().getValue());
		assertEquals("mobile", checkMh.getSource().getContact().getUse());
		
		assertEquals("SPINE 2 MHS", checkMh.getDestinationFirstRep().getName());
		assertEquals("urn:spinecore:asid/990101234567", checkMh.getDestinationFirstRep().getEndpoint());
		
		assertEquals("Practitioner/41fe704c-18e5-11e5-b60b-1697f925ec7b", checkMh.getAuthor().getReference());
		assertEquals("Dr Town Wood",checkMh.getAuthor().getDisplay());
		
		assertEquals("Parameters/7cb73a48-090d-469a-a2b2-04f1e6b11ea2", checkMh.getData());
	}
	
	@Test
	public void checkCreateParametersAddsTheAttributes(){
		
		Organization checkParams = CreateXML.createOrganization();
		assertEquals(checkParams.getName(), "Health and Social Care Information Centre");
	}
	
	@Test
	public void checkCreatePractitionerAddsTheAttributes(){
		
		Organization checkPrac = CreateXML.createOrganization();
		assertEquals(checkPrac.getName(), "Health and Social Care Information Centre");
	}
	
}
