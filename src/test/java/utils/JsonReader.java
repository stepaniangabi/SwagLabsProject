package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.CustomerModel;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static CustomerModel getCustomerData() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(
                    new File("src/test/resources/customerData.json"),
                    CustomerModel.class
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
