package ca.uhn.hapi.fhir.docs;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.client.api.IBasicClient;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import java.util.List;

//START SNIPPET: provider
/**
 * All RESTful clients must be an interface which extends IBasicClient
 */
public interface IRestfulClient extends IBasicClient {

	/**
	 * The "@Read" annotation indicates that this method supports the
	 * read operation. Read operations should return a single resource
	 * instance. 
	 * 
	 * @param theId
	 *    The read operation takes one parameter, which must be of type
	 *    IdType and must be annotated with the "@Read.IdParam" annotation.
	 * @return 
	 *    Returns a resource matching this identifier, or null if none exists.
	 */
	@Read()
	Patient getResourceById(@IdParam IIdType theId);

	/**
	 * The "@Read" annotation indicates that this method supports the
	 * read operation. Read operations should return a single resource
	 * instance.
	 *
	 * @param theId
	 *    The read operation takes one parameter, which must be of type
	 *    IdType and must be annotated with the "@Read.IdParam" annotation.
	 * @return
	 *    Returns a resource matching this identifier, or null if none exists.
	 */
	@Read()
	Organization getOrganizationById(@IdParam IIdType theId);

	/**
	 * The "@Search" annotation indicates that this method supports the 
	 * search operation. You may have many different methods annotated with
	 * this annotation, to support many different search criteria. This
	 * example searches by family name.
	 * 
	 * @param theFamilyName
	 *    This operation takes one parameter which is the search criteria. It is
	 *    annotated with the "@Required" annotation. This annotation takes one argument,
	 *    a string containing the name of the search criteria. The datatype here
	 *    is StringDt, but there are other possible parameter types depending on the
	 *    specific search criteria.
	 * @return
	 *    This method returns a list of Patients. This list may contain multiple
	 *    matching resources, or it may also be empty.
	 */
	@Search()
	List<Patient> getPatient(@RequiredParam(name = Patient.SP_FAMILY) StringType theFamilyName);

}
//END SNIPPET: provider


