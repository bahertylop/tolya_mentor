package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Needle7 {

    @Autowired
    private final Deth8 deth;

    public Needle7(Deth8 deth) {
        this.deth = deth;
    }

    @Override
    public String toString() {
        return ", смерть Кощея на игле :( ";
    }
}
