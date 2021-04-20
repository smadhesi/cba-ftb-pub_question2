package helper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import resources.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Properties {
    private static Resources resource;
    public static synchronized Resources getResource(){
        if(resource==null ){
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            try{
                URL url = Thread.currentThread().getContextClassLoader().getResource("Resource.yml");
                File file = new File(url.getPath());
                resource = objectMapper.readValue(file,Resources.class);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        return resource;
    }

}
