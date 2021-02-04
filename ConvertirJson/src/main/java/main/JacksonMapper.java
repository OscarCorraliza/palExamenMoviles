package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import modelo.Character;
import modelo.JsonResponse;

public class JacksonMapper {
    public static void main(String[] args) {
        String api = "https://rickandmortyapi.com/api/character";
        String data;

        do{
            try {
                data = new GetJson().getJson(api);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                JsonResponse jsonResponse = objectMapper.readValue(data, JsonResponse.class);

                for(Character c:jsonResponse.getResults()){
                    System.out.println(c.getName());
                }
                api = jsonResponse.getInfo().getNext();

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }while(api!=null);

    }
}
