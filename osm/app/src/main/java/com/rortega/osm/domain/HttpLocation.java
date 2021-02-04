package com.rortega.osm.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HttpLocation {


    private String title;
    private Double latitude;
    private Double longitude;

    @Builder
    public HttpLocation(String title, Double latitude, Double longitude) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
