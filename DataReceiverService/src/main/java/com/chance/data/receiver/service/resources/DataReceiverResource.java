package com.chance.data.receiver.service.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/upload-data")
public class DataReceiverResource {

  public static final Logger logger = LoggerFactory.getLogger(DataReceiverResource.class);

  private static final String API_KEY = "dd9d5615d80f6ddee591a703caa2a915";

  public DataReceiverResource() {

  }

  @GET
  @Timed
  public void uploadData(@QueryParam("data") Optional<String> data, @QueryParam("type") Optional<String> type,
      @QueryParam("apikey") Optional<String> apikey) {
    if (!checkApiKey(apikey.get())) {
      return;
    }
    logger.info(type.or("") + " - " + data.or("") + "\n");
  }

  private boolean checkApiKey(String apikey) {
    return API_KEY.equals(apikey);
  }

}
