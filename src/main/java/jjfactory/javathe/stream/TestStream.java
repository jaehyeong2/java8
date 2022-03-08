package jjfactory.javathe.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        System.out.println("male List:");

//        for(People p: People.getPeople()){
//            if(p.getGender() == 1){
//                System.out.println(p.getName());
//            }
//        }

        List<People> femaleList = People.getPeople().stream().filter(people -> people.getGender() == 2)
                .collect(Collectors.toList());
        System.out.println("females :");
        femaleList.forEach(System.out::println);


        List<People> sortedFemaleList = People.getPeople().stream().sorted(Comparator.comparing(People::getAge))
                .collect(Collectors.toList());
        System.out.println("sorted by Age");
        sortedFemaleList.forEach(System.out::println);

        boolean allMatch = People.getPeople().stream().allMatch(people -> people.getAge() > 25);
        System.out.println(" all age over 25?");
        System.out.println("allMatch = " + allMatch);

        boolean anyMatch = People.getPeople().stream().anyMatch(people -> people.getAge() > 60);
        System.out.println("anyMatch = " + anyMatch);

        boolean noMatch = People.getPeople().stream().noneMatch(people -> people.getAge() == 24);
        System.out.println("noMatch = " + noMatch);

        Optional<People> maxAge = People.getPeople().stream().max(Comparator.comparing(People::getAge));
        if (maxAge.isPresent()){
            System.out.println("maxAge = " + maxAge);
        }

        Map<Integer, List<People>> collect = People.getPeople().stream().collect(Collectors.groupingBy(People::getGender));
        collect.forEach((gender,peopleList) -> {
            System.out.println("gender = " + gender);
            peopleList.forEach(System.out::println);
        });
    }
}

