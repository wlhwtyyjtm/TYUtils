package com.chance.data.receiver.service;

import com.chance.data.receiver.service.resources.DataReceiverResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DataReceiverApplication extends Application<DataReceiverConfiguration> {

  @Override
  public void initialize(Bootstrap<DataReceiverConfiguration> bootstrap) {}

  @Override
  public void run(DataReceiverConfiguration configuration, Environment environment) throws Exception {
    
    final DataReceiverResource resource = new DataReceiverResource();
    environment.jersey().register(resource);
    
  }
  
  public static void main(String[] args) throws Exception {
    new DataReceiverApplication().run(args);
  }

}
