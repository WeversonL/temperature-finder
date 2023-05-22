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
public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = -8657204571030072280L;

    private String lat;
    private String lng;

}
