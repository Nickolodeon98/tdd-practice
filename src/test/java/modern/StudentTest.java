package modern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    List<Lecturer> lecturers;
    Lecturer kyeongrok;
    Lecturer kyeonghwan;
    Lecturer sujin;
    Lecturer sohyun;

    @BeforeEach
    void setUp() {
        lecturers = new ArrayList<>();
        kyeongrok = new Lecturer("김경록", true, true);
        kyeonghwan = new Lecturer("고경환", true, false);
        sujin = new Lecturer("김수진", false, true);
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

        for (Integer nameLength : nameLengths) {
            System.out.println(nameLength);
        }
    }

}