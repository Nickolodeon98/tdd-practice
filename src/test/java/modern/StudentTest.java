package modern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    List<Lecturer> lecturers;
    Lecturer kyeongrok;
    Lecturer kyeonghwan;
    Lecturer sujin;
    Lecturer sohyun;
    final int DEFAULT_IDENTITY = 0;

    @BeforeEach
    void setUp() {
        lecturers = new ArrayList<>();
        kyeongrok = new Lecturer("김경록", true, true);
        kyeonghwan = new Lecturer("고경환", true, false);
        sujin = new Lecturer("김수진", false, false);
        sohyun = new Lecturer("강소현", true, true);
        lecturers.add(kyeongrok);
        lecturers.add(kyeonghwan);
        lecturers.add(sujin);
        lecturers.add(sohyun);
    }

    @Test
    void findCategory() {
        List<String> likeAlgorithmLecturers = lecturers.stream()
                .filter(Lecturer::isLikeAlgorithm)
                .map(Lecturer::getName)
                .collect(Collectors.toList());

        for (String likeAlgorithmLecturer : likeAlgorithmLecturers) {
            System.out.println(likeAlgorithmLecturer);
        }
    }

    @Test
    void findNameLength() {
        List<Integer> nameLengths = lecturers.stream()
                .filter(Lecturer::isLikeSpringBoot)
                .map(lecturer -> lecturer.getName().length())
                .collect(Collectors.toList());

//        for (Integer nameLength : nameLengths) {
//            System.out.println(nameLength);
//        }
        System.out.println(nameLengths);
    }

    @Test
    void reduce() {
        String[] nums = {"1", "2", "3"};

        List<Integer> list = Arrays.stream(nums).map(strNum->Integer.parseInt(strNum)).collect(Collectors.toList());

        int reduceSum = Arrays.stream(nums).map(strNum->Integer.parseInt(strNum))
                .reduce(0, (a, b)-> a + b);

        System.out.println("reduceSum: " + reduceSum);

        int countIsLikeSpringBoot = lecturers.stream()
                .filter(Lecturer::isLikeSpringBoot)
                .map(lecturer -> 1)
                .reduce(DEFAULT_IDENTITY, (partialResult, toAdd) -> partialResult + toAdd);

        System.out.println(countIsLikeSpringBoot);
    }

    @Test
    void optionalTest() {
        /* JPA 에서 findBy~ 메소드를 사용하면 값이 있는 경우에는 Optional.empty() 를, 없는 경우에는 Optional.of() 로 감싸서 리턴한다. */
        Optional<Lecturer> optionalLecturer = Optional.of(Lecturer.builder().isLikeAlgorithm(true).isLikeAlgorithm(true).build());

        Optional<Lecturer> emptyLecturer = Optional.empty();

        List<Lecturer> lecturers1 = new ArrayList<>();

        Lecturer lecturer = optionalLecturer.orElseThrow(RuntimeException::new);

        System.out.println("here");

        emptyLecturer.ifPresent(sth -> {throw new RuntimeException();});
        System.out.println("here2");

        assertThrows(RuntimeException.class, () -> optionalLecturer.ifPresent(sth -> {
            throw new RuntimeException();
        }));

        System.out.println("here3");

        String name = Optional.ofNullable(optionalLecturer.get().getName()).orElse("이름을 못 찾습니다.");

        System.out.println(name);

        int size = lecturers1.size(); // 현재는 0이다.


    }
}