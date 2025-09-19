package Entidades;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

public class UnidadMedida {
    private Long id;
    private String denominacion;
}
