package br.com.temperature.finder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather implements Serializable {

    @Serial
    private static final long serialVersionUID = 7106326730246485523L;

    private String description;

}
