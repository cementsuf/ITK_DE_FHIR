package uk.gov.hscic.itk.generate;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Destination;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Source;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.InstantDt;
import ca.uhn.fhir.model.primitive.StringDt;

public class CreateXML {

	public static Bundle createBundle(){
		
		final Bundle bndl = new Bundle();
		
		bndl.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:x-fhir:uk:nhs:extension:NHS-ITK-Bundle");
		bndl.setResourceMetadata(meta);
		
		return bndl;
	}
	
	public static Organization createOrganization(){
		
		Organization org = new Organization();
		org.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58878");
		org.setName("THE WHITTINGTON HOSPITAL NHS TRUST");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:x-fhir:uk:nhs:profile:organization: NHS-FGM-Organization");
		org.setResourceMetadata(meta);
		
		IdentifierDt rr2 = new IdentifierDt();
		rr2.setSystem("urn:x-fhir:uk:nhs:id:ODSOrganisationCode").setValue("RKE");
		List<IdentifierDt> idenList = new ArrayList<IdentifierDt>();
		idenList.add(rr2);
		org.setIdentifier(idenList);
		return org;
	}
	
	public static MessageHeader createMessageHeader(){
		
		MessageHeader msgH = new MessageHeader();
		msgH.setId("14daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		InstantDt dt = new InstantDt();
		dt.setValueAsString("2015-06-22T14:04:44+00:00");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.UPDATED, dt);
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:x-fhir:uk:nhs:profile:messageheader:NHS-FGM-MessageHeader-QueryParameters");
		msgH.setResourceMetadata(meta);
		
		//removed below to pass publisher
		//msgH.setIdentifier("13daadee-26e1-4d6a-9e6a-7f4af9b58977");
		
		dt.setValueAsString("2015-07-04T09:10:14+00:00");
		msgH.setTimestamp(dt);
		
		CodingDt event = new CodingDt();
		
		event.setSystem("urn:x-fhir:uk:nhs:vs:MessageEvent");
		event.setCode("urn:nhs:names:services:fgmquery/FGMQuery_1_0");
		msgH.setEvent(event);
		
		ExtensionDt extSourceType = new ExtensionDt();
		extSourceType.setModifier(false);
		extSourceType.setValue(new StringDt().setValue("2.16.840.1.113883.2.1.3.2.4.18.27"));
		extSourceType.setUrl("http://fhir.nhs.net/StructureDefinition/extension-itk-source-type-1-0");
		
		Source src = new Source();
		src.setName("FooBar NHS Trust").setSoftware("FooBar Patient Manager").setEndpoint("urn:system:asid/047192794544");
		src.setContact(new ContactPointDt().setSystem(ContactPointSystemEnum.PHONE).setValue("0207 444777").setUse(ContactPointUseEnum.MOBILE));
		src.addUndeclaredExtension(extSourceType);
		msgH.setSource(src);
		
		
		ExtensionDt extDestinationType = new ExtensionDt();
		extDestinationType.setModifier(false);
		extDestinationType.setValue(new StringDt().setValue("2.16.840.1.113883.2.1.3.2.4.18.27"));
		extDestinationType.setUrl("http://fhir.nhs.net/StructureDefinition/extension-itk-destination-type-1-0");
		
		Destination dest = new Destination();
		dest.setName("SPINE 2 MHS");
		dest.setEndpoint("urn:spinecore:asid/990101234567");
		dest.addUndeclaredExtension(extDestinationType);
		msgH.addDestination(new Destination().setName("SPINE 2 MHS").setEndpoint("urn:spinecore:asid/990101234567"));
		
		msgH.setAuthor(new ResourceReferenceDt().setReference("Practitioner/41fe704c-18e5-11e5-b60b-1697f925ec7b").setDisplay("Dr Town Wood"));
		
		ResourceReferenceDt rr2 = new ResourceReferenceDt();
		rr2.setReference("Patient/7cb73a48-090d-469a-a2b2-04f1e6b11ea2");
		List<ResourceReferenceDt> rr2list = new ArrayList<ResourceReferenceDt>();
		rr2list.add(rr2);
		
		msgH.setData(rr2list);
		
		//Extensions
		ExtensionDt auditIdentity = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-auditidentity-1-0");
		ExtensionDt extAuditId = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-auditidentity-id-1-0", new StringDt("urn:nhs-uk:identity:ods:A1A"));
		ExtensionDt extAuditType = new ExtensionDt(false, "http://fhir.nhs.net/StructureDefinition/extension-itk-auditidentity-type-1-0", new StringDt("2.16.840.1.113883.2.1.3.2.4.18.27"));
		ExtensionDt extAuditURI = new ExtensionDt(false, "http://fhir.nhs.net/StructureDefinition/extension-itk-auditidentity-uri-1-0",  new StringDt("urn:nhs-uk:addressing:ods:V396A"));
		
		msgH.addUndeclaredExtension(auditIdentity);
		auditIdentity.addUndeclaredExtension(extAuditId);
		auditIdentity.addUndeclaredExtension(extAuditType);
		auditIdentity.addUndeclaredExtension(extAuditURI);
		
		ExtensionDt manifest = new ExtensionDt(false, "http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-1-0");
		ExtensionDt manifestMimeType = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-mime-type-1-0", new StringDt("text/xml"));
		ExtensionDt manifestProfileId = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-profile-id-1-0");
		ExtensionDt manifestMetadata = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-metadata-1-0", new BooleanDt(false));
		ExtensionDt manifestCompressed = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-compressed-1-0", new BooleanDt(false));
		ExtensionDt manifestBase64 = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-base64-1-0", new BooleanDt(false));
		ExtensionDt manifestEncrypted = new ExtensionDt(false,"http://fhir.nhs.net/StructureDefinition/extension-itk-manifest-encrypted-1-0", new BooleanDt(false));

		msgH.addUndeclaredExtension(manifest);
		manifest.addUndeclaredExtension(manifestMimeType);
		manifest.addUndeclaredExtension(manifestProfileId);
		manifest.addUndeclaredExtension(manifestMetadata);
		manifest.addUndeclaredExtension(manifestCompressed);
		manifest.addUndeclaredExtension(manifestBase64);
		manifest.addUndeclaredExtension(manifestEncrypted);
		
		ExtensionDt handlingSpecification = new ExtensionDt(false, "http://fhir.nhs.net/StructureDefinition/extension-itk-handling-specification-1-0");
		handlingSpecification.setValue(new CodingDt().setSystem("urn:nhs:itk:ns:201005:ackrequested").setCode("false"));
		msgH.addUndeclaredExtension(handlingSpecification);
		
		return msgH;
		
	}
	
	public static Practitioner createPractitioner(){
		
		Practitioner prac = new Practitioner();
		prac.setId("41fe704c-18e5-11e5-b60b-1697f925ec7b");
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:x-fhir:uk:nhs:profile: practitioner:NHS-FGM-Practitioner");
		prac.setResourceMetadata(meta);
		
		List<IdentifierDt> identifierList = new ArrayList<IdentifierDt>();
		
		identifierList.add(0,new IdentifierDt().setUse(IdentifierUseEnum.OFFICIAL).setSystem("urn:x-fhir:uk:nhs:id:SDSUserID").setValue("G12345678"));
		identifierList.add(1,new IdentifierDt().setUse(IdentifierUseEnum.OFFICIAL).setSystem("urn:x-fhir:uk:nhs:id:SDSRoleProfileID").setValue("PT1234"));
		prac.setIdentifier(identifierList);
		
		prac.setName(new HumanNameDt().addFamily("Wood").addGiven("Town").addPrefix("Dr.").setUse(NameUseEnum.OFFICIAL));
		
		List<PractitionerRole> PracRoleList = new ArrayList<PractitionerRole>();
		
		PractitionerRole pr1 = new PractitionerRole();
		pr1.setManagingOrganization(new ResourceReferenceDt().setReference("Organization/41fe704c-18e5-11e5-b60b-1697f925ec7b"));
		
		pr1.getRole().getCodingFirstRep().setSystem("urn:x-fhir:uk:nhs:vs:SDSJobRoleName").setCode("R0090").setDisplay("Hospital Practitioner");
		
		PracRoleList.add(pr1);
		
		prac.setPractitionerRole(PracRoleList);
		
		return prac;
		
	}
		
}
