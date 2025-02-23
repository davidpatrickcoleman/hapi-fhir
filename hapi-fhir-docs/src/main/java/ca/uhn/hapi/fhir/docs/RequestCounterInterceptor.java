package ca.uhn.hapi.fhir.docs;

import ca.uhn.fhir.rest.server.interceptor.InterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//START SNIPPET: interceptor
public class RequestCounterInterceptor extends InterceptorAdapter
{

   private int myRequestCount;

   public int getRequestCount() {
      return myRequestCount;
   }

   /**
    * Override the incomingRequestPreProcessed method, which is called
    * for each incoming request before any processing is done
    */
   @Override
   public boolean incomingRequestPreProcessed(HttpServletRequest theRequest, HttpServletResponse theResponse) {
      myRequestCount++;
      return true;
   }
   
}
//END SNIPPET: interceptor
