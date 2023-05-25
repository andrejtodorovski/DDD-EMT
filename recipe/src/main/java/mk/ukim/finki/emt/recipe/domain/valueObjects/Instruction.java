package mk.ukim.finki.emt.recipe.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Instruction {
    private final String instruction;

    protected Instruction() {
        this.instruction = "";
    }
}
