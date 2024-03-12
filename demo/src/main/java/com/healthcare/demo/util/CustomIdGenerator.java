package com.healthcare.demo.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomIdGenerator implements IdentifierGenerator {

  private static int sequence = 1;
  @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Implement your custom ID generation logic here
         LocalDate currentDate = LocalDate.now();

        // Generate the ID by combining the current date and the sequence number
        String id = "AR-"+currentDate.toString() + "-" + getNextSequence();


        return id;
    }
    private synchronized int getNextSequence() {
      return sequence++;
  }
}
