package ca.uhn.hapi.fhir.docs;

import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.InstantType;
import org.hl7.fhir.r4.model.Patient;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("null")
// START SNIPPET: provider
public class PagingPatientProvider implements IResourceProvider {

   /**
    * Search for Patient resources matching a given family name
    */
   @Search
   public IBundleProvider search(@RequiredParam(name = Patient.SP_FAMILY) StringParam theFamily) {
      final InstantType searchTime = InstantType.withCurrentTime();

      /**
       * First, we'll search the database for a set of database row IDs that
       * match the given search criteria. That way we can keep just the row IDs
       * around, and load the actual resources on demand later as the client
       * pages through them.
       */
      final List<Long> matchingResourceIds = null; // <-- implement this

      /**
       * Return a bundle provider which can page through the IDs and return the
       * resources that go with them.
       */
      return new IBundleProvider() {

         @Override
         public Integer size() {
            return matchingResourceIds.size();
         }

         @Nonnull
			@Override
         public List<IBaseResource> getResources(int theFromIndex, int theToIndex) {
            int end = Math.max(theToIndex, matchingResourceIds.size() - 1);
            List<Long> idsToReturn = matchingResourceIds.subList(theFromIndex, end);
            return loadResourcesByIds(idsToReturn);
         }

         @Override
         public InstantType getPublished() {
            return searchTime;
         }

         @Override
         public Integer preferredPageSize() {
            // Typically this method just returns null
            return null;
         }

			@Override
			public String getUuid() {
				return null;
			}
      };
   }

   /**
    * Load a list of patient resources given their IDs
    */
   private List<IBaseResource> loadResourcesByIds(List<Long> theIdsToReturn) {
      // .. implement this search against the database ..
      return null;
   }

   @Override
   public Class<? extends IBaseResource> getResourceType() {
      return Patient.class;
   }

}
// END SNIPPET: provider
