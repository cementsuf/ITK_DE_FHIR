package uk.gov.hscic.itk.generate.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import uk.gov.hscic.itk.generate.CreateXML;


public class MyTests {

	@Test
	public void checkCreateBundleAddsTheAttributes(){
		
		Bundle checkBundle = CreateXML.createBundle();
		
		assertEquals("13daadee-26e1-4d6a-9e6a-7f4af9b58877", checkBundle.getId().toString() );
		assertEquals("urn:x-fhir:uk:nhs:profile:bundle:NHS-FGM-Bundle-QueryParameters", checkBundle.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES));
	} 
	
	@Test
	public void checkCreateOrganisationAddsTheAttributes(){
		
		Organization checkOrg = CreateXML.createOrganization();
		
		assertEquals("13daadee-26e1-4d6a-9e6a-7f4af9b58878", checkOrg.getId().toString());
		assertEquals("THE WHITTINGTON HOSPITAL NHS TRUST",checkOrg.getName());
		assertEquals("urn:x-fhir:uk:nhs:profile:organization: NHS-FGM-Organization", checkOrg.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES));
		assertEquals("urn:x-fhir:uk:nhs:id:ODSOrganisationCode", checkOrg.getIdentifier().get(0).getSystem().toString());
		assertEquals("RKE", checkOrg.getIdentifier().get(0).getValue().toString());
	} 
	
	@Test
	public void checkCreateMessageHeaderAddsTheAttributes() {
		
		MessageHeader checkMh = CreateXML.createMessageHeader();
		assertEquals("14daadee-26e1-4d6a-9e6a-7f4af9b58877", checkMh.getId().toString());
		assertEquals("urn:x-fhir:uk:nhs:profile:messageheader:NHS-FGM-MessageHeader-QueryParameters", checkMh.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES));
//		assertEquals("2015-07-04T09:10:14+00:00", checkMh.getTimestamp());
		assertEquals("13daadee-26e1-4d6a-9e6a-7f4af9b58977", checkMh.getIdentifier());
		
		assertEquals("urn:x-fhir:uk:nhs:vs:MessageEvent", checkMh.getEvent().getSystem());
		assertEquals("urn:nhs:names:services:fgmquery/FGMQuery_1_0", checkMh.getEvent().getCode());
		
		assertEquals("FooBar NHS Trust", checkMh.getSource().getName());
		assertEquals("FooBar Patient Manager", checkMh.getSource().getSoftware());
		assertEquals("urn:system:asid/047192794544", checkMh.getSource().getEndpoint());
		assertEquals("phone", checkMh.getSource().getContact().getSystem());
		assertEquals("0207 444777", checkMh.getSource().getContact().getValue());
		assertEquals("mobile", checkMh.getSource().getContact().getUse());
		
		assertEquals("SPINE 2 MHS", checkMh.getDestinationFirstRep().getName());
		assertEquals("urn:spinecore:asid/990101234567", checkMh.getDestinationFirstRep().getEndpoint());
		
		assertEquals("Practitioner/41fe704c-18e5-11e5-b60b-1697f925ec7b", checkMh.getAuthor().getReference().toString());
		assertEquals("Dr Town Wood",checkMh.getAuthor().getDisplay().toString());
		
		assertEquals("Parameters/7cb73a48-090d-469a-a2b2-04f1e6b11ea2", checkMh.getData().get(0).getReference().toString());
	}
	
	@Test
	public void checkCreatePractitionerAddsTheAttributes(){
		
		Practitioner checkPrac = CreateXML.createPractitioner();
		
		assertEquals("41fe704c-18e5-11e5-b60b-1697f925ec7b", checkPrac.getId().toString());
		assertEquals("urn:x-fhir:uk:nhs:profile: practitioner:NHS-FGM-Practitioner", checkPrac.getResourceMetadata().get(ResourceMetadataKeyEnum.PROFILES));
		assertEquals("official", checkPrac.getIdentifier().get(0).getUse());
		assertEquals("urn:x-fhir:uk:nhs:id:SDSUserID", checkPrac.getIdentifier().get(0).getSystem());
		assertEquals("G12345678", checkPrac.getIdentifier().get(0).getValue());

		assertEquals("official", checkPrac.getIdentifier().get(01).getUse());
		assertEquals("urn:x-fhir:uk:nhs:id:SDSRoleProfileID", checkPrac.getIdentifier().get(1).getSystem());
		assertEquals("PT1234", checkPrac.getIdentifier().get(1).getValue());
		
		assertEquals("official", checkPrac.getName().getUse());
		assertEquals("Wood", checkPrac.getName().getFamily().get(0).toString());
		assertEquals("Town", checkPrac.getName().getGiven().get(0).toString());
		assertEquals("Dr.", checkPrac.getName().getPrefix().get(0).toString());
		
		assertEquals("Organization/41fe704c-18e5-11e5-b60b-1697f925ec7b", checkPrac.getPractitionerRole().get(0).getManagingOrganization().getReference().toString());
		
		assertEquals("urn:x-fhir:uk:nhs:vs:SDSJobRoleName", checkPrac.getPractitionerRole().get(0).getRole().getCoding().get(0).getSystem().toString());
		assertEquals("R0090", checkPrac.getPractitionerRole().get(0).getRole().getCoding().get(0).getCode());
		assertEquals("Hospital Practitioner", checkPrac.getPractitionerRole().get(0).getRole().getCoding().get(0).getDisplay());

	}
	
}
