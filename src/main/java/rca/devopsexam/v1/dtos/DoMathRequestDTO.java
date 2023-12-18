package rca.devopsexam.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DoMathRequestDTO {
    private double operand1;
    private double operand2;
    private String operation;
}
