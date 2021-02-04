package modelo;

import lombok.Data;

@Data
public class JsonResponse {
    public Info info;
    public Character[] results;
}
