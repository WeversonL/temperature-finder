package br.com.temperature.finder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenweatherResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -7685350084636990659L;

    private String name;
    private List<Weather> weather;
    private Main main;

}
