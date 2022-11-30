package modern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Lecturer {
    private String name;
    private boolean isLikeAlgorithm;
    private boolean isLikeSpringBoot;
}
