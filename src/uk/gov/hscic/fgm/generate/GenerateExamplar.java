package uk.gov.hscic.fgm.generate;

import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters.Parameter;

public class GenerateExamplar {

	public static void main(String[] args) {

		
		String orgn = CreateXML.createOrganization();
		System.out.println(orgn);
		
	}

}
