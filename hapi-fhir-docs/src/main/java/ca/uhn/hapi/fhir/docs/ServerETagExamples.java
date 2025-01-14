package ca.uhn.hapi.fhir.docs;

import ca.uhn.fhir.rest.server.ETagSupportEnum;
import ca.uhn.fhir.rest.server.RestfulServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
public class ServerETagExamples {

   // START SNIPPET: disablingETags
   @WebServlet(urlPatterns = { "/fhir/*" }, displayName = "FHIR Server")
   public class RestfulServerWithLogging extends RestfulServer {

      @Override
      protected void initialize() throws ServletException {
         // ... define your resource providers here ...
         
         // ETag support is enabled by default
         setETagSupport(ETagSupportEnum.ENABLED);
      }
      
   }
   // END SNIPPET: disablingETags
   
   
   
}
